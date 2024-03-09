package com.example.newmsp.ui.student;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.newmsp.Constant;
import com.example.newmsp.MyApp;
import com.example.newmsp.R;
import com.example.newmsp.ui.About_us;
import com.example.newmsp.ui.Privacy_policy;
import com.example.newmsp.ui.Rating_bar;
import com.example.newmsp.ui.Chat.RegisterActivityChat;
import com.example.newmsp.ui.MainActivity;
import com.example.newmsp.ui.Notes.MainActivityNotes;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class Student_home extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    BottomNavigationView nav;

    ImageView img_notice, lines;
    TextView text_std;

    MaterialCardView card_guj, card_eng, card_hindi, card_maths, card_ss, card_sci, card_sa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);

        findViewByIds();

        if (MyApp.getStringPrefs(Constant.DB_STD).equals(Constant.STD1)) {
            card_guj.setVisibility(View.VISIBLE);
            card_eng.setVisibility(View.VISIBLE);
            card_hindi.setVisibility(View.VISIBLE);
            card_maths.setVisibility(View.VISIBLE);
            card_ss.setVisibility(View.INVISIBLE);
            card_sci.setVisibility(View.INVISIBLE);
            card_sa.setVisibility(View.INVISIBLE);
            text_std.setText("Standard 1");
        }
        else if (MyApp.getStringPrefs(Constant.DB_STD).equals(Constant.STD2)) {
            card_guj.setVisibility(View.VISIBLE);
            card_eng.setVisibility(View.VISIBLE);
            card_hindi.setVisibility(View.VISIBLE);
            card_maths.setVisibility(View.VISIBLE);
            card_ss.setVisibility(View.INVISIBLE);
            card_sci.setVisibility(View.INVISIBLE);
            card_sa.setVisibility(View.INVISIBLE);
            text_std.setText("Standard 2");
        }
        else if (MyApp.getStringPrefs(Constant.DB_STD).equals(Constant.STD3)) {
            card_guj.setVisibility(View.VISIBLE);
            card_eng.setVisibility(View.VISIBLE);
            card_hindi.setVisibility(View.VISIBLE);
            card_maths.setVisibility(View.VISIBLE);
            card_ss.setVisibility(View.INVISIBLE);
            card_sci.setVisibility(View.INVISIBLE);
            card_sa.setVisibility(View.INVISIBLE);
            text_std.setText("Standard 3");
        }
        else if (MyApp.getStringPrefs(Constant.DB_STD).equals(Constant.STD4)) {
            card_guj.setVisibility(View.VISIBLE);
            card_eng.setVisibility(View.VISIBLE);
            card_hindi.setVisibility(View.VISIBLE);
            card_maths.setVisibility(View.VISIBLE);
            card_ss.setVisibility(View.INVISIBLE);
            card_sci.setVisibility(View.INVISIBLE);
            card_sa.setVisibility(View.INVISIBLE);
            text_std.setText("Standard 4");
        }
        else if (MyApp.getStringPrefs(Constant.DB_STD).equals(Constant.STD5)) {
            card_guj.setVisibility(View.VISIBLE);
            card_eng.setVisibility(View.VISIBLE);
            card_hindi.setVisibility(View.VISIBLE);
            card_maths.setVisibility(View.VISIBLE);
            card_ss.setVisibility(View.INVISIBLE);
            card_sci.setVisibility(View.INVISIBLE);
            card_sa.setVisibility(View.INVISIBLE);
            text_std.setText("Standard 5");
        }
        else if (MyApp.getStringPrefs(Constant.DB_STD).equals(Constant.STD6)) {
            card_guj.setVisibility(View.VISIBLE);
            card_eng.setVisibility(View.VISIBLE);
            card_hindi.setVisibility(View.VISIBLE);
            card_maths.setVisibility(View.VISIBLE);
            card_ss.setVisibility(View.VISIBLE);
            card_sci.setVisibility(View.VISIBLE);
            card_sa.setVisibility(View.VISIBLE);
            text_std.setText("Standard 6");
        }
        else if (MyApp.getStringPrefs(Constant.DB_STD).equals(Constant.STD7)) {
            card_guj.setVisibility(View.VISIBLE);
            card_eng.setVisibility(View.VISIBLE);
            card_hindi.setVisibility(View.VISIBLE);
            card_maths.setVisibility(View.VISIBLE);
            card_ss.setVisibility(View.VISIBLE);
            card_sci.setVisibility(View.VISIBLE);
            card_sa.setVisibility(View.VISIBLE);
            text_std.setText("Standard 7");
        }
        else if (MyApp.getStringPrefs(Constant.DB_STD).equals(Constant.STD8)) {
            card_guj.setVisibility(View.VISIBLE);
            card_eng.setVisibility(View.VISIBLE);
            card_hindi.setVisibility(View.VISIBLE);
            card_maths.setVisibility(View.VISIBLE);
            card_ss.setVisibility(View.VISIBLE);
            card_sci.setVisibility(View.VISIBLE);
            card_sa.setVisibility(View.VISIBLE);
            text_std.setText("Standard 8");
        }
        else if (MyApp.getStringPrefs(Constant.DB_STD).equals(Constant.STD9)) {
            card_guj.setVisibility(View.VISIBLE);
            card_eng.setVisibility(View.VISIBLE);
            card_hindi.setVisibility(View.VISIBLE);
            card_maths.setVisibility(View.VISIBLE);
            card_ss.setVisibility(View.VISIBLE);
            card_sci.setVisibility(View.VISIBLE);
            card_sa.setVisibility(View.VISIBLE);
            text_std.setText("Standard 9");
        }
        else if (MyApp.getStringPrefs(Constant.DB_STD).equals(Constant.STD10)) {
            card_guj.setVisibility(View.VISIBLE);
            card_eng.setVisibility(View.VISIBLE);
            card_hindi.setVisibility(View.VISIBLE);
            card_maths.setVisibility(View.VISIBLE);
            card_ss.setVisibility(View.VISIBLE);
            card_sci.setVisibility(View.VISIBLE);
            card_sa.setVisibility(View.VISIBLE);
            text_std.setText("Standard 10");
        }


        ImageSlider imageSlider = findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.slide, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slide2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slide3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slide4, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        img_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), S_list_notice.class);
                startActivity(intent);
            }
        });

        lines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNavigation(v);
            }
        });

        nav = findViewById(R.id.nav);

        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.home:
                        Toast.makeText(Student_home.this, "HOME", Toast.LENGTH_SHORT).show();
                        break;


                    case R.id.assignment:
                        Intent i = new Intent(getApplicationContext(), Student_Assignment.class);
                        startActivity(i);
                        break;

                    case R.id.notes:
                        Intent intent = new Intent(getApplicationContext(), MainActivityNotes.class);
                        startActivity(intent);
                        Toast.makeText(Student_home.this, "NOTES", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.chat:
                        startActivity(new Intent(getApplicationContext(), RegisterActivityChat.class));
                        Toast.makeText(Student_home.this, "CHAT", Toast.LENGTH_SHORT).show();
                        break;


                    case R.id.profile:

                        Intent in = new Intent(getApplicationContext(), Student_Profile.class);
                        startActivity(in);
                        break;


                    default:
                }

                return true;
            }
        });


        card_guj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyApp.setStringPrefs(Constant.SUBJECT, Constant.S_GUJ);
                Log.e("TAG---", "onSuccess: S_GUJ : " + Constant.S_GUJ);

                Intent i = new Intent(Student_home.this, Material_Retrive.class);
                startActivity(i);
            }
        });

        card_eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyApp.setStringPrefs(Constant.SUBJECT, Constant.S_ENG);
                Log.e("TAG---", "onSuccess: S_ENG : " + Constant.S_ENG);

                Intent i = new Intent(Student_home.this, Material_Retrive.class);
                startActivity(i);
            }
        });

        card_hindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyApp.setStringPrefs(Constant.SUBJECT, Constant.S_HINDI);
                Log.e("TAG---", "onSuccess: S_HINDI : " + Constant.S_HINDI);

                Intent i = new Intent(Student_home.this, Material_Retrive.class);
                startActivity(i);
            }
        });

        card_maths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyApp.setStringPrefs(Constant.SUBJECT, Constant.S_MATHS);
                Log.e("TAG---", "onSuccess: S_MATHS : " + Constant.S_MATHS);

                Intent i = new Intent(Student_home.this, Material_Retrive.class);
                startActivity(i);
            }
        });

        card_ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyApp.setStringPrefs(Constant.SUBJECT, Constant.S_SS);
                Log.e("TAG---", "onSuccess: S_SS : " + Constant.S_SS);

                Intent i = new Intent(Student_home.this, Material_Retrive.class);
                startActivity(i);
            }
        });

        card_sci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyApp.setStringPrefs(Constant.SUBJECT, Constant.S_SCI);
                Log.e("TAG---", "onSuccess: S_SCI : " + Constant.S_SCI);

                Intent i = new Intent(Student_home.this, Material_Retrive.class);
                startActivity(i);
            }
        });

        card_sa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyApp.setStringPrefs(Constant.SUBJECT, Constant.S_SA);
                Log.e("TAG---", "onSuccess: S_SA : " + Constant.S_SA);

                Intent i = new Intent(Student_home.this, Material_Retrive.class);
                startActivity(i);
            }
        });

    }

    private void showNavigation(View v) {
        PopupMenu popup = new PopupMenu(Student_home.this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.item_navigation);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.home:
                startActivity(new Intent(getApplicationContext(), Student_home.class));
                return true;

            case R.id.assignment:
                startActivity(new Intent(getApplicationContext(), Student_Assignment.class));
                return true;

            case R.id.notes:
                startActivity(new Intent(getApplicationContext(), MainActivityNotes.class));
                return true;

            case R.id.chat:
                startActivity(new Intent(getApplicationContext(), RegisterActivityChat.class));
                return true;

            case R.id.notice:
                startActivity(new Intent(getApplicationContext(), S_list_notice.class));
                return true;

            case R.id.profile:
                startActivity(new Intent(getApplicationContext(), Student_Profile.class));
                return true;

            case R.id.share:
                Intent sharingIntent=new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/Hello msp..!!");
                String shareBody="Download App MSP";
                String shareSubject="Your Subject Here";
                sharingIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT,shareSubject);
                startActivity(Intent.createChooser(sharingIntent,"Share using"));
                return true;

            case R.id.rate_us:
                startActivity(new Intent(getApplicationContext(), Rating_bar.class));
                return true;

            case R.id.about_us:
                startActivity(new Intent(getApplicationContext(), About_us.class));
                return true;

            case R.id.privacy_policy:
                startActivity(new Intent(getApplicationContext(), Privacy_policy.class));
                return true;

            case R.id.log_out:
                AlertDialog.Builder builder = new AlertDialog.Builder(Student_home.this);
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
                return true;

            default:
                return false;

        }
    }

    private void findViewByIds() {

        card_guj = findViewById(R.id.card_guj);
        card_eng = findViewById(R.id.card_eng);
        card_hindi = findViewById(R.id.card_hindi);
        card_maths = findViewById(R.id.card_maths);
        card_ss = findViewById(R.id.card_ss);
        card_sci = findViewById(R.id.card_sci);
        card_sa = findViewById(R.id.card_sa);
        img_notice = findViewById(R.id.img_notice);
        lines = findViewById(R.id.lines);
        text_std = findViewById(R.id.text_std);
    }
}