package com.ironhack.RPG.Model;

import com.ironhack.RPG.Utils.Colors;
import com.ironhack.RPG.Utils.Emoji;

import java.util.Random;

public class Warrior extends Character implements Attacker{

    private int stamina;
    private int strength;
    private boolean isStrongAttack;

// warrior attack (implements attack from interface).
    @Override
    public void attack(Character attackedCharacter) {
        int damage;

        if (getIsStrongAttack()) {
            damage = getStrength();
            attackedCharacter.setHp(attackedCharacter.getHp() - damage);
            if (attackedCharacter.getHp() <= 0) {
                attackedCharacter.setAlive(false);
            }

            setStamina(this.stamina - 5);
        } else {
            damage = getStrength() / 2;

            attackedCharacter.setHp(attackedCharacter.getHp() - damage);
            if (attackedCharacter.getHp() <= 0) {
                attackedCharacter.setAlive(false);
            }

            setStamina(this.stamina + 1);
        }
    }


//'manual' constructor: generates a warrior
    public Warrior(String type, String name, int hp, int stamina, int strength) {
        super(type, name, hp);
        setStamina(stamina);
        setStrength(strength);
    }
//'auto' constructor: generates a warrior automatically & randomly
    public Warrior() {
        super();
        setType("warrior");
        setStamina(generateWarriorStamina());
        setStrength(generateWarriorStrength());
        setHp(generateWarriorHp());
    }

    @Override
    public String toString() {
        return  "\033[100C" + Emoji.WARRIOR + Colors.WARRIOR + "     name: " + super.getName() + "\n\n" +
                "\033[95C" + Colors.RESET + "hp: " + super.getHp() + "\t" +
                "stamina: " + stamina + "\t" +
                "strength: " + strength;
    }

// random generators
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

// getters & setters

    public int getStamina() {
        return stamina;
    }

    public int getStrength() {
        return strength;
    }


    @Override
    public boolean getIsStrongAttack() {
        return this.stamina >= 5;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

}
