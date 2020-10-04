package com.example.kalorilaskuri;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private Button eatBtn;
    private FirebaseAuth firebaseAuth;
    private Button exitbtn;




    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setEatBtn();

        firebaseAuth = FirebaseAuth.getInstance();
        exitbtn = (Button)findViewById(R.id.exitbtn);
        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exit();
            }
        });




    }

    private void Exit(){//Uloskirjaus funktio kirjaa käyttäjän takaisin Activity_Login.xml:n.
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(MainActivity.this, Login.class));
        Toast.makeText(MainActivity.this, "You were logged out", Toast.LENGTH_SHORT).show();

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