package com.example.buddy4hostellers;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.buddy4hostellers.data.Mess;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

public class MessAdapter extends BaseAdapter {


    Context context;
    LayoutInflater layoutInflater;
    List<Mess> messList;
    private static final String TAG = "MessAdapter";

    public MessAdapter(Context applicationContext,List<Mess> messList){
        this.context = applicationContext;
        this.messList = messList;
        this.layoutInflater = (LayoutInflater.from(applicationContext));
    }


    @Override
    public int getCount() {
        return messList.size();
    }

    @Override
    public Object getItem(int i) {
        return messList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = layoutInflater.inflate(R.layout.mess_list_item,null);

        Mess mess = (Mess) getItem(i);

        ImageView imageView = view.findViewById(R.id.image_view_mess_image_new);

        StorageReference mImageRef =
                FirebaseStorage.getInstance().getReference("messMenu/"+mess.getMessId());
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



        TextView textViewMessName = view.findViewById(R.id.text_view_mess_name_new);
        TextView textViewDistance = view.findViewById(R.id.text_view_mess_distance);
        TextView textViewClgName = view.findViewById(R.id.text_view_mess_near_clg);
        TextView textViewFoodType = view.findViewById(R.id.text_view_mess_food_type);
        ImageView imageViewCall = view.findViewById(R.id.image_view_call_mess);


        textViewClgName.setText(mess.getNearbyCollege().getNearByCollege());
        textViewDistance.setText(Double.toString(mess.getNearbyCollege().getDistanceFromCollege()));
        textViewFoodType.setText(mess.getFoodType());
        textViewMessName.setText(mess.getMessName());
        
        return view;
    }
}
