package com.example.kalorilaskuri;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button eatBtn;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setEatBtn();

    }

    public void setEatBtn() {
        //nimetään activity_main.xml:stä löytyvä EAT! nappi, jonka id on button.
        eatBtn = findViewById(R.id.button);
        //asetetaan setOnClickListener metodi joka nappia painamalla käynnistää openFoodList()
        // metodin
        eatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFoodList();
            }
        });


    }

    public void openFoodList() {
        //Luo uuden intent olion, mikä käynnistää FoodListActivityn
        Intent intent = new Intent(this, FoodListActivity.class);
        startActivity(intent);
    }

    public void openMain() {
        //Luo uuden intent olion mikä käynnistää MainActivityn.
        //Käytetään return-buttonissa.
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void clearFoodListDetails() {
        //Tyhjentää FoodListDetailsActivityn lisättyjen ruokien listan
        //Käytetään clear-buttonissa
        FoodListDetailsSingletonClass.getInstance().getFoods().clear();
    }
}