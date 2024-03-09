package com.example.newmsp.ui.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newmsp.Constant;
import com.example.newmsp.R;
import com.google.android.material.card.MaterialCardView;

public class T_Assig_Std extends AppCompatActivity {

    MaterialCardView cardh1,cardh2,cardh3,cardh4,cardh5,cardh6,cardh7,cardh8,cardh9,cardh10;

    private String strAMedium="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_assig_std);

        if (getIntent()!=null){
            strAMedium = getIntent().getStringExtra(Constant.A_MEDIUM);
        }

        cardh1 = findViewById(R.id.cardh1);
        cardh2 = findViewById(R.id.cardh2);
        cardh3 = findViewById(R.id.cardh3);
        cardh4 = findViewById(R.id.cardh4);
        cardh5 = findViewById(R.id.cardh5);
        cardh6 = findViewById(R.id.cardh6);
        cardh7 = findViewById(R.id.cardh7);
        cardh8 = findViewById(R.id.cardh8);
        cardh9 = findViewById(R.id.cardh9);
        cardh10 = findViewById(R.id.cardh10);

        cardh1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Assig_Std.this, Admin_Assig_Upload.class);
                i.putExtra(Constant.A_MEDIUM, strAMedium);
                i.putExtra(Constant.A_STANDARD, Constant.A_STD1);
                startActivity(i);
                finish();
            }
        });

        cardh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Assig_Std.this, Admin_Assig_Upload.class);
                i.putExtra(Constant.A_MEDIUM, strAMedium);
                i.putExtra(Constant.A_STANDARD, Constant.A_STD2);
                startActivity(i);
                finish();
            }
        });

        cardh3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Assig_Std.this, Admin_Assig_Upload.class);
                i.putExtra(Constant.A_MEDIUM, strAMedium);
                i.putExtra(Constant.A_STANDARD, Constant.A_STD3);
                startActivity(i);
                finish();
            }
        });

        cardh4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Assig_Std.this, Admin_Assig_Upload.class);
                i.putExtra(Constant.A_MEDIUM, strAMedium);
                i.putExtra(Constant.A_STANDARD, Constant.A_STD4);
                startActivity(i);
                finish();
            }
        });

        cardh5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Assig_Std.this, Admin_Assig_Upload.class);
                i.putExtra(Constant.A_MEDIUM, strAMedium);
                i.putExtra(Constant.A_STANDARD, Constant.A_STD5);
                startActivity(i);
                finish();
            }
        });

        cardh6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Assig_Std.this, Admin_Assig_Upload.class);
                i.putExtra(Constant.A_MEDIUM, strAMedium);
                i.putExtra(Constant.A_STANDARD, Constant.A_STD6);
                startActivity(i);
                finish();
            }
        });

        cardh7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Assig_Std.this, Admin_Assig_Upload.class);
                i.putExtra(Constant.A_MEDIUM, strAMedium);
                i.putExtra(Constant.A_STANDARD, Constant.A_STD7);
                startActivity(i);
                finish();
            }
        });

        cardh8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Assig_Std.this, Admin_Assig_Upload.class);
                i.putExtra(Constant.A_MEDIUM, strAMedium);
                i.putExtra(Constant.A_STANDARD, Constant.A_STD8);
                startActivity(i);
                finish();
            }
        });

        cardh9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Assig_Std.this, Admin_Assig_Upload.class);
                i.putExtra(Constant.A_MEDIUM, strAMedium);
                i.putExtra(Constant.A_STANDARD, Constant.A_STD9);
                startActivity(i);
                finish();
            }
        });

        cardh10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Assig_Std.this, Admin_Assig_Upload.class);
                i.putExtra(Constant.A_MEDIUM, strAMedium);
                i.putExtra(Constant.A_STANDARD, Constant.A_STD10);
                startActivity(i);
                finish();
            }
        });
    }
}