package com.example.newmsp.ui.student;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.newmsp.R;
import com.example.newmsp.ui.student.Student_home;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class Payment extends AppCompatActivity implements PaymentResultListener {

    private ImageView button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        button=findViewById(R.id.button);

        Checkout.preload(getApplicationContext());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPayment();
            }
        });

    }

    private void startPayment(){

        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_lH84a5DuaiqXkP");

        checkout.setImage(R.drawable.logo);


        final Activity activity = this;


        try {
            JSONObject options = new JSONObject();

            options.put("name", "Learning Spark");
            options.put("description", "Reference No. #123456");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
//            options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#8a7ba2");
            options.put("currency", "INR");
            options.put("amount", "150000");//pass amount in currency subunits
            options.put("prefill.email", "msp@gmail.com");
            options.put("prefill.contact","8200724497");
            JSONObject retryObj = new JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count", 4);
            options.put("retry", retryObj);

            checkout.open(activity, options);

        } catch(Exception e) {
            Log.e("TAG", "Error in starting Razorpay Checkout", e);
        }
    }

    @Override
    public void onPaymentSuccess(String s) {

       // Log.d("ONSUCCESS", "onPaymentSuccess: " + s);

        Toast.makeText(this, "Payment is successfull : " + s, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), Student_home.class);
        startActivity(intent);
    }

    @Override
    public void onPaymentError(int i, String s) {

       // Log.d("ONERROR", "onPaymentError: "+s);

        Toast.makeText(this, "Payment failed due to error : " + s, Toast.LENGTH_SHORT).show();
    }

}