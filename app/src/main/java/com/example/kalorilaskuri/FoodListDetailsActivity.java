package com.example.kalorilaskuri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class FoodListDetailsActivity extends MainActivity {
    Button eatmorebtn;
    private ArrayList<Food> foodDetails;
    ListView foodListDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list_details);

        this.foodListDetail = findViewById(R.id.addedfoods);

        foodListDetail.setAdapter(new ArrayAdapter<>(this, android.R.layout.
                simple_list_item_1, FoodListDetailsSingletonClass.getInstance().getFoods()));



        foodDetails = new ArrayList<>();

        eatmorebtn = (Button)findViewById(R.id.eatmore);

        eatmorebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFoodList();



            }
        });


    }
}