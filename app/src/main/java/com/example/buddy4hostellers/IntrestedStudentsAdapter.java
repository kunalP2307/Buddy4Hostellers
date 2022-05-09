package com.example.buddy4hostellers;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.buddy4hostellers.data.LivingPlace;
import com.example.buddy4hostellers.data.Student;

import java.util.List;

public class IntrestedStudentsAdapter extends BaseAdapter {

    private static final String TAG = "IntrestedStudentsAdapte";
    Context context;
    LayoutInflater layoutInflater;
    List<Student> studentList;

    public IntrestedStudentsAdapter(Context applicationContext,List<Student> studentList){
        this.context = applicationContext;
        this.studentList = studentList;
        this.layoutInflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return this.studentList.size();
    }

    @Override
    public Object getItem(int i) {
        return this.studentList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = layoutInflater.inflate(R.layout.inrested_student_item,null);

        Student student = studentList.get(i);

        TextView textViewName,textViewCollegeName,textViewYear,textViewDescription;

        textViewName = view.findViewById(R.id.text_view_in_std_name);
        textViewCollegeName = view.findViewById(R.id.text_view_in_std_clg_name);
        textViewYear = view.findViewById(R.id.text_view_in_std_year);
        textViewDescription = view.findViewById(R.id.text_view_in_std_description);

        textViewName.setText(student.getName());
        textViewCollegeName.setText(student.getCollegeName());
        textViewYear.setText(student.getYearOfStudy()+" "+student.getBranchOfStudy());
        textViewDescription.setText(student.getDescription());


        ImageView imageView = view.findViewById(R.id.image_view_call_in_std);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: image clicked");
            }
        });

        return view;
    }
}
