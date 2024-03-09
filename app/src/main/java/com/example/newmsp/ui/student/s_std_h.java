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

public class s_std_h extends AppCompatActivity {

    MaterialCardView cardh1,cardh2,cardh3,cardh4,cardh5,cardh6,cardh7,cardh8,cardh9,cardh10;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();


    DatabaseReference userRef = FirebaseDatabase.getInstance().getReference(Constant.DATABASE_ROOT);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_std_h);

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

                String aid = MyApp.getStringPrefs(Constant.PREF_AID);
                Log.e("TAG---", "onClick: LOGIN_USER_AID :  "+ aid );

                firebaseDatabase.getReference().child(Constant.DATABASE_ROOT).child(aid).child(Constant.DB_STD).setValue(Constant.STD1).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        MyApp.setStringPrefs(Constant.DB_STD, Constant.STD1);
                        Log.e("TAG---", "onSuccess: STD1 : "+Constant.STD1 );

                        startActivity(new Intent(s_std_h.this, Student_home.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(s_std_h.this, "Something went wrong...!" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

        cardh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aid = MyApp.getStringPrefs(Constant.PREF_AID);
                Log.e("TAG---", "onClick: LOGIN_USER_AID :  "+ aid );

                firebaseDatabase.getReference().child(Constant.DATABASE_ROOT).child(aid).child(Constant.DB_STD).setValue(Constant.STD2).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        MyApp.setStringPrefs(Constant.DB_STD, Constant.STD2);
                        Log.e("TAG---", "onSuccess: STD2 : "+Constant.STD2 );

                        startActivity(new Intent(s_std_h.this, Student_home.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(s_std_h.this, "Something went wrong...!" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });

        cardh3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aid = MyApp.getStringPrefs(Constant.PREF_AID);
                Log.e("TAG---", "onClick: LOGIN_USER_AID :  "+ aid );

                firebaseDatabase.getReference().child(Constant.DATABASE_ROOT).child(aid).child(Constant.DB_STD).setValue(Constant.STD3).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        MyApp.setStringPrefs(Constant.DB_STD, Constant.STD3);
                        Log.e("TAG---", "onSuccess: STD3 : "+Constant.STD3 );

                        startActivity(new Intent(s_std_h.this, Student_home.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(s_std_h.this, "Something went wrong...!" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

        cardh4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aid = MyApp.getStringPrefs(Constant.PREF_AID);
                Log.e("TAG---", "onClick: LOGIN_USER_AID :  "+ aid );

                firebaseDatabase.getReference().child(Constant.DATABASE_ROOT).child(aid).child(Constant.DB_STD).setValue(Constant.STD4).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        MyApp.setStringPrefs(Constant.DB_STD, Constant.STD4);
                        Log.e("TAG---", "onSuccess: STD4 : "+Constant.STD4 );

                        startActivity(new Intent(s_std_h.this, Student_home.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(s_std_h.this, "Something went wrong...!" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

        cardh5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aid = MyApp.getStringPrefs(Constant.PREF_AID);
                Log.e("TAG---", "onClick: LOGIN_USER_AID :  "+ aid );

                firebaseDatabase.getReference().child(Constant.DATABASE_ROOT).child(aid).child(Constant.DB_STD).setValue(Constant.STD5).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        MyApp.setStringPrefs(Constant.DB_STD, Constant.STD5);
                        Log.e("TAG---", "onSuccess: STD5 : "+Constant.STD5 );

                        startActivity(new Intent(s_std_h.this, Student_home.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(s_std_h.this, "Something went wrong...!" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

        cardh6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aid = MyApp.getStringPrefs(Constant.PREF_AID);
                Log.e("TAG---", "onClick: LOGIN_USER_AID :  "+ aid );

                firebaseDatabase.getReference().child(Constant.DATABASE_ROOT).child(aid).child(Constant.DB_STD).setValue(Constant.STD6).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        MyApp.setStringPrefs(Constant.DB_STD, Constant.STD6);
                        Log.e("TAG---", "onSuccess: STD6 : "+Constant.STD6 );

                        startActivity(new Intent(s_std_h.this, Student_home.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(s_std_h.this, "Something went wrong...!" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

        cardh7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aid = MyApp.getStringPrefs(Constant.PREF_AID);
                Log.e("TAG---", "onClick: LOGIN_USER_AID :  "+ aid );

                firebaseDatabase.getReference().child(Constant.DATABASE_ROOT).child(aid).child(Constant.DB_STD).setValue(Constant.STD7).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        MyApp.setStringPrefs(Constant.DB_STD, Constant.STD7);
                        Log.e("TAG---", "onSuccess: STD7 : "+Constant.STD7 );

                        startActivity(new Intent(s_std_h.this, Student_home.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(s_std_h.this, "Something went wrong...!" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

        cardh8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aid = MyApp.getStringPrefs(Constant.PREF_AID);
                Log.e("TAG---", "onClick: LOGIN_USER_AID :  "+ aid );

                firebaseDatabase.getReference().child(Constant.DATABASE_ROOT).child(aid).child(Constant.DB_STD).setValue(Constant.STD8).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        MyApp.setStringPrefs(Constant.DB_STD, Constant.STD8);
                        Log.e("TAG---", "onSuccess: STD8 : "+Constant.STD8 );

                        startActivity(new Intent(s_std_h.this, Student_home.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(s_std_h.this, "Something went wrong...!" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });

        cardh9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aid = MyApp.getStringPrefs(Constant.PREF_AID);
                Log.e("TAG---", "onClick: LOGIN_USER_AID :  "+ aid );

                firebaseDatabase.getReference().child(Constant.DATABASE_ROOT).child(aid).child(Constant.DB_STD).setValue(Constant.STD9).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        MyApp.setStringPrefs(Constant.DB_STD, Constant.STD9);
                        Log.e("TAG---", "onSuccess: STD9 : "+Constant.STD9 );

                        startActivity(new Intent(s_std_h.this, Student_home.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(s_std_h.this, "Something went wrong...!" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });

        cardh10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aid = MyApp.getStringPrefs(Constant.PREF_AID);
                Log.e("TAG---", "onClick: LOGIN_USER_AID :  "+ aid );

                firebaseDatabase.getReference().child(Constant.DATABASE_ROOT).child(aid).child(Constant.DB_STD).setValue(Constant.STD10).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        MyApp.setStringPrefs(Constant.DB_STD, Constant.STD10);
                        Log.e("TAG---", "onSuccess: STD10 : "+Constant.STD10 );

                        startActivity(new Intent(s_std_h.this, Payment.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(s_std_h.this, "Something went wrong...!" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }
}