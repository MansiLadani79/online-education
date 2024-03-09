package com.example.newmsp.ui.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.newmsp.Constant;
import com.example.newmsp.ui.MainActivity;
import com.example.newmsp.MyApp;
import com.example.newmsp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class admin_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        EditText emailET_login =findViewById(R.id.emailET_login);
        EditText passET_login = findViewById(R.id.passET_login);

        Button btnL_login =findViewById(R.id.btnL_login);
        btnL_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((emailET_login.getText().toString().isEmpty() && passET_login.getText().toString().isEmpty())){
                    Toast.makeText(getApplicationContext(), "Please Enter All Field", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(emailET_login.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Enter Your Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (passET_login.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please Enter Your Password", Toast.LENGTH_SHORT).show();
                    return;
                }


                FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();

                if(!(emailET_login.getText().toString().isEmpty() && passET_login.getText().toString().isEmpty())){

                    firebaseAuth.signInWithEmailAndPassword(emailET_login.getText().toString(),passET_login.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){

                                String aid = task.getResult().getUser().getUid();

                                FirebaseDatabase firebaseDatabase =FirebaseDatabase.getInstance();
                                firebaseDatabase.getReference().child(Constant.DATABASE_ROOT).child(aid).child("logintype").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        int logintype=snapshot.getValue(Integer.class);
                                        if(logintype==0){

                                            Toast.makeText(getApplicationContext(), "only admin can login plz try login for student", Toast.LENGTH_LONG).show();
                                            Intent i = new Intent(admin_login.this, MainActivity.class);
                                            startActivity(i);
                                        }
                                        if(logintype==1){
                                            MyApp.setStringPrefs(Constant.PREF_AID,aid);
                                            MyApp.setBooleanPrefs(Constant.PREF_LOGIN, true);
                                            MyApp.setStringPrefs(Constant.PREF_LOGIN_TYPE, Constant.TEACHER);

                                            Intent i = new Intent(admin_login.this, admin2home.class);
                                            startActivity(i);
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });

                            }

                            else{
                                Toast.makeText(getApplicationContext(),task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }

                finish();

            }
        });
    }
}