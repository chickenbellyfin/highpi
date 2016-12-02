package com.chickenbellyfinn.highpi;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeController extends Controller {

    @BindView(R.id.home_test) Button testButton;
    @BindView(R.id.home_memorize) Button memorizeButton;

    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_home, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.home_test)
    public void onTestClicked(){
        getRouter().pushController(
                RouterTransaction.with(new TestController())
                        .pushChangeHandler(new FadeChangeHandler())
                        .popChangeHandler(new FadeChangeHandler()));
    }

    @OnClick(R.id.home_memorize)
    public void onMemorizeClicked(){
        getRouter().pushController(
                RouterTransaction.with(new MemorizeController())
                        .pushChangeHandler(new FadeChangeHandler())
                        .popChangeHandler(new FadeChangeHandler()));
    }
}