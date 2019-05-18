package com.example.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button play, pause, stop;
    MediaPlayer mediaPlayer;
    int pauseCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.Play);
        pause = findViewById(R.id.Pause);
        stop = findViewById(R.id.Stop);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);






    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.Play:
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.lakshya);
                    mediaPlayer.start();
                } else if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.seekTo(pauseCurrent);
                    mediaPlayer.start();
                }
                break;
            case R.id.Pause:
                if (mediaPlayer != null) {
                    mediaPlayer.pause();
                    pauseCurrent = mediaPlayer.getCurrentPosition();

                }
                break;
            case R.id.Stop:
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ek_ladki);


                }
                break;

        }
    }
}

