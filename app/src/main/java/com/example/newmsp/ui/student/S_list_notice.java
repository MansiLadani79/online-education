package com.example.newmsp.ui.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.newmsp.Constant;
import com.example.newmsp.R;
import com.example.newmsp.model.NoticeModel;
import com.example.newmsp.ui.Notice.MainActivityNotice;
import com.example.newmsp.ui.Notice.NoticeClickListener;
import com.example.newmsp.ui.Notice.NoticeItemRecyclerView;
import com.example.newmsp.ui.Notice.ViewNoticeData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class S_list_notice extends AppCompatActivity implements NoticeClickListener {

    List<NoticeModel> noticeModels=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_list_notice);

        final RecyclerView notelist=findViewById(R.id.notelist);

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

                NoticeItemRecyclerView noticeItemsRecyclerView = new NoticeItemRecyclerView(noticeModels, S_list_notice.this);
                notelist.setLayoutManager(new LinearLayoutManager(S_list_notice.this));
                notelist.setAdapter(noticeItemsRecyclerView);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void onClickItem(NoticeModel noticeModel) {
        Intent intent=new Intent(S_list_notice.this, ViewNoticeData.class);
        intent.putExtra(Constant.nid,noticeModel.getId());
        intent.putExtra(Constant.notice_text,noticeModel.getNote_data());
        intent.putExtra(Constant.creates_time,noticeModel.getCreated_at());
        startActivity(intent);
    }
}