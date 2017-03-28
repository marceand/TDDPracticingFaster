package com.marceme.tddfasterpracting.injection;

import com.marceme.tddfasterpracting.datamanager.PixabayAPIService;
import com.marceme.tddfasterpracting.datamanager.PixabayAPIServiceFactory;
import com.marceme.tddfasterpracting.datamanager.PixabayDataManager;
import com.marceme.tddfasterpracting.imageui.ImageAdapter;
import com.marceme.tddfasterpracting.imageui.ImagesPresenter;
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

    @Provides @Singleton
    PixabayAPIService providePixabayAPIService(){
        return PixabayAPIServiceFactory.makeImageApiService();
    }

    @Provides @Singleton
    PixabayDataManager providePixabayDataManager(PixabayAPIService pixabayAPIService){
        return new PixabayDataManager(pixabayAPIService);
    }

    @Provides @Singleton
    ImagesPresenter provideImagesPresenter(PixabayDataManager pixabayDataManager){
        return new ImagesPresenter(pixabayDataManager);
    }

    @Provides @Singleton
    ImageAdapter provideImageAdapter(){
        return new ImageAdapter();
    }
}
