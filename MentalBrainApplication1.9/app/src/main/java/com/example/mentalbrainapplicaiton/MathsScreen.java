package com.example.mentalbrainapplicaiton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MathsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths_screen);
    }

    public void openMentalMaths(View view) {
        Intent intent = new Intent(this, MentalMaths.class);
        startActivity(intent);
    }

    public void openMathsQuiz(View view) {
        Intent intent = new Intent(this, MathsQuiz.class);
        startActivity(intent);
    }

    /***
     * Method to be used to return to the main menu.  Called the user selects the 'Home' button.
     */
    public void openMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * Method to be used to open respective AccountDetails Activity, called when the user icon is clicked.
     */
    public void openAccountDetails(View view) {

        Intent intent = new Intent(this, UserRegister.class);
        startActivity(intent);
    }

    /**
     * Method to be used to start Settings Activity, called when the Settings Button is clicked.
     */
    public void openSettings(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
}