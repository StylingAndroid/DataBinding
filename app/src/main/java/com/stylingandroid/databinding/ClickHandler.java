package com.stylingandroid.databinding;

import android.support.design.widget.Snackbar;
import android.view.View;

import com.stylingandroid.databinding.data.Status;

public class ClickHandler {
    private final Status status;

    public ClickHandler(Status status) {
        this.status = status;
    }

    public void onClick(View view) {
        Snackbar.make(view, "Item clicked", Snackbar.LENGTH_LONG).show();
    }
}
