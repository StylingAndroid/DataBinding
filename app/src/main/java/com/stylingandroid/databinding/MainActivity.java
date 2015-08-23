package com.stylingandroid.databinding;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import twitter4j.Status;

public class MainActivity extends Activity implements TwitterConsumer {
    private TwitterClient twitterClient;
    private StatusAdapter adapter;
    private RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (RecyclerView) findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = StatusAdapter.newInstance();
        list.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        twitterClient = TwitterClient.newInstance(this);
        twitterClient.connect();
    }

    @Override
    protected void onPause() {
        twitterClient.shutdown();
        super.onPause();
    }

    @Override
    public void addToHomeStream(final List<Status> newStatuses) {
        runOnUiThread(
                new Runnable() {
                    @Override
                    public void run() {
                        adapter.setStatuses(newStatuses);
                    }
                }
        );
    }

    @Override
    public void onConnected() {
        twitterClient.fetchHomeStream(1);
    }

    @Override
    public void onError(Exception e) {
        Snackbar.make(list, "Twitter Error: " + e.toString(), Snackbar.LENGTH_LONG).show();
    }
}
