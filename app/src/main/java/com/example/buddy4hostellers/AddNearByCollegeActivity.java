package com.example.buddy4hostellers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.buddy4hostellers.data.LivingPlace;
import com.example.buddy4hostellers.data.NearbyCollege;

import java.io.Serializable;

public class AddNearByCollegeActivity extends AppCompatActivity {

    private static final String TAG = "AddNearByCollegeActivity";

    EditText editTextDistanceFromCollege;
    EditText textViewCollegeName;
    Button buttonFindDistance,buttonContinue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_near_by_college);

        bindComponents();
        addListeners();
        setSelectedCollege();
        setActionBarText();
    }

    public void setActionBarText(){
        getSupportActionBar().setTitle("1. College Details");
    }

    public void setSelectedCollege(){

        Intent intent = getIntent();

        if(intent != null){
            String collegeName = intent.getStringExtra("EXTRA_SELECTED_COLLEGE");
            if(collegeName != null && collegeName != "")
                textViewCollegeName.setText(collegeName);

        }

    }
    public void bindComponents(){

        this.editTextDistanceFromCollege = findViewById(R.id.editTextSelectNearClgDistance);
        this.textViewCollegeName = findViewById(R.id.textViewSelectNearClg);
        this.buttonContinue = findViewById(R.id.button_add_near_clg_continue);
        this.buttonFindDistance = findViewById(R.id.button_calc_distance);
    }

    public void addListeners(){

        this.textViewCollegeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AddNearByCollegeActivity.this,CollegeListActivity.class);
                intent.putExtra("EXTRA_TYPE","ADD_NEAR_CLG");
                startActivity(intent);
            }
        });

        this.buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LivingPlace livingPlace = new LivingPlace();
                livingPlace.setPlaceId("1");

                NearbyCollege nearbyCollege = new NearbyCollege(textViewCollegeName.getText().toString(),Double.parseDouble(editTextDistanceFromCollege.getText().toString()));
                livingPlace.setNearbyCollege(nearbyCollege);

                Intent intent = new Intent(AddNearByCollegeActivity.this,AddPlaceDetailsActivity.class);
                intent.putExtra("EXTRA_LIVING_PLACE", (Serializable) livingPlace);
                startActivity(intent);
            }
        });

        this.buttonFindDistance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}