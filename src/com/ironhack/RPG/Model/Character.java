package com.ironhack.RPG.Model;

import java.util.UUID;

public abstract class Character {

    private String id;
    private String name;
    private int hp; //number representing the health points
    private boolean isAlive;

    public Character( String name, int hp) {
        this.id = UUID.randomUUID().toString();
        setName(name);
        setHp(hp);
        setAlive(true);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String setRandomName

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
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

    public boolean isAlive() {
        return isAlive;
    }
}
