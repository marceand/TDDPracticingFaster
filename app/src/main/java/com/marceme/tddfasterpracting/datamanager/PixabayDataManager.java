package com.marceme.tddfasterpracting.datamanager;

import com.marceme.tddfasterpracting.model.Image;
import com.marceme.tddfasterpracting.model.Photos;
import com.marceme.tddfasterpracting.util.CategoryGenerator;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * @author Marcelino Yax-marce7j@gmail.com-Android Developer
 *         Created on 2/8/2017.
 */

public class PixabayDataManager {


    private PixabayAPIService mImageAPIService;

    public PixabayDataManager(PixabayAPIService imageAPIService) {
        mImageAPIService = imageAPIService;
    }

    public Observable<List<Image>> getImages() {
        String randomCategory = CategoryGenerator.generateRandomCategory();
        return mImageAPIService.getImages(randomCategory,
                PixabayAPIService.IMAGE_TYPE,
                PixabayAPIService.MAXIMUM_RESULT).map(new Func1<Photos, List<Image>>() {
                    @Override
                    public List<Image> call(Photos photos) {
                        return photos.hits;
                    }
        });
    }

}
