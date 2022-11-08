package com.ironhack.RPG.Model;

import com.ironhack.RPG.Utils.Colors;
import com.ironhack.RPG.Utils.Emoji;

import java.util.Random;

public class Warrior extends Character implements Attacker{

    private int stamina;
    private int strength;
    private static boolean isStrongAttack;



// warrior attack (implements attack from interface).
    @Override
    public void attack(Character attackedCharacter) {
        int damage;

        if (this.stamina >= 5) {
            setIsStrongAttack(true);
            damage = getStrength();

            attackedCharacter.setHp(attackedCharacter.getHp() - this.strength);
            if (attackedCharacter.getHp() <= 0) {
                attackedCharacter.setAlive(false);
            }

            setStamina(this.stamina - 5);
        } else {
            setIsStrongAttack(false);
            damage = getStrength() / 2;

            attackedCharacter.setHp(attackedCharacter.getHp() - (this.strength / 2));
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
        setStamina(generateWarriorStamina());
        setStrength(generateWarriorStrength());
        setHp(generateWarriorHp());
    }

    @Override
    public String toString() {
        return  "\033[60C" + Emoji.WARRIOR + Colors.WARRIOR + "     name: " + super.getName() + "\n\n" +
                "\033[50C" + Colors.RESET + "hp: " + super.getHp() + "\t" +
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


    public static boolean getIsStrongAttack() {
        return isStrongAttack;
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

    public static void setIsStrongAttack(boolean isStrongAttack) {
        Warrior.isStrongAttack = isStrongAttack;
    }
}
