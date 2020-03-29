package com.example.mentalbrainapplicaiton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.firebase.auth.FirebaseAuth;

public class Settings extends AppCompatActivity {

    static private String darkMode = "false";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final Switch newSwitch = (Switch) findViewById(R.id.switch1);
        final TextView tv = findViewById(R.id.textView36);
        final View root = tv.getRootView();
        //root.setBackgroundColor(Color.parseColor("#000000"));
        root.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.gradient));

        newSwitch.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {

                if(newSwitch.isChecked()){
                    darkMode = "true";
                    root.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.background));

                }
                else {
                    darkMode = "false";
                   root.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.gradient));

                }

            }
        });
    }

    /***
     * Method to return current setting of "dark mode" switch
     */
    static public String getDarkMode()
    {
        return darkMode;
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
     * Method called onClick of logout button
     * @param view
     */
    public void logout (View view) {
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(Settings.this, "You are now logged out!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
