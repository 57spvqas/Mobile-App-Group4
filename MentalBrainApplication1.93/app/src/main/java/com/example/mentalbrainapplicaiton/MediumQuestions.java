package com.example.mentalbrainapplicaiton;

public class MediumQuestions {

    private String myQuestions [] = {"28 x 0.5", "14 x 3", "7 x 12", "5 x 15", "99 / 3", "12 + 39", "42 + 116", "100 / 5", "56 / 7", "75 x 3", "225 / 25", "19 - 6 - 12", "5 x 3 x 6", "42 + 12 + 9", "16 x 3", "7 - 5 + 19", "18 x 3", "57 + 48", "14 x 5", "29 + 74", ""};

    private String Answers [] = {"14", "42", "84", "75", "33", "51", "158", "20", "8", "225", "9", "1", "90", "63", "48", "21", "54", "105", "70", "103", ""};


    public String getQuestion(int a){
        String question = myQuestions[a];
        return question;
    }

    public String getAnswers(int a){
        String answer = Answers[a];
        return answer;
    }
}
