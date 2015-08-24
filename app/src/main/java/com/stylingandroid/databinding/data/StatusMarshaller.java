package com.stylingandroid.databinding.data;

import java.util.ArrayList;
import java.util.List;

import twitter4j.User;

public class StatusMarshaller {

    public List<Status> marshall(List<twitter4j.Status> statuses) {
        List<Status> newStatuses = new ArrayList<>(statuses.size());
        for (twitter4j.Status status : statuses) {
            newStatuses.add(marshall(status));
        }
        return newStatuses;
    }

    private Status marshall(twitter4j.Status status) {
        User user = status.getUser();
        Status quotedStatus = null;
        if (status.getQuotedStatus() != null) {
            quotedStatus = marshall(status.getQuotedStatus());
        }
        return new Status(user.getName(), user.getScreenName(), status.getText(), user.getBiggerProfileImageURL(), quotedStatus);
    }
}
