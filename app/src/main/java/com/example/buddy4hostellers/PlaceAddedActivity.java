package com.example.buddy4hostellers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlaceAddedActivity extends AppCompatActivity {

    Button buttonOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_added);

        bindComponents();

    }

    public void bindComponents() {
        this.buttonOk = findViewById(R.id.button_ok_place_added);

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ServiceProvHomeActivity.class));
            }
        });
    }
}