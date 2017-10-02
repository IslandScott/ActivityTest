package com.example.activitytest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.*;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/8/10.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;
    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects){
            super(context,textViewResourceId,objects);
            resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view ;
        ViewHolder1 viewHolder1;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder1 = new ViewHolder1();
            viewHolder1.fruitImage1 = (ImageView)view.findViewById(R.id.fruit_image);
            viewHolder1.fruitName1 =  (TextView)view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder1);
        }else{
            view = convertView;
            viewHolder1 = (ViewHolder1)view.getTag();
        }
        viewHolder1.fruitName1.setText(fruit.getName());
        viewHolder1.fruitImage1.setImageResource(fruit.getImageId());

        return view;
    }
    private class ViewHolder1{
        ImageView fruitImage1;
        TextView fruitName1;
    }
}
