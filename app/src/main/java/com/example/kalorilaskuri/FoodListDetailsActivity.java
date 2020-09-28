package com.example.kalorilaskuri;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class FoodListDetailsActivity extends MainActivity {
    ListView lvFoodListDetails;
    Button eatmorebtn;
    public ArrayList<Food> foodDetails;
    public ArrayAdapter <Food> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list_details);
        this.lvFoodListDetails = (ListView) findViewById(R.id.addedfoods);
        eatMoreButton();

        int selectedFoodIndex =
                getIntent().getExtras().getInt(FoodListActivity.SELECTED_FOOD, -1);
        Food food =
                FoodList.getInstance().getFood(selectedFoodIndex);
        foodDetails = new ArrayList<Food>(Arrays.asList(food));
        adapter=new ArrayAdapter<Food>(this,R.layout.activity_food_list_details,
                R.id.addedfoods, foodDetails);
        lvFoodListDetails.setAdapter(adapter);




    }





    public void eatMoreButton(){
        eatmorebtn = (Button)findViewById(R.id.eatmore);
        eatmorebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFoodList();
            }
        });

    }

}