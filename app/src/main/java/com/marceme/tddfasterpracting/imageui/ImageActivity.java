package com.marceme.tddfasterpracting.imageui;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.marceme.tddfasterpracting.MainApplication;
import com.marceme.tddfasterpracting.R;
import com.marceme.tddfasterpracting.injection.ApplicationComponent;
import com.marceme.tddfasterpracting.model.Image;
import com.marceme.tddfasterpracting.util.DialogFactory;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;




public class ImageActivity extends AppCompatActivity implements ImageMvpView {

    @Inject ImagesPresenter mImagesPresenter;
    @Inject ImageAdapter mImageAdapter;
    @BindView(R.id.recycler_view_images)
    RecyclerView mImageRecyclerView;
    @BindView(R.id.text_no_images)
    TextView mNoImageText;
    @BindView(R.id.progress_image)
    ProgressBar mProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        injectImagesPresenter();
        bindViewWithButterKnife();
        setupRecyclerView();
        attachViewToPresenter();

    }

    private void injectImagesPresenter() {
        ((MainApplication)getApplication()).getComponent().inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mImagesPresenter.detachView();
    }

    private void attachViewToPresenter() {
        mImagesPresenter.attachView(this);
        mImagesPresenter.loadImages();
    }

    private void bindViewWithButterKnife() {
        ButterKnife.bind(this);
    }

    private void setupRecyclerView() {
        mImageRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mImageRecyclerView.setAdapter(mImageAdapter);
    }

    @Override
    public void showImageProgress(boolean show) {
        mProgress.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showImages(List<Image> imageList) {
        mImageAdapter.setImages(imageList);
    }

    @Override
    public void showLoadImageError() {
        mNoImageText.setVisibility(View.VISIBLE);
    }

    @Override
    public void showEmptyMessage() {
        DialogFactory.createErrorDialog(this,
                getString(R.string.error_no_image)).show();
    }
}
