package com.example.mentalbrainapplicaiton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MentalMaths extends AppCompatActivity {

    private Questions newQuestions = new Questions();
    private String newAnswer;
    private int QuestionNumber = 0;
    private int Score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_maths);
        nextQuestion();
    }

    /***
     * Method to be used to start MainActivity, called when the Back Button is clicked.
     *
     */

    public void openMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onButtonClick(View view) {
        TextView Note = findViewById(R.id.note);
        EditText Answer = findViewById(R.id.answer);
        if (Answer.getText().toString().equals(newAnswer)) {
            Note.setText("Well Done!");
            Score = Score + 1;
            updateScore(Score);
            nextQuestion();
        } else {
            Note.setText("Incorrect");
            nextQuestion();
        }

    }

    private void nextQuestion() {
        TextView myQuestions = findViewById(R.id.question);
        myQuestions.setText(newQuestions.getQuestion(QuestionNumber));
        newAnswer = newQuestions.getAnswers(QuestionNumber);
        QuestionNumber++;
        if (QuestionNumber == 21) {
            gameOver();
        }
    }

    private void gameOver() {
        TextView Note = findViewById(R.id.note);
        Note.setText("Completed!");
        openResults();
    }

    private void updateScore(int a) {
        TextView score = findViewById(R.id.score);
        score.setText("Score: " + Score);
    }

    public void openResults() {
        TextView score = findViewById(R.id.score);
        String str = score.getText().toString();
        Intent intent = new Intent(this, Results.class);
        intent.putExtra("Total Score", str);
        startActivity(intent);
    }

    public void Finish(View view){
        TextView score = findViewById(R.id.score);
        String str = score.getText().toString();
        Intent intent = new Intent(this, Results.class);
        intent.putExtra("Total Score", str);
        startActivity(intent);
    }


}
