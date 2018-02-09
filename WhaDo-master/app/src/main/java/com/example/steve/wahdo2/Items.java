package com.example.steve.wahdo2;

/**
 * Created by steve on 2/4/2018.
 */

public class Items {
    private String mImageUrl;
    private String mCreator;
    private int mLikes;

    public Items(String imageUrl, String creator, int likes) {
        mImageUrl = imageUrl;
        mCreator = creator;
        mLikes = likes;
    }

    public String getImageUrl(){
        return mImageUrl;
    }

    public String getCreator() {
        return mCreator;
    }

    public int getLikeCount() {
        return mLikes;
    }
}
