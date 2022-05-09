package com.example.buddy4hostellers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buddy4hostellers.data.CollegeDetails;
import com.example.buddy4hostellers.data.Student;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterStudentCollegeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String TAG = "RegisterStudentCollegeActivity";
    EditText editTextCollegeName,editTextDescribeYourself;
    Spinner spinnerCourse,spinnerYearOfStudy,spinnerCollege;
    RadioButton radioButtonMale,radioButtonFemale;
    Button buttonSignUp;
    FirebaseAuth firebaseAuth;
    static String name,email,contact,password,college,yearOfStudy,course,description;
    boolean gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student_college);

        bindComponents();
        addListners();
        initSpinners();
        setCollegeName();

    }

    @Override
    protected void onResume() {
        super.onResume();
        /*Log.d(TAG, "onResume: called");
        String temp = getIntent().getStringExtra("EXTRA_TEMP");
        Log.d(TAG, "onCreate: temp Pass" + temp);


        this.name = getIntent().getStringExtra("EXTRA_NAME");
        this.email = getIntent().getStringExtra("EXTRA_EMAIL");
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewEmail.setText(email);
        Log.d(TAG, "onCreate:getText " + textViewEmail.getText());
        this.contact = getIntent().getStringExtra("EXTRA_CONTACT");
        this.password = getIntent().getStringExtra("EXTRA_PASSWORD");

        Log.d(TAG, "onCreate: name email" + name + email + contact + password);
        */
        name = getIntent().getStringExtra("EXTRA_NAME");
        email = getIntent().getStringExtra("EXTRA_EMAIL");
        contact = getIntent().getStringExtra("EXTRA_CONTACT");
        password = getIntent().getStringExtra("EXTRA_PASSWORD");
        Log.d(TAG, "onCreate: name email" + name + email + contact + password);

    }


    public void bindComponents(){

        this.spinnerCollege = findViewById(R.id.spinner_college_name_register_std);

        ArrayAdapter arrayAdapterCollege = new ArrayAdapter(this, android.R.layout.simple_spinner_item,CollegeDetails.colleges);
        arrayAdapterCollege.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCollege.setAdapter(arrayAdapterCollege);


        this.editTextCollegeName = findViewById(R.id.edit_text_reg_service_pro_name);
        this.editTextDescribeYourself = findViewById(R.id.edit_text_reg_clg_describe);
        this.spinnerCourse = findViewById(R.id.spinner_reg_course);
        this.spinnerYearOfStudy = findViewById(R.id.spinner_reg_clg_year_of_study);
        this.radioButtonFemale = findViewById(R.id.radioButton_reg_clg_female);
        this.radioButtonMale = findViewById(R.id.radioButton_reg_clg_male);
        this.buttonSignUp = findViewById(R.id.btn_reg_clg_reg_service_pro_sign_up);
        Log.d(TAG, "bindComponents: "+email);
    }

    public void addListners(){


        this.radioButtonFemale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(radioButtonMale.isChecked())
                    radioButtonMale.setChecked(false);

                //radioButtonFemale.setChecked(true);
                radioButtonFemale.setSelected(true);
            }
        });

        this.radioButtonMale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(radioButtonFemale.isChecked())
                    radioButtonFemale.setChecked(false);

                //radioButtonMale.setChecked(true);
                radioButtonMale.setSelected(true);
            }
        });

        this.buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }

    public void registerUser(){

        Log.d(TAG, "onClick: temp");
        System.out.println("temp");
        if(validInput()){

            college = spinnerCollege.getSelectedItem().toString();
            yearOfStudy = spinnerYearOfStudy.getSelectedItem().toString();
            course = spinnerCourse.getSelectedItem().toString();
            gender = true;
            description = editTextDescribeYourself.getText().toString();

            if(radioButtonFemale.isChecked())
                gender = false;

            Log.d(TAG, "onClick: email"+email);

            Log.d(TAG, "onClick:before registerUser "+email);

        }
        Student student1 = new Student(1,name,email,contact,college,yearOfStudy,course,gender,description);

        Log.d(TAG, "registerUser: "+email+password);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){

                            FirebaseDatabase.getInstance().getReference("UserStudent")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(student1).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if(task.isSuccessful()){
                                        Toast.makeText(RegisterStudentCollegeActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(),LoginRegisterActivity.class);
                                        intent.putExtra("USER_TYPE","STUDENT");
                                        startActivity(intent);
                                    }

                                    else{
                                        Toast.makeText(RegisterStudentCollegeActivity.this, "Something Went Wrong! ", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                        else{
                            Toast.makeText(RegisterStudentCollegeActivity.this, "Something Went Wrong!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public boolean validInput(){

        boolean validInput = true;

        if(spinnerCourse.getSelectedItem().toString().equals(CollegeDetails.courses[0])){
            TextView errorTextView = (TextView) spinnerCourse.getSelectedView();
            errorTextView.setError("Please Select Course");
            errorTextView.requestFocus();
            validInput = false;
        }
        if(spinnerYearOfStudy.getSelectedItem().toString().equals(CollegeDetails.yearOfStudy[0])){
            TextView errorTextView = (TextView) spinnerYearOfStudy.getSelectedView();
            errorTextView.setError("Please Select Year of Study");
            errorTextView.requestFocus();
            validInput = false;
        }
        if(!radioButtonMale.isChecked() && !radioButtonFemale.isChecked()){
            Toast.makeText(this, "Select Gender", Toast.LENGTH_SHORT).show();
            validInput = false;
        }
        if(editTextDescribeYourself.getText().toString().isEmpty()){
            editTextDescribeYourself.setError("This Field Cannot be Empty");
            editTextDescribeYourself.requestFocus();
            validInput = false;
        }
        return validInput;

    }

    public void setCollegeName(){

        Intent intent = getIntent();
        Bundle bundle  = intent.getExtras();

        if(bundle != null){
            String collegeName = bundle.getString("EXTRA_SELECTED_COLLEGE");
            //editTextCollegeName.setText(collegeName);
        }
    }
    public void initSpinners(){

        // courses Spinner
        spinnerCourse.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdapterCourse = new ArrayAdapter(this, android.R.layout.simple_spinner_item, CollegeDetails.courses);
        arrayAdapterCourse.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCourse.setAdapter(arrayAdapterCourse);


        ArrayAdapter arrayAdapterYearOfStudy = new ArrayAdapter(this, android.R.layout.simple_spinner_item, CollegeDetails.yearOfStudy);

        spinnerYearOfStudy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerYearOfStudy.setAdapter(arrayAdapterYearOfStudy);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}