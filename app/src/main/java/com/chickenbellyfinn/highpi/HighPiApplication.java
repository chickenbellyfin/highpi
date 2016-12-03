package com.chickenbellyfinn.highpi;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by akshay on 12/2/16.
 */

public class HighPiApplication extends Application {

    private static final String PREF_SCORE = "score";

    public static SharedPreferences prefs;

    public static int getHighScore(){
        return prefs.getInt(PREF_SCORE, 0);
    }

    public static boolean submitScore(int score){
        if(score > getHighScore()){
            prefs.edit().putInt(PREF_SCORE, score).commit();
            return true;
        }
        return false;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
    }

}
