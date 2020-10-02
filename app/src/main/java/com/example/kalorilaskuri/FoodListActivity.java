package com.example.kalorilaskuri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FoodListActivity extends AppCompatActivity implements FoodListAdapter.FoodListViewHolder.OnFoodListListener {

    private RecyclerView mFoodList;
    private RecyclerView.Adapter mFoodListAdapter;
    private RecyclerView.LayoutManager mFoodListLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        setFoodList();

    }

    public void setFoodList() {
        this.mFoodList = findViewById(R.id.foodListRecyclerView);
        mFoodList.setHasFixedSize(true);
        mFoodListLayoutManager = new LinearLayoutManager(this);
        mFoodListAdapter = new FoodListAdapter(FoodList.getInstance().getFoods(), this);
        mFoodList.setLayoutManager(mFoodListLayoutManager);
        mFoodList.setAdapter(mFoodListAdapter);
    }

    @Override
    public void onFoodListClick(int position) {
        Intent nextActivity = new Intent(FoodListActivity.this,
                FoodListDetailsActivity.class);
        FoodListDetailsSingletonClass.getInstance().getFoods().
                add(FoodList.getInstance().getFood(position));

        startActivity(nextActivity);
    }
}