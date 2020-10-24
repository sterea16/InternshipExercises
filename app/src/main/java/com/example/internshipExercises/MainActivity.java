package com.example.internshipExercises;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.internshipExercises.model.post.Post;
import com.example.internshipExercises.server.ServerProvider;
import com.example.internshipExercises.util.DownloaderUtil;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public final static String TAG = "MainActivity";
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image_view);
        downloadImageUsingThread();
    }

    private void downloadImageUsingThread(){
        new Thread(() -> {
            final Bitmap bitmap = DownloaderUtil.INSTANCE.downloadImage();
            runOnUiThread(() -> imageView.setImageBitmap(bitmap));
        }).start();
    }
}
