package com.techyaleo.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btnStart,buttonans0,buttonans1,buttonans2,buttonans3;
    TextView textViewScore, textViewqtn, textVTimer,textViewmessage;
    ProgressBar progressBar;

    Game game = new Game();
    int secRemaining = 30;

    CountDownTimer countDownTimer = new CountDownTimer(30500, 1000) {
        @Override
        public void onTick(long l) {
            secRemaining--;
            textVTimer.setText(Integer.toString(secRemaining) +"Sec");
            progressBar.setProgress(30-secRemaining);

        }

        @Override
        public void onFinish() {
            buttonans0.setEnabled(false);
            buttonans1.setEnabled(false);
            buttonans2.setEnabled(false);
            buttonans3.setEnabled(false);
            textViewmessage.setText(game.getNumberCorrect()+"/"+ (game.getTotalQuestions() -1));

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btnStart.setVisibility(View.VISIBLE );
                }
            },3000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = findViewById(R.id.buttonstart);
        buttonans0 = findViewById(R.id.buttonanswer0);
        buttonans1 = findViewById(R.id.buttonanswer1);
        buttonans2 = findViewById(R.id.buttonaswer2);
        buttonans3 = findViewById(R.id.buttonanswer3);

        textViewScore = findViewById(R.id.textScore);
        textViewmessage = findViewById(R.id.textViewMessage);
        textVTimer = findViewById(R.id.textViewTimer);
        textViewqtn = findViewById(R.id.textquestion);

        progressBar = findViewById(R.id.progressBar);

        textVTimer.setText("0Sec");
        textViewqtn.setText("");
        textViewScore.setText("0pts");
        textViewmessage.setText("Get Started");
        progressBar.setProgress(0);

        //sharing one click listener
        View.OnClickListener onClickListen = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button startbutton =(Button) view;
                startbutton.setVisibility(View.INVISIBLE);
                secRemaining = 30;
                game = new Game();
                startGame();
                countDownTimer.start();

            }
        };
        btnStart.setOnClickListener(onClickListen);

        View.OnClickListener AnsweronClickListen = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    Button anstbutton = (Button) view;
                    int answersected = Integer.parseInt(anstbutton.getText().toString());
                    game.checkAnswer(answersected);
                    textViewScore.setText(Integer.toString(game.getScore()));
                    startGame();
                }catch (Exception exception){
                    exception.getMessage().toString().hashCode();
                }


            }
        };
        buttonans0.setOnClickListener(AnsweronClickListen);
        buttonans1.setOnClickListener(AnsweronClickListen);
        buttonans2.setOnClickListener(AnsweronClickListen);
        buttonans3.setOnClickListener(AnsweronClickListen);

    }

    private void startGame() {
        //create a new question
        //set text on answer buttons
        //start timer
        game.makeNewQuestion();
        int [] answer = game.getCurrentquestion().getAnswerArray();
        buttonans0.setText(Integer.toString(answer[0]));
        buttonans1.setText(Integer.toString(answer[1]));
        buttonans2.setText(Integer.toString(answer[2]));
        buttonans3.setText(Integer.toString(answer[3]));

        buttonans0.setEnabled(true);
        buttonans1.setEnabled(true);
        buttonans2.setEnabled(true);
        buttonans3.setEnabled(true);

        textViewqtn.setText(game.getCurrentquestion().getQuestionPhrase());

        textViewmessage.setText(game.getNumberCorrect()+"/"+ (game.getTotalQuestions() -1));

    }
}