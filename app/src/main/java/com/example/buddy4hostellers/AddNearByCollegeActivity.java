package com.example.buddy4hostellers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.buddy4hostellers.data.LivingPlace;
import com.example.buddy4hostellers.data.NearbyCollege;
import com.example.buddy4hostellers.data.ServiceProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;

public class AddNearByCollegeActivity extends AppCompatActivity {

    private static final String TAG = "AddNearByCollegeActivity";

    EditText editTextDistanceFromCollege;
    EditText textViewCollegeName;
    Button buttonFindDistance,buttonContinue;
    String key,userId;
    String ownerContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_near_by_college);

        bindComponents();
        getUserId();

        addListeners();
        setSelectedCollege();
        setActionBarText();


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        key = database.getReference("LivingPlaces").push().getKey();


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
                getOwnerContact();

                Intent intent = new Intent(AddNearByCollegeActivity.this,CollegeListActivity.class);
                intent.putExtra("EXTRA_TYPE","ADD_NEAR_CLG");
                startActivity(intent);
            }
        });

        this.buttonContinue.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View view) {


                LivingPlace livingPlace = new LivingPlace();
                livingPlace.setPlaceId(key);
                //Log.d(TAG, "onClick: L"+key);

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

    @SuppressLint("LongLogTag")
    public void getUserId(){

        userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Log.d(TAG, "getUserId: "+userId);
    }


    public void getOwnerContact(){

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("LivingPlaces");
        DatabaseReference child = databaseReference.child(userId);

        child.addValueEventListener(new ValueEventListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ServiceProvider serviceProvider = snapshot.getValue(ServiceProvider.class);
                Log.d(TAG, "onDataChange: "+serviceProvider.getContact());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}