package com.marceme.tddfasterpracting;

import com.marceme.tddfasterpracting.model.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcelino Yax-marce7j@gmail.com-Android Developer
 *         Created on 2/8/2017.
 */
public class DataFactory {
    public static List<Image> makeImages(int size) {
        List<Image> imageList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            imageList.add(newImage());
        }
        return imageList;
    }

    private static Image newImage() {
        return new Image();
    }
}
