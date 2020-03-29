package com.example.mentalbrainapplicaiton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UserLogin extends AppCompatActivity {

    EditText uEmail, uPassword;
    Button uSignInBtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;

    /**
     * Method to initialise activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        uEmail = findViewById(R.id.usernameEditText);
        uPassword = findViewById(R.id.passwordEditText);
        uSignInBtn = findViewById(R.id.loginButton);
        progressBar = findViewById(R.id.lProgressBar);
        fAuth = FirebaseAuth.getInstance();

        uSignInBtn.setOnClickListener(new View.OnClickListener() {
            /**
             * Method called when the loginButton(uSignInBtn)
             * @param v
             */
            @Override
            public void onClick(View v) {
                String email = uEmail.getText().toString().trim();
                String password = uPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)) {
                    uEmail.setError("Email is required!");
                    return;
                }

                if(TextUtils.isEmpty(password)) {
                    uPassword.setError("Password is required!");
                    return;
                }

                if(password.length() < 6) {
                    uPassword.setError("The password must be 6 or more characters long");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //Authenticating the user through Firebase
                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(UserLogin.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }else{
                            Toast.makeText(UserLogin.this, "Error Please try again/contact SysAdmin", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), UserLogin.class));
                        }
                    }
                });
            }
        });
    }

    /***
     * Method to be used to return to the main menu.  Called the user selects the 'Home' button.
     */
    public void openMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
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
