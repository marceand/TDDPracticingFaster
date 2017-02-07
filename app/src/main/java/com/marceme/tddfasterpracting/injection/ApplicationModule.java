package com.marceme.tddfasterpracting.injection;

import com.marceme.tddfasterpracting.mainui.MainActivityPresenter;
import com.marceme.tddfasterpracting.mainui.UserActionListener;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Marcelino Yax-marce7j@gmail.com-Android Developer
 *         Created on 2/7/2017.
 */

@Module
public class ApplicationModule {

    @Provides @Singleton
    UserActionListener provideMainPresenter(){
        return new MainActivityPresenter();
    }
}
