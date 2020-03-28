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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserRegister extends AppCompatActivity {

    EditText nUsername, nEmail, nPassword, nCPassword;
    Button nRegisterButton;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    DatabaseReference dReference;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        nUsername = findViewById(R.id.editText);
        nEmail = findViewById(R.id.editText2);
        nPassword = findViewById(R.id.editText3);
        nCPassword = findViewById(R.id.editText4);
        nRegisterButton = findViewById(R.id.button11);
        user = new User();
        dReference = FirebaseDatabase.getInstance().getReference().child("User");

        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.rProgressBar);

        if(fAuth.getCurrentUser()!= null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        nRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = nEmail.getText().toString().trim();
                String password = nPassword.getText().toString().trim();
                String confirmPassword = nCPassword.getText().toString().trim();
                String username = nUsername.getText().toString().trim();

                if(TextUtils.isEmpty(email)) {
                    nEmail.setError("Email is required!");
                    return;
                }

                if(TextUtils.isEmpty(password)) {
                    nPassword.setError("Password is required!");
                    return;
                }

                if(password.length() < 6) {
                    nPassword.setError("The password must be 6 or more characters long");
                    return;
                }

                if(!confirmPassword.equals(password)) {
                    nCPassword.setError("Sorry the passwords you have entered do not match");
                    return;
                }

                if(TextUtils.isEmpty(username)) {
                    nPassword.setError("Username is required!");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //Add to Database

                user.setEmail(email);
                user.setPassword(password);
                user.setUsername(username);
                user.setExperience(0);
                dReference.push().setValue(user);

                //Register user to FireBase
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(UserRegister.this, "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }else{
                            Toast.makeText(UserRegister.this, "Error Please Try Again" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), UserRegister.class));

                        }
                    }
                });
            }
        });


    }

    /** Called when the user taps the Sign in button */
    public void toLogin(View view) {
        Intent intent = new Intent(this, UserLogin.class);
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
     * Method to be used to start Settings Activity, called when the Settings Button is clicked.
     */
    public void openSettings(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
}
