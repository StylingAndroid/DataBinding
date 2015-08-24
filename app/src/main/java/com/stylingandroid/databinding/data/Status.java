package com.stylingandroid.databinding.data;

import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

@SuppressWarnings("Unused")
public class Status {

    private final String name;
    private final String screenName;
    private final String text;
    private final String imageUrl;
    private final Status quotedStatus;
    private ObservableField<Status> observableQuotedStatus;

    public Status(@NonNull String name, @NonNull String screenName, @NonNull String text, @NonNull String imageUrl, @Nullable Status quotedStatus) {
        this.name = name;
        this.screenName = screenName;
        this.text = text;
        this.imageUrl = imageUrl;
        this.quotedStatus = quotedStatus;
        observableQuotedStatus = new ObservableField<>();
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

    public boolean hasQuotedStatus() {
        return quotedStatus != null;
    }

    public void updateQuotedStatus() {
        observableQuotedStatus.set(quotedStatus);
    }

    public void clearQuotedStatus() {
        observableQuotedStatus.set(null);
    }

    public ObservableField<Status> getObservableQuotedStatus() {
        return observableQuotedStatus;
    }
}
