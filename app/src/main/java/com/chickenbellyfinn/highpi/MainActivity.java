package com.chickenbellyfinn.highpi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @BindView(R.id.home_test) Button testButton;
    @BindView(R.id.home_memorize) Button memorizeButton;
    @BindView(R.id.score) TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void onResume(){
        super.onResume();

        int highScore = HighPiApplication.getHighScore();

        if(highScore == 0){
            score.setVisibility(View.INVISIBLE);
        } else {
            score.setVisibility(View.VISIBLE);
            score.setText(String.format("%d Digits", HighPiApplication.getHighScore()));
        }
    }

    @OnClick(R.id.home_test)
    public void onTestClicked(){
        startActivity(new Intent(this, TestActivity.class));
    }

    @OnClick(R.id.home_memorize)
    public void onMemorizeClicked(){
        startActivity(new Intent(this, MemorizeActivity.class));
    }

}