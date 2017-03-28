package com.marceme.tddfasterpracting.datamanager;

import com.marceme.tddfasterpracting.model.Image;
import com.marceme.tddfasterpracting.model.Photos;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author Marcelino Yax-marce7j@gmail.com-Android Developer
 *         Created on 2/10/2017.
 */
public interface PixabayAPIService {

    String PIXABAY_BASE_URL = "https://pixabay.com/";
    String API_KEY_NAME = "key";
    String API_KEY = "";
    String IMAGE_TYPE = "photo";
    int MAXIMUM_RESULT = 20;

    @GET("api/")
    Observable<Photos> getImages(@Query("category")String category,
                                                   @Query("image_type") String imageType,
                                                   @Query("per_page") int resultSize);
}
