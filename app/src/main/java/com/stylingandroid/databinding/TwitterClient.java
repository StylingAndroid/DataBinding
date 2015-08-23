package com.stylingandroid.databinding;

import twitter4j.AsyncTwitter;
import twitter4j.AsyncTwitterFactory;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterAdapter;
import twitter4j.TwitterException;
import twitter4j.TwitterMethod;
import twitter4j.User;
import twitter4j.auth.AccessToken;

public class TwitterClient extends TwitterAdapter {
    private static final int PAGE_SIZE = 50;

    private final AsyncTwitter asyncTwitter;
    private final TwitterConsumer streamConsumer;

    public static TwitterClient newInstance(TwitterConsumer streamConsumer) {
        AsyncTwitter asyncTwitter = AsyncTwitterFactory.getSingleton();
        asyncTwitter.setOAuthConsumer(BuildConfig.TWITTER_CONSUMER_KEY, BuildConfig.TWITTER_CONSUMER_SECRET);
        asyncTwitter.setOAuthAccessToken(new AccessToken(BuildConfig.TWITTER_ACCESS_KEY, BuildConfig.TWITTER_ACCESS_SECRET));
        return new TwitterClient(asyncTwitter, streamConsumer);
    }

    TwitterClient(AsyncTwitter asyncTwitter, TwitterConsumer streamConsumer) {
        this.asyncTwitter = asyncTwitter;
        this.streamConsumer = streamConsumer;
    }

    @Override
    public void onException(TwitterException te, TwitterMethod method) {
        streamConsumer.onError(te);
    }

    @Override
    public void verifiedCredentials(User user) {
        streamConsumer.onConnected();
    }

    public void fetchHomeStream(long sinceId) {
        Paging paging = new Paging(1, PAGE_SIZE, sinceId);
        asyncTwitter.getHomeTimeline(paging);
    }

    @Override
    public void gotHomeTimeline(ResponseList<Status> statuses) {
        streamConsumer.addToHomeStream(statuses);
    }

    public void shutdown() {
        asyncTwitter.shutdown();
    }

    public void connect() {
        asyncTwitter.addListener(this);
        asyncTwitter.verifyCredentials();
    }
}
