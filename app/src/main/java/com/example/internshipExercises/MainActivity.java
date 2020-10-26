package com.example.internshipExercises;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity{
    public static final String FILE_NAME = MainActivity.class.getSimpleName() + " SHARED PREF FILE NAME FOR COLORS ";
    public static final String CHOSEN_COLOR_KEY = MainActivity.class.getSimpleName() + " CHOSEN COLOR KEY ";
    public static final String CHOSEN_INT_KEY = MainActivity.class.getSimpleName() + " CHOSEN INTEGER KEY ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usePreferences();
    }

    private void usePreferences(){
        SharedPreferences prefs = getSharedPreferences(FILE_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString(CHOSEN_COLOR_KEY, "RED");
        editor.putInt(CHOSEN_INT_KEY, 7);
        editor.apply();

        String color = prefs.getString(CHOSEN_COLOR_KEY,"BLACK");
        int number = prefs.getInt(CHOSEN_INT_KEY, 0);

        Log.d("MAinActivity", "color: " + color + " number: " + number);
    }

}
