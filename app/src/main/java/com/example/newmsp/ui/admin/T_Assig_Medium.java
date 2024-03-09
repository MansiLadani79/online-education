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

public class T_Assig_Medium extends AppCompatActivity {

    MaterialCardView cardE, cardG, cardH;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();


    DatabaseReference userRef = FirebaseDatabase.getInstance().getReference(Constant.DATABASE_ROOT);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_assig_medium);

        cardE = findViewById(R.id.cardEN);
        cardG = findViewById(R.id.cardGU);
        cardH = findViewById(R.id.cardHI);


        cardE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Assig_Medium.this,T_Assig_Std.class);
                i.putExtra(Constant.A_MEDIUM, Constant.A_M_ENGLISH);
                startActivity(i);
                finish();
            }
        });

        cardG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Assig_Medium.this,T_Assig_Std.class);
                i.putExtra(Constant.A_MEDIUM, Constant.A_M_GUJARATI);
                startActivity(i);
                finish();
            }
        });

        cardH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Assig_Medium.this,T_Assig_Std.class);
                i.putExtra(Constant.A_MEDIUM, Constant.A_M_HINDI);
                startActivity(i);
                finish();

                goToNext();
            }
        });

    }

    private void goToNext() {

    }

}