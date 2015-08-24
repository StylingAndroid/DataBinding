package com.stylingandroid.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.stylingandroid.databinding.data.Status;
import com.stylingandroid.databinding.databinding.StatusItemBinding;

public class StatusViewHolder extends RecyclerView.ViewHolder {
    private StatusItemBinding binding;

    public StatusViewHolder(View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
    }

    public void bind(Status status) {
        binding.setStatus(status);
        binding.setHandler(new ClickHandler(status));
    }

}
