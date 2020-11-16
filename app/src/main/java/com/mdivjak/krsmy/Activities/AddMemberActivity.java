package com.mdivjak.krsmy.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.mdivjak.krsmy.ViewModels.AddMemberViewModel;
import com.mdivjak.krsmy.databinding.ActivityAddMemberBinding;

public class AddMemberActivity extends AppCompatActivity {
    private ActivityAddMemberBinding binding;
    private AddMemberViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddMemberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(AddMemberViewModel.class);
        viewModel.initByInstanceStateBundle(savedInstanceState);
        binding.firstName.getEditText().setText(viewModel.getFirstName().getValue());
        binding.lastName.getEditText().setText(viewModel.getLastName().getValue());
        binding.instrument.getEditText().setText(viewModel.getInstrument().getValue());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(AddMemberViewModel.FIRST_NAME_INPUT_KEY, binding.firstName.getEditText().getText().toString());
        outState.putString(AddMemberViewModel.LAST_NAME_INPUT_KEY, binding.lastName.getEditText().getText().toString());
        outState.putString(AddMemberViewModel.INSTRUMENT_KEY, binding.instrument.getEditText().getText().toString());
    }
}