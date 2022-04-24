package com.example.buddy4hostellers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class RegisterStudentCollegeActivity extends AppCompatActivity {

    EditText editTextCollegeName,editTextDescribeYourself;
    Spinner spinnerCourse,spinnerYearOfStudy;
    RadioButton radioButtonMale,radioButtonFemale;
    Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student_college);

        bindComponents();
        addListners();

    }

    public void bindComponents(){

        this.editTextCollegeName = findViewById(R.id.edit_text_clg_clg_name);
        this.editTextDescribeYourself = findViewById(R.id.edit_text_reg_clg_describe);
        this.spinnerCourse = findViewById(R.id.spinner_reg_course);
        this.spinnerYearOfStudy = findViewById(R.id.spinner_reg_clg_year_of_study);
        this.radioButtonFemale = findViewById(R.id.radioButton_reg_clg_female);
        this.radioButtonMale = findViewById(R.id.radioButton_reg_clg_male);

    }

    public void addListners(){

        this.editTextCollegeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        this.radioButtonFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        this.radioButtonMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        this.buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}