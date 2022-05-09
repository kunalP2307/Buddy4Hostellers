package com.example.buddy4hostellers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.buddy4hostellers.data.CollegeDetails;

public class AddNearClgForMessActivity extends AppCompatActivity {

    Spinner spinnerNearCollege;
    EditText editTextDistance;
    Button buttonContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_near_clg_for_mess);
        initComponents();
    }
    public void initComponents(){
        this.spinnerNearCollege = findViewById(R.id.spinner_near_clg_mess);

        ArrayAdapter arrayAdapterNearClg = new ArrayAdapter(this, android.R.layout.simple_spinner_item, CollegeDetails.colleges);
        spinnerNearCollege.setAdapter(arrayAdapterNearClg);

        this.editTextDistance = findViewById(R.id.edit_text_distance_mess);

        this.buttonContinue = findViewById(R.id.button_continue_mess_near_clg);

        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });
    }
}