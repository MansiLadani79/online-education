package com.example.newmsp.ui.Notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newmsp.Constant;
import com.example.newmsp.MyApp;
import com.example.newmsp.R;
import com.example.newmsp.model.NoteModel;
import com.example.newmsp.ui.Chat.RegisterActivityChat;
import com.example.newmsp.ui.student.Student_Profile;
import com.example.newmsp.ui.student.Student_home;
import com.example.newmsp.ui.student.Student_Assignment;
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
public class MainActivityNotes extends AppCompatActivity implements NoteClickListener {

    BottomNavigationView nav;

    List<NoteModel> noteModels=new ArrayList<>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

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
                        Intent intent = new Intent(getApplicationContext(), Student_Assignment.class);
                        startActivity(intent);
                        Toast.makeText(MainActivityNotes.this, "ASSIGNMENT", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.notes:
                        Toast.makeText(MainActivityNotes.this, "NOTES", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.chat:
                        startActivity(new Intent(getApplicationContext(), RegisterActivityChat.class));
                        Toast.makeText(MainActivityNotes.this, "CHAT", Toast.LENGTH_SHORT).show();
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

        nav.getMenu().findItem(R.id.notes).setChecked(true);



        final RecyclerView notelist=findViewById(R.id.notelist);

        FloatingActionButton create=findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivityNotes.this,CreateNoteActivity.class));
            }
        });

        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference(Constant.DATABASE_ROOT);
        databaseReference.child(MyApp.getStringPrefs(Constant.PREF_AID)).child("noteModels").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()) {
                    String id=dataSnapshot1.child("id").getValue(String.class);
                    String note=dataSnapshot1.child("note_data").getValue(String.class);
                    String create=dataSnapshot1.child("created_at").getValue(String.class);
                    noteModels.add(new NoteModel(id,note,create));
                }

                NoteItemsRecyclerView noteItemsRecyclerView = new NoteItemsRecyclerView(noteModels, MainActivityNotes.this);
                notelist.setLayoutManager(new LinearLayoutManager(MainActivityNotes.this));
                notelist.setAdapter(noteItemsRecyclerView);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void onClickItem(NoteModel noteModel) {
        Intent intent=new Intent(MainActivityNotes.this,ViewNoteDataActivity.class);
        intent.putExtra(Constant.id,noteModel.getId());
        intent.putExtra(Constant.note_text,noteModel.getNote_data());
        intent.putExtra(Constant.create_time,noteModel.getCreated_at());
        startActivity(intent);
    }
}