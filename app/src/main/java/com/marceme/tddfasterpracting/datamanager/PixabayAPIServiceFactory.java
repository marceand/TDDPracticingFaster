package com.marceme.tddfasterpracting.datamanager;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Marcelino Yax-marce7j@gmail.com-Android Developer
 *         Created on 2/10/2017.
 */

public class PixabayAPIServiceFactory {

    public static PixabayAPIService makeImageApiService(){
        return new Retrofit.Builder()
                .baseUrl(PixabayAPIService.PIXABAY_BASE_URL)
                .client(keyApiParameterClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(PixabayAPIService.class);
    }

    private static OkHttpClient keyApiParameterClient() {
        return new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request request = chain.request();
                HttpUrl url = request.url().newBuilder().addQueryParameter(
                        PixabayAPIService.API_KEY_NAME, PixabayAPIService.API_KEY).build();
                request = request.newBuilder().url(url).build();
                return chain.proceed(request);
            }

        }).build();
    }
}
