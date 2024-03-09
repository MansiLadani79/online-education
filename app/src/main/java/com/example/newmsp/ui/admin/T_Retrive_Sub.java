package com.example.newmsp.ui.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.newmsp.Constant;
import com.example.newmsp.R;
import com.google.android.material.card.MaterialCardView;

public class T_Retrive_Sub extends AppCompatActivity {

    MaterialCardView cardReGuj,cardReEng,cardReHindi,cardReMaths,cardReSs,cardReSci,cardReSa;

    private String strMedium="";
    private String strStandard="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_retrive_sub);


        if (getIntent()!=null){
            strMedium = getIntent().getStringExtra(Constant.MEDIUM);
            strStandard = getIntent().getStringExtra(Constant.STANDARD);
        }

        cardReMaths = findViewById(R.id.cardReMaths);
        cardReEng = findViewById(R.id.cardReEng);
        cardReGuj = findViewById(R.id.cardReGuj);
        cardReHindi = findViewById(R.id.cardReHindi);
        cardReSs = findViewById(R.id.cardReSs);
        cardReSci = findViewById(R.id.cardReSci);
        cardReSa = findViewById(R.id.cardReSa);

        if (strStandard.equals(Constant.STD1))
        {
            cardReGuj.setVisibility(View.VISIBLE);
            cardReEng.setVisibility(View.VISIBLE);
            cardReHindi.setVisibility(View.VISIBLE);
            cardReMaths.setVisibility(View.VISIBLE);
            cardReSs.setVisibility(View.INVISIBLE);
            cardReSci.setVisibility(View.INVISIBLE);
            cardReSa.setVisibility(View.INVISIBLE);
        }
        else if(strStandard.equals(Constant.STD2)){
            cardReGuj.setVisibility(View.VISIBLE);
            cardReEng.setVisibility(View.VISIBLE);
            cardReHindi.setVisibility(View.VISIBLE);
            cardReMaths.setVisibility(View.VISIBLE);
            cardReSs.setVisibility(View.INVISIBLE);
            cardReSci.setVisibility(View.INVISIBLE);
            cardReSa.setVisibility(View.INVISIBLE);
        }
        else if(strStandard.equals(Constant.STD3)){
            cardReGuj.setVisibility(View.VISIBLE);
            cardReEng.setVisibility(View.VISIBLE);
            cardReHindi.setVisibility(View.VISIBLE);
            cardReMaths.setVisibility(View.VISIBLE);
            cardReSs.setVisibility(View.INVISIBLE);
            cardReSci.setVisibility(View.INVISIBLE);
            cardReSa.setVisibility(View.INVISIBLE);
        }
        else if(strStandard.equals(Constant.STD4)){
            cardReGuj.setVisibility(View.VISIBLE);
            cardReEng.setVisibility(View.VISIBLE);
            cardReHindi.setVisibility(View.VISIBLE);
            cardReMaths.setVisibility(View.VISIBLE);
            cardReSs.setVisibility(View.INVISIBLE);
            cardReSci.setVisibility(View.INVISIBLE);
            cardReSa.setVisibility(View.INVISIBLE);
        }
        else if(strStandard.equals(Constant.STD5)){
            cardReGuj.setVisibility(View.VISIBLE);
            cardReEng.setVisibility(View.VISIBLE);
            cardReHindi.setVisibility(View.VISIBLE);
            cardReMaths.setVisibility(View.VISIBLE);
            cardReSs.setVisibility(View.INVISIBLE);
            cardReSci.setVisibility(View.INVISIBLE);
            cardReSa.setVisibility(View.INVISIBLE);
        }


        cardReMaths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Retrive_Sub.this, activity_retrive.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, strStandard);
                i.putExtra(Constant.SUBJECT, Constant.S_MATHS);
                startActivity(i);
                finish();
            }
        });

        cardReEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Retrive_Sub.this, activity_retrive.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, strStandard);
                i.putExtra(Constant.SUBJECT, Constant.S_ENG);
                startActivity(i);
                finish();
            }
        });

        cardReGuj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Retrive_Sub.this, activity_retrive.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, strStandard);
                i.putExtra(Constant.SUBJECT, Constant.S_GUJ);
                startActivity(i);
                finish();
            }
        });

        cardReHindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Retrive_Sub.this, activity_retrive.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, strStandard);
                i.putExtra(Constant.SUBJECT, Constant.S_HINDI);
                startActivity(i);
                finish();
            }
        });

        cardReSs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Retrive_Sub.this, activity_retrive.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, strStandard);
                i.putExtra(Constant.SUBJECT, Constant.S_SS);
                startActivity(i);
                finish();
            }
        });

        cardReSci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Retrive_Sub.this, activity_retrive.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, strStandard);
                i.putExtra(Constant.SUBJECT, Constant.S_SCI);
                startActivity(i);
                finish();
            }
        });

        cardReSa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Retrive_Sub.this, activity_retrive.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, strStandard);
                i.putExtra(Constant.SUBJECT, Constant.S_SA);
                startActivity(i);
                finish();
            }
        });


    }
}