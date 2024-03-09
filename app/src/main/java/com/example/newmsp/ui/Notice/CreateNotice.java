package com.example.newmsp.ui.Notice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.newmsp.R;
import com.example.newmsp.model.NoticeModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class CreateNotice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_notice);

        FloatingActionButton floatingActionButton=findViewById(R.id.save);
        final EditText edittext_area=findViewById(R.id.edittext_area);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNotices(edittext_area.getText().toString());
            }
        });
    }

    private void saveNotices(String note) {
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("Notices");
        String id=databaseReference.push().getKey();
        NoticeModel noticeModel=new NoticeModel(id,note,new Date().toString());
        databaseReference.child(id).setValue(noticeModel);
        startActivity(new Intent(CreateNotice.this,MainActivityNotice.class));
        finish();
    }
}