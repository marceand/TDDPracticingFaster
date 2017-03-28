package com.marceme.tddfasterpracting.imageui;

import com.marceme.tddfasterpracting.model.Image;

import java.util.List;

/**
 * @author Marcelino Yax-marce7j@gmail.com-Android Developer
 *         Created on 2/8/2017.
 */

public interface ImageMvpView {
    void showImageProgress(boolean show);
    void showImages(List<Image> imageList);
    void showLoadImageError();
    void showEmptyMessage();
}
