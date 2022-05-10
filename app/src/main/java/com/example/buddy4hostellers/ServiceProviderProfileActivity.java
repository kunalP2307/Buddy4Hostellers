package com.example.buddy4hostellers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

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

        TextView textViewLogout = findViewById(R.id.text_view_log_out_ser_prov);
        textViewLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),SelectUserActivity.class));
            }
        });

    }
}