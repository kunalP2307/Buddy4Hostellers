package com.example.buddy4hostellers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.buddy4hostellers.data.CollegeDetails;

public class CollegeListAdapter extends BaseAdapter{

    Context context;
    LayoutInflater layoutInflater;
    String[] collegeList;

    public CollegeListAdapter(Context applicationContext){
        this.context = applicationContext;
        this.collegeList = CollegeDetails.colleges;
        this.layoutInflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return this.collegeList.length;
    }

    @Override
    public Object getItem(int i) {
        return collegeList[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = layoutInflater.inflate(R.layout.college_name_list_item,null);
        TextView textViewCollegeName = (TextView) view.findViewById(R.id.textview_college_name);
        textViewCollegeName.setText(collegeList[i]);
        return view;
    }
}
