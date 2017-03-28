package com.marceme.tddfasterpracting.injection.module;

import android.accounts.AccountManager;
import android.app.Application;
import android.content.Context;


import com.marceme.tddfasterpracting.datamanager.PixabayAPIService;
import com.marceme.tddfasterpracting.datamanager.PixabayDataManager;
import com.marceme.tddfasterpracting.injection.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.mock;

/**
 * Provides application-level dependencies for an app running on a testing environment
 * This allows injecting mocks if necessary.
 */
@Module
public class ApplicationTestModule {
    protected final Application mApplication;

    public ApplicationTestModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    /************* MOCKS *************/

    @Provides
    @Singleton
    PixabayDataManager providesDataManager() {
        return mock(PixabayDataManager.class);
    }


    @Provides
    @Singleton
    PixabayAPIService provideRibotService() {
        return mock(PixabayAPIService.class);
    }

}
