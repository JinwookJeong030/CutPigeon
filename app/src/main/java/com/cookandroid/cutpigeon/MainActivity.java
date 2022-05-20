package com.cookandroid.cutpigeon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    MediaPlayer m ;
    static boolean check = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_sound);

        Button button = (Button)findViewById(R.id.sound1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(!check) {
                    m = MediaPlayer.create(MainActivity.this, R.raw.sound );
                    check = true;
                    m.start();
                    button.setText("종료");
                }
                else {
                    check = false;
                    m.stop();
                    m.reset();
                    button.setText("비둘기\n위협하기");
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // MediaPlayer 해지
        if(m != null) {
            m.release();
            m = null;
        }
    }
}