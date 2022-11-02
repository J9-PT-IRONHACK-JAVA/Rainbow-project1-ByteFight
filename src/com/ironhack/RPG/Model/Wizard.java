package com.ironhack.RPG.Model;

import java.util.Random;

public  class Wizard extends Character implements Attacker{

    private int mana;
    private int intelligence;
    private static double attackDamage; // allows to move value from attack() to receiveAttack().


// wizard attack (implements attack from interface).
    @Override
    public double attack() {
        double damage;
        if (this.mana >= 5) {

            damage = getIntelligence();
            setMana(this.mana - 5);
            damage = damage + 0.1;
        } else {
            damage = 2;
            setMana(this.mana + 1);
            damage = damage + 0.2;
        }
       setAttackDamage(damage);
        return attackDamage;
    }

    public void receiveAttack(double attackDamage) {
        setHp(this.getHp() - ((int) attackDamage));
    }


// constructors
    public Wizard(String type, String name, int hp, int mana, int intelligence) {
        super(type, name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
    }

    public Wizard() {
        super();
        setMana(generateWizardMana());
        setIntelligence(generateWizardIntelligence());
        setHp(generateWizardHp());
    }

    @Override
    public String toString() {
        return "Wizard{" +
                "type='" + super.getType() + '\'' +
                "id='" + super.getId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", hp=" + super.getHp() +
                ", isAlive=" + super.isAlive() +
                "stamina=" + mana +
                ", strength=" + intelligence +
                '}';
    }

    // random generators
    public static int generateWizardHp (){
        Random a = new Random();
        return a.nextInt(100,201);
    }

    public static int generateWizardMana (){
        Random a = new Random();
        return a.nextInt(10,51);
    }

    public static int generateWizardIntelligence(){
        Random a = new Random();
        return a.nextInt(1,11);
    }


//setters and getters
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public static double getAttackDamage() {
        return attackDamage;
    }

    public static void setAttackDamage(double attackDamage) {
        Wizard.attackDamage = attackDamage;
    }
}
