package com.example.buddy4hostellers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.buddy4hostellers.data.CollegeDetails;
import com.example.buddy4hostellers.data.Mess;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;
public class AddMessDetailsActivity extends AppCompatActivity {

    private Button buttonSelectImage, buttonAdd;

    private ImageView imageView;

    private Uri filePath;
    Mess mess;
    String messId;
    private final int PICK_IMAGE_REQUEST = 22;
    Spinner spinnerFoodType;
    EditText editTextMessName;
    FirebaseStorage storage;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mess_details);

        bindComponents();
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        Intent intent = getIntent();
        mess = (Mess) intent.getSerializableExtra("EXTRA_MESS");
        messId = mess.getMessId();


    }

    public void bindComponents(){

        buttonSelectImage = findViewById(R.id.button_select_mess_menu_image);
        buttonAdd = findViewById(R.id.button_add_mess);
        imageView = findViewById(R.id.imgeg_view_mess_menu);
        editTextMessName = findViewById(R.id.edit_text_mess_name);
        spinnerFoodType = findViewById(R.id.spinner_food_type);

        String foodTypes[] = {"Select Food Type","VEG","NON_VEG","BOTH"};

        ArrayAdapter arrayAdapterFoodType = new ArrayAdapter(this, android.R.layout.simple_spinner_item, foodTypes);
        spinnerFoodType.setAdapter(arrayAdapterFoodType);

        buttonSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                SelectImage();
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                uploadImage();
            }
        });


    }

    private void SelectImage()
    {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(
                Intent.createChooser(
                        intent,
                        "Select Image from here..."),
                PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data)
    {

        super.onActivityResult(requestCode,
                resultCode,
                data);

        if (requestCode == PICK_IMAGE_REQUEST
                && resultCode == RESULT_OK
                && data != null
                && data.getData() != null) {

            filePath = data.getData();
            try {

                Bitmap bitmap = MediaStore
                        .Images
                        .Media
                        .getBitmap(
                                getContentResolver(),
                                filePath);
                imageView.setImageBitmap(bitmap);
            }

            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void uploadImage()
    {
        if (filePath != null) {

            ProgressDialog progressDialog
                    = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();



            StorageReference ref
                    = storageReference
                    .child(
                            "messMenu/"
                                    + messId);

            ref.putFile(filePath)
                    .addOnSuccessListener(
                            new OnSuccessListener<UploadTask.TaskSnapshot>() {

                                @Override
                                public void onSuccess(
                                        UploadTask.TaskSnapshot taskSnapshot)
                                {

                                    progressDialog.dismiss();
                                    Toast
                                            .makeText(AddMessDetailsActivity.this,
                                                    "Image Uploaded!!",
                                                    Toast.LENGTH_SHORT)
                                            .show();

                                    String foodType = spinnerFoodType.getSelectedItem().toString();
                                    String messName = editTextMessName.getText().toString();
                                    mess.setMessName(messName);
                                    mess.setFoodType(foodType);

                                    FirebaseDatabase.getInstance().getReference("Messes").child(messId)
                                            .setValue(mess).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                Toast.makeText(AddMessDetailsActivity.this, "Mess Added Sucessfully!", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(getApplicationContext(),PlaceAddedActivity.class);
                                                intent.putExtra("ADD_TYPE","MESS");
                                                startActivity(intent);
                                            }
                                        }
                                    });

                                }
                            })

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e)
                        {

                            // Error, Image not uploaded
                            progressDialog.dismiss();
                            Toast
                                    .makeText(AddMessDetailsActivity.this,
                                            "Failed " + e.getMessage(),
                                            Toast.LENGTH_SHORT)
                                    .show();
                        }
                    })
                    .addOnProgressListener(
                            new OnProgressListener<UploadTask.TaskSnapshot>() {

                                @Override
                                public void onProgress(
                                        UploadTask.TaskSnapshot taskSnapshot)
                                {
                                    double progress
                                            = (100.0
                                            * taskSnapshot.getBytesTransferred()
                                            / taskSnapshot.getTotalByteCount());
                                    progressDialog.setMessage(
                                            "Uploaded "
                                                    + (int)progress + "%");
                                }
                            });
        }
    }
}