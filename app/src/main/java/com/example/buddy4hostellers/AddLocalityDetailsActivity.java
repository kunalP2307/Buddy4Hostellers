package com.example.buddy4hostellers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.buddy4hostellers.data.LivingPlace;
import com.example.buddy4hostellers.data.LocalityDetails;
import com.example.buddy4hostellers.data.Mess;
import com.example.buddy4hostellers.data.RentDetails;

public class AddLocalityDetailsActivity extends AppCompatActivity {

    EditText editTextArea,editTextStreet,editTextLandmark;
    Button buttonSetLocationOnMap,buttonContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_locality_details);

        bindComponents();
        addListners();

    }
    public void bindComponents(){

        this.editTextArea = findViewById(R.id.edit_text_area);
        this.editTextLandmark = findViewById(R.id.edit_text_landmark);
        this.editTextStreet = findViewById(R.id.edit_text_street);
        this.buttonContinue = findViewById(R.id.button_locality_continue);
        this.buttonSetLocationOnMap = findViewById(R.id.button_set_location_on_map);

    }

    public void addListners(){
        buttonSetLocationOnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent recievedIntent = getIntent();

                LivingPlace livingPlace = (LivingPlace) recievedIntent.getSerializableExtra("EXTRA_LIVING_PLACE");

                String area = editTextArea.getText().toString();
                String street = editTextStreet.getText().toString();
                String landMark = editTextLandmark.getText().toString();

                LocalityDetails liLocalityDetails = new LocalityDetails(area,street,landMark,0,0);


                livingPlace.setLocalityDetails(liLocalityDetails);

                Intent intent = new Intent(AddLocalityDetailsActivity.this, AddRentDetailsActivity.class);

                intent.putExtra("EXTRA_LIVING_PLACE",livingPlace);
                startActivity(intent);
            }
        });

    }
}