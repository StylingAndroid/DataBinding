package com.stylingandroid.databinding;

import java.util.List;

import twitter4j.Status;

public interface TwitterConsumer {
    void addToHomeStream(List<Status> newStatuses);

    void onConnected();

    void onError(Exception e);
}
