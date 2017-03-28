package com.marceme.tddfasterpracting.imageui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.marceme.tddfasterpracting.R;
import com.marceme.tddfasterpracting.model.Image;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindFloat;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Marcelino Yax-marce7j@gmail.com-Android Developer
 *         Created on 2/19/2017.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private List<Image> mImages;

    public ImageAdapter() {
        mImages = Collections.emptyList();
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_row_layout, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {

        Image image = mImages.get(position);
        Picasso.with(holder.itemView.getContext())
                .load(image.getWebformatURL())
                .into(holder.mPhoto);
        holder.mLikesData.setText(image.getLikes());
        holder.mCommentData.setText(image.getComments());
        holder.mFavoriteData.setText(image.getFavorites());


    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    public void setImages(List<Image> images){
        this.mImages = images;
        notifyDataSetChanged();
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.image_photo)
        ImageView mPhoto;

        @BindView(R.id.text_likes_data)
        TextView mLikesData;

        @BindView(R.id.text_comment_data)
        TextView mCommentData;

        @BindView(R.id.text_favorite_data)
        TextView mFavoriteData;

        public ImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
