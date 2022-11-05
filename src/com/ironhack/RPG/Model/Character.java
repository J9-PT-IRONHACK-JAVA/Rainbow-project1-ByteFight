package com.ironhack.RPG.Model;

import java.util.Random;
import java.util.UUID;

public abstract class Character {

    private String id;
    private String name;
    private int hp; //number representing the health points
    private boolean isAlive;

    private String type; // define the type of player

    public Character(String type, String name, int hp) {
        this.id = UUID.randomUUID().toString();
        setName(name);
        setHp(hp);
        setAlive(true);
        setType(type);

    }

    public Character() {
        this.id = UUID.randomUUID().toString();
        setName(nameGenerator());
        setAlive(true);
    }

    public Character(String type){
        setType(type);
    }

    public void attack(Character attackedCharacter){

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public String getType() {
        return type;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public String nameGenerator(){
        String[] listNames = {"Alvaro", "Adrián", "Antonio", "Andrés", "Adán", "Borja", "Ataulfo", "Sigerico","Walia","Teodoredo", "Eurico ",
                "Khintila","Tulga","Chindasvinto", "Ervigio", "Witiza","Égica", "Rodrigo","Homer", "Lisa", "Marge", "Bart", "Maggie"};

        Random y = new Random();
        String randomName = listNames[y.nextInt(listNames.length)];
        return (randomName);
    }
}
