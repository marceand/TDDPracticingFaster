package com.marceme.tddfasterpracting;

import android.app.Application;
import android.content.Context;

import com.marceme.tddfasterpracting.injection.ApplicationComponent;
import com.marceme.tddfasterpracting.injection.ApplicationModule;
import com.marceme.tddfasterpracting.injection.DaggerApplicationComponent;

/**
 * @author Marcelino Yax-marce7j@gmail.com-Android Developer
 *         Created on 2/7/2017.
 */

public class MainApplication extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule()).build();
    }

    public ApplicationComponent getComponent(){
        return component;
    }

    public static MainApplication get(Context context) {
        return (MainApplication) context.getApplicationContext();
    }
    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        component = applicationComponent;
    }
}
