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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;


public class LoginRegisterActivity extends AppCompatActivity {

    String TAG = "LoginRegisterActivity";
    EditText editTextEmail,editTextPassword;
    Button buttonLogin;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        initComponents();
        addListners();
    }

    public void addListners(){
        this.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validInput())
                    loginUser();
            }
        });
    }

    public boolean validInput(){

        String email = editTextEmail.getText().toString();
        String passWord = editTextPassword.getText().toString();

        if(email.isEmpty()){
            editTextEmail.setError("This Field Cannot be empty");
            editTextEmail.requestFocus();
            return false;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please Enter Valid Email Address");
            editTextEmail.requestFocus();
            return false;
        }
        if(passWord.isEmpty()){
            editTextPassword.setError("This Field Cannot be Empty");
            editTextPassword.requestFocus();
            return false;
        }

        return true;
    }

    public void initComponents(){

        editTextEmail = findViewById(R.id.edit_text_login_email);
        editTextPassword = findViewById(R.id.edit_text_login_pass);
        buttonLogin = findViewById(R.id.btn_login_login);
    }

    public void loginUser(){

        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    Intent intent = getIntent();

                    String userType = intent.getStringExtra("USER_TYPE");
                    if(userType.equals("STUDENT"))
                        startActivity(new Intent(LoginRegisterActivity.this,RegisterStudentPersonalActivity.class));
                    else
                        startActivity(new Intent(LoginRegisterActivity.this,RegisterServiceProviderActivity.class));

                }
                else{
                    Toast.makeText(LoginRegisterActivity.this, "Invalid Credentials! Please Try Again!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}