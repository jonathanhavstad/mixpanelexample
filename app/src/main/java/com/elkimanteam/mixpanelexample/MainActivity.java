package com.elkimanteam.mixpanelexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mixpanel.android.mpmetrics.MixpanelAPI;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private MixpanelAPI mixpanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String projectToken = getString(R.string.mixpanel_flurry_token);
        mixpanel = MixpanelAPI.getInstance(this, projectToken);
        MixpanelAPI.People people = mixpanel.getPeople();
        people.identify(getString(R.string.unique_user_id));
        people.set("trackme", true);
        people.initPushHandling(getString(R.string.firebase_server_id));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mixpanel.flush();
    }
}
