package com.example.newmsp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.newmsp.Constant;
import com.example.newmsp.MyApp;
import com.example.newmsp.R;
import com.example.newmsp.ui.student.Student_home;
import com.example.newmsp.ui.admin.admin2home;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class SplashActivity extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;
    float v=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        lottieAnimationView = findViewById(R.id.lottie);


        FirebaseMessaging.getInstance().subscribeToTopic("all")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Subscribed";
                        if (!task.isSuccessful()) {
                            msg = "Subscribe failed";
                        }
                        Log.e("TAG---", msg);
                        Toast.makeText(SplashActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (MyApp.getBooleanPrefs(Constant.PREF_LOGIN)) {

                        if (MyApp.getStringPrefs(Constant.PREF_LOGIN_TYPE).equals(Constant.STUDENT)) {
                            startActivity(new Intent(SplashActivity.this, Student_home.class));
                        }
                        else if (MyApp.getStringPrefs(Constant.PREF_LOGIN_TYPE).equals(Constant.TEACHER)) {
                            startActivity(new Intent(SplashActivity.this, admin2home.class));
                        }
                        else {
                            Toast.makeText(SplashActivity.this, "No User Type", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));

                    }

                    finish();
                }
            }, 3000);

    }
}