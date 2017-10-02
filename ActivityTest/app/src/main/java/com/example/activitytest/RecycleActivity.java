package com.example.activitytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecycleActivity extends AppCompatActivity {
    private List<Fruit> fruit = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_activity);
        initFruits();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter2 adapter2 = new FruitAdapter2(fruit);
        recyclerView.setAdapter(adapter2);
    }

//    private void initFruits(){
//        for(int i = 0;i < 4; i++){
//            Fruit apple = new Fruit(getRandomLengthName("Apple"),R.drawable.timg);
//            fruit.add(apple);
//            Fruit banana = new Fruit(getRandomLengthName("Banana"),R.drawable.timg);
//            fruit.add(banana);
//            Fruit orange = new Fruit(getRandomLengthName("Orange"),R.drawable.timg);
//            fruit.add(orange);
//            Fruit strawberry = new Fruit(getRandomLengthName("Strawberry"),R.drawable.timg);
//            fruit.add(strawberry);
//            Fruit pear = new Fruit(getRandomLengthName("Pear"),R.drawable.timg);
//            fruit.add(pear);
//            Fruit grape = new Fruit(getRandomLengthName("Grape"),R.drawable.timg);
//            fruit.add(grape);
//            Fruit pineapple = new Fruit(getRandomLengthName("Pineapple"),R.drawable.timg);
//            fruit.add(pineapple);
//            Fruit cherry = new Fruit(getRandomLengthName("Cherry"),R.drawable.timg);
//            fruit.add(cherry);
//            Fruit mango = new Fruit(getRandomLengthName("Mango"),R.drawable.timg);
//            fruit.add(mango);
//        }
//    }
    private void initFruits(){
        for(int i = 0;i < 4; i++){
            Fruit apple = new Fruit("Apple",R.drawable.timg);
            fruit.add(apple);
            Fruit banana = new Fruit("Banana",R.drawable.timg);
            fruit.add(banana);
            Fruit orange = new Fruit("Orange",R.drawable.timg);
            fruit.add(orange);
            Fruit strawberry = new Fruit("Strawberry",R.drawable.timg);
            fruit.add(strawberry);
            Fruit pear = new Fruit("Pear",R.drawable.timg);
            fruit.add(pear);
            Fruit grape = new Fruit("Grape",R.drawable.timg);
            fruit.add(grape);
            Fruit pineapple = new Fruit("Pineapple",R.drawable.timg);
            fruit.add(pineapple);
            Fruit cherry = new Fruit("Cherry",R.drawable.timg);
            fruit.add(cherry);
            Fruit mango = new Fruit("Mango",R.drawable.timg);
            fruit.add(mango);
        }
    }
    private String getRandomLengthName(String name){
        Random random = new Random();
        int length = random.nextInt(20)+1;
        StringBuilder builder = new StringBuilder();
        for(int i=0;i < length;i++){
            builder.append(name);
        }
        return builder.toString();
    }
}
