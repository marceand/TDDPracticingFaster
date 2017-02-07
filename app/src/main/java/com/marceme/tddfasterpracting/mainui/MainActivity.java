package com.marceme.tddfasterpracting.mainui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.marceme.tddfasterpracting.MainApplication;
import com.marceme.tddfasterpracting.R;
import com.marceme.tddfasterpracting.feedbackui.FeedbackActivity;
import com.marceme.tddfasterpracting.imageui.ImageActivity;
import com.marceme.tddfasterpracting.nutritionixui.NutritionixActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView{

    @Inject
    UserActionListener mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        injectMainPresenter();
        bindViewWithButterKnife();
    }


    @Override
    protected void onResume() {
        super.onResume();
        mMainPresenter.attachView(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMainPresenter.detachView();
    }

    private void injectMainPresenter() {
        ((MainApplication)getApplication()).getComponent().inject(this);
    }

    private void bindViewWithButterKnife() {
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_image)
    void imageBtnListener(){
        mMainPresenter.loadImageActivity();
    }

    @OnClick(R.id.button_nutritionix)
    void nutritionixBtnListener(){
        mMainPresenter.loadNutritionixActivity();
    }

    @OnClick(R.id.button_feedback)
    void feedbackBtnListener(){
        mMainPresenter.loadFeedbackActivity();
    }

    @Override
    public void showImageActivity() {
        Intent intent = new Intent(this, ImageActivity.class);
        startActivity(intent);
    }

    @Override
    public void showNutritionixActivity() {
        Intent intent = new Intent(this, NutritionixActivity.class);
        startActivity(intent);
    }

    @Override
    public void showFeedbackActivity() {
        Intent intent = new Intent(this,FeedbackActivity.class);
        startActivity(intent);
    }
}
