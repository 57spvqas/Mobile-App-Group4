package com.example.mentalbrainapplicaiton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);


    }

    /** Called when the user taps the Sign in button */
    public void toLogin(View view) {

        Intent intent = new Intent(this, UserLogin.class);
        startActivity(intent);
    }
}
