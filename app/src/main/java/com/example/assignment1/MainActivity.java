package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    protected sharedPreferencesHelper sharedPreferencesHelper = new sharedPreferencesHelper();

    protected static final String TAG = "MainActivity"; //do I even need to set up UI?
    protected Button settingsButton = null;
    protected Button eventAButton = null;
    protected Button eventBButton = null;
    protected Button eventCButton = null;
    protected Button showMyCounts = null;
    protected TextView totalCount = null;

    protected void setupUI(){ //sets up all of the buttons and inputs in the UI
        totalCount = (TextView) findViewById(R.id.totalCount);
        settingsButton = (Button) findViewById(R.id.settingsButton);
        eventAButton = (Button) findViewById(R.id.eventAButton);
        eventBButton = (Button) findViewById(R.id.eventBButton);
        eventCButton = (Button) findViewById(R.id.eventCButton);
        showMyCounts = (Button) findViewById(R.id.showMyCounts);
        showMyCounts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDataActivity();
            }
        });
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSettingsActivity();
            }
        });
    }

    public void openDataActivity(){
        Intent intent = new Intent(this, dataActivity.class);
        startActivity(intent);
    }

    public void openSettingsActivity(){
        Intent intent = new Intent(this, settingsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "The onCreate() event");
        setupUI();
    }


    @Override
    protected void onStart()
    {
        super.onStart(); //overrides onstart
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.settings), Context.MODE_PRIVATE);
        String counterOneInput = sharedPreferences.getString("Event A Name", null);
        String counterTwoInput = sharedPreferences.getString(getString(R.string.settings), null);
        String counterThreeInput = sharedPreferences.getString(getString(R.string.settings), null);
        String maximumCountsInputInteger = sharedPreferences.getString(getString(R.string.settings), null);//uses get string to receive the input
       System.out.println(counterOneInput+counterTwoInput+counterThreeInput);
        if(counterOneInput == null)
            openSettingsActivity();
        else
            eventAButton.setText(counterOneInput);
        if(counterTwoInput == null)
            openSettingsActivity();
        else
            eventBButton.setText(counterTwoInput);
        if(counterThreeInput == null)
            openSettingsActivity();
        else
            eventCButton.setText(counterThreeInput);
        if(maximumCountsInputInteger == null)
            System.out.println("no max counts");
        else
            settingsButton.setText(maximumCountsInputInteger);
    }
}