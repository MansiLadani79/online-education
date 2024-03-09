package com.example.newmsp.ui.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.newmsp.Constant;
import com.example.newmsp.MyApp;
import com.example.newmsp.R;
import com.example.newmsp.ui.admin.T_Retrive_Medi;
import com.example.newmsp.ui.admin.T_Retrive_std;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class s_medium extends AppCompatActivity {


    MaterialCardView cardE, cardG, cardH;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();


    DatabaseReference userRef = FirebaseDatabase.getInstance().getReference(Constant.DATABASE_ROOT);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smedium);


        cardE = findViewById(R.id.cardEN);
        cardG = findViewById(R.id.cardGU);
        cardH = findViewById(R.id.cardHI);


        cardE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aid = MyApp.getStringPrefs(Constant.PREF_AID);
                Log.e("TAG---", "onClick: LOGIN_USER_AID :  "+ aid );
                firebaseDatabase.getReference().child(Constant.DATABASE_ROOT).child(aid).child(Constant.DB_MEDIUM).setValue(Constant.M_ENGLISH).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {


                        MyApp.setStringPrefs(Constant.DB_MEDIUM, Constant.M_ENGLISH);
                        Log.e("TAG---", "onSuccess: ENGLISH : "+Constant.M_ENGLISH );

                        Intent i = new Intent(s_medium.this, s_std_e.class);
                        startActivity(i);
                        finish();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(s_medium.this, "Something went wrong...!" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        cardG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String aid = MyApp.getStringPrefs(Constant.PREF_AID);
                Log.e("TAG---", "onClick: LOGIN_USER_AID :  "+ aid );

                firebaseDatabase.getReference().child(Constant.DATABASE_ROOT).child(aid).child(Constant.DB_MEDIUM).setValue(Constant.M_GUJARATI).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        MyApp.setStringPrefs(Constant.DB_MEDIUM, Constant.M_GUJARATI);
                        Log.e("TAG---", "onSuccess: GUJARATI : "+Constant.M_GUJARATI );

                        Intent i = new Intent(s_medium.this,s_std_g.class);
                        startActivity(i);
                        finish();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(s_medium.this, "Something went wrong...!" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

        cardH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aid = MyApp.getStringPrefs(Constant.PREF_AID);
                Log.e("TAG---", "onClick: LOGIN_USER_AID :  "+ aid );

                firebaseDatabase.getReference().child(Constant.DATABASE_ROOT).child(aid).child(Constant.DB_MEDIUM).setValue(Constant.M_HINDI).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        MyApp.setStringPrefs(Constant.DB_MEDIUM, Constant.M_HINDI);
                        Log.e("TAG---", "onSuccess: HINDI : "+Constant.M_HINDI );

                        Intent i = new Intent(s_medium.this,s_std_h.class);
                        startActivity(i);
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(s_medium.this, "Something went wrong...!" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });



                goToNext();
            }
        });
    }


    private void goToNext() {

    }


}