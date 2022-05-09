package com.example.buddy4hostellers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.buddy4hostellers.data.InterestedStudents;
import com.example.buddy4hostellers.data.LivingPlace;
import com.example.buddy4hostellers.data.Student;

import java.util.ArrayList;
import java.util.List;

public class IntrestedStudentsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listViewInterestedStudents;
    IntrestedStudentsAdapter intrestedStudentsAdapter;
    LivingPlace livingPlace;
    Student interestedStud;
    List<Student> studentList;
    Button buttonAddMe;
    private static final String TAG = "IntrestedStudentsActivi";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intrested_students);

        Intent reciedIntent = getIntent();

        livingPlace = (LivingPlace) reciedIntent.getSerializableExtra("EXTRA_LIVING_PLACE");
        Log.d(TAG, "onCreate:abc "+livingPlace.getPlaceId());
        interestedStud = (Student) reciedIntent.getSerializableExtra("EXTRA_INTERESTED_STUD");

        initListView();

        initComponents();
    }

    public void initComponents(){
        this.buttonAddMe = findViewById(R.id.button_mark_as_interested);

        buttonAddMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d(TAG, "onClick: ");
                Intent intent = new Intent(IntrestedStudentsActivity.this,AddInterestedStudentActivity.class);
                intent.putExtra("ADD_STUDENT",interestedStud);
                intent.putExtra("EXTRA_LIVING_PLACE",livingPlace);
                startActivity(intent);

            }
        });


    }

    public void initListView(){

        /*Student student = new Student();
        student.setName("Kunal Patil");
        student.setCollegeName("DY PATIL INSTITUTE OF TECHNOLOGY");
        student.setDescription("AACB");
        student.setYearOfStudy("234");
        student.setBranchOfStudy("dfddf");

        List<Student>  studentList= new ArrayList<>();
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);studentList.add(student);
        studentList.add(student);
        studentList.add(student);studentList.add(student);
        studentList.add(student);
        studentList.add(student);*/


        InterestedStudents interestedStudents = livingPlace.getInterestedStudents();

        if(interestedStudents != null)
            studentList = interestedStudents.getStudents();

        if(studentList == null){
            TextView textView = findViewById(R.id.text_view_no_one_here);
            textView.setVisibility(View.VISIBLE);
        }

        else {
            listViewInterestedStudents = findViewById(R.id.list_view_interested_students);
            intrestedStudentsAdapter = new IntrestedStudentsAdapter(getApplicationContext(), studentList);
            listViewInterestedStudents.setAdapter(intrestedStudentsAdapter);
            listViewInterestedStudents.setOnItemClickListener(this);
        }

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}