package com.example.kalorilaskuri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FoodList extends AppCompatActivity {

    ListView foodlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        ArrayList<Food> foods = new ArrayList<>();

        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));


        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, foods);
        this.foodlist = findViewById(R.id.foodlist);
        foodlist.setAdapter(ad);








    }
}