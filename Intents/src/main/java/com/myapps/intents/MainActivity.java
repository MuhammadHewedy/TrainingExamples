package com.myapps.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    IntentHelper.MainActivityIntents mMainActivityIntents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainActivityIntents = IntentHelper.prepareInents(this);
    }



    public void callButtonClicked(View view) {
        startActivity(mMainActivityIntents.mCallIntent);
    }

    public void openUrlButtonClicked(View view) {
        startActivity(mMainActivityIntents.mOpenUrlIntent);
    }

    public void sendEmailButtonClicked(View view) {
        Intent chooseIntent = Intent.createChooser(mMainActivityIntents.mSendEmailIntent,
                getString(R.string.choose_email_text));
        startActivity(chooseIntent);
    }

    public void getMapButtonClicked(View view) {
        startActivity(mMainActivityIntents.mGetMapIntnet);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
