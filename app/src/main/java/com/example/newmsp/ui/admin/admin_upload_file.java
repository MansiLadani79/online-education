package com.example.newmsp.ui.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.newmsp.Constant;
import com.example.newmsp.R;
import com.example.newmsp.model.putPDF;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import javax.annotation.Nullable;

public class admin_upload_file extends AppCompatActivity {

    ImageView imagebrowse,imageupload,filelogo,cancelfile;
    EditText filetitle;

    StorageReference storageReference;
    DatabaseReference databaseReference;

    private String strMedium="";
    private String strStandard="";
    private String strSubject="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_upload_file);

        if (getIntent()!=null){
            strMedium = getIntent().getStringExtra(Constant.MEDIUM);
            strStandard = getIntent().getStringExtra(Constant.STANDARD);
            strSubject= getIntent().getStringExtra(Constant.SUBJECT);
        }

        storageReference= FirebaseStorage.getInstance().getReference();
        databaseReference= FirebaseDatabase.getInstance().getReference(Constant.UPLOAD).child(strMedium).child(strStandard).child(strSubject);

        filetitle=findViewById(R.id.filetitle);

        imagebrowse=findViewById(R.id.imagebrowse);
        imageupload=findViewById(R.id.imageupload);

        filelogo=findViewById(R.id.filelogo);
        cancelfile=findViewById(R.id.cancelfile);


        filelogo.setVisibility(View.INVISIBLE);
        cancelfile.setVisibility(View.INVISIBLE);

        cancelfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filelogo.setVisibility(View.INVISIBLE);
                cancelfile.setVisibility(View.INVISIBLE);
                imagebrowse.setVisibility(View.VISIBLE);
            }
        });

        imageupload.setEnabled(false);

        imagebrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectPDF();
            }
        });


    }

    private void selectPDF() {
        Dexter.withContext(getApplicationContext())
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {

                        Intent intent = new Intent();
                        intent.setType("application/pdf");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(Intent.createChooser(intent, "Select pdf file"), 12);
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                        permissionToken.continuePermissionRequest();
                    }
                }).check();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 12 && resultCode == RESULT_OK && data!=null && data.getData()!=null) {
            imageupload.setEnabled(true);
            filetitle.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));

            imageupload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    uploadPDFFileFirebase(data.getData());
                }
            });

            filelogo.setVisibility(View.VISIBLE);
            cancelfile.setVisibility(View.VISIBLE);
            imagebrowse.setVisibility(View.INVISIBLE);
        }
    }


    private void uploadPDFFileFirebase(Uri data) {

        final ProgressDialog pd=new ProgressDialog(this);
        pd.setTitle("File Uploading...");
        pd.show();

        StorageReference reference=storageReference.child("upload"+System.currentTimeMillis()+".pdf");

            reference.putFile(data)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                            while (!uriTask.isComplete());
                            Uri uri= uriTask.getResult();

                            putPDF p = new putPDF();
                            p.setName(filetitle.getText().toString());
                            p.setUrl(uri.toString());
                         //   String key = String.valueOf(System.nanoTime());

                           // putPDF putPDF = new putPDF(filetitle.getText().toString(), uri.toString());
                            //databaseReference.child(databaseReference.push().getKey()).setValue(p);
                            databaseReference.push().setValue(p);
                            Toast.makeText(admin_upload_file.this,"File Uploaded..", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(admin_upload_file.this, admin_home.class);
                            startActivity(intent);
                            pd.dismiss();
                            finish();
                        }
                    }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                            double progress=(100.0* snapshot.getBytesTransferred())/snapshot.getTotalByteCount();
                            pd.setMessage("File Uploaded.." +(int) progress+ "%");
                        }
                    });


    }

}