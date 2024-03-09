package com.example.newmsp.ui.admin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newmsp.R;
import com.example.newmsp.adapter.MyAdapterStudent;
import com.example.newmsp.model.MyItemsStudent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowStudent extends AppCompatActivity {


    //getting Firebase database refrence
    private  final  DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    //creating  List of MyItems to store students details
    private  final  List<MyItemsStudent> myItemsListStudents = new ArrayList<>();


    @Override
    protected  void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_student);

        //getting RecyclerView from xml file
        final  RecyclerView recyclerViewStudent = findViewById(R.id.recyclerViewStudent);

        // setting recyclerview size fixed for every item in the recyclerview
        recyclerViewStudent.setHasFixedSize(true);

        //setting layout manager to the recyclearview
        recyclerViewStudent.setLayoutManager(new LinearLayoutManager(ShowStudent.this));

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //clear old items / student from list to add new data/student
                myItemsListStudents.clear();

             //getting all children from users root
             for(DataSnapshot users : snapshot.child("users").getChildren()) {


                 //to prevent app crash if the student hal all the details in firebase Database
                 if (users.hasChild("name") && users.hasChild("phoneNumber") && users.hasChild("email")) {
                     //getting studentd details from firebas database and store into the list one by one
                     final String getFullname = users.child("name").getValue(String.class);
                     final String getMobile = users.child("phoneNumber").getValue(String.class);
                     final String getEmail = users.child("email").getValue(String.class);

                     //creating student item with student details
                     MyItemsStudent myItemsStudent = new MyItemsStudent(getFullname, getMobile, getEmail);

                     //adding this student item to list
                     myItemsListStudents.add(myItemsStudent);

                 }

             }


             recyclerViewStudent.setAdapter(new MyAdapterStudent(myItemsListStudents,ShowStudent.this));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


    }