package com.example.buddy4hostellers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectUserActivity extends AppCompatActivity {

    Button buttonStudent;
    Button buttonServiceProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user);

        initComponents();
        addListners();
    }
    public void initComponents(){

        this.buttonStudent = findViewById(R.id.button_continue_as_student);
        this.buttonServiceProvider = findViewById(R.id.button_continue_as_service_provider);

    }

    public void addListners(){

        this.buttonStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectUserActivity.this,LoginRegisterActivity.class);
                intent.putExtra("USER_TYPE","STUDENT");
                startActivity(intent);
            }
        });

        this.buttonServiceProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectUserActivity.this,LoginRegisterActivity.class);
                intent.putExtra("USER_TYPE","SERVICE_PROVIDER");
                startActivity(intent);
            }
        });

    }
}