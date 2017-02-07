package com.marceme.tddfasterpracting.mainui;

/**
 * @author Marcelino Yax-marce7j@gmail.com-Android Developer
 *         Created on 2/7/2017.
 */

public interface UserActionListener {
    void attachView(MainView mainView);
    void loadImageActivity();
    void loadNutritionixActivity();
    void loadFeedbackActivity();
    void detachView();
}
