package com.example.buddy4hostellers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlaceAddedActivity extends AppCompatActivity {

    Button buttonOk;
    TextView textViewPlaceAdded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_added);

        bindComponents();

        String type = getIntent().getStringExtra("ADD_TYPE");
        if(type != null) {
            if (type.equals("MESS")) {
                textViewPlaceAdded.setText("Your Mess Has Been Added to Our Portal Sucsessfully!");
            }
        }

    }

    public void bindComponents() {
        this.textViewPlaceAdded = findViewById(R.id.textView_place_added);

        this.buttonOk = findViewById(R.id.button_ok_place_added);

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ServiceProvHomeActivity.class));
            }
        });
    }
}