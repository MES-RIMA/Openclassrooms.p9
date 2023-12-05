package com.openclassrooms.realestatemanager.edit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.openclassrooms.realestatemanager.databinding.ActivityEditPropretyBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class EditPropertyActivity extends AppCompatActivity {

    public static final String PROPERTY_ID_KEY = "PROPERTY_ID_KEY";

    private ActivityEditPropretyBinding binding;
    private EditPropertyViewMode viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditPropretyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new  ViewModelProvier(this).get(EditPropertyViewMode.class);
        bindProperty();
    }

    private void bindProperty(){
        final int propertyId = getIntent().getIntExtra(PROPERTY_ID_KEY, 0);
        if(propertyId != 0) {
            viewModel.updateProperty(propertyId).observe(this,binding::setProperty);
        }else {
            binding.setProperty(viewModel.createNewProperty());
        }
    }
}
