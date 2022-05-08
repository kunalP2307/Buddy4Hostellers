package com.example.buddy4hostellers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.buddy4hostellers.data.CollegeDetails;

public class CollegeListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView collegeListView;
    ImageView imageViewSearch;
    EditText editTextSearchCollege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_list);

        initComponents();

        CollegeListAdapter collegeListAdapter = new CollegeListAdapter(getApplicationContext());
        collegeListView.setAdapter(collegeListAdapter);
        collegeListView.setOnItemClickListener(this);

    }

    public void initComponents(){
        this.collegeListView = findViewById(R.id.list_view_living_place);
        this.imageViewSearch = findViewById(R.id.imageSearch);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Intent recievedIntent = getIntent();
        String reqType = recievedIntent.getStringExtra("EXTRA_TYPE");

        String selectedCollege = CollegeDetails.colleges[i];

        if(reqType.equals("ADD_NEAR_CLG")){
            Intent intent = new Intent(CollegeListActivity.this,AddNearByCollegeActivity.class);
            intent.putExtra("EXTRA_SELECTED_COLLEGE",selectedCollege);
            startActivity(intent);
        }

        else {
            Intent intent = new Intent(CollegeListActivity.this, RegisterStudentCollegeActivity.class);
            intent.putExtra("EXTRA_SELECTED_COLLEGE", selectedCollege);
            startActivity(intent);
        }

    }
}