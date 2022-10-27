package com.ironhack.RPG.Model;

import java.util.Random;

public class Warrior extends Character implements Atacker{

    private int stamina;
    private int strength;

//generates a warrior
    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        setStamina(stamina);
        this.strength = strength;
    }
//generates automatically & randomly a warrior
    public Warrior() {
        super(name, generateWarriorHp ());
        setStamina(generateWarriorStamina ());
        setStrength(generateWarriorStrength());
        this.strength = strength;
    }

    public static int generateWarriorHp (){
        Random a = new Random();
        return a.nextInt(100,201); //por verificar rango

    }

    public static int generateWarriorStamina (){
        Random a = new Random();
        return a.nextInt(10,51); //por verificar rango
        //return a.nextInt(101)+100;
        //return a.nextInt(100,101);
    }

    public static int generateWarriorStrength(){
        Random a = new Random();
        return a.nextInt(1,11);
    }

    public int getStamina() {
        return stamina;
    }

    public int getStrength() {
        return strength;
    }


    public void setStamina(int stamina) {

        if (stamina >= 10 && stamina <=50 ) {
            this.stamina = stamina;
        }else{
            this.stamina = -1;
        }
    }


    public void setStrength(int strength) {
        this.strength = strength;
    }
}
