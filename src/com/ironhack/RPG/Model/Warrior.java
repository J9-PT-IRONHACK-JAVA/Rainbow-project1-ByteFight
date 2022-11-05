package com.ironhack.RPG.Model;

import java.util.Random;

public class Warrior extends Character implements Attacker{

    private int stamina;
    private int strength;
    private static int attackDamage; // allows to move value from attack() to receiveAttack().
    private static boolean isStrongAttack;



// warrior attack (implements attack from interface).
    public int attack(Character attackedCharacter) {
        int damage;

        if (this.stamina >= 5) {
            setIsStrongAttack(true);
            damage = getStrength();

            attackedCharacter.setHp(attackedCharacter.getHp() - this.strength);
            if (attackedCharacter.getHp() <= 0) {
                attackedCharacter.setAlive(false);
            }

            setStamina(this.stamina - 5);
        }else {
            setIsStrongAttack(false);
            damage = getStrength() / 2;

            attackedCharacter.setHp(attackedCharacter.getHp() - (this.strength / 2));
            if (attackedCharacter.getHp() <= 0) {
                attackedCharacter.setAlive(false);
            }

            setStamina(this.stamina + 1);
        }
        setAttackDamage(damage);
        return attackDamage;
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

    public static double getAttackDamage() {
        return attackDamage;
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

    public static void setAttackDamage(int attackDamage) {
        Warrior.attackDamage = attackDamage;
    }

    public static void setIsStrongAttack(boolean isStrongAttack) {
        Warrior.isStrongAttack = isStrongAttack;
    }
}
