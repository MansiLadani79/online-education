package com.example.newmsp.ui.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.newmsp.Constant;
import com.example.newmsp.R;
import com.example.newmsp.adapter.AnswerAdapter;
import com.example.newmsp.adapter.AssignmentAdapter;
import com.example.newmsp.model.AnswerAssignment;
import com.example.newmsp.model.putPDF;
import com.example.newmsp.ui.student.Student_Assignment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Show_Answer_Assignment extends AppCompatActivity {

    ListView listView;
    DatabaseReference databaseReference;
    ArrayList<AnswerAssignment> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_answer_assignment);

        listView = findViewById(R.id.listView);

        String name=getIntent().getStringExtra("name");
        String url=getIntent().getStringExtra("url");

        arrayList = new ArrayList<AnswerAssignment>();

        retrievePDFFiles();

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                AnswerAssignment answerAssignment = arrayList.get(i);
//
//                Intent intent = new Intent();
//                intent.setType(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse(answerAssignment.getUrl()));
//                startActivity(intent);
//            }
//        });

    }

    private void retrievePDFFiles() {

        //TODO: set-in-OnCreate-getIntent

//        Log.println(Log.ASSERT, "TAG---", "StrMed : " + strMedium
//                + "\nstrStd : " + strStandard
//                + "\nstrSub : " + strSubject);

        databaseReference = FirebaseDatabase.getInstance().getReference("Answer_Assignment");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot ds : snapshot.getChildren()) {

                    AnswerAssignment answerAssignment = ds.getValue(com.example.newmsp.model.AnswerAssignment.class);
                    arrayList.add(answerAssignment);
                }

                String[] uploadsName = new String[arrayList.size()];

                for (int i = 0; i < uploadsName.length; i++) {

                    uploadsName[i] = arrayList.get(i).getName();
                }

//                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
//                        android.R.layout.simple_list_item_1, uploadsName) {
//
//
//                    @Override
//                    public View getView(int position, View convertView, ViewGroup parent) {
//
//                        View view = super.getView(position, convertView, parent);
//
//                        TextView myText = (TextView) view.findViewById(android.R.id.text1);
//                        myText.setTextColor(Color.BLACK);
//                        myText.setTextSize(20);
//                        return view;
//                    }
//                };


                AnswerAdapter answerAdapter = new AnswerAdapter(Show_Answer_Assignment.this, arrayList);
                listView.setAdapter(answerAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}