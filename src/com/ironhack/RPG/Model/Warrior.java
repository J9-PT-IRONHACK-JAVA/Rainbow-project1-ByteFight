package com.ironhack.RPG.Model;

import java.util.Random;

public class Warrior extends Character implements Atacker{

    private int stamina;
    private int strength;


//generates a warrior
    public Warrior(String type, String name, int hp, int stamina, int strength) {
        super(type, name, hp);
        setStamina(stamina);
        setStrength(strength);
    }
//generates automatically & randomly a warrior
    public Warrior() {
        super();
        setStamina(generateWarriorStamina());
        setStrength(generateWarriorStrength());
        setHp(generateWarriorHp());
    }

    //completar para el menu, para llamar este metodo para para imprimir info, falta diseño y colores
    @Override
    public String toString() {
        return  "Warrior{" +
                "type='" + super.getType() + '\'' +
                "id='" + super.getId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", hp=" + super.getHp() +
                ", isAlive=" + super.isAlive() +
                "stamina=" + stamina +
                ", strength=" + strength +
                '}';
    }

    public static int generateWarriorHp (){
        Random a = new Random();
        return a.nextInt(100,201);
    }

    public static int generateWarriorStamina (){
        Random a = new Random();
        return a.nextInt(10,51);
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

    @Override
    public int attack() {
        int damage;
        if (this.stamina >= 5) {

            damage = getStrength();
            setStamina(this.stamina - 5);
        }else {
            damage = getStrength() / 2;
            setStamina(this.stamina + 1);
        }
        return damage;
    }
}
