package com.example.buddy4hostellers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ServiceProviderProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_profile);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation_service_provider);

        bottomNavigationView.setSelectedItemId(R.id.profile);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),ServiceProvHomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ads:
                        startActivity(new Intent(getApplicationContext(),ServiceProviderMyPlacesActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile:
                         return true;
                }
                return false;
            }
        });

    }
}