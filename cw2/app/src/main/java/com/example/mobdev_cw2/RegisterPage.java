package com.example.mobdev_cw2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegisterPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Sign in button */
    public void toLogin(View view) {

        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }



}

