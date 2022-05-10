package com.example.buddy4hostellers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ServiceProvHomeActivity extends AppCompatActivity {

    Button buttonAddPlaceAd,buttonAddMessAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_service_prov_home);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation_service_provider);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        return true;
                    case R.id.ads:
                        startActivity(new Intent(getApplicationContext(),ServiceProviderMyPlacesActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),ServiceProviderProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        bindComponents();
        addListeners();
        

    }

    public void bindComponents(){
        this.buttonAddMessAd = findViewById(R.id.button_add_mess_ad);
        this.buttonAddPlaceAd = findViewById(R.id.button_add_place_ad);
    }

    public void addListeners(){

        this.buttonAddPlaceAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ServiceProvHomeActivity.this,AddServiceProviderContactDetailsActivity.class);
                startActivity(intent);
            }
        });

        this.buttonAddMessAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ServiceProvHomeActivity.this,AddServiceProContactMessActivity.class);
                startActivity(intent);
            }
        });
    }

}