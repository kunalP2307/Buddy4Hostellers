package com.example.buddy4hostellers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.buddy4hostellers.data.ServiceProviderContactDetails;

import java.io.Serializable;

public class AddServiceProContactMessActivity extends AppCompatActivity {

    private static final String TAG = "AddServiceProContactMessActivity";

    EditText editTextName,editTextContact;
    TextView textViewResendOTP;
    Button buttonContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service_pro_contact_mess);

        bindComponents();

        addListeners();

    }

    public void bindComponents(){

        this.editTextContact = findViewById(R.id.edit_text_service_pro_contact_mess);
        this.editTextName = findViewById(R.id.edit_text_service_pro_name_mess);
        this.buttonContinue = findViewById(R.id.button_continue_service_pro_continue_mess);
        this.textViewResendOTP = findViewById(R.id.text_view_resend_otp);

    }

    public void addListeners(){

        this.buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validInput()){

                    ServiceProviderContactDetails contactDetails = new ServiceProviderContactDetails(editTextName.getText().toString(),editTextContact.getText().toString());
                    Intent intent = new Intent(AddServiceProContactMessActivity.this,AddNearClgForMessActivity.class);

                    intent.putExtra("EXTRA_CONTACT_DETAILS", (Serializable) contactDetails);

                    startActivity(intent);
                }
            }
        });

    }

    public boolean validInput(){

        String name = editTextName.getText().toString();
        String contact = editTextContact.getText().toString();

        if(name.isEmpty()){
            editTextName.setError("This Field Cannot be Empty");
            editTextName.requestFocus();
            return false;

        }
        if(!Patterns.PHONE.matcher(contact).matches()){

            editTextContact.setError("Please Enter Valid Contact Numbers");
            editTextContact.requestFocus();
            return false;
        }
        if(contact.length() < 10 || contact.length() > 10){
            editTextContact.setError("Please Enter Valid Contact Number");
            editTextContact.requestFocus();
            return false;
        }

        return true;
    }
}