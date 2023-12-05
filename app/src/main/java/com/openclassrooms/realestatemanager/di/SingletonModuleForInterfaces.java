package com.openclassrooms.realestatemanager.di;

import com.openclassrooms.realestatemanager.data_provider.PropertyProvider;
import com.openclassrooms.realestatemanager.data_source.PropertyDataProvider;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class SingletonModuleForInterfaces {
    @Binds
    @Singleton
    public abstract PropertyProvider bindPropertyProvider(PropertyDataProvider propertyDataProvider);
}
