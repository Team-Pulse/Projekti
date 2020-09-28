package com.example.kalorilaskuri;

public class Food {
    String name;
    int kcal;

    public Food(String name, int kcal){
        this.name = name;
        this.kcal = kcal;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setKcal(int kcal){
        this.kcal = kcal;
    }




    @Override
    public String toString() {
        return "Food: " + this.name + "\n"
                + "kcal: " + this.kcal;
    }


}
