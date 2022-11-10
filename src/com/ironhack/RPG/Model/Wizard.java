package com.ironhack.RPG.Model;

import com.ironhack.RPG.Utils.Colors;
import com.ironhack.RPG.Utils.Emoji;

import java.util.Random;

public  class Wizard extends Character implements Attacker{

    private int mana;
    private int intelligence;
    private static boolean isStrongAttack;


// wizard attack (implements attack from interface).
    @Override
    public void attack(Character attackedCharacter) {
        int damage;

        if (this.mana >= 5) {
            setIsStrongAttack(true);
            damage = getIntelligence();

            attackedCharacter.setHp(attackedCharacter.getHp() - this.intelligence);
            if (attackedCharacter.getHp() <= 0) {
                attackedCharacter.setAlive(false);
            }

            setMana(this.mana - 5);
        } else {
            setIsStrongAttack(false);
            damage = 2;

            attackedCharacter.setHp(attackedCharacter.getHp() - this.intelligence);
            if (attackedCharacter.getHp() <= 0) {
                attackedCharacter.setAlive(false);
            }

            setMana(this.mana + 1);
        }
    }


    //'manual' constructor: generates a wizard
    public Wizard(String type, String name, int hp, int mana, int intelligence) {
        super(type, name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
    }


//'auto' constructor: generates a wizard automatically & randomly
    public Wizard() {
        super();
        setMana(generateWizardMana());
        setIntelligence(generateWizardIntelligence());
        setHp(generateWizardHp());
    }

    @Override
    public String toString() {
        return "\033[100C" + Emoji.WIZARD + Colors.WIZARD + "    name: " + super.getName() + "\n\n" +
                "\033[95C" + Colors.RESET + "hp: " + super.getHp() + "\t" +
                "stamina: " + mana + "\t" +
                "strength: " + intelligence;
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


// getters & setters
    public int getMana() {
        return mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public static boolean getIsStrongAttack() {
        return isStrongAttack;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public static void setIsStrongAttack(boolean isStrongAttack) {
        Wizard.isStrongAttack = isStrongAttack;
    }
}
