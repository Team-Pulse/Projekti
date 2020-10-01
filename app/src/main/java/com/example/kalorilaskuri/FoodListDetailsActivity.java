package com.example.kalorilaskuri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class FoodListDetailsActivity extends MainActivity {
    Button eatmorebtn;
    Button returnbtn;
    Button clearbtn;
    ListView foodListDetail;
    ArrayAdapter<Food> adapter;
    private ArrayList<Food> foodDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list_details);
        setFoodListDetail();
        clearbtn = findViewById(R.id.clearButton);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                FoodListDetailsSingletonClass.getInstance().getFoods());
        foodListDetail.setAdapter(adapter);


        foodDetails = new ArrayList<>();
        setEatmorebtn();
        setReturnbtn();
        setClearbtn();
    }

    public void reloadUI() {
        setContentView(R.layout.activity_food_list_details);
        setFoodListDetail();
        foodDetails = new ArrayList<>();
        setEatmorebtn();
        setReturnbtn();
        setClearbtn();
    }


    public void setFoodListDetail() {

        this.foodListDetail = findViewById(R.id.addedfoods);
        foodListDetail.setAdapter(new ArrayAdapter<>(this, android.R.layout.
                simple_list_item_1, FoodListDetailsSingletonClass.getInstance().getFoods()));

    }

    public void setEatmorebtn() {

        eatmorebtn = findViewById(R.id.eatmore);
        eatmorebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFoodList();
            }
        });
    }

    public void setReturnbtn() {

        returnbtn = findViewById(R.id.returnButton);
        returnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });
    }

    public void setClearbtn() {


        clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FoodListDetailsSingletonClass.getInstance().clearArray();
                foodListDetail.setAdapter(null);
                adapter.notifyDataSetChanged();



            }
        });


    }
}