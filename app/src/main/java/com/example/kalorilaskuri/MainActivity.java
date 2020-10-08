package com.example.kalorilaskuri;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

/**
 * luokkanäkymä  uloskirjausnapille ja Eat! napille.
 */

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

    /**
     * Uloskirjaus funktio kirjaa käyttäjän takaisin Activity_Login.xml:n.
     */
    private void Exit(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(MainActivity.this, Login.class));
        Toast.makeText(MainActivity.this, "You were logged out", Toast.LENGTH_SHORT).show();

    }


    /**
     * nimetään activity_main.xml:stä löytyvä EAT! nappi, jonka id on button.
     * asetetaan setOnClickListener metodi joka nappia painamalla käynnistää openFoodList()
     * metodin
     */
    public void setEatBtn() {

        eatBtn = findViewById(R.id.button);

        eatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFoodList();
            }
        });


    }

    /**
     * Luo uuden intent olion, mikä käynnistää FoodListActivityn
     */
    public void openFoodList() {

        Intent intent = new Intent(this, FoodListActivity.class);
        startActivity(intent);
    }

    /**
     * Luo uuden intent olion mikä käynnistää MainActivityn.
     * Käytetään return-buttonissa.
     */
    public void openMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     *         Tyhjentää FoodListDetailsActivityn lisättyjen ruokien listan
     *         Käytetään clear-buttonissa
     */
    public void clearFoodListDetails() {

        FoodListDetailsSingletonClass.getInstance().getFoods().clear();
    }
}