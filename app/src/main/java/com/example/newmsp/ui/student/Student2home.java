package com.example.newmsp.ui.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;
import com.example.newmsp.R;
import com.example.newmsp.ui.student.s_medium;

public class Student2home extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student2home);

        lottieAnimationView = findViewById(R.id.s2h);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(), s_medium.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}