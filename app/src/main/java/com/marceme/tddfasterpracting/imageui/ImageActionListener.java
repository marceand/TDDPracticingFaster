package com.marceme.tddfasterpracting.imageui;

/**
 * @author Marcelino Yax-marce7j@gmail.com-Android Developer
 *         Created on 2/8/2017.
 */

public interface ImageActionListener {

    void attachView(ImageMvpView view);
    void detachView();
    void loadImages();
}
