package com.example.buddy4hostellers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        Log.d(TAG, "onCreate: ");
        startActivity(intent);
    }
    public void initComponents(){
        this.intent = new Intent(MainActivity.this, RegisterStudentPersonalActivity.class);

    }
}