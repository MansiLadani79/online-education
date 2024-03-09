package com.example.newmsp.ui.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.newmsp.R;
import com.example.newmsp.ui.Chat.RegisterActivityChat;
import com.example.newmsp.ui.MainActivity;
import com.example.newmsp.ui.Notice.MainActivityNotice;
import com.example.newmsp.ui.student.Student_home;

public class admin_home extends AppCompatActivity {

    TextView aLogin;
    ImageView img_logout;

    CardView card_material,card_show,card_assignment,card_answer,card_notification,card_notice,card_list,card_chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);


        card_material = (CardView) findViewById(R.id.card_material);
        card_show = (CardView) findViewById(R.id.card_show);
        card_assignment = (CardView) findViewById(R.id.card_assignment);
        card_answer = (CardView) findViewById(R.id.card_answer);
        card_notification = (CardView) findViewById(R.id.card_notification);
        card_notice = (CardView) findViewById(R.id.card_notice);
        card_list = (CardView) findViewById(R.id.card_list);
        card_chat = (CardView) findViewById(R.id.card_chat);

        img_logout = (ImageView) findViewById(R.id.img_logout);


        img_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(admin_home.this);
                builder.setTitle("Log Out");
                builder.setMessage("Do you want logout");

                builder.setCancelable(false);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                });

                builder.create().show();
            }
        });


        card_material.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), t_medium.class);
                startActivity(i);
            }
        });


        card_assignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), T_Assig_Medium.class);
                startActivity(i);
            }
        });


        card_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RegisterActivityChat.class);
                startActivity(i);
            }
        });


        card_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ShowStudent.class);
                startActivity(i);
            }
        });


        card_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivityNotice.class);
                startActivity(i);
            }
        });


        card_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Send_Notification.class);
                startActivity(i);
            }
        });


        card_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Show_Answer_Assignment.class);
                startActivity(i);
            }
        });

    }

    public void retrivePDF(View view) {

        startActivity(new Intent(getApplicationContext(), T_Retrive_Medi.class));

    }


}