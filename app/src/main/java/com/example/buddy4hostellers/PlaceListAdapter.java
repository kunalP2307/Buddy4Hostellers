package com.example.buddy4hostellers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


import com.example.buddy4hostellers.data.CollegeDetails;
import com.example.buddy4hostellers.data.LivingPlace;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.w3c.dom.Text;

import java.util.List;

public class PlaceListAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    List<LivingPlace> livingPlaces;
    private static final String TAG = "PlaceListAdapter";

    public PlaceListAdapter(Context applicationContext,List<LivingPlace> livingPlaces){
        this.context = applicationContext;
        this.livingPlaces = livingPlaces;
        this.layoutInflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return this.livingPlaces.size();
    }

    @Override
    public Object getItem(int i) {
        return livingPlaces.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = layoutInflater.inflate(R.layout.place_list_item,null);

        LivingPlace livingPlace = livingPlaces.get(i);

        ImageView imageView = view.findViewById(R.id.image_view_property_img);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Image CLicked");
            }
        });
        StorageReference mImageRef =
                FirebaseStorage.getInstance().getReference("images/I"+livingPlace.getPlaceId());
        final long ONE_MEGABYTE = 1024 * 1024;
        mImageRef.getBytes(ONE_MEGABYTE)
                .addOnSuccessListener(new OnSuccessListener<byte[]>() {
                    @Override
                    public void onSuccess(byte[] bytes) {
                        Bitmap bm = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                        DisplayMetrics dm = new DisplayMetrics();
                        //  getWindowManager().getDefaultDisplay().getMetrics(dm);

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

        TextView textViewHeading,textViewAddress,textViewRent,textViewRoomType,textViewDistance;

        textViewHeading = view.findViewById(R.id.textView_place_heading);
        textViewAddress  = view.findViewById(R.id.text_view_place_address);
        textViewRent = view.findViewById(R.id.text_view_living_place_rent);
        textViewRoomType = view.findViewById(R.id.text_view_living_room_type);
        textViewDistance = view.findViewById(R.id.edit_text_living_place_distance);

        textViewHeading.setText("PG for Boys");
        textViewAddress.setText(livingPlace.getLocalityDetails().getArea());
        textViewRent.setText(Double.toString(livingPlace.getRentDetails().getRent()));
        textViewRoomType.setText(livingPlace.getPlaceDetails().getRoomType());
        textViewDistance.setText(Double.toString(livingPlace.getNearbyCollege().getDistanceFromCollege()));


        return view;
    }


}
