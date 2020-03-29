package com.example.mentalbrainapplicaiton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EasyQuiz extends AppCompatActivity {
    private EasyQuestions newEasyQuestions = new EasyQuestions();
    private String newAnswer;
    private int QuestionNumber = 0;
    private int Score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_quiz);
        nextQuestion();
    }
    public void onButtonClick(View view) {
        TextView Note = findViewById(R.id.note);
        EditText Answer = findViewById(R.id.answer);
        if(Answer.getText().toString().isEmpty()){
            return;
        }
        if (Answer.getText().toString().equals(newAnswer)) {
            Note.setText("Well Done!");
            Score = Score + 1;
            updateScore(Score);
            nextQuestion();
            Answer.getText().clear();
        } else {
            Note.setText("Incorrect");
            nextQuestion();
            Answer.getText().clear();
        }
    }

    private void nextQuestion() {
        TextView myQuestions = findViewById(R.id.question);
        TextView questionNumber = findViewById(R.id.questionNumber4);
        myQuestions.setText(newEasyQuestions.getQuestion(QuestionNumber));
        newAnswer = newEasyQuestions.getAnswers(QuestionNumber);
        QuestionNumber++;
        if (QuestionNumber == 21) {
            gameOver();
        } else {
            questionNumber.setText(Integer.toString(QuestionNumber) + "\\" + "20");
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
        Intent intent = new Intent(this, MathsQuizResults.class);
        intent.putExtra("Total Score", str);
        startActivity(intent);
    }

    public void Finish(View view){
        TextView score = findViewById(R.id.score);
        String str = score.getText().toString();
        Intent intent = new Intent(this, MathsQuizResults.class);
        intent.putExtra("Total Score", str);
        startActivity(intent);
    }
}
