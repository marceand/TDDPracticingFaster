package com.marceme.tddfasterpracting.injection;

import com.marceme.tddfasterpracting.imageui.ImageActivity;
import com.marceme.tddfasterpracting.mainui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Marcelino Yax-marce7j@gmail.com-Android Developer
 *         Created on 2/7/2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(ImageActivity imageActivity);
}
