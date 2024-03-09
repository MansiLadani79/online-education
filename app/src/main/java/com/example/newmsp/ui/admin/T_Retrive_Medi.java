package com.example.newmsp.ui.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.newmsp.Constant;
import com.example.newmsp.R;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class T_Retrive_Medi extends AppCompatActivity {

    MaterialCardView cardReE, cardReG, cardReH;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_retrive_medi);

        cardReE = findViewById(R.id.cardReEN);
        cardReG = findViewById(R.id.cardReGU);
        cardReH = findViewById(R.id.cardReHI);

        databaseReference = FirebaseDatabase.getInstance().getReference(Constant.UPLOAD);


        cardReE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Retrive_Medi.this, T_Retrive_std.class);
                i.putExtra(Constant.MEDIUM, Constant.M_ENGLISH);
                startActivity(i);
                finish();
            }
        });

        cardReG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Retrive_Medi.this,T_Retrive_std.class);
                i.putExtra(Constant.MEDIUM, Constant.M_GUJARATI);
                startActivity(i);
                finish();
            }
        });

        cardReH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Retrive_Medi.this,T_Retrive_std.class);
                i.putExtra(Constant.MEDIUM, Constant.M_HINDI);
                startActivity(i);
                finish();

                goToNext();
            }
        });
    }


    private void goToNext() {

    }

}
