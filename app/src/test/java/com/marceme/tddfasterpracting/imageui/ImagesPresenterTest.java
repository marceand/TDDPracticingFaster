package com.marceme.tddfasterpracting.imageui;

import com.marceme.tddfasterpracting.DataFactory;
import com.marceme.tddfasterpracting.RxSchedulersOverrideRule;
import com.marceme.tddfasterpracting.datamanager.PixabayDataManager;
import com.marceme.tddfasterpracting.model.Image;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


import rx.Observable;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author Marcelino Yax-marce7j@gmail.com-Android Developer
 *         Created on 2/8/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ImagesPresenterTest {

    @Mock
    ImageMvpView mockView;
    @Mock
    PixabayDataManager mMockDataManager;
    ImageActionListener mImagePresenter;

    @Rule
    public final RxSchedulersOverrideRule mOverrideSchedulersRule = new RxSchedulersOverrideRule();

     @Before
     public void setUp() throws Exception {
          mImagePresenter = new ImagesPresenter(mMockDataManager);
          mImagePresenter.attachView(mockView);
      }

    @Test
    public void shouldLoadImagesSuccessful() throws Exception{

        List<Image> imageList = DataFactory.makeImages(5);
        stubDataManagerGetImages(Observable.just(imageList));

        mImagePresenter.loadImages();

        verify(mockView, times(1)).showImageProgress(true);
        verify(mockView, times(1)).showImages(imageList);
        verify(mockView, times(1)).showImageProgress(false);
    }


    @Test
    public void shouldHandleLoadImagesFail() throws Exception{
        List<Image> imageList = DataFactory.makeImages(5);

        stubDataManagerGetImages(Observable.error(new RuntimeException()));

        mImagePresenter.loadImages();

        verify(mockView, times(1)).showImageProgress(true);
        verify(mockView, never()).showImages(imageList);
        verify(mockView, times(1)).showLoadImageError();
        verify(mockView, times(1)).showImageProgress(false);

    }

    @Test
    public void shouldHandleEmptyLoadedImages() throws Exception{

        List<Image> imageEmptyList = new ArrayList<>();
        stubDataManagerGetImages(Observable.just(imageEmptyList));

        mImagePresenter.loadImages();

        verify(mockView, times(1)).showImageProgress(true);
        verify(mockView, never()).showImages(imageEmptyList);
        verify(mockView, times(1)).showEmptyMessage();
        verify(mockView, times(1)).showImageProgress(false);
    }
    @After
    public void tearDown() throws Exception {
        mImagePresenter.detachView();
    }

    private void stubDataManagerGetImages(Observable observable) {
        doReturn(observable).when(mMockDataManager).getImages();
    }
}