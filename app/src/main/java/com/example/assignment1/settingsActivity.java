package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;

public class settingsActivity extends AppCompatActivity {

    String counterOneInputString, counterTwoInputString, counterThreeInputString;
    int maximumCountsInputInteger;



    protected static final String TAG = "settingsActivity"; //do I even need to set up UI?

    protected TextView counterOneName = null;
    protected TextView counterTwoName = null;
    protected TextView counterThreeName = null;
    protected TextView maximumCounts = null;
    protected TextInputEditText counterOneInput = null;
    protected TextInputEditText counterTwoInput = null;
    protected TextInputEditText counterThreeInput = null;
    protected TextInputEditText maximumCountsInput = null;
    protected Button saveButton;

    protected void setupUI() { //sets up all of the buttons and inputs in the UI
        counterOneName = (TextView) findViewById(R.id.counterOneName);
        counterTwoName = (TextView) findViewById(R.id.counterTwoName);
        counterThreeName = (TextView) findViewById(R.id.counterThreeName);
        maximumCounts = (TextView) findViewById(R.id.maximumCounts);
        counterOneInput = (TextInputEditText) findViewById(R.id.counterOneInput);
        counterTwoInput = (TextInputEditText) findViewById(R.id.counterTwoInput);
        counterThreeInput = (TextInputEditText) findViewById(R.id.counterThreeInput);
        maximumCountsInput = (TextInputEditText) findViewById(R.id.maximumCountsInput);
        saveButton = (Button) findViewById(R.id.saveButton); //why the error?
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterOneInputString = counterOneInput.getText().toString();
                counterTwoInputString = counterTwoInput.getText().toString();
                counterThreeInputString = counterThreeInput.getText().toString();
                maximumCountsInputInteger = Integer.valueOf(maximumCountsInput.getText().toString());
                SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.settings), Context.MODE_PRIVATE); //creates shredPreferences object
                SharedPreferences.Editor editor = sharedPreferences.edit(); //returns editor for this file
                editor.putString("Event A name", counterOneInputString); // Todo grab all inputs from edit text, save them with a unique key
                editor.putString("Event B name", counterTwoInputString);
                editor.putString("Event C name", counterThreeInputString);
                System.out.println(counterOneInputString+counterTwoInputString+counterThreeInputString);
                editor.apply();
                sharedPreferences.getString("Event A Name", null);
                System.out.println(sharedPreferences.getString("Event A Name", null));
                Toast toast = Toast.makeText(getApplicationContext(), "Settings saved", Toast.LENGTH_LONG);
                toast.show(); //shows that the settings have been saved by the user
                returnToMainActivity();
            }
        });
    }

    //@Override
   // public boolean onCreateOptionsMenu(Menu menu){
       // MenuInflater inflater = getMenuInflater();
      //  inflater.inflate(R.menu.menuresources, menu);
       // return true; //need to make on click listeners for dropdown
    //}

    //@Override
   // public boolean onOptionsItemSelected(MenuItem item){
    //    switch (item.getItemID()){
       //     case R.id.
      //  }
   // }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Log.d(TAG, "The onCreate() event");
        setupUI();
        Intent intent = getIntent(); //receiving intent from activity main
    }
    private void returnToMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}