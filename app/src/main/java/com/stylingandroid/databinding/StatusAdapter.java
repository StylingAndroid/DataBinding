package com.stylingandroid.databinding;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stylingandroid.databinding.data.Status;
import com.stylingandroid.databinding.data.StatusMarshaller;

import java.util.ArrayList;
import java.util.List;

public class StatusAdapter extends RecyclerView.Adapter<StatusViewHolder> {
    private final List<Status> statuses;
    private final StatusMarshaller marshaller;

    public static StatusAdapter newInstance() {
        List<Status> statuses = new ArrayList<>();
        StatusMarshaller marshaller = new StatusMarshaller();
        return new StatusAdapter(statuses, marshaller);
    }

    StatusAdapter(List<Status> statuses, StatusMarshaller marshaller) {
        this.statuses = statuses;
        this.marshaller = marshaller;
    }

    @Override
    public StatusViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View statusContainer = inflater.inflate(R.layout.status_item, parent, false);
        return new StatusViewHolder(statusContainer);
    }

    @Override
    public void onBindViewHolder(StatusViewHolder holder, int position) {
        Status status = statuses.get(position);
        holder.bind(status);
    }

    @Override
    public int getItemCount() {
        return statuses.size();
    }

    public void setStatuses(List<twitter4j.Status> statuses) {
        this.statuses.clear();
        this.statuses.addAll(marshaller.marshall(statuses));
        notifyDataSetChanged();
    }

}
