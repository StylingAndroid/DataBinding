package com.stylingandroid.databinding;

import android.view.View;

import com.stylingandroid.databinding.data.Status;

public class ClickHandler {
    private final Status status;

    public ClickHandler(Status status) {
        this.status = status;
    }

    public void onClick(View view) {
        if (status.getObservableQuotedStatus().get() == null) {
            status.updateQuotedStatus();
        } else {
            status.clearQuotedStatus();
        }
    }
}
