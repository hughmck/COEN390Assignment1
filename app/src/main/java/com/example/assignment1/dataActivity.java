package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class dataActivity extends AppCompatActivity {

    protected static final String TAG = "dataActivity";
    protected TextView dataView1 = null;
    protected TextView dataView2 = null;
    protected TextView dataView3 = null;
    protected TextView dataView4 = null;

    protected void setupUI() { //sets up all of the buttons and inputs in the UI
        dataView1 = (TextView) findViewById(R.id.eventName1);
        dataView2 = (TextView) findViewById(R.id.eventName2);
        dataView3 = (TextView) findViewById(R.id.eventName3);
        dataView4 = (TextView) findViewById(R.id.totalEvents);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_data);
        Log.d(TAG, "The onCreate() event");
        setupUI();
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.settingsActivity), Context.MODE_PRIVATE);
        String counterOneInput = sharedPreferences.getString(getString(R.string.settings), null);
        String counterTwoInput = sharedPreferences.getString(getString(R.string.settings), null);
        String counterThreeInput = sharedPreferences.getString(getString(R.string.settings), null);
        String maximumCountsInputInteger = sharedPreferences.getString(getString(R.string.settings), null);
        dataView1.setText(counterOneInput);
        dataView2.setText(counterTwoInput);
        dataView3.setText(counterThreeInput);
        dataView4.setText(maximumCountsInputInteger);
    }

    public void onStart(){
        super.onStart();

    }


    //@Override
   // public boolean onOptionsItemSelected(MenuItem item) {
      //  switch (item.getItemId()) {
          //  case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
               // return true;

         //   case R.id.action_favorite:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
             //   return true;

          //  default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
          //      return super.onOptionsItemSelected(item);

      //  }
   // }
    Intent intent = getIntent(); //receiving intent from activity main
}