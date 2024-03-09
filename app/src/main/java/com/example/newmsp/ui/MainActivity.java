package com.example.newmsp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newmsp.R;
import com.example.newmsp.ui.Signup;
import com.example.newmsp.ui.admin.admin_login;
import com.example.newmsp.ui.student.OtpSendActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imgT,imgS;
    TextView txtSU;
    float v=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSU=(TextView)findViewById(R.id.txtSU);
        imgS=(ImageView) findViewById(R.id.imgS);
        imgT=(ImageView) findViewById(R.id.imgT);

        imgT.setTranslationY(500);
        imgS.setTranslationY(500);

        imgT.setAlpha(v);
        imgS.setAlpha(v);

        imgT.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(100).start();
        imgS.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(300).start();

        txtSU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Signup.class);
                startActivity(i);
            }
        });


        imgT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), admin_login.class);
                startActivity(i);
                finish();
            }
        });


        imgS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), OtpSendActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}