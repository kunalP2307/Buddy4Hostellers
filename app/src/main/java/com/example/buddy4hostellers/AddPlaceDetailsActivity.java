package com.example.buddy4hostellers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.buddy4hostellers.data.LivingPlace;
import com.example.buddy4hostellers.data.PlaceDetails;

import java.io.Serializable;

public class AddPlaceDetailsActivity extends AppCompatActivity {

    Spinner spinnerRoomType,spinnerTenantType,spinnerMaxAllowed,spinnerApartmentType,spinnerBHKType;
    EditText editTextApartmentName,editTextFloor;
    Button buttonContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_place_details);

        bindComponents();
        setSpinners();
        setListerns();
    }

    public void setListerns(){
        this.buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String roomType = spinnerRoomType.getSelectedItem().toString();
                String maxAllowed = spinnerMaxAllowed.getSelectedItem().toString();
                String tenantType = spinnerTenantType.getSelectedItem().toString();
                String apartmentType = spinnerApartmentType.getSelectedItem().toString();
                String apartmentName = editTextApartmentName.getText().toString();
                String bhkType = spinnerBHKType.getSelectedItem().toString();
                int floor = Integer.parseInt(editTextFloor.getText().toString());

                boolean tenant = false;
                if(tenantType.equals("Male"))
                    tenant = true;

                PlaceDetails placeDetails = new PlaceDetails(roomType,maxAllowed,tenant,apartmentType,apartmentName,bhkType,floor);

                Intent intent = new Intent(AddPlaceDetailsActivity.this, AddLocalityDetailsActivity.class);

                Intent recievedIntent = getIntent();

                LivingPlace livingPlace = (LivingPlace) recievedIntent.getSerializableExtra("EXTRA_LIVING_PLACE");
                livingPlace.setPlaceDetails(placeDetails);

                intent.putExtra("EXTRA_LIVING_PLACE", (Serializable) livingPlace);
                startActivity(intent);

            }
        });
    }

    public void setSpinners(){

        String roomTypes[] = {"Select Room Type","Single","Shared"};
        ArrayAdapter arrayAdapterRoomType = new ArrayAdapter(this, android.R.layout.simple_spinner_item,roomTypes);
        arrayAdapterRoomType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRoomType.setAdapter(arrayAdapterRoomType);

        String tenants[] = {"Select Tenant Type","Male","Female"};
        ArrayAdapter arrayAdapterTenants = new ArrayAdapter(this, android.R.layout.simple_spinner_item,tenants);
        arrayAdapterTenants.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTenantType.setAdapter(arrayAdapterTenants);

        String maxAllowed[] = {"Select Max Allowed","1","2","3","4","5","6"};
        ArrayAdapter arrayAdapterMaxAllowed = new ArrayAdapter(this, android.R.layout.simple_spinner_item,maxAllowed);
        spinnerMaxAllowed.setAdapter(arrayAdapterMaxAllowed);

        String apartmentType[] = {"Select Apartment","PG","Independent House","Society"};
        ArrayAdapter arrayAdapterApartmentType = new ArrayAdapter(this, android.R.layout.simple_spinner_item,apartmentType);
        spinnerApartmentType.setAdapter(arrayAdapterApartmentType);

        String bhkType[] = {"Select BHK ","1RK","1BHK","2BHK","Shared PG"};
        ArrayAdapter arrayAdapterBHKType = new ArrayAdapter(this, android.R.layout.simple_spinner_item,bhkType);
        spinnerBHKType.setAdapter(arrayAdapterBHKType);

    }

    public void bindComponents(){

        this.spinnerRoomType = findViewById(R.id.spinner_room_type);
        this.spinnerApartmentType = findViewById(R.id.spinner_aprtment_type);
        this.spinnerBHKType = findViewById(R.id.spinner_bhk_type);
        this.spinnerMaxAllowed = findViewById(R.id.spinner_max_allowed);
        this.spinnerTenantType = findViewById(R.id.spinner_tenant_type);
        this.editTextApartmentName = findViewById(R.id.edit_text_apartment_name);
        this.editTextFloor = findViewById(R.id.edit_text_floor);
        this.buttonContinue = findViewById(R.id.button_place_details_continue);


    }
}