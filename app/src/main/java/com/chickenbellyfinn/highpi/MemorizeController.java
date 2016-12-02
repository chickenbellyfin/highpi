package com.chickenbellyfinn.highpi;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bluelinelabs.conductor.Controller;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by akshay on 12/2/16.
 */

public class MemorizeController extends Controller {

    @BindView(R.id.digits) TextView digits;

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_memorize, container);
        ButterKnife.bind(this, view);

        digits.setText(Digits.spaced(5));

        return view;
    }
}
