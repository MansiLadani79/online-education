package com.example.newmsp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newmsp.R;
import com.example.newmsp.ui.student.Student_home;
import com.google.android.material.button.MaterialButton;

public class Rating_bar extends AppCompatActivity {

    private TextView txtRating;
    private RatingBar rbRating;
    private MaterialButton btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);

        init();

        rbRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float ratingValue, boolean b) {

                String rating = "Selected Rating : " + ratingValue;
                txtRating.setText(rating);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Rating_bar.this, "Thank you for rating", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Student_home.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void init() {

        txtRating = findViewById(R.id.txtRating);
        rbRating = findViewById(R.id.ratingBar);
        btnSubmit = findViewById(R.id.btn_submit);
    }
}