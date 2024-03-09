package com.example.newmsp.ui.Notice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.newmsp.Constant;
import com.example.newmsp.R;
import com.example.newmsp.model.NoticeModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivityNotice extends AppCompatActivity implements NoticeClickListener{

    List<NoticeModel> noticeModels=new ArrayList<>();

    FloatingActionButton cre_notice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_notice);

        final RecyclerView notelist=findViewById(R.id.notelist);

        cre_notice = findViewById(R.id.cre_notice);
        cre_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivityNotice.this,CreateNotice.class));
            }
        });
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("Notices");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()) {
                    String id=dataSnapshot1.child("id").getValue(String.class);
                    String note=dataSnapshot1.child("note_data").getValue(String.class);
                    String create=dataSnapshot1.child("created_at").getValue(String.class);
                    noticeModels.add(new NoticeModel(id,note,create));
                }

                NoticeItemRecyclerView noticeItemsRecyclerView = new NoticeItemRecyclerView(noticeModels, MainActivityNotice.this);
                notelist.setLayoutManager(new LinearLayoutManager(MainActivityNotice.this));
                notelist.setAdapter(noticeItemsRecyclerView);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void onClickItem(NoticeModel noticeModel) {
        Intent intent=new Intent(MainActivityNotice.this,ViewNoticeData.class);
        intent.putExtra(Constant.nid,noticeModel.getId());
        intent.putExtra(Constant.notice_text,noticeModel.getNote_data());
        intent.putExtra(Constant.creates_time,noticeModel.getCreated_at());
        startActivity(intent);
    }
}