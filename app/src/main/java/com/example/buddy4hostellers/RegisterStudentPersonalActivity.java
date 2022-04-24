package com.example.buddy4hostellers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterStudentPersonalActivity extends AppCompatActivity {

    EditText editTextName,editTextContact,editTextEmail,editTextPassword,editTextConfirmPass;
    Button buttonContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student_personal);

        initComponents();
        addListneres();

    }

    public void initComponents(){

        this.editTextName = findViewById(R.id.edit_text_clg_clg_name);
        this.editTextEmail = findViewById(R.id.edit_text_reg_email);
        this.editTextContact = findViewById(R.id.edit_text_reg_mobile);
        this.editTextPassword = findViewById(R.id.edit_text_reg_pass);
        this.editTextConfirmPass = findViewById(R.id.edit_text_reg_cong_pass);
        this.buttonContinue = findViewById(R.id.btn_reg_clg_sign_up);

    }

    public void addListneres(){

        this.buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(validInput()){

                }
            }
        });

    }

    public boolean validInput(){

        boolean isValid = true;

        if(editTextName.getText().toString().isEmpty()){
            editTextName.setError("This Field Cannot be Empty!");
            editTextName.requestFocus();
            isValid = false;
        }
        if(editTextContact.getText().toString().isEmpty()){
            editTextContact.setError("This Field Cannot be Empty!");
            editTextContact.requestFocus();
            isValid = false;
        }
        if(editTextPassword.getText().toString().isEmpty()){
            editTextPassword.setError("This Field Cannot be Empty!");
            editTextPassword.requestFocus();
            isValid = false;
        }
        if(editTextConfirmPass.getText().toString().isEmpty()){
            editTextConfirmPass.setError("This Field Cannot be Empty!");
            editTextConfirmPass.requestFocus();
            isValid = false;
        }
        if(editTextEmail.getText().toString().isEmpty()){
            editTextEmail.setError("This Field Cannot be Empty!");
            editTextEmail.requestFocus();
            isValid = false;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(editTextEmail.getText().toString()).matches()){
            editTextEmail.setError("Please Enter Valid Email ID ");
            editTextEmail.requestFocus();
            isValid = false;
        }
        if(!Patterns.PHONE.matcher(editTextContact.getText().toString()).matches()){
            editTextContact.setError("Please Enter Valid Contact No ");
            editTextContact.requestFocus();
            isValid = false;
        }
        if(editTextPassword.getText().toString().length() < 6){
            editTextPassword.setError("Password length must be greater than 6");
            editTextPassword.requestFocus();
            isValid = false;
        }
        if(!editTextPassword.getText().toString().equals(editTextConfirmPass.getText().toString())){
            editTextConfirmPass.setError("Please Re Confirm Password ");
            editTextConfirmPass.requestFocus();
            isValid = false;
        }

        return true;
    }
}