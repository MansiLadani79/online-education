package com.example.newmsp.ui.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newmsp.Constant;
import com.example.newmsp.R;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class T_Retrive_std extends AppCompatActivity {

    MaterialCardView cardgRe1,cardgRe2,cardg3,cardg4,cardg5,cardg6,cardg7,cardg8,cardg9,cardg10;

    DatabaseReference databaseReference;

    private String strMedium="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_retrive_std);

        databaseReference = FirebaseDatabase.getInstance().getReference(Constant.UPLOAD);


        if (getIntent()!=null){
            strMedium = getIntent().getStringExtra(Constant.MEDIUM);
        }

        cardgRe1 = findViewById(R.id.cardgRe1);
        cardgRe2 = findViewById(R.id.cardgRe2);
        cardg3 = findViewById(R.id.cardg3);
        cardg4 = findViewById(R.id.cardg4);
        cardg5 = findViewById(R.id.cardg5);
        cardg6 = findViewById(R.id.cardg6);
        cardg7 = findViewById(R.id.cardg7);
        cardg8 = findViewById(R.id.cardg8);
        cardg9 = findViewById(R.id.cardg9);
        cardg10 = findViewById(R.id.cardg10);

        cardgRe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Retrive_std.this, T_Retrive_Sub.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, Constant.STD1);
                startActivity(i);
                finish();
            }
        });

        cardgRe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Retrive_std.this, T_Retrive_Sub.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, Constant.STD2);
                startActivity(i);
                finish();
            }
        });

        cardg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Retrive_std.this,T_Retrive_Sub.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, Constant.STD3);
                startActivity(i);
                finish();
            }
        });

        cardg4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Retrive_std.this,T_Retrive_Sub.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, Constant.STD4);
                startActivity(i);
                finish();
            }
        });

        cardg5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Retrive_std.this,T_Retrive_Sub.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, Constant.STD5);
                startActivity(i);
                finish();
            }
        });

        cardg6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Retrive_std.this,T_Retrive_Sub.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, Constant.STD6);
                startActivity(i);
                finish();
            }
        });

        cardg7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Retrive_std.this,T_Retrive_Sub.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, Constant.STD7);
                startActivity(i);
                finish();
            }
        });

        cardg8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Retrive_std.this,T_Retrive_Sub.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, Constant.STD8);
                startActivity(i);
                finish();
            }
        });

        cardg9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Retrive_std.this,T_Retrive_Sub.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, Constant.STD9);
                startActivity(i);
                finish();
            }
        });

        cardg10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Retrive_std.this,T_Retrive_Sub.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, Constant.STD10);
                startActivity(i);
                finish();
            }
        });
    }
}