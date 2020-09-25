package com.example.kalorilaskuri;

import java.util.ArrayList;

public class FoodList {
    private static final FoodList ourInstance = new FoodList();
    private ArrayList<Food> foods;

    private FoodList(){
        foods = new ArrayList<>();
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("mandariini", 32));
    }

    public static FoodList getInstance(){
        return ourInstance;
    }

    public ArrayList<Food> getFoods(){
        return this.foods;
    }

    public Food getFood(int index){
        return foods.get(index);
    }
}
