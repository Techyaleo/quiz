package com.techyaleo.quiz;

import java.util.Random;

public class Questions {
    private int firstNumber;
    private int secondNumber;
    private  int answer;
    //there are four possible chioces for the user to pick from
    private int [] answerArray;

    //which of the four positions is correct, 0,1,2 or 3.
    private  int answerPosition;

    //the maximum volume of firstnumer or secondNumber
    private int upperLimit;
    //string output of the problem e.g "4+9="
    private String questionPhrase;

    //generate a new random question
    public Questions(int upperLimit){
        this.upperLimit = upperLimit;
        Random randomNumberMaker = new Random();

        this.firstNumber = randomNumberMaker.nextInt(upperLimit);
        this.secondNumber = randomNumberMaker.nextInt(upperLimit);
        this.answer = this.firstNumber + this.secondNumber;
        this.questionPhrase = firstNumber+" + "+secondNumber+"=";//"\u00F7"

        this.answerPosition = randomNumberMaker.nextInt(4);
        this.answerArray = new  int[]{0,1,2,3};

        this.answerArray[0] = answer+1;
        this.answerArray[1]=answer+10;
        this.answerArray[2]=answer-4;
        this.answerArray[3] =answer-2;

        this.answerArray = shuffleArray(this.answerArray);

        //after shuffling array place the answer in one of the array
        answerArray[answerPosition] = answer;

    }

    private int[] shuffleArray(int[] array){
        int index, temp;
        Random randomNumberGenerator = new Random();
        //get random position swap it with temporary no
        for (int i = array.length-1;i>0;i--){
            index = randomNumberGenerator.nextInt(i+1);
            temp = array[index];
            array[i] =temp;
        }
        return array;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        answer = answer;
    }

    public int[] getAnswerArray() {
        return answerArray;
    }

    public void setAnswerArray(int[] answerArray) {
        this.answerArray = answerArray;
    }

    public int getAnswerPosition() {
        return answerPosition;
    }

    public void setAnswerPosition(int answerPosition) {
        this.answerPosition = answerPosition;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getQuestionPhrase() {
        return questionPhrase;
    }

    public void setQuestionPhrase(String questionPhrase) {
        this.questionPhrase = questionPhrase;
    }
}
