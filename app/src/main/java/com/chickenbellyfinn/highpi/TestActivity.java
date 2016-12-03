package com.chickenbellyfinn.highpi;

import android.app.Activity;
import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestActivity extends Activity {

    private final static long VIBRATE = 40;

    @BindView(R.id.three) TextView three;
    @BindView(R.id.test_input) ViewGroup inputLayout;
    @BindView(R.id.test_scroll) HorizontalScrollView scroll;
    @BindView(R.id.test_counter) TextView counter;
    @BindView(R.id.test_reset) ImageButton reset;

    @BindView(R.id.n0) Button n0;
    @BindView(R.id.n1) Button n1;
    @BindView(R.id.n2) Button n2;
    @BindView(R.id.n3) Button n3;
    @BindView(R.id.n4) Button n4;
    @BindView(R.id.n5) Button n5;
    @BindView(R.id.n6) Button n6;
    @BindView(R.id.n7) Button n7;
    @BindView(R.id.n8) Button n8;
    @BindView(R.id.n9) Button n9;

    private Runnable scrollMax = new Runnable() {
        @Override
        public void run() {
            scroll.fullScroll(ScrollView.FOCUS_RIGHT);
        }
    };

    private Vibrator vibrator;
    private LayoutInflater inflater;

    private int streak = 0;
    private int digitIndex = 0;

    private TextView nextView;
    private TextView space;

    private boolean errorFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        this.inflater = LayoutInflater.from(this);

        n0.setTag("0");
        n1.setTag("1");
        n2.setTag("2");
        n3.setTag("3");
        n4.setTag("4");
        n5.setTag("5");
        n6.setTag("6");
        n7.setTag("7");
        n8.setTag("8");
        n9.setTag("9");

        reset();
    }

    @OnClick({ R.id.n0,
            R.id.n1, R.id.n2, R.id.n3,
            R.id.n4, R.id.n5, R.id.n6,
            R.id.n7, R.id.n8, R.id.n9 })
    public void onDigitClicked(View v){
        String d = v.getTag().toString();

        if(!d.equals(Digits.at(digitIndex))){
            nextView.setTextColor(getResources().getColor(R.color.error));
            errorFlag = true;
            return;
        }

        if(!errorFlag){
            streak++;
            HighPiApplication.submitScore(streak);
        }
        digitIndex++;

        nextView.setText(d);
        space.setText("_");
        nextView = space;
        space = createDigit(" ");

        updateCounter();

        vibrator.vibrate(VIBRATE);
    }
    @OnClick(R.id.test_reset)
    public void onResetClick(){
        vibrator.vibrate(VIBRATE);
        reset();
    }

    private void reset(){
        streak = 0;
        digitIndex = 0;
        errorFlag = false;

        inputLayout.removeAllViews();
        inputLayout.addView(three);

        nextView = createDigit("_");
        space = createDigit(" ");

        scroll.post(scrollMax);

        updateCounter();
    }

    private void updateCounter(){
        counter.setText(String.format("%d digits", streak));
    }

    private TextView createDigit(String d){
        TextView view = (TextView) inflater.inflate(R.layout.layout_digit, null);
        view.setText(d);
        inputLayout.addView(view);
        scroll.post(scrollMax);
        return view;
    }
}
