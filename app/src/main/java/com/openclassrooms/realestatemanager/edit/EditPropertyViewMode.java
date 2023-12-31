package com.openclassrooms.realestatemanager.edit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.openclassrooms.realestatemanager.models.Property;
import com.openclassrooms.realestatemanager.repositories.PropertyRepository;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class EditPropertyViewMode extends ViewModel {
    private final PropertyRepository propertyRepository;

    // For the update mode
    private final MutableLiveData<PropertyDataBinding> propertyToBeUpdated = new MutableLiveData<>();
    private final Executor doInBackground = Executors.newSingleThreadExecutor();
    private Property newProperty; // For the creation mode

    @Inject
    public EditPropertyViewMode(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public LiveData<PropertyDataBinding> updateProperty(int propertyId) {
        doInBackground.execute(() -> {
            final Property property = propertyRepository.getById(propertyId);
            propertyToBeUpdated.setValue(new PropertyDataBinding(property));
        });
        return propertyToBeUpdated;
    }

    public PropertyDataBinding createNewProperty() {
        newProperty = new Property();
        return new PropertyDataBinding(newProperty);
    }

    public void persist() {
        if(newProperty != null) {
            propertyRepository.create(newProperty);
        } else {
            propertyRepository.update(propertyToBeUpdated.getValue().getProperty());
        }
    }
}
