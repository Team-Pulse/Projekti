package com.example.kalorilaskuri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class FoodListActivity extends AppCompatActivity {

    ListView lv;
    public static final String SELECTED_FOOD = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        setAdapter();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("onItemClick", "pressed");
                Intent foodDetailsActivity = new Intent(FoodListActivity.this,
                        FoodListDetailsActivity.class);



                foodDetailsActivity.putExtra(FoodListActivity.SELECTED_FOOD, position);
                startActivity(foodDetailsActivity);
            }
        });



    }

    public void setAdapter(){
        this.lv = findViewById(R.id.foodlistview);
        lv.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                FoodList.getInstance().getFoods()));
    }


}