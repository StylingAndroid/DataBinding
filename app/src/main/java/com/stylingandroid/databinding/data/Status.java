package com.stylingandroid.databinding.data;

import android.support.annotation.NonNull;

@SuppressWarnings("Unused")
public class Status {

    private final String name;
    private final String screenName;
    private final String text;
    private final String imageUrl;

    public Status(@NonNull String name, @NonNull String screenName, @NonNull String text, @NonNull String imageUrl) {
        this.name = name;
        this.screenName = screenName;
        this.text = text;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getText() {
        return text;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
