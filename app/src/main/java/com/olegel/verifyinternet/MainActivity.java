package com.olegel.verifyinternet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Checking(new ICallBack() {
            @Override
            public void requestCallBack(boolean connectionResult, int responseCode) {
                Log.d(TAG, "requestCallBack: "+connectionResult+" "+responseCode);
            }
        });
    }
}
