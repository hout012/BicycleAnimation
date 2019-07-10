package com.example.bicycleanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

public class MainActivity extends AppCompatActivity {
    Bicycle b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.bike);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_DPAD_DOWN:
                b.moveBike("down");
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                b.moveBike("left");
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                b.moveBike("right");
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                b.moveBike("up");
                break;
        }
        return true;
    }
}
