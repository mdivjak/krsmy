package com.mdivjak.krsmy.ViewModels;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddMemberViewModel extends ViewModel {
    public static final String FIRST_NAME_INPUT_KEY = "first-name";
    public static final String LAST_NAME_INPUT_KEY = "last-name";
    public static final String INSTRUMENT_KEY = "instrument";

    private boolean dataValid = false;

    private MutableLiveData<String> firstName = new MutableLiveData<>();
    private MutableLiveData<String> lastName = new MutableLiveData<>();
    private MutableLiveData<String> instrument = new MutableLiveData<>();

    public LiveData<String> getFirstName() { return firstName; }
    public LiveData<String> getLastName() { return lastName; }
    public LiveData<String> getInstrument() { return instrument; }

    public void setFirstName(String s) { firstName.setValue(s); }
    public void setLastName(String s) { lastName.setValue(s); }
    public void setInstrument(String s) { instrument.setValue(s); }

    public void initByInstanceStateBundle(Bundle bundle) {
        if(bundle == null) return;
        if(dataValid) return;
        if(bundle.containsKey(FIRST_NAME_INPUT_KEY)) {
            dataValid = true;
            firstName.setValue(bundle.getString(FIRST_NAME_INPUT_KEY));
        }
        if(bundle.containsKey(LAST_NAME_INPUT_KEY)) {
            dataValid = true;
            lastName.setValue(bundle.getString(LAST_NAME_INPUT_KEY));
        }
        if(bundle.containsKey(INSTRUMENT_KEY)) {
            dataValid = true;
            instrument.setValue(bundle.getString(INSTRUMENT_KEY));
        }
    }

}
