package com.example.juegodel21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView mTextField = findViewById(R.id.text2);
        CountDownTimer CountDownTimer = new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                mTextField.setText("" + millisUntilFinished / 2000);

            }

            public void onFinish() {
                startActivity(new Intent(getApplicationContext(), MainActivity3.class));
            }
        }.start();
    }
}