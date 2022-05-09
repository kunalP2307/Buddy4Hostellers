package com.example.buddy4hostellers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buddy4hostellers.data.LivingPlace;
import com.example.buddy4hostellers.data.ServiceProviderContactDetails;

import java.util.List;
import java.util.Random;

public class SendAndVerifyContactActivity extends AppCompatActivity {

    EditText editTextOtp;
    TextView textViewResendOtp;
    Button buttonContinue;
    int otp;
    String contact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_and_verify_contact);

        bindComponents();

        ServiceProviderContactDetails contactDetails = (ServiceProviderContactDetails) getIntent().getSerializableExtra("EXTRA_CONTACT_DETAILS");

        contact = contactDetails.getContact();
        sendOtp();

    }

    public void bindComponents(){

        editTextOtp = findViewById(R.id.edit_text_otp);
        buttonContinue = findViewById(R.id.button_continue_verify_contact);
        textViewResendOtp = findViewById(R.id.text_view_resend_otp);

        textViewResendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendOtp();
            }
        });

        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(verifyOtp()){

                    ServiceProviderContactDetails contactDetails = (ServiceProviderContactDetails) getIntent().getSerializableExtra("EXTRA_CONTACT_DETAILS");

                    LivingPlace livingPlace = new LivingPlace();
                    livingPlace.setServiceProviderContactDetails(contactDetails);


                    Intent intent = new Intent(SendAndVerifyContactActivity.this,AddNearByCollegeActivity.class);
                    intent.putExtra("EXTRA_LIVING_PLACE",livingPlace);
                    startActivity(intent);
                }
                else{
                    editTextOtp.setError("Incorrect OTP");
                    editTextOtp.requestFocus();
                }
            }
        });
    }

    public boolean verifyOtp(){

        int enteredOtp = Integer.parseInt(editTextOtp.getText().toString());

        if(enteredOtp == otp)
            return true;

        return false;

    }
    public void sendOtp(){

        otp = (int)Math.floor(Math.random()*(9999-1000+1)+1000);

        String message = "OTP to verify your mobile number : "+otp+" Please do not share with anyone!\nTeam Buddy4Hostellers.";

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(contact, null, message, null, null);
            Toast.makeText(this, "OTP Sent Successfully!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Something Went Wrong!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}