package com.example.buddy4hostellers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.buddy4hostellers.data.Amenities;
import com.example.buddy4hostellers.data.LivingPlace;
import com.example.buddy4hostellers.data.Mess;
import com.example.buddy4hostellers.data.ServiceProvider;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";
    Intent intent;
    List<LivingPlace> livingPlaces;
    List<Mess> messList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(MainActivity.this,ShowAllMessActivity.class);

        Button button = findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });


        livingPlaces = new ArrayList<>();
        messList = new ArrayList<>();
        FirebaseDatabase.getInstance().getReference("LivingPlaces").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                livingPlaces.clear();

                for(DataSnapshot poDataSnapshot : snapshot.getChildren()){
                    LivingPlace livingPlace = poDataSnapshot.getValue(LivingPlace.class);
                    livingPlaces.add(livingPlace);
                    Log.d(TAG, "onDataChange: "+livingPlace.getPlaceId());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

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


        ServiceProvider serviceProvider = new ServiceProvider(1,"kunal","mail","123",null,null,null);

       /* FirebaseDatabase.getInstance().getReference("UserServiceProvider").child("gCrGe0kBLPae80z2tSO8zQH61cE3")
                .setValue(serviceProvider).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

            }
        });*/

        intent.putExtra("EXTRA_ALL_PLACES", (Serializable) livingPlaces);

        intent.putExtra("EXTRA_ALL_MESSES", (Serializable) messList);

    }

}