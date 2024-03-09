package com.example.newmsp.ui;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newmsp.Constant;
import com.example.newmsp.MyApp;
import com.example.newmsp.R;
import com.example.newmsp.model.Admin;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Signup extends AppCompatActivity {

    EditText nameET,emailET,passET,phoneET,addET,dateET;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button btnsignup = findViewById(R.id.btnsignup);
        nameET = findViewById(R.id.nameET);
        emailET = findViewById(R.id.emailET);
        passET = findViewById(R.id.passET);
        phoneET = findViewById(R.id.phoneET);
        addET = findViewById(R.id.addET);
        dateET = findViewById(R.id.dateET);


        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = nameET.getText().toString();
                String email = emailET.getText().toString();
                String password = passET.getText().toString();
                String phoneNo = phoneET.getText().toString();
                String address = addET.getText().toString();
                String date = dateET.getText().toString();

                if ((name.isEmpty() && email.isEmpty() && passET.getText().toString().isEmpty() && phoneET.getText().toString().isEmpty() && addET.getText().toString().isEmpty()) && dateET.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Enter All Field", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (nameET.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "PLEASE ENTER YOUR NAME", Toast.LENGTH_SHORT).show();
                    return;
                } else if (emailET.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "PLEASE ENTER YOUR EMAIL ID", Toast.LENGTH_SHORT).show();
                    return;
                } else if (passET.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "PLEASE ENTER YOUR PASSWORD", Toast.LENGTH_SHORT).show();
                    return;
                } else if (phoneET.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "PLEASE ENTER YOUR PHONE NUMBER", Toast.LENGTH_SHORT).show();
                    return;
                }else if (addET.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"PLEASE ENTER ADDRESS",Toast.LENGTH_SHORT).show();
                    return;
                }else if (dateET.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please enter date of joining",Toast.LENGTH_SHORT);
                    return;
                }


                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

                if (!(name.isEmpty()
                        && email.isEmpty()
                        && password.isEmpty()
                        && phoneNo.isEmpty()
                        && address.isEmpty()
                        && date.isEmpty())
                ) {
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                String aid = task.getResult().getUser().getUid();
/*                                SharedPreferences preferences = getSharedPreferences(Constant.PREFERENCE_NAME, MODE_PRIVATE);
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putString(Constant.PREF_AID, aid);
                                editor.commit();*/
                                MyApp.setStringPrefs(Constant.PREF_AID, aid);


                                Admin a = new Admin();
                                a.setAid(aid);
                                a.setName(name);
                                a.setEmail(email);
                                a.setPassword(password);
                                a.setPhoneNumber(phoneNo);
                                a.setLogintype(0);
                                a.setAddress(address);
                                a.setDate(date);


                                //TODO:check-it

                                firebaseDatabase.getReference().child(Constant.DATABASE_ROOT).child(aid).setValue(a);

                                Toast.makeText(getApplicationContext(), "registration successfull !! Try to log in", Toast.LENGTH_LONG).show();

                                Intent i = new Intent(Signup.this, MainActivity.class);
                                startActivity(i);
                            } else {
                                Toast.makeText(getApplicationContext(), task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }


            }
        });

        dateET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectDate();
            }
        });

    }

    private void selectDate() {

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
               dateET.setText(day + "-" + (month + 1) + "-" + year);
            }
        }, year, month, day);
        datePickerDialog.show();
    }
}