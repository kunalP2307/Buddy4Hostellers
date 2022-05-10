package com.example.buddy4hostellers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.buddy4hostellers.data.LivingPlace;
import com.example.buddy4hostellers.data.Mess;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentHomeActivity extends AppCompatActivity {

    String TAG = "StudentHomeActivity";
    List<Mess> messList;
    List<LivingPlace> livingPlaceList;
    Button buttonFindPlace,buttonFindMess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);

        initComponents();
        initPlaces();
        initMesses();

        Log.d(TAG, "onCreate: ");
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        return true;
                    case R.id.saved:
                        startActivity(new Intent(getApplicationContext(),StudentServicesActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),StudentProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    public void initMesses(){

        messList = new ArrayList<>();

        FirebaseDatabase.getInstance().getReference("Messes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                messList.clear();

                for(DataSnapshot poDataSnapshot : snapshot.getChildren()){
                    Mess mess = poDataSnapshot.getValue(Mess.class);
                    messList.add(mess);
                    Log.d(TAG, "onDataChange: "+mess.getMessId());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void initPlaces(){
        livingPlaceList = new ArrayList<>();

        FirebaseDatabase.getInstance().getReference("LivingPlaces").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                livingPlaceList.clear();

                for(DataSnapshot poDataSnapshot : snapshot.getChildren()){
                    LivingPlace livingPlace = poDataSnapshot.getValue(LivingPlace.class);
                    livingPlaceList.add(livingPlace);
                    Log.d(TAG, "onDataChange: "+livingPlace.getPlaceId());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }

    public void initComponents(){
        this.buttonFindMess = findViewById(R.id.button_find_mess_std_home);
        this.buttonFindPlace = findViewById(R.id.button_find_place_std_home);

        buttonFindPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ShowAllLivingPlaces.class);
                intent.putExtra("EXTRA_ALL_PLACES", (Serializable) livingPlaceList);
                startActivity(intent);
            }
        });

        buttonFindMess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ShowAllMessActivity.class);
                intent.putExtra("EXTRA_ALL_MESSES", (Serializable) messList);
                startActivity(intent);
            }
        });

    }
}