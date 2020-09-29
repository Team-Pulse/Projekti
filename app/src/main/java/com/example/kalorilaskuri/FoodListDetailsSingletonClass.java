package com.example.kalorilaskuri;

import java.util.ArrayList;

public class FoodListDetailsSingletonClass {
    private static final FoodListDetailsSingletonClass ourInstance = new FoodListDetailsSingletonClass();
    public ArrayList<Food> foodDetailsAcitiy;

    private FoodListDetailsSingletonClass(){
        foodDetailsAcitiy = new ArrayList<>();
    }

    public static FoodListDetailsSingletonClass getInstance(){
        return ourInstance;
    }

    public ArrayList<Food> getFoods(){
        return this.foodDetailsAcitiy;
    }

    public Food getFood(int index){
        return foodDetailsAcitiy.get(index);
    }


}
