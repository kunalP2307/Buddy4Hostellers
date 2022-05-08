package com.example.buddy4hostellers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.buddy4hostellers.data.LivingPlace;

import java.util.ArrayList;
import java.util.List;

public class ShowAllLivingPlaces extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String TAG = "ShowAllLivingPlaces";
    List<LivingPlace> livingPlacesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_living_places);

        initListView();



    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



    }


    public void initListView(){
        ListView listView = findViewById(R.id.list_view_living_place);

        Intent intent = getIntent();

        List<LivingPlace> livingPlaces = (List<LivingPlace>) intent.getSerializableExtra("EXTRA_ALL_PLACES");
        Log.d(TAG, "onCreate: "+livingPlaces.get(0).getPlaceId());

        PlaceListAdapter placeListAdapter = new PlaceListAdapter(getApplicationContext(),livingPlaces);
        listView.setAdapter(placeListAdapter);
        listView.setOnItemClickListener(this);

    }
}