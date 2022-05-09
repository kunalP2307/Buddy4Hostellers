package com.example.buddy4hostellers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.buddy4hostellers.data.ServiceProvider;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class RegisterServiceProviderActivity extends AppCompatActivity {

    EditText editTextName,editTextContact,editTextEmail,editTextPassword,editTextConfirmPass;
    Button buttonContinue;
    FirebaseAuth firebaseAuth;
    String TAG = "RegisterServiceProviderActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_service_provider);
        initComponents();
        addListneres();

    }

    public void addListneres(){

        this.buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(validInput()){

                    String name = editTextName.getText().toString();
                    String contact = editTextContact.getText().toString();
                    String email = editTextEmail.getText().toString();
                    String password = editTextPassword.getText().toString();

                    registerServiceProvider(name,contact,email,password);
                }
            }
        });

    }

    public void initComponents(){

        this.editTextName = findViewById(R.id.edit_text_reg_service_pro_name);
        this.editTextEmail = findViewById(R.id.edit_text_reg_service_pro_email);
        this.editTextContact = findViewById(R.id.edit_text_reg_servie_pro_mobile);
        this.editTextPassword = findViewById(R.id.edit_text_reg_service_pro_pass);
        this.editTextConfirmPass = findViewById(R.id.edit_text_reg_reg_service_pro_cong_pass);
        this.buttonContinue = findViewById(R.id.btn_reg_clg_reg_service_pro_sign_up);

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

        return isValid;
    }

    public void registerServiceProvider(String name,String contact,String email,String password){

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            ArrayList<String> temp = new ArrayList<>();
                            temp.add("nothing");
                            
                            ServiceProvider serviceProvider = new ServiceProvider(1,name,email,contact,null,null,temp);
                            FirebaseDatabase.getInstance().getReference("UserServiceProvider")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(serviceProvider).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()) {
                                        Toast.makeText(RegisterServiceProviderActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(RegisterServiceProviderActivity.this,ServiceProvHomeActivity.class));
                                    }
                                    else
                                        Toast.makeText(RegisterServiceProviderActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                                }

                            });
                            Toast.makeText(RegisterServiceProviderActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}