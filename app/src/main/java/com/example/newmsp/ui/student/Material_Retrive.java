package com.example.newmsp.ui.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.newmsp.Constant;
import com.example.newmsp.MyApp;
import com.example.newmsp.R;
import com.example.newmsp.adapter.CustomAdapter;
import com.example.newmsp.model.putPDF;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Material_Retrive extends AppCompatActivity {

    ListView listView;
    DatabaseReference databaseReference;
    ArrayList<putPDF> arrayList;


    private String strMedium = "";
    private String strStandard = "";
    private String strSubject = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_retrive);

        listView = findViewById(R.id.listView);
        arrayList = new ArrayList<putPDF>();


        String aid = MyApp.getStringPrefs(Constant.PREF_AID);
      //  Log.e("TAG---", "onClick: LOGIN_USER_AID :  "+ aid );

        strMedium = MyApp.getStringPrefs(Constant.DB_MEDIUM);
        strStandard = MyApp.getStringPrefs(Constant.DB_STD);
        strSubject = MyApp.getStringPrefs(Constant.SUBJECT);

        retrievePDFFiles();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                putPDF putPDFS = arrayList.get(i);

                Intent intent = new Intent();
                intent.setType(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(putPDFS.getUrl()));
                startActivity(intent);
            }
        });
    }

    private void retrievePDFFiles() {
        //TODO: set-in-OnCreate-getIntent

        Log.println(Log.ASSERT, "TAG---", "StrMed : " + strMedium
                + "\nstrStd : " + strStandard
                + "\nstrSub : " + strSubject);


        databaseReference = FirebaseDatabase.getInstance().getReference(Constant.UPLOAD).child(strMedium).child(strStandard).child(strSubject);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot ds : snapshot.getChildren()) {

                    putPDF putPDF = ds.getValue(com.example.newmsp.model.putPDF.class);
                    arrayList.add(putPDF);
                }

                String[] uploadsName = new String[arrayList.size()];

                for (int i = 0; i < uploadsName.length; i++) {

                    uploadsName[i] = arrayList.get(i).getName();
                }

//                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
//                        android.R.layout.simple_list_item_1, uploadsName){
//
//                    @Override
//                    public View getView(int position, View convertView, ViewGroup parent) {
//
//                        View view = super.getView(position, convertView, parent);
//
//                        TextView myText = (TextView) view.findViewById(android.R.id.text1);
//                        myText.setTextColor(Color.BLACK);
//                        myText.setTextSize(20);
//                        return view;
//                    }
//                };

                CustomAdapter customAdapter = new CustomAdapter(Material_Retrive.this, arrayList);
                listView.setAdapter(customAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}