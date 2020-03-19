package com.example.mentalbrainapplicaiton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


/**
 * This class provides the functionality for the main activity of the application
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Method to be used to start MentalMaths Activity, called when the MentalMaths Button is clicked.
     */
    public void openMentalMaths(View view) {
        Intent intent = new Intent(this, MentalMaths.class);
        startActivity(intent);
    }

    /**
     * Method to be used to start LeaderBoard Activity, called when the LeaderBoard Button is clicked.
     */
    public void openLeaderBoard(View view) {
        Intent intent = new Intent(this, LeaderBoards.class);
        startActivity(intent);
    }

    /**
     * Method to be used to start Settings Activity, called when the Settings Button is clicked.
     */
    public void openSettings(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    /**
     * Method to be used to start Memory Activity, called when the Memory Button is clicked.
     */
    public void openMemory(View view) {
        Intent intent = new Intent(this, MentalMaths.class);
        startActivity(intent);
    }

    /**
     * Method to be used to start ProblemSolving Activity, called when the ProblemSolving Button is clicked.
     */
    public void openProblemSolving(View view) {
        Intent intent = new Intent(this, ProblemSolving.class);
        startActivity(intent);
    }
}


