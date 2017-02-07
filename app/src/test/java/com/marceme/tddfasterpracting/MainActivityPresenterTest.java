package com.marceme.tddfasterpracting;

import com.marceme.tddfasterpracting.mainui.MainActivityPresenter;
import com.marceme.tddfasterpracting.mainui.MainView;
import com.marceme.tddfasterpracting.mainui.UserActionListener;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author Marcelino Yax-marce7j@gmail.com-Android Developer
 *         Created on 2/7/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainActivityPresenterTest {

    @Mock
    MainView mMainViewMock;
    private UserActionListener mUserActionPresenter;

     @Before
      public void setUp() throws Exception {
         mUserActionPresenter = new MainActivityPresenter();
         mUserActionPresenter.attachView(mMainViewMock);
      }

    @Test
    public void shouldShowImageActivity() throws Exception{
        mUserActionPresenter.loadImageActivity();
        verify(mMainViewMock, times(1)).showImageActivity();
    }

    @Test
    public void shouldShowNutritionixActivity() throws Exception{
        mUserActionPresenter.loadNutritionixActivity();
        verify(mMainViewMock, times(1)).showNutritionixActivity();
    }

    @Test
    public void shouldShowFeedbackActivity() throws Exception{
        mUserActionPresenter.loadFeedbackActivity();
        verify(mMainViewMock, times(1)).showFeedbackActivity();
    }

    @After
    public void tearDown() throws Exception {
        mUserActionPresenter.detachView();
    }
}