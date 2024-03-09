package com.example.newmsp.ui.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.newmsp.Constant;
import com.example.newmsp.MyApp;
import com.example.newmsp.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class s_std_e extends AppCompatActivity {

    MaterialCardView carde1,carde2,carde3,carde4,carde5,carde6,carde7,carde8,carde9,carde10;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();


    DatabaseReference userRef = FirebaseDatabase.getInstance().getReference(Constant.DATABASE_ROOT);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_std_e);


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

                String aid = MyApp.getStringPrefs(Constant.PREF_AID);
                Log.e("TAG---", "onClick: LOGIN_USER_AID :  "+ aid );

                firebaseDatabase.getReference().child(Constant.DATABASE_ROOT).child(aid).child(Constant.DB_STD).setValue(Constant.STD1).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        MyApp.setStringPrefs(Constant.DB_STD, Constant.STD1);
                        Log.e("TAG---", "onSuccess: STD1 : "+Constant.STD1 );

                        Intent i = new Intent(s_std_e.this, Student_home.class);
                        startActivity(i);
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(s_std_e.this, "Something went wrong...!" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });

        carde2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aid = MyApp.getStringPrefs(Constant.PREF_AID);
                Log.e("TAG---", "onClick: LOGIN_USER_AID :  "+ aid );

                firebaseDatabase.getReference().child(Constant.DATABASE_ROOT).child(aid).child(Constant.DB_STD).setValue(Constant.STD2).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        MyApp.setStringPrefs(Constant.DB_STD, Constant.STD2);
                        Log.e("TAG---", "onSuccess: STD2 : "+Constant.STD2 );

                        Intent i = new Intent(s_std_e.this, Student_home.class);
                        startActivity(i);
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(s_std_e.this, "Something went wrong...!" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

        carde3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aid = MyApp.getStringPrefs(Constant.PREF_AID);
                Log.e("TAG---", "onClick: LOGIN_USER_AID :  "+ aid );

                firebaseDatabase.getReference().child(Constant.DATABASE_ROOT).child(aid).child(Constant.DB_STD).setValue(Constant.STD3).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        MyApp.setStringPrefs(Constant.DB_STD, Constant.STD3);
                        Log.e("TAG---", "onSuccess: STD3 : "+Constant.STD3 );

                        Intent i = new Intent(s_std_e.this, Student_home.class);
                        startActivity(i);
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(s_std_e.this, "Something went wrong...!" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

        carde4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aid = MyApp.getStringPrefs(Constant.PREF_AID);
                Log.e("TAG---", "onClick: LOGIN_USER_AID :  "+ aid );

                firebaseDatabase.getReference().child(Constant.DATABASE_ROOT).child(aid).child(Constant.DB_STD).setValue(Constant.STD4).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        MyApp.setStringPrefs(Constant.DB_STD, Constant.STD4);
                        Log.e("TAG---", "onSuccess: STD4 : "+Constant.STD4 );

                        Intent i = new Intent(s_std_e.this, Student_home.class);
                        startActivity(i);
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(s_std_e.this, "Something went wrong...!" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });

        carde5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aid = MyApp.getStringPrefs(Constant.PREF_AID);
                Log.e("TAG---", "onClick: LOGIN_USER_AID :  "+ aid );

                firebaseDatabase.getReference().child(Constant.DATABASE_ROOT).child(aid).child(Constant.DB_STD).setValue(Constant.STD5).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        MyApp.setStringPrefs(Constant.DB_STD, Constant.STD5);
                        Log.e("TAG---", "onSuccess: STD5 : "+Constant.STD5 );

                        Intent i = new Intent(s_std_e.this, Student_home.class);
                        startActivity(i);
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(s_std_e.this, "Something went wrong...!" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

        carde6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aid = MyApp.getStringPrefs(Constant.PREF_AID);
                Log.e("TAG---", "onClick: LOGIN_USER_AID :  "+ aid );

                firebaseDatabase.getReference().child(Constant.DATABASE_ROOT).child(aid).child(Constant.DB_STD).setValue(Constant.STD6).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        MyApp.setStringPrefs(Constant.DB_STD, Constant.STD6);
                        Log.e("TAG---", "onSuccess: STD6 : "+Constant.STD6 );

                        Intent i = new Intent(s_std_e.this, Student_home.class);
                        startActivity(i);
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(s_std_e.this, "Something went wrong...!" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });

        carde7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aid = MyApp.getStringPrefs(Constant.PREF_AID);
                Log.e("TAG---", "onClick: LOGIN_USER_AID :  "+ aid );

                firebaseDatabase.getReference().child(Constant.DATABASE_ROOT).child(aid).child(Constant.DB_STD).setValue(Constant.STD7).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        MyApp.setStringPrefs(Constant.DB_STD, Constant.STD7);
                        Log.e("TAG---", "onSuccess: STD7 : "+Constant.STD7 );

                        Intent i = new Intent(s_std_e.this, Student_home.class);
                        startActivity(i);
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(s_std_e.this, "Something went wrong...!" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });

        carde8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aid = MyApp.getStringPrefs(Constant.PREF_AID);
                Log.e("TAG---", "onClick: LOGIN_USER_AID :  "+ aid );

                firebaseDatabase.getReference().child(Constant.DATABASE_ROOT).child(aid).child(Constant.DB_STD).setValue(Constant.STD8).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        MyApp.setStringPrefs(Constant.DB_STD, Constant.STD8);
                        Log.e("TAG---", "onSuccess: STD8 : "+Constant.STD8 );

                        Intent i = new Intent(s_std_e.this, Student_home.class);
                        startActivity(i);
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(s_std_e.this, "Something went wrong...!" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });

        carde9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aid = MyApp.getStringPrefs(Constant.PREF_AID);
                Log.e("TAG---", "onClick: LOGIN_USER_AID :  "+ aid );

                firebaseDatabase.getReference().child(Constant.DATABASE_ROOT).child(aid).child(Constant.DB_STD).setValue(Constant.STD9).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        MyApp.setStringPrefs(Constant.DB_STD, Constant.STD9);
                        Log.e("TAG---", "onSuccess: STD9 : "+Constant.STD9 );

                        Intent i = new Intent(s_std_e.this, Student_home.class);
                        startActivity(i);
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(s_std_e.this, "Something went wrong...!" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });

        carde10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aid = MyApp.getStringPrefs(Constant.PREF_AID);
                Log.e("TAG---", "onClick: LOGIN_USER_AID :  "+ aid );

                firebaseDatabase.getReference().child(Constant.DATABASE_ROOT).child(aid).child(Constant.DB_STD).setValue(Constant.STD10).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        MyApp.setStringPrefs(Constant.DB_STD, Constant.STD10);
                        Log.e("TAG---", "onSuccess: STD10 : "+Constant.STD10 );

                        Intent i = new Intent(s_std_e.this, Payment.class);
                        startActivity(i);
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(s_std_e.this, "Something went wrong...!" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

    }
}