package com.example.mentalbrainapplicaiton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MathsQuiz extends AppCompatActivity {

    public boolean easy = false;
    public boolean medium = false;
    public boolean hard = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths_quiz);

    }
        public void selectEasy(View view) {
            easy = true;
        }
        public void selectMedium(View view) {
            medium = true;
        }
        public void selectHard(View view) {
            hard = true;
        }

        public void startQuiz(View view) {
            Intent easyintent = new Intent(this, EasyQuiz.class);
            Intent mediumintent = new Intent(this, MediumQuiz.class);
            Intent hardintent = new Intent(this, HardQuiz.class);
            if (easy == true) {
                easyintent.putExtra("easy", true);
                startActivity(easyintent);
            }
            if(medium == true){
                mediumintent.putExtra("medium", true);
                startActivity(mediumintent);
            }
            if(hard == true){
                hardintent.putExtra("hard", true);
                startActivity(hardintent);
            }
        }

    /**
     * Method to be used to start Settings Activity, called when the Settings Button is clicked.
     */
    public void openSettings(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    /**
     * Method to be used to open respective AccountDetails Activity, called when the user icon is clicked.
     */
    public void openAccountDetails(View view) {

        Intent intent = new Intent(this, UserRegister.class);
        startActivity(intent);
    }

    /***
     * Method to be used to return to the main menu.  Called the user selects the 'Home' button.
     */
    public void openMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



    }
