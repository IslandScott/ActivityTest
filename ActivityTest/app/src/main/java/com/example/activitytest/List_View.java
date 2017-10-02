package com.example.activitytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class List_View extends AppCompatActivity {
    //private String[] data = {"Apple","Banana","Orange","Watermelon","Pear","Grape",
    //        "Pineapple","Strawberry","Cherry","Mango","Pineapple"};

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list__view);
        initFruits();
        FruitAdapter adapter = new FruitAdapter(List_View.this,R.layout.fruit_item,fruitList);

        //ArrayAdapter<String> adapter = new ArrayAdapter<>(
        //        List_View.this,android.R.layout.simple_list_item_1,data);
        ListView listview = (ListView) findViewById(R.id.list_view1);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Fruit fruit = fruitList.get(i);
                        Toast.makeText(List_View.this,fruit.getName(),Toast.LENGTH_SHORT).show();
                    }
                }

        );


        //targetListView.setAdapter(adapter);
    }
    private void initFruits(){
        for(int i = 0;i < 10;i++){
            Fruit apple = new Fruit("Apple",R.drawable.timg);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana",R.drawable.timg);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange",R.drawable.timg);
            fruitList.add(orange);
            Fruit strawberry = new Fruit("Strawberry",R.drawable.timg);
            fruitList.add(strawberry);
            Fruit pear = new Fruit("Pear",R.drawable.timg);
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape",R.drawable.timg);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple",R.drawable.timg);
            fruitList.add(pineapple);
            Fruit cherry = new Fruit("Cherry",R.drawable.timg);
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango",R.drawable.timg);
            fruitList.add(mango);

        }
    }
}
