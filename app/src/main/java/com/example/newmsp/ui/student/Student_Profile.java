package com.example.newmsp.ui.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.newmsp.R;
import com.example.newmsp.model.Admin;
import com.example.newmsp.ui.Chat.RegisterActivityChat;
import com.example.newmsp.ui.MainActivity;
import com.example.newmsp.ui.Notes.MainActivityNotes;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Student_Profile extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {


    EditText pNameEt,PemailET,PaddressET,PPhoneET,PDateET;


    ImageView dot3,btnSelect,btnUpload;


    private ImageView imageView;
    private Uri filePath;

    private final int PICK_IMAGE_REQUEST = 22;

    FirebaseStorage storage;
    StorageReference storageReference;
    BottomNavigationView nav;


    FirebaseUser user ;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);


        pNameEt = findViewById(R.id.pNameEt);
        PemailET = findViewById(R.id.PemailET);
        PaddressET = findViewById(R.id.PaddressET);
        PPhoneET = findViewById(R.id.PPhoneET);
        PDateET = findViewById(R.id.PDateET);

        dot3=(ImageView) findViewById(R.id.dot3);

        nav = findViewById(R.id.nav);

        btnSelect = findViewById(R.id.btnChoose);
        btnUpload = findViewById(R.id.btnUpload);
        imageView = findViewById(R.id.imgView);

        btnSelect.setVisibility(View.VISIBLE);
        btnUpload.setVisibility(View.INVISIBLE);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("users").child("1Vhc20PRx2h9vantFpQBLfeTjf02");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists()) {



                    Admin admin = snapshot.getValue(Admin.class);
                    pNameEt.setText(snapshot.child("name").getValue().toString());
                    PemailET.setText(snapshot.child("email").getValue().toString());
                    PaddressET.setText(snapshot.child("address").getValue().toString());
                    PPhoneET.setText(snapshot.child("phoneNumber").getValue().toString());
                    PDateET.setText(snapshot.child("date").getValue().toString());


                    if(snapshot.child("profileimage").exists()){

                        Glide.with(Student_Profile.this).load(snapshot.child("profileimage").getValue()).into(imageView);


                    }
                }else{
                    Toast.makeText(Student_Profile.this, "Data Not Found", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        showUserData();


        dot3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v);
            }
        });




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
                        break;

                    case R.id.notes:
                        Intent in = new Intent(getApplicationContext(), MainActivityNotes.class);
                        startActivity(in);
                        Toast.makeText(Student_Profile.this, "NOTES", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.chat:
                        startActivity(new Intent(getApplicationContext(), RegisterActivityChat.class));
                        Toast.makeText(Student_Profile.this, "CHAT", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.profile:
                        Toast.makeText(Student_Profile.this, "PROFILE", Toast.LENGTH_SHORT).show();
                        break;

                    default:

                }

                return true;
            }
        });

        nav.getMenu().findItem(R.id.profile).setChecked(true);



        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectImage();

                btnSelect.setVisibility(View.INVISIBLE);
                btnUpload.setVisibility(View.VISIBLE);
            }
        });

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
            }
        });


    }


    private void showUserData() {
        Intent i = getIntent();

        String nameUser =i.getStringExtra("name");
        String emailUser = i.getStringExtra("email");
        String addressUser = i.getStringExtra("address");
        String phoneUser = i.getStringExtra("phone");
        String dateUser = i.getStringExtra("date");

        pNameEt.setText(nameUser);
        PemailET.setText(emailUser);
        PaddressET.setText(addressUser);
        PPhoneET.setText(phoneUser);
        PDateET.setText(dateUser);


    }




    private void showPopup(View v) {
        PopupMenu popup = new PopupMenu(Student_Profile.this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup);
        popup.show();
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.edit:
                startActivity(new Intent(getApplicationContext(), s_medium.class));
                return true;

            case R.id.log_out:
                AlertDialog.Builder builder=new AlertDialog.Builder(Student_Profile.this);
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


            default:
                return false;
        }
    }

    private void SelectImage() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(
                Intent.createChooser(
                        intent,
                        "Select Image from here..."),
                PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {

        super.onActivityResult(requestCode,
                resultCode,
                data);

        if (requestCode == PICK_IMAGE_REQUEST
                && resultCode == RESULT_OK
                && data != null
                && data.getData() != null) {

            filePath = data.getData();
            try {

                Bitmap bitmap = MediaStore
                        .Images
                        .Media
                        .getBitmap(
                                getContentResolver(),
                                filePath);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void uploadImage() {
        if (filePath != null) {

            ProgressDialog progressDialog
                    = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            StorageReference ref
                    = storageReference
                    .child(
                            "images/"
                                    + UUID.randomUUID().toString());

            ref.putFile(filePath)
                    .addOnSuccessListener(
                            new OnSuccessListener<UploadTask.TaskSnapshot>() {

                                @Override
                                public void onSuccess(
                                        UploadTask.TaskSnapshot taskSnapshot) {

                                    ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                                @Override
                                                public void onSuccess(Uri uri) {
                                                    Map<String, Object> result = new HashMap<>();
                                                    result.put("profileimage",uri.toString());
                                                    FirebaseDatabase.getInstance().getReference("users").child("1Vhc20PRx2h9vantFpQBLfeTjf02").updateChildren(result).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                        @Override
                                                        public void onSuccess(Void unused) {

                                                            Toast.makeText(Student_Profile.this, "Profile saved", Toast.LENGTH_SHORT).show();
                                                        }
                                                    });
                                                }
                                            }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(Student_Profile.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });

                                    progressDialog.dismiss();
                                    Toast
                                            .makeText(Student_Profile.this,
                                                    "Image Uploaded!!",
                                                    Toast.LENGTH_SHORT)
                                            .show();
                                }
                            })

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            progressDialog.dismiss();
                            Toast
                                    .makeText(Student_Profile.this,
                                            "Failed " + e.getMessage(),
                                            Toast.LENGTH_SHORT)
                                    .show();
                        }
                    })
                    .addOnProgressListener(
                            new OnProgressListener<UploadTask.TaskSnapshot>() {

                                @Override
                                public void onProgress(
                                        UploadTask.TaskSnapshot taskSnapshot)
                                {
                                    double progress
                                            = (100.0
                                            * taskSnapshot.getBytesTransferred()
                                            / taskSnapshot.getTotalByteCount());
                                    progressDialog.setMessage(
                                            "Uploaded "
                                                    + (int) progress + "%");
                                }
                            });
        }
    }
}