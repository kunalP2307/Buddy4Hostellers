package com.example.buddy4hostellers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.buddy4hostellers.data.LivingPlace;
import com.example.buddy4hostellers.data.Student;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ShowPlaceDetailsActivity extends AppCompatActivity {

    ImageView imageViewPlaceImage,imageViewViewOnMap;
    TextView textViewNearCollege,textViewDistanceFromClg,textViewAddress,textViewRent
            ,textViewTenantType,textViewMaxAllowed,textViewApartmentType,textViewRoomType,textViewBhkType
            ,textViewFloor,getTextViewApartmentName,textViewArea,textViewStreet,textViewLandMark
            ,textViewDetailsRent,textViewDeposit,textViewMaintenance,textViewFurnishing
            ,textViewRentPerHead;
    Button buttonOtherDetails,buttonFindMates,buttonCallOwner;
    LivingPlace livingPlace;
    Student loggedInStudent;
    String loggedUserId;
    private static final String TAG = "ShowPlaceDetailsActivit";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_place_details);

        getUserId();

        livingPlace = (LivingPlace) getIntent().getSerializableExtra("EXTRA_SELECTED_PLACE");

        showImage();


        getCurrentLoggedStudent();
        bindComponents();
        addListeners();

        setDetails();

    }

    public void showImage(){

        ImageView imageView = findViewById(R.id.image_view_place_details_img);

        StorageReference mImageRef =
                FirebaseStorage.getInstance().getReference("images/I"+livingPlace.getPlaceId());
        final long ONE_MEGABYTE = 1024 * 1024;
        mImageRef.getBytes(ONE_MEGABYTE)
                .addOnSuccessListener(new OnSuccessListener<byte[]>() {
                    @Override
                    public void onSuccess(byte[] bytes) {
                        Bitmap bm = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                        DisplayMetrics dm = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(dm);

                        imageView.setMinimumHeight(300);
                        imageView.setMinimumWidth(300);
                        imageView.setImageBitmap(bm);
                        Log.d(TAG, "onSuccess: "+bm.toString());
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });

    }
    public void setDetails(){

        textViewNearCollege.setText(livingPlace.getNearbyCollege().getNearByCollege());
        textViewDistanceFromClg.setText(Double.toString(livingPlace.getNearbyCollege().getDistanceFromCollege()));

        textViewAddress.setText(livingPlace.getLocalityDetails().getArea()+" "+livingPlace.getLocalityDetails().getStreet());
        textViewRent.setText(Double.toString(livingPlace.getRentDetails().getRent()));

        if(livingPlace.getPlaceDetails().isTenantType())
            textViewTenantType.setText("Male");
        else
            textViewTenantType.setText("Female");

        textViewMaxAllowed.setText(livingPlace.getPlaceDetails().getMaxAllowed());
        textViewApartmentType.setText(livingPlace.getPlaceDetails().getApartmentType());
        textViewRoomType.setText(livingPlace.getPlaceDetails().getRoomType());
        textViewBhkType.setText(livingPlace.getPlaceDetails().getBhkType());
        textViewFloor.setText(Integer.toString(livingPlace.getPlaceDetails().getFloor()));
        getTextViewApartmentName.setText(livingPlace.getPlaceDetails().getApartmentName());
        textViewArea.setText(livingPlace.getLocalityDetails().getArea());
        textViewStreet.setText(livingPlace.getLocalityDetails().getStreet());
        textViewLandMark.setText(livingPlace.getLocalityDetails().getLandMark());

        textViewDetailsRent.setText(Double.toString(livingPlace.getRentDetails().getRent()));
        textViewDeposit.setText(Double.toString(livingPlace.getRentDetails().getDeposit()));
        textViewMaintenance.setText(Double.toString(livingPlace.getRentDetails().getMaintenance()));
        textViewFurnishing.setText(livingPlace.getRentDetails().getFurnishing());

        Double rentPerHead;
        rentPerHead = livingPlace.getRentDetails().getRent() / Integer.parseInt(livingPlace.getPlaceDetails().getMaxAllowed());

        textViewRentPerHead.setText(Double.toString(rentPerHead));


    }

    public void addListeners(){

        buttonFindMates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowPlaceDetailsActivity.this,IntrestedStudentsActivity.class);
                intent.putExtra("EXTRA_INTERESTED_STUD",loggedInStudent);
                intent.putExtra("EXTRA_LIVING_PLACE",livingPlace);
                startActivity(intent);
            }
        });

        buttonOtherDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        buttonCallOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+livingPlace.getServiceProviderContactDetails().getContact()));
                startActivity(intent);
            }
        });
    }


    public void bindComponents(){

        this.imageViewPlaceImage = findViewById(R.id.image_view_place_details_img);
        this.textViewNearCollege = findViewById(R.id.text_view_place_details_near_clg);
        this.textViewDistanceFromClg = findViewById(R.id.text_view_place_details_distance);
        this.textViewAddress = findViewById(R.id.text_view_place_details_address);
        this.textViewRent = findViewById(R.id.text_view_place_details_rent);
        this.textViewTenantType = findViewById(R.id.edit_text_place_details_tenant_type);
        this.textViewMaxAllowed = findViewById(R.id.text_view_place_details_max_allowed);
        this.textViewApartmentType = findViewById(R.id.edit_text_place_details_apt_type);
        this.textViewRoomType = findViewById(R.id.text_view_place_details_room_type);
        this.textViewBhkType = findViewById(R.id.text_view_place_details_bhk_type);
        this.textViewFloor = findViewById(R.id.text_view_placde_details_floor);
        this.getTextViewApartmentName = findViewById(R.id.text_view_place_details_apartment_name);
        this.textViewStreet = findViewById(R.id.text_view_place_details_street);
        this.textViewArea = findViewById(R.id.text_view_place_details_area);
        this.textViewLandMark = findViewById(R.id.text_view_place_details_landmark);
        this.imageViewViewOnMap = findViewById(R.id.image_view_place_details_view_on_map);
        this.textViewDetailsRent = findViewById(R.id.text_view_place_details_rent_det_rent);
        this.textViewDeposit = findViewById(R.id.text_view_place_details_rent_det_deposite);
        this.textViewMaintenance = findViewById(R.id.text_view_place_details_rent_det_maintenance);
        this.textViewFurnishing = findViewById(R.id.text_view_place_details_rent_det_furnishing);
        this.textViewRentPerHead = findViewById(R.id.text_view_place_details_rent_det_rent_per_head);
        this.buttonFindMates = findViewById(R.id.button_details_living_place_find_mates);
        this.buttonOtherDetails = findViewById(R.id.button_details_living_place_other_details);
        this.buttonCallOwner = findViewById(R.id.button_place_details_call_owner_new);
    }

    public void getCurrentLoggedStudent(){

       FirebaseDatabase.getInstance().getReference("UserStudent").
               child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                loggedInStudent = snapshot.getValue(Student.class);
                Log.d(TAG, "onDataChange: "+loggedInStudent.getName());
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void getUserId(){
        loggedUserId = FirebaseAuth.getInstance().getCurrentUser().getUid();
    }
}