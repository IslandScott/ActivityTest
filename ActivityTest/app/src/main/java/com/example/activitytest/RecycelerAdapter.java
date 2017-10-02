package com.example.activitytest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/9/10.
 */

public class RecycelerAdapter extends ArrayAdapter<RecycleList> {
        private int resourceId;
        public RecycelerAdapter(Context context, int textViewResourceId, List<RecycleList> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;

    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //将ArrayAdapter<> 中的子项指定为RecycleList 才能将getItem(position)赋值给RecycleList;
        RecycleList recycleList = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView recycleName = (TextView) view.findViewById(R.id.recyclelist_item);
        recycleName.setText(recycleList.getName());
        return view;

    }

}


