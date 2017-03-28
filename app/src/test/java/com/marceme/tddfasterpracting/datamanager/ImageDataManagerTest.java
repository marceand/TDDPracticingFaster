package com.marceme.tddfasterpracting.datamanager;

import com.marceme.tddfasterpracting.DataFactory;
import com.marceme.tddfasterpracting.model.Image;
import com.marceme.tddfasterpracting.model.Photos;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import rx.Observable;
import rx.observers.TestSubscriber;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;

/**
 * @author Marcelino Yax-marce7j@gmail.com-Android Developer
 *         Created on 2/9/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class ImageDataManagerTest {

    @Mock
    PixabayAPIService mImageAPIService;
    private PixabayDataManager mImageDataManager;

    @Before
    public void setUp() throws Exception {
        mImageDataManager = new PixabayDataManager(mImageAPIService);
    }

    @Test
    public void shouldGetImagesFromAPIService() throws Exception{

        List<Image> imageList = DataFactory.makeImages(5);
        Photos photos = new Photos();
        photos.hits = imageList;
        doReturn(Observable.just(photos)).when(mImageAPIService)
                .getImages(anyString(),anyString(),anyInt());

        TestSubscriber<List<Image>> testSubscriber = new TestSubscriber<>();
        mImageDataManager.getImages().subscribe(testSubscriber);

        testSubscriber.assertCompleted();
        testSubscriber.assertValueCount(1);
        testSubscriber.assertValue(imageList);

    }



}