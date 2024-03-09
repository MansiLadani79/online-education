package com.example.newmsp.ui.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.newmsp.Constant;
import com.example.newmsp.R;
import com.google.android.material.card.MaterialCardView;

public class T_Sub extends AppCompatActivity {

    ImageView img_guj,img_eng,img_hindi,img_maths,img_ss,img_sci,img_sa;

    private String strMedium="";
    private String strStandard="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_sub);

        findViewByIds();

        if (getIntent()!=null){
            strMedium = getIntent().getStringExtra(Constant.MEDIUM);
            strStandard = getIntent().getStringExtra(Constant.STANDARD);
        }


        if (strStandard.equals(Constant.STD1))
        {
            img_guj.setVisibility(View.VISIBLE);
            img_eng.setVisibility(View.VISIBLE);
            img_hindi.setVisibility(View.VISIBLE);
            img_maths.setVisibility(View.VISIBLE);
            img_ss.setVisibility(View.INVISIBLE);
            img_sci.setVisibility(View.INVISIBLE);
            img_sa.setVisibility(View.INVISIBLE);
        }
        else if(strStandard.equals(Constant.STD2)){
            img_guj.setVisibility(View.VISIBLE);
            img_eng.setVisibility(View.VISIBLE);
            img_hindi.setVisibility(View.VISIBLE);
            img_maths.setVisibility(View.VISIBLE);
            img_ss.setVisibility(View.INVISIBLE);
            img_sci.setVisibility(View.INVISIBLE);
            img_sa.setVisibility(View.INVISIBLE);
        }
        else if(strStandard.equals(Constant.STD3)){
            img_guj.setVisibility(View.VISIBLE);
            img_eng.setVisibility(View.VISIBLE);
            img_hindi.setVisibility(View.VISIBLE);
            img_maths.setVisibility(View.VISIBLE);
            img_ss.setVisibility(View.INVISIBLE);
            img_sci.setVisibility(View.INVISIBLE);
            img_sa.setVisibility(View.INVISIBLE);
        }
        else if(strStandard.equals(Constant.STD4)){
            img_guj.setVisibility(View.VISIBLE);
            img_eng.setVisibility(View.VISIBLE);
            img_hindi.setVisibility(View.VISIBLE);
            img_maths.setVisibility(View.VISIBLE);
            img_ss.setVisibility(View.INVISIBLE);
            img_sci.setVisibility(View.INVISIBLE);
            img_sa.setVisibility(View.INVISIBLE);
        }
        else if(strStandard.equals(Constant.STD5)){
            img_guj.setVisibility(View.VISIBLE);
            img_eng.setVisibility(View.VISIBLE);
            img_hindi.setVisibility(View.VISIBLE);
            img_maths.setVisibility(View.VISIBLE);
            img_ss.setVisibility(View.INVISIBLE);
            img_sci.setVisibility(View.INVISIBLE);
            img_sa.setVisibility(View.INVISIBLE);
        }



        img_guj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Sub.this, admin_upload_file.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, strStandard);
                i.putExtra(Constant.SUBJECT, Constant.S_GUJ);
                startActivity(i);
                finish();
            }
        });

        img_eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Sub.this, admin_upload_file.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, strStandard);
                i.putExtra(Constant.SUBJECT, Constant.S_ENG);
                startActivity(i);
                finish();
            }
        });

        img_hindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Sub.this, admin_upload_file.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, strStandard);
                i.putExtra(Constant.SUBJECT, Constant.S_HINDI);
                startActivity(i);
                finish();
            }
        });

        img_maths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Sub.this, admin_upload_file.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, strStandard);
                i.putExtra(Constant.SUBJECT, Constant.S_MATHS);
                startActivity(i);
                finish();
            }
        });

        img_ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Sub.this, admin_upload_file.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, strStandard);
                i.putExtra(Constant.SUBJECT, Constant.S_SS);
                startActivity(i);
                finish();
            }
        });

        img_sci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Sub.this, admin_upload_file.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, strStandard);
                i.putExtra(Constant.SUBJECT, Constant.S_SCI);
                startActivity(i);
                finish();
            }
        });

        img_sa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(T_Sub.this, admin_upload_file.class);
                i.putExtra(Constant.MEDIUM, strMedium);
                i.putExtra(Constant.STANDARD, strStandard);
                i.putExtra(Constant.SUBJECT, Constant.S_SA);
                startActivity(i);
                finish();
            }
        });

    }

    private void findViewByIds() {
        img_guj = findViewById(R.id.img_guj);
        img_eng = findViewById(R.id.img_eng);
        img_hindi = findViewById(R.id.img_hindi);
        img_maths = findViewById(R.id.img_maths);
        img_ss = findViewById(R.id.img_ss);
        img_sci = findViewById(R.id.img_sci);
        img_sa = findViewById(R.id.img_sa);


    }
}