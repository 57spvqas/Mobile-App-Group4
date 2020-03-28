package com.example.mentalbrainapplicaiton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        TextView textView = findViewById(R.id.textView2);
        textView.setText("Results");
        TextView textView1 = findViewById(R.id.textView3);
        textView1.setText("0 to 5: We Recommend Easy \n\n 6 to 10: We Recommend Medium \n\n11 to 20: We Recommend Hard");

        Intent intent = getIntent();
        tv = findViewById(R.id.textView4);
        String str = intent.getStringExtra("Total Score");
        tv.setText(str +"/20");
    }

    /***
     * Method to be used to return to the main menu.  Called the user selects the 'Home' button.
     */
    public void openMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void openMentalMaths(View view) {
        Intent intent = new Intent(this, MathsScreen.class);
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
