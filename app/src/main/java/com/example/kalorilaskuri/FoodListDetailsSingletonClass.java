package com.example.kalorilaskuri;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Luokka sisältää ruokalistalla olevien olioiden ominaisuuksia:Nimen ja energiamäärän
 * @author Jukka-Pekka Lappalainen, Robert Rastas
 */

public class FoodListDetailsSingletonClass {
    /**
     * Luo yksityisen staattisen instanssiolion.
     */
    private static final FoodListDetailsSingletonClass ourInstance = new FoodListDetailsSingletonClass();
    public ArrayList<Food> addedfoods;

    /**
     * summaa lisättyjen olioiden kalorit yhteen.
     * @param foodDetails
     * @return
     */
    public static int totalKcal(ArrayList<Food> foodDetails) {
        int sum = 0;
        for (int i = 0; i < foodDetails.size(); i++) {
            sum += FoodListDetailsSingletonClass.getInstance().getFood(i).getKcal();
        }
        return sum;
    }

    /**
     *  Luo foodDetailsActivity taulukon
     */
    public FoodListDetailsSingletonClass(){



        addedfoods = new ArrayList<>();
    }

    /**
     * palauttaa staattisen olion.
     * @return
     */
    public static FoodListDetailsSingletonClass getInstance(){

        return ourInstance;
    }
    /**
     * palauttaa addedfoods listan.
     * @return addedfoods
     */
    public ArrayList<Food> getFoods(){
        return this.addedfoods;
    }

    /**
     * palauttaa yksittäisen olion.
     * @param index
     * @return
     */
    public Food getFood(int index){

        return addedfoods.get(index);
    }

    /**
     * tyhjentää listan.
     */
    public void clearArray(){
        addedfoods = new ArrayList<>();
    }








}
