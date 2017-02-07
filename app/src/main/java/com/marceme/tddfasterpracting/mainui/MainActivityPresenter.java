package com.marceme.tddfasterpracting.mainui;

/**
 * @author Marcelino Yax-marce7j@gmail.com-Android Developer
 *         Created on 2/7/2017.
 */

public class MainActivityPresenter implements UserActionListener {

    private MainView mMainView;

    @Override
    public void attachView(MainView mainView) {
        mMainView = mainView;
    }

    @Override
    public void detachView() {
        mMainView = null;
    }

    @Override
    public void loadImageActivity() {
        mMainView.showImageActivity();
    }

    @Override
    public void loadNutritionixActivity() {
        mMainView.showNutritionixActivity();
    }

    @Override
    public void loadFeedbackActivity() {
        mMainView.showFeedbackActivity();
    }
}
