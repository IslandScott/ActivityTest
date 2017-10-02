package com.example.activitytest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Administrator on 2017/8/11.
 */

public class FruitAdapter2 extends RecyclerView.Adapter<FruitAdapter2.ViewHolder> {
    private List<Fruit> mFruitList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        //View fruitView;
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View view){
            super(view);
            //fruitView = view;
            fruitImage = (ImageView)view.findViewById(R.id.fruit_image);
           fruitName  = (TextView)view.findViewById(R.id.fruit_name);
        }
    }
    public FruitAdapter2(List<Fruit> fruitList){
        mFruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
        final ViewHolder holder1 = new ViewHolder(view);
        holder1.fruitName.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        int positon = holder1.getAdapterPosition();
                        Fruit fruit = mFruitList.get(positon);
                        Toast.makeText(view.getContext(),"you clicked viewname"+fruit.getName(),Toast.LENGTH_SHORT).show();
                    }
                }
        );
        holder1.fruitImage.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        int positon = holder1.getAdapterPosition();
                        Fruit fruit = mFruitList.get(positon);
                        Toast.makeText(view.getContext(),"you clicked image"+fruit.getName(),Toast.LENGTH_SHORT).show();
                    }
                }
        );
        return holder1;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
}

