package com.example.mentalbrainapplicaiton;

public class Questions {

    private String myQuestions [] = {"3 + 5?", "2 x 4?", "9 / 3?", "10 - 1", "7 + 3", "7 x 3", "8 x 4", "36 / 9", "12 x 10", "17 - 13", "12 x 12", "13 x 13", "17 + 38", "56 + 69", "15 x 12", "17 x 17", "21 x 15", "323 / 19", "374 / 34", "3 x 163", ""};

    private String Answers [] = {"8", "8", "3", "9", "10", "21", "32", "4", "120", "4", "144", "169", "55", "125", "180", "289", "315", "17", "11", "489", ""};


    public String getQuestion(int a){
        String question = myQuestions[a];
        return question;
    }

    public String getAnswers(int a){
        String answer = Answers[a];
        return answer;
    }
}