package com.example.kalorilaskuri;

import java.util.ArrayList;

public class FoodList {
    private static final FoodList ourInstance = new FoodList();
    private ArrayList<Food> foods;

    private FoodList(){
        foods = new ArrayList<>();
        foods.add(new Food("mandariini", 32));
        foods.add(new Food("appelsiini", 43));
        foods.add(new Food("banaani", 84));
        foods.add(new Food("kanankoipi", 294));
        foods.add(new Food("grillimakkara", 260));
        foods.add(new Food("murot", 352));
        foods.add(new Food("donitsi", 423));
        foods.add(new Food("maito", 46));
        foods.add(new Food("piimä", 30));
        foods.add(new Food("kirjolohi", 259));
        foods.add(new Food("graavilohi", 185));
        foods.add(new Food("anjovis", 257));
        foods.add(new Food("muikku", 183));
        foods.add(new Food("peruna", 83));
        foods.add(new Food("naudan jauheliha", 228));
        foods.add(new Food("broilerin jauheliha", 147));
        foods.add(new Food("lampaan jauheliha", 204));
        foods.add(new Food("tomaatti", 21));
        foods.add(new Food("kurkku", 10));
        foods.add(new Food("parsakaali", 30));
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
