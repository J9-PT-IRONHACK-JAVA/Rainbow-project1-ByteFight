package com.ironhack.RPG.Model;

import com.ironhack.RPG.Utils.Emoji;

import java.util.ArrayList;

public class Graveyard {
    private static ArrayList<Character> graveyard = new ArrayList<>();

    public Graveyard() {
    }

    public void addToGraveyard(Character character){
        graveyard.add(character);
    }

    public void displayGraveyard(){
        for(Character character : graveyard){
            System.out.println("\033[120C" + Emoji.CANDLE);
            System.out.println(character);
        }
    }

    public ArrayList<Character> getGraveyard(){
        return graveyard;
    }
}
