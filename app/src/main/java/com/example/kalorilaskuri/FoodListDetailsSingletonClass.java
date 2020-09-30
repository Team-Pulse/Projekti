package com.example.kalorilaskuri;

import java.util.ArrayList;

/**
 * Luokka sisältää ruokalistalla olevien olioiden ominaisuuksia:Nimen ja energiamäärän
 *
 * @author Jukka-Pekka Lappalainen
 */

public class FoodListDetailsSingletonClass {
    /**
     * Luo yksityisen staattisen instanssiolion.
     */
    private static final FoodListDetailsSingletonClass ourInstance = new FoodListDetailsSingletonClass();
    public ArrayList<Food> foodDetailsAcitivity;

<<<<<<< HEAD
    public FoodListDetailsSingletonClass(){
=======
    private FoodListDetailsSingletonClass() {
>>>>>>> 5b1b07fd7764f5edbc9741c0ab196fdc30955ae2
        /*
         * Luo foodDetailsActivity taulukon
         */
        foodDetailsAcitivity = new ArrayList<>();
    }

    public static FoodListDetailsSingletonClass getInstance() {
        /**
         * @return ourInstance
         */
        return ourInstance;
    }

    public ArrayList<Food> getFoods() {
        /**
         * @return foodDetailsActivity
         */
        return this.foodDetailsAcitivity;
    }

    public Food getFood(int index) {
        /**
         * @return foodDetails
         */
        return foodDetailsAcitivity.get(index);
    }






}
