package com.techyaleo.quiz;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Questions> questionsList;
    private int numberCorrect;
    private int numberInCorrect;
    private int totalQuestions;
    private int score;
    private Questions currentquestion;

    public Game() {
        numberCorrect = 0;
        numberInCorrect =0;
        totalQuestions=0;
        score = 0;
        currentquestion = new Questions(10);
        questionsList = new ArrayList<Questions>();
    }

    public void makeNewQuestion(){
        currentquestion = new Questions(totalQuestions*2+5);
        totalQuestions++;
        questionsList.add(currentquestion);
    }

    public  boolean checkAnswer(int submittedAnswer){
        boolean isCorrect;
        if(currentquestion.getAnswer() == submittedAnswer){
            numberCorrect++;
            isCorrect=true;
        }else {
            numberInCorrect++;
            isCorrect=false;
        }
        score = numberCorrect*10 - numberInCorrect*30;
        return isCorrect;
    }


    public List<Questions> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<Questions> questionsList) {
        this.questionsList = questionsList;
    }

    public int getNumberCorrect() {
        return numberCorrect;
    }

    public void setNumberCorrect(int numberCorrect) {
        this.numberCorrect = numberCorrect;
    }

    public int getNumberInCorrect() {
        return numberInCorrect;
    }

    public void setNumberInCorrect(int numberInCorrect) {
        this.numberInCorrect = numberInCorrect;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Questions getCurrentquestion() {
        return currentquestion;
    }

    public void setCurrentquestion(Questions currentquestion) {
        this.currentquestion = currentquestion;
    }

}
