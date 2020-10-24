package com.example.internshipExercises;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.internshipExercises.util.DataBindExecutor;
import com.example.internshipExercises.util.DownloaderUtil;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image_view);
        /*downloadImageUsingThread();*/
        downloadImageUsingExecutor();
    }

    private void downloadImageUsingExecutor() {
        Runnable runnable = () -> {
            Bitmap bitmap = DownloaderUtil.INSTANCE.downloadImage();
            runOnUiThread(() -> imageView.setImageBitmap(bitmap));
        };
        DataBindExecutor downloadExecutor = new DataBindExecutor();
        downloadExecutor.execute(runnable);
    }

    private void downloadImageUsingThread(){
        new Thread(() -> {
            final Bitmap bitmap = DownloaderUtil.INSTANCE.downloadImage();
            runOnUiThread(() -> imageView.setImageBitmap(bitmap));
        }).start();
    }
}
