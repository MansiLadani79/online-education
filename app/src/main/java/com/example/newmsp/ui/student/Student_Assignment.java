package com.example.newmsp.ui.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newmsp.Constant;
import com.example.newmsp.MyApp;
import com.example.newmsp.R;
import com.example.newmsp.adapter.AssignmentAdapter;
import com.example.newmsp.adapter.CustomAdapter;
import com.example.newmsp.model.Assignment;
import com.example.newmsp.ui.Chat.RegisterActivityChat;
import com.example.newmsp.ui.Notes.MainActivityNotes;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Student_Assignment extends AppCompatActivity {

    BottomNavigationView nav;

    ListView listView;
    DatabaseReference databaseReference;
    ArrayList<Assignment> arrayList;


    private String strMedium = "";
    private String strStandard = "";
    private String strSubject = "";

    FloatingActionButton upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_assignment);

        upload = findViewById(R.id.upload);

        String name=getIntent().getStringExtra("name");
        String url=getIntent().getStringExtra("url");

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), Student_Ans_Assignment.class);
                startActivity(i);
            }
        });


        nav = findViewById(R.id.nav);

        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.home:
                        Intent i = new Intent(getApplicationContext(), Student_home.class);
                        startActivity(i);
                        break;

                    case R.id.assignment:
                        Toast.makeText(Student_Assignment.this, "ASSIGNMENT", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.notes:
                        Intent intent = new Intent(getApplicationContext(), MainActivityNotes.class);
                        startActivity(intent);
                        Toast.makeText(Student_Assignment.this, "NOTES", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.chat:
                        startActivity(new Intent(getApplicationContext(), RegisterActivityChat.class));
                        Toast.makeText(Student_Assignment.this, "CHAT", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.profile:
                        Intent in = new Intent(getApplicationContext(), Student_Profile.class);
                        startActivity(in);
                        break;
                    default:
                }

                return true;
            }
        });

        nav.getMenu().findItem(R.id.assignment).setChecked(true);

        listView = findViewById(R.id.listView);
        arrayList = new ArrayList<Assignment>();

        String aid = MyApp.getStringPrefs(Constant.PREF_AID);
        //  Log.e("TAG---", "onClick: LOGIN_USER_AID :  "+ aid );

        strMedium = MyApp.getStringPrefs(Constant.DB_MEDIUM);
        strStandard = MyApp.getStringPrefs(Constant.DB_STD);

        retrievePDFFiles();

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                Assignment assignment = arrayList.get(i);
//
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setType("application/pdf");
//                intent.setData(Uri.parse(assignment.getUrl()));
//                startActivity(intent);
//            }
//        });
    }

    private void retrievePDFFiles() {

        databaseReference= FirebaseDatabase.getInstance().getReference("Assignment").child(strMedium).child(strStandard);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot ds:snapshot.getChildren()){

                    Assignment assignment =ds.getValue(com.example.newmsp.model.Assignment.class);
                    arrayList.add(assignment);
                }

                String[] uploadsName=new String[arrayList.size()];

                for(int i = 0; i < uploadsName.length; i++){

                    uploadsName[i] = arrayList.get(i).getName();
                }

//                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),
//                        android.R.layout.simple_list_item_1, uploadsName){
//
//
//                    @Override
//                    public View getView(int position,  View convertView,  ViewGroup parent) {
//
//                        View view = super.getView(position, convertView, parent);
//
//                        TextView myText = (TextView) view.findViewById(android.R.id.text1);
//                        myText.setTextColor(Color.BLACK);
//                        myText.setTextSize(20);
//
//
//                        return view;
//                    }
//                };

                AssignmentAdapter assignmentAdapter = new AssignmentAdapter(Student_Assignment.this, arrayList);
                listView.setAdapter(assignmentAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}