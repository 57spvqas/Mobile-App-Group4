package com.example.mentalbrainapplicaiton;

public class HardQuestions {

    private String myQuestions [] = {"75 x 6", "128 / 4", "17 x 17", "19 x 19", "106 + 117 + 296", "334 - 156", "22 x 19", "15 x 35", "29 x 11", "84 - (3 x 16)", "17 x (12 / 3)", "7 x 7 x 7", "25 + 182 + 191", "2 x 3 x 4 x 5 x 6", "0.75 x 180", "0.2 x 185", "5 x 0.6", "(25 x 25) - 107", "72 x 3", "587 x 4", ""};

    private String Answers [] = {"450", "32", "289", "361", "519", "178", "418", "525", "319", "36", "68", "343", "398", "720", "135", "37", "3", "518", "216", "2348", ""};


    public String getQuestion(int a){
        String question = myQuestions[a];
        return question;
    }

    public String getAnswers(int a){
        String answer = Answers[a];
        return answer;
    }
}

