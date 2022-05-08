package com.example.buddy4hostellers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowPlaceDetailsActivity extends AppCompatActivity {

    ImageView imageViewPlaceImage,imageViewViewOnMap;
    TextView textViewNearCollege,textViewDistanceFromClg,textViewAddress,textViewRent
            ,textViewTenantType,textViewMaxAllowed,textViewApartmentType,textViewRoomType,textViewBhkType
            ,textViewFloor,getTextViewApartmentName,textViewArea,textViewStreet,textViewLandMark
            ,textViewDetailsRent,textViewDeposit,textViewMaintenance,textViewFurnishing
            ,textViewRentPerHead;
    Button buttonOtherDetails,buttonFindMates;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_place_details);

        bindComponents();

    }

    public void bindComponents(){

        this.imageViewPlaceImage = findViewById(R.id.image_view_place_details_img);
        this.textViewNearCollege = findViewById(R.id.text_view_place_details_near_clg);
        this.textViewDistanceFromClg = findViewById(R.id.text_view_place_details_distance);
        this.textViewAddress = findViewById(R.id.text_view_place_details_address);
        this.textViewRent = findViewById(R.id.text_view_place_details_rent);
        this.textViewTenantType = findViewById(R.id.edit_text_place_details_tenant_type);
        this.textViewMaxAllowed = findViewById(R.id.text_view_place_details_max_allowed);
        this.textViewApartmentType = findViewById(R.id.text_view_place_details_apartment_name);
        this.textViewRoomType = findViewById(R.id.text_view_place_details_room_type);
        this.textViewBhkType = findViewById(R.id.text_view_place_details_bhk_type);
        this.textViewFloor = findViewById(R.id.text_view_placde_details_floor);
        this.getTextViewApartmentName = findViewById(R.id.text_view_place_details_apartment_name);
        this.textViewStreet = findViewById(R.id.text_view_place_details_street);
        this.textViewArea = findViewById(R.id.text_view_place_details_area);
        this.textViewLandMark = findViewById(R.id.text_view_place_details_landmark);
        this.imageViewViewOnMap = findViewById(R.id.image_view_place_details_view_on_map);
        this.textViewDetailsRent = findViewById(R.id.text_view_place_details_rent_det_rent2);
        this.textViewDeposit = findViewById(R.id.text_view_place_details_rent_det_deposite);
        this.textViewMaintenance = findViewById(R.id.text_view_place_details_rent_det_maintenance);
        this.textViewFurnishing = findViewById(R.id.text_view_place_details_rent_det_furnishing);
        this.textViewRentPerHead = findViewById(R.id.text_view_place_details_rent_det_rent_per_head);
        this.buttonFindMates = findViewById(R.id.button_details_living_place_find_mates);
        this.buttonOtherDetails = findViewById(R.id.button_details_living_place_other_details);

    }
}