package com.example.mentalbrainapplicaiton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class UserProgress extends AppCompatActivity {

    FirebaseAuth fAuth;
    FirebaseUser user;
    FirebaseDatabase database;
    DatabaseReference databaseReference;

    TextView usernameTV, experienceTV;

    /**
     * Method to initialise activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_progress);
        
        fAuth = FirebaseAuth.getInstance();
        user = fAuth.getCurrentUser();
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getInstance().getReference("User");

        usernameTV = findViewById(R.id.usernameTV);
        experienceTV = findViewById(R.id.experienceTV);

        //Querying userdata that corresponds with currently signed in email


        if (user == null){

            TextView usernameTv = findViewById(R.id.textViewUsername);
            TextView scoreTv = findViewById(R.id.textViewScore);
            TextView newTv = findViewById(R.id.textView38);

            usernameTv.setText("");
            scoreTv.setText("");
            newTv.setText("Register or Log-In to start tracking your progress!");

        }

        else {
        Query query = databaseReference.orderByChild("email").equalTo(user.getEmail());
        query.addValueEventListener(new ValueEventListener() {

            /**
             * Method to take snapshot of user attributes from Firebase, sets TextViews with
             * snapshot results.
             * @param dataSnapshot
             */
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //check until required data is returned
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    String userName = "" + ds.child("username").getValue();
                    String experience = "" + ds.child("experience").getValue();

                    usernameTV.setText(userName);
                    experienceTV.setText(experience);
                }

            }

            /**
             * Method to be called if no networks connection, returns error.
             * @param databaseError
             */
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UserProgress.this, "Error Please log in, or check your network settings to check your progress", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), UserLogin.class));

            }
        });
    }




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
