package com.pranav.timetableactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import java.util.Random;


public class SplahScreenActivity extends AppCompatActivity {
    int[] images = {R.drawable.splash1, R.drawable.splash2, R.drawable.splash3, R.drawable.splash4, R.drawable.splash5, R.drawable.splash6};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splah_screen);
        //ImageView imageButton = findViewById(R.id.imageView2);
        //imageButton.setImageResource(getRandom(images));
        final Handler handler = new Handler();
        //MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.intro_sound);
        //mediaPlayer.start();
        //Toast.makeText(getApplicationContext(), "Lol ;)", Toast.LENGTH_SHORT).show();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                startActivity(new Intent(SplahScreenActivity.this,Timetable.class));
            }
        }, 2000);

    }

    public static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}