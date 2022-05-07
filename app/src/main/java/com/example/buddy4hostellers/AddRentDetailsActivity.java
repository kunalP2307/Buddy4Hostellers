package com.example.buddy4hostellers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.buddy4hostellers.data.LivingPlace;
import com.example.buddy4hostellers.data.RentDetails;

public class AddRentDetailsActivity extends AppCompatActivity {

    private static final String TAG = "RentDetailsActivity";
    EditText editTextRent,editTextDeposit,editTextMaintenance;
    Spinner spinnerFurnishing;
    CheckBox checkBoxNegotiable;
    Button buttonContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_details);

        initComponents();
        addListeners();

    }

    public void addListeners(){

        String furnishing[] = {"Select Furnishing Type","Fully","Semi","Unfurnished"};


        ArrayAdapter arrayAdapterRoomType = new ArrayAdapter(this, android.R.layout.simple_spinner_item,furnishing);
        arrayAdapterRoomType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFurnishing.setAdapter(arrayAdapterRoomType);


        this.buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double rent = Double.parseDouble(editTextRent.getText().toString());
                double deposit = Double.parseDouble(editTextDeposit.getText().toString());
                double maintenance = Double.parseDouble(editTextMaintenance.getText().toString());
                String furnishing = spinnerFurnishing.getSelectedItem().toString();

                boolean negotiable = false;
                if(checkBoxNegotiable.isSelected())
                    negotiable = true;

                Intent intent = new Intent(AddRentDetailsActivity.this,AddAmenitiesDetailsActivity.class);

                Intent recievedIntent = getIntent();

                LivingPlace livingPlace = (LivingPlace) recievedIntent.getSerializableExtra("EXTRA_LIVING_PLACE");

                RentDetails rentDetails = new RentDetails(rent,negotiable,deposit,maintenance,furnishing);

                livingPlace.setRentDetails(rentDetails);

                intent.putExtra("EXTRA_LIVING_PLACE",livingPlace);
                startActivity(intent);
            }
        });
    }

    public void initComponents(){

        this.editTextDeposit = findViewById(R.id.edit_text_deposit);
        this.editTextRent = findViewById(R.id.edit_text_rent);
        this.editTextMaintenance = findViewById(R.id.edit_text_maintenance);
        this.spinnerFurnishing = findViewById(R.id.spinner_furnishing);
        this.checkBoxNegotiable = findViewById(R.id.checkBox_negotioable);
        this.buttonContinue = findViewById(R.id.button_rent_details_continue);

    }
}