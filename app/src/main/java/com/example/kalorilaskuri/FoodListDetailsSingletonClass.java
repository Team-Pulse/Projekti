package com.example.kalorilaskuri;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Luokka sisältää ruokalistalla olevien olioiden ominaisuuksia:Nimen ja energiamäärän
 * @author Jukka-Pekka Lappalainen
 */

public class FoodListDetailsSingletonClass {
    /**
     * Luo yksityisen staattisen instanssiolion.
     */
    private static final FoodListDetailsSingletonClass ourInstance = new FoodListDetailsSingletonClass();
    public ArrayList<Food> addedfoods;

    public static int totalKcal(ArrayList<Food> foodDetails) {
        int sum = 0;
        for (int i = 0; i < foodDetails.size(); i++) {
            sum += FoodListDetailsSingletonClass.getInstance().getFood(i).getKcal();
        }
        return sum;
    }

    public FoodListDetailsSingletonClass(){
        /*
         * Luo foodDetailsActivity taulukon
         */
        addedfoods = new ArrayList<>();
    }

    public static FoodListDetailsSingletonClass getInstance(){
        /**
         * @return ourInstance
         */
        return ourInstance;
    }

    public ArrayList<Food> getFoods(){
        /**
         * @return foodDetailsActivity
         */
        return this.addedfoods;
    }

    public Food getFood(int index){
        /**
         * @return foodDetails
         */
        return addedfoods.get(index);
    }

    public void clearArray(){
        addedfoods = new ArrayList<>();
    }








}
