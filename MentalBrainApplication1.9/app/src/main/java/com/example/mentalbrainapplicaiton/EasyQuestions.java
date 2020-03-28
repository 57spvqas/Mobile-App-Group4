package com.example.mentalbrainapplicaiton;

public class EasyQuestions {

    private String myQuestions [] = {"5 x 10", "7 x 3", "17 + 3", "5 x 2", "4 x 4", "8 + 5", "4 x 3", "17 - 9", "18 +6", "8 - 5", "12 - 7", "7 x 0", "1 + 17", "2 / 2", "7 x 5", "18 + 7", "6 + 2 + 3", "5 + 11 + 7", "17 x 2", "19 x 2", ""};

    private String Answers [] = {"50", "21", "20", "10", "16", "13", "12", "8", "24", "3", "5", "0", "18", "1", "35", "25", "11", "23", "34", "38", ""};


    public String getQuestion(int a){
        String question = myQuestions[a];
        return question;
    }

    public String getAnswers(int a){
        String answer = Answers[a];
        return answer;
    }
}

