package com.example.buddy4hostellers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.buddy4hostellers.data.LivingPlace;
import com.example.buddy4hostellers.data.Mess;

import java.util.List;

public class ShowAllMessActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String TAG = "ShowAllMessActivity";
    List<Mess> messList;
    MessAdapter messAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_mess);

        initListView();

    }

    public void initListView(){

            ListView listView = findViewById(R.id.list_view_mess);

            Intent intent = getIntent();

            messList = (List<Mess>) intent.getSerializableExtra("EXTRA_ALL_MESSES");
            Log.d(TAG, "onCreate: "+messList.get(0).getMessId());

            messAdapter = new MessAdapter(getApplicationContext(),messList);
            listView.setAdapter(messAdapter);
            listView.setOnItemClickListener(this);

        }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
