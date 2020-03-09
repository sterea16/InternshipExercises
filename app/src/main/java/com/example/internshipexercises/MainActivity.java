package com.example.internshipexercises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String TAG = MainActivity.class.getSimpleName();
    public final static String INT_EXTRA = "extra_value";
    private int incrementValue;
    private TextView incrementTv;
    private Button incrementBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate: Happy to be born");
        if(savedInstanceState != null)
            incrementValue = savedInstanceState.getInt(INT_EXTRA);
        initViews();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(INT_EXTRA, incrementValue);
        super.onSaveInstanceState(outState);
    }

    private void initViews(){
        incrementTv = findViewById(R.id.counter_value_tv);
        incrementBtn = findViewById(R.id.increment_bt);

        incrementTv.setText(incrementValue + "");

        incrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementValue++;
                incrementTv.setText(incrementValue + "");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: I exist, but you cannot see me");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(TAG,"onResume: Preparing final UI changes for you master");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause: You can see me, but I don't want to interact");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop: Packing up to leave");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy: Bye, bye!");
    }
}
