package com.olegel.verifyinternet;

import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executors;

/**
 * Created by Oleg on 19.07.2017.
 */

public class Checking {
    private ICallBack callback;
    private static final String TAG = Checking.class.getSimpleName();
    private String testUrl = "https://www.google.com";
    private URL url;
    private HttpURLConnection connection;

    public Checking(ICallBack callback) {
        this.callback = callback;
        tryOut();
    }

    private void tryOut() {
        if (callback == null) {
            return;
        }
        Executors.newCachedThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    url = new URL(testUrl);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(3_000);
                    connection.setReadTimeout(10_000);
                    connection.setRequestMethod("HEAD");
                    if (connection.getResponseCode() == 200) {
                        callback.requestCallBack(true, connection.getResponseCode());
                        return;
                    } else {
                        callback.requestCallBack(false,connection.getResponseCode());
                    }
                } catch (MalformedURLException e) {
                    callback.requestCallBack(false,-1);
                    e.printStackTrace();
                } catch (IOException e) {
                    callback.requestCallBack(false,-1);
                    e.printStackTrace();
                } finally {
                    try {
                        connection.disconnect();
                        Log.d(TAG, "run:2 ");
                    } catch (Exception e) {

                    }

                }
            }
        });
    }
}
