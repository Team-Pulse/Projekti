package com.example.kalorilaskuri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class FoodListDetailsActivity extends MainActivity implements FoodListAdapter.FoodListViewHolder.OnFoodListListener {
    Button eatmorebtn;
    Button returnbtn;
    Button clearbtn;
    private TextView totalKcal;
    private RecyclerView mAddedFoods;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list_details);
        setFoodListDetail();
        setTotalKcal();
        clearbtn = findViewById(R.id.clearButton);

        setEatmorebtn();
        setReturnbtn();
        setClearbtn();
    }

    public void setFoodListDetail() {

        this.mAddedFoods = findViewById(R.id.addedfoods);
        mAddedFoods.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new FoodListAdapter(FoodListDetailsSingletonClass.getInstance().getFoods(), this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(mAddedFoods);
        mAddedFoods.setLayoutManager(mLayoutManager);
        mAddedFoods.setAdapter(mAdapter);
    }

    public void setTotalKcal() {
        totalKcal = findViewById(R.id.kcals);
        totalKcal.setText(Integer.toString(FoodListDetailsSingletonClass.totalKcal(FoodListDetailsSingletonClass.getInstance().getFoods())));
    }

    ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            FoodListDetailsSingletonClass.getInstance().getFoods().remove(viewHolder.getAdapterPosition());
            mAdapter.notifyDataSetChanged();
            setTotalKcal();
        }
    };

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
                mAddedFoods.setAdapter(null);
                mAdapter.notifyDataSetChanged();
                setTotalKcal();
            }
        });


    }

    @Override
    public void onFoodListClick(int position) {

    }
}