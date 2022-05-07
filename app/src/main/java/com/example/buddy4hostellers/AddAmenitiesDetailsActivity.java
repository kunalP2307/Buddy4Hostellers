package com.example.buddy4hostellers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.buddy4hostellers.data.Amenities;
import com.example.buddy4hostellers.data.LivingPlace;

import java.util.ArrayList;

public class AddAmenitiesDetailsActivity extends AppCompatActivity {

    Spinner spinnerNoOfBeds,spinnerNoOfBathrooms,spinnerNoOfBalconies;
    CheckBox checkBoxFriendsAllowed;
    EditText editTextDescription,editTextOtherAmenities;
    Button buttonContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_amenities_details);

        bindComponents();
        addListeners();

    }
    public void bindComponents(){

        this.spinnerNoOfBeds = findViewById(R.id.spinner_amenities_no_of_beds);
        this.spinnerNoOfBathrooms = findViewById(R.id.spinner_amenities_no_of_bathrooms);
        this.spinnerNoOfBalconies = findViewById(R.id.spinner_amenities_no_of_balconies);
        this.editTextDescription = findViewById(R.id.edit_text_amenities_description);
        this.checkBoxFriendsAllowed = findViewById(R.id.checkBox_freinds_allowed);
        this.buttonContinue = findViewById(R.id.button_add_amenities_continue);
        this.editTextOtherAmenities = findViewById(R.id.edit_text_other_amenities);
    }

    public void addListeners(){

        String beds [] = {"Select Bed Count","1","2","3","4"};
        ArrayAdapter arrayAdapterBeds = new ArrayAdapter(this, android.R.layout.simple_spinner_item,beds);
        arrayAdapterBeds.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNoOfBeds.setAdapter(arrayAdapterBeds);

        String balconies [] = {"Select Balcony Count","1","2"};
        ArrayAdapter arrayAdapterBalconies = new ArrayAdapter(this, android.R.layout.simple_spinner_item,balconies);
        arrayAdapterBeds.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNoOfBalconies.setAdapter(arrayAdapterBalconies);

        String bathroom [] = {"Select Bathroom Count","1","2"};
        ArrayAdapter arrayAdapterBathrooms = new ArrayAdapter(this, android.R.layout.simple_spinner_item,bathroom);
        arrayAdapterBeds.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNoOfBathrooms.setAdapter(arrayAdapterBathrooms);


        this.buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int noOfBeds = Integer.parseInt(spinnerNoOfBeds.getSelectedItem().toString());
                int noOfBathrooms = Integer.parseInt(spinnerNoOfBathrooms.getSelectedItem().toString());
                int noOfBalconies = Integer.parseInt(spinnerNoOfBalconies.getSelectedItem().toString());
                ArrayList<Boolean> otherAmenities = new ArrayList<>();
                otherAmenities.add(true);

                boolean friendsAllowed = false;

                if(checkBoxFriendsAllowed.isSelected())
                    friendsAllowed = true;

                String otherAmenitiesString = editTextOtherAmenities.getText().toString();
                String description = editTextDescription.getText().toString();

                Amenities amenities = new Amenities(noOfBathrooms,noOfBalconies,noOfBeds,otherAmenities,friendsAllowed,otherAmenitiesString,description);

                Intent recievedIntent = getIntent();

                LivingPlace livingPlace = (LivingPlace) recievedIntent.getSerializableExtra("EXTRA_LIVING_PLACE");
                livingPlace.setAmenities(amenities);

                Intent intent = new Intent(AddAmenitiesDetailsActivity.this, AddPlaceImagesActivity.class);
                intent.putExtra("EXTRA_LIVING_PLACE",livingPlace);
                startActivity(intent);
            }
        });

    }
}