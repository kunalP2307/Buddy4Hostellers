package com.example.buddy4hostellers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.buddy4hostellers.data.InterestedStudents;
import com.example.buddy4hostellers.data.LivingPlace;
import com.example.buddy4hostellers.data.Student;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class AddInterestedStudentActivity extends AppCompatActivity {

    private static final String TAG = "AddInterestedStudentAct";
    Button buttonOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_interested_student);

        initComponents();

        Intent recievedIntent = getIntent();

        Student interestedStudent = (Student) recievedIntent.getSerializableExtra("ADD_STUDENT");
        LivingPlace livingPlace = (LivingPlace) recievedIntent.getSerializableExtra("EXTRA_LIVING_PLACE");

        Log.d(TAG, "onCreate: temp"+interestedStudent.getName());

        String placeId = livingPlace.getPlaceId();

        InterestedStudents interestedStudents = livingPlace.getInterestedStudents();

        if (interestedStudents != null) {

            List<Student> list = interestedStudents.getStudents();
            list.add(interestedStudent);
            interestedStudents.setStudents(list);
            livingPlace.setInterestedStudents(interestedStudents);
        }
        else{
            List<Student> studentList = new ArrayList<>();
            studentList.add(interestedStudent);
            InterestedStudents interestedStudents1 = new InterestedStudents(studentList);
            livingPlace.setInterestedStudents(interestedStudents1);
        }

        FirebaseDatabase.getInstance().getReference("LivingPlaces").child(placeId)
                .setValue(livingPlace).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){

                }
            }
        });

    }

    public void initComponents(){

        this.buttonOk = findViewById(R.id.button_ok_in_std_added);

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),StudentHomeActivity.class));
            }
        });
    }
}