package com.example.newmsp.ui.Notice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.newmsp.Constant;
import com.example.newmsp.R;
import com.example.newmsp.model.NoticeModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class ViewNoticeData extends AppCompatActivity {

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_notice_data);

        id=getIntent().getStringExtra(Constant.nid);
        String notetext=getIntent().getStringExtra(Constant.notice_text);
        String create_time=getIntent().getStringExtra(Constant.creates_time);

        TextView note_time=findViewById(R.id.create_time);

        final EditText edittext_area=findViewById(R.id.edittext_area);



        edittext_area.setText(notetext);
        note_time.setText(create_time);
    }


}