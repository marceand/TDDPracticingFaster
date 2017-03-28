package com.marceme.tddfasterpracting.injection.component;

import com.marceme.tddfasterpracting.datamanager.PixabayDataManager;
import com.marceme.tddfasterpracting.injection.ApplicationComponent;
import com.marceme.tddfasterpracting.injection.module.ApplicationTestModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends ApplicationComponent {
    PixabayDataManager dataManager();
}
