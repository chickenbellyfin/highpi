package com.chickenbellyfinn.highpi;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MemorizeActivity extends Activity {


    @BindView(R.id.digits) TextView digits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorize);
        ButterKnife.bind(this);
        digits.setText(Digits.spaced(5));

    }
}
