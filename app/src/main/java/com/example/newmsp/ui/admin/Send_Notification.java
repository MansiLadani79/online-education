package com.example.newmsp.ui.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newmsp.R;
import com.google.firebase.messaging.FirebaseMessaging;

public class Send_Notification extends AppCompatActivity {

    private  EditText title,message;
    private Button sendbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_send_notification);


        FirebaseMessaging.getInstance().subscribeToTopic("all");



        title = findViewById(R.id.title_id);
         message = findViewById(R.id.message_id);

         sendbtn = findViewById(R.id.send_btn);


         sendbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 if(!title.getText().toString().isEmpty() && !message.getText().toString().isEmpty()){

                     FcmNotificationsSender notificationsSender
                             = new FcmNotificationsSender("/topics/all",title.getText().toString(),
                             message.getText().toString(),getApplicationContext(),Send_Notification.this);


                     //notificationsSender.SendNotifications();
                     notificationsSender.SendNotificationsToTopic("all");

                     Toast.makeText(Send_Notification.this, "Send Successfully", Toast.LENGTH_SHORT).show();
                     Intent intent = new Intent(Send_Notification.this, admin_home.class);
                     startActivity(intent);


                 }else{
                     Toast.makeText(Send_Notification.this, "Please give your data ", Toast.LENGTH_SHORT).show();
                 }

             }
         });




    }
}