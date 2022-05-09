package com.example.buddy4hostellers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.buddy4hostellers.data.CollegeDetails;
import com.example.buddy4hostellers.data.Mess;
import com.example.buddy4hostellers.data.NearbyCollege;
import com.google.firebase.database.FirebaseDatabase;

public class AddNearClgForMessActivity extends AppCompatActivity {

    Spinner spinnerNearCollege;
    EditText editTextDistance;
    Button buttonContinue;
    String messId;
    private static final String TAG = "AddNearClgForMessActivi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_near_clg_for_mess);

        getMessId();
        initComponents();

    }

    public void getMessId(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        messId = database.getReference("Messes").push().getKey();

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

                Mess mess = (Mess) getIntent().getSerializableExtra("EXTRA_MESS");
                Log.d(TAG, "onClick: messId"+messId);
                mess.setMessId(messId);
                Double distance = Double.parseDouble(editTextDistance.getText().toString());
                NearbyCollege nearbyCollege = new NearbyCollege(spinnerNearCollege.getSelectedItem().toString(),distance);
                mess.setNearbyCollege(nearbyCollege);

                Intent intent = new Intent(AddNearClgForMessActivity.this,AddMessDetailsActivity.class);
                intent.putExtra("EXTRA_MESS",mess);
                startActivity(intent);
            }
        });
    }
}