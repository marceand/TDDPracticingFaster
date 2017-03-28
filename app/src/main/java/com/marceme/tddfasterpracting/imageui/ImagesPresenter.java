package com.marceme.tddfasterpracting.imageui;

import android.util.Log;

import com.marceme.tddfasterpracting.datamanager.PixabayDataManager;
import com.marceme.tddfasterpracting.model.Image;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * @author Marcelino Yax-marce7j@gmail.com-Android Developer
 *         Created on 2/8/2017.
 */

public class ImagesPresenter implements ImageActionListener {


    private ImageMvpView mImageMvpView;
    private PixabayDataManager mDataManager;

    public ImagesPresenter(PixabayDataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(ImageMvpView view) {
        mImageMvpView = view;
    }

    @Override
    public void loadImages() {
        mImageMvpView.showImageProgress(true);
        mDataManager.getImages()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(new Subscriber<List<Image>>() {
                    @Override
                    public void onCompleted() {
                        mImageMvpView.showImageProgress(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mImageMvpView.showImageProgress(false);
                        mImageMvpView.showLoadImageError();
                    }

                    @Override
                    public void onNext(List<Image> imagesList) {
                        if(!imagesList.isEmpty()) {
                            mImageMvpView.showImages(imagesList);
                        }else {
                            mImageMvpView.showEmptyMessage();
                        }
                    }
        });

    }

    @Override
    public void detachView() {
        mImageMvpView = null;
    }
}
