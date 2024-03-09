package com.example.newmsp.ui.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newmsp.Constant;
import com.example.newmsp.R;
import com.google.android.material.card.MaterialCardView;

public class t_std_e extends AppCompatActivity {

    MaterialCardView carde1,carde2,carde3,carde4,carde5,carde6,carde7,carde8,carde9,carde10;

    private String strMedium="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_std_e);

        if (getIntent()!=null){
            strMedium = getIntent().getStringExtra(Constant.MEDIUM);
        }

        carde1 = findViewById(R.id.carde1);
        carde2 = findViewById(R.id.carde2);
        carde3 = findViewById(R.id.carde3);
        carde4 = findViewById(R.id.carde4);
        carde5 = findViewById(R.id.carde5);
        carde6 = findViewById(R.id.carde6);
        carde7 = findViewById(R.id.carde7);
        carde8 = findViewById(R.id.carde8);
        carde9 = findViewById(R.id.carde9);
        carde10 = findViewById(R.id.carde10);

        carde1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(t_std_e.this, T_Sub.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, Constant.STD1);
                startActivity(i);
                finish();
            }
        });

        carde2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(t_std_e.this, T_Sub.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, Constant.STD2);
                startActivity(i);
                finish();
            }
        });

        carde3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(t_std_e.this, T_Sub.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, Constant.STD3);
                startActivity(i);
                finish();
            }
        });

        carde4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(t_std_e.this, T_Sub.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, Constant.STD4);
                startActivity(i);
                finish();
            }
        });

        carde5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(t_std_e.this, T_Sub.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, Constant.STD5);
                startActivity(i);
                finish();
            }
        });

        carde6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(t_std_e.this, T_Sub.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, Constant.STD6);
                startActivity(i);
                finish();
            }
        });

        carde7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(t_std_e.this, T_Sub.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, Constant.STD7);
                startActivity(i);
                finish();
            }
        });

        carde8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(t_std_e.this, T_Sub.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, Constant.STD8);
                startActivity(i);
                finish();
            }
        });

        carde9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(t_std_e.this, T_Sub.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, Constant.STD9);
                startActivity(i);
                finish();
            }
        });

        carde10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(t_std_e.this, T_Sub.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, Constant.STD10);
                startActivity(i);
                finish();
            }
        });

    }
}