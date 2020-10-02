package com.example.kalorilaskuri;

/**
 * Luokka sisältää ruokalistalla olevien olioiden ominaisuuksia:Nimen ja energiamäärän
 *
 * @author Jukka-Pekka Lappalainen
 */

public class Food {
    private String name;
    private int kcal;
    private int mImageResource;

    /**
     * Oliolla on 2 muuttujaa, String tyypin nimi, int tyypin kcal.
     *
     * @param name määrittää olion String tyypin nimen.
     * @param kcal määrittää olion int tyypin energiamäärän.
     */
    public Food(String name, int kcal, int imageResource) {
        /*
        Luokan konstruktori johon syötetään String tyypin paremetri name, ja int tyypin paremetri
        kcal.
         */
        this.name = name;
        this.kcal = kcal;
        this.mImageResource = imageResource;
    }

    public String getName() {
        /*
         * Tämä metodi palauttaa String tyypin nimen.
         */
        return this.name;
    }

    public int getKcal() {
        /*
         * tämä metodi palauttaa int tyypin kcal.
         */
        return kcal;
    }

    public String getKcalString() {
        return "kcal: " + this.kcal;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    @Override
    public String toString() {
        /*
        Tämä metodi määrittelee mitä tietoja käyttäjä näkee listalla olevasta
        yksittäisestä oliosta.
         */
        return "Food: " + this.name + "\n"
                + "kcal: " + this.kcal;
    }


}
