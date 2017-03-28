package com.marceme.tddfasterpracting.util;

import java.util.Random;

/**
 * @author Marcelino Yax-marce7j@gmail.com-Android Developer
 *         Created on 2/10/2017.
 */

public class CategoryGenerator {

    private static String[] category = {"fashion",
            "nature",
            "backgrounds",
            "science",
            "education",
            "people",
            "feelings",
            "religion",
            "health",
            "places",
            "animals",
            "industry",
            "food",
            "computer",
            "sports",
            "transportation",
            "travel",
            "buildings",
            "business",
            "music"};

    public static String generateRandomCategory(){
        Random random = new Random();
        int randomIndex = random.nextInt(category.length);
        return category[randomIndex];
    }
}
