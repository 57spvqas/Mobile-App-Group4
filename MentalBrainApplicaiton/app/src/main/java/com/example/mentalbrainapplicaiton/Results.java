package com.example.mentalbrainapplicaiton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        TextView textView = findViewById(R.id.textView2);
        textView.setText("Results");
        TextView textView1 = findViewById(R.id.textView2);
        textView1.setText("0 to 5: We Recommend Easy \n\n 6 to 10: We Recommend Medium \n\n11 to 15: We Recommend Hard \n\n16 and above: We Recommend Insane");

        Intent intent = getIntent();
        tv = findViewById(R.id.textView3);
        String str = intent.getStringExtra("Total Score");
        tv.setText(str +"/20");
    }
}
