package com.example.kalorilaskuri;

import java.util.ArrayList;

/**
 * Luettelo singletonluokka, jossa ruoat.
 * @author Roni Heininen
 * @version Android Studio 4.0.1 Build #AI-193.6911.18.40.6626763, built on June 25, 2020
 */

public class FoodList {
    /**
     * Luodaan staattinen oliomuuttuja
     */
    private static final FoodList ourInstance = new FoodList();
    /**
     * Luodaan luettelo foods.
     */
    private ArrayList<Food> foods = new ArrayList<>();

    /**
     * ruokaolioita.
     */
    private FoodList() {
        foods.add(new Food("mandariini", 32, R.drawable.icons8_orange_50));
        foods.add(new Food("appelsiini", 43, R.drawable.icons8_orange_50));
        foods.add(new Food("banaani", 84, R.drawable.icons8_banana_50));
        foods.add(new Food("kanankoipi", 294, R.drawable.icons8_chicken_50));
        foods.add(new Food("grillimakkara", 260, R.drawable.icons8_sausage_50));
        foods.add(new Food("murot", 352, R.drawable.icons8_cereal_50));
        foods.add(new Food("donitsi", 423, R.drawable.icons8_doughnut_50));
        foods.add(new Food("maito", 46, R.drawable.icons8_milk_carton_50));
        foods.add(new Food("piimä", 30, R.drawable.icons8_milk_carton_50));
        foods.add(new Food("kirjolohi", 259, R.drawable.icons8_fish_food_50));
        foods.add(new Food("graavilohi", 185, R.drawable.icons8_fish_food_50));
        foods.add(new Food("anjovis", 257, R.drawable.icons8_fish_food_50));
        foods.add(new Food("muikku", 183, R.drawable.icons8_fish_food_50));
        foods.add(new Food("peruna", 83, R.drawable.icons8_potato_50));
        foods.add(new Food("naudan jauheliha", 228, R.drawable.icons8_cuts_of_beef_50));
        foods.add(new Food("broilerin jauheliha", 147, R.drawable.icons8_chicken_50));
        foods.add(new Food("lampaan jauheliha", 204, R.drawable.icons8_lamb_50));
        foods.add(new Food("tomaatti", 21, R.drawable.icons8_tomato_50));
        foods.add(new Food("kurkku", 10, R.drawable.icons8_cucumber_50));
        foods.add(new Food("parsakaali", 30, R.drawable.icons8_broccoli_50));
    }

    /**
     * palauttaa staattisen oliomuuttujan.
     * @return ourInstance
     */
    public static FoodList getInstance() {
        return ourInstance;
    }

    /**
     * metodi palauttaa listalta foods.
     * @return
     */
    public ArrayList<Food> getFoods() {
        return this.foods;
    }

    /**
     * palauttaa tietyn yksittäisen olion listalta.
     * @param index
     * @return
     */
    public Food getFood(int index) {
        return foods.get(index);
    }
}
