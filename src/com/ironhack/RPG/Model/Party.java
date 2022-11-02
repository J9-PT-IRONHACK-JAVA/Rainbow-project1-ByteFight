package com.ironhack.RPG.Model;

import java.util.ArrayList;
import java.util.Random;

public class Party {


    private String partyName;
    private ArrayList<Character> listCharacters;

    private int numTeams;


    //Main Constructor
    public Party(String partyName) {

        setPartyName(partyName);
    }

    //Overload Constructor
    public Party() {

        setPartyName("Team" + numTeams);
    }

    //Party automatic constructor
    public void authomaticParty(int partySize) {
        Random ran = new Random();
        for (int y = 0; y < partySize; y++) {
            int randomWarriorOrWizard = ran.nextInt(2);
            if (randomWarriorOrWizard == 1) {
                var warrior = new Warrior();//generate a random warrior
                warrior = (Warrior) checkName(warrior);
                listCharacters.add(warrior);

            } else if (randomWarriorOrWizard == 0) { //Generate a random Wizard
                var wizard = new Wizard();
                wizard = (Wizard) checkName(wizard);
                listCharacters.add(wizard);
            }

        }
    }
//Overload authomaticParty with a default size of the parties of 10
    public void authomaticParty() {
        int partySize = 10;
        Random ran = new Random();
        for (int y = 0; y < partySize; y++) {
            int randomWarriroOrWizard = ran.nextInt(2);
            if (randomWarriroOrWizard == 1) {
                var warrior = new Warrior();//generate a random warrior
                warrior = (Warrior) checkName(warrior);
                listCharacters.add(warrior);

            } else if (randomWarriroOrWizard == 0) { //Generate a random Wizard
                var wizard = new Wizard();
                wizard = (Wizard) checkName(wizard);
                listCharacters.add(wizard);
            }

        }
    }



    public String getPartyName(){
        return this.partyName;
    }

    public void setPartyName(String partyName){
        this.partyName = partyName;
    }

    public int getPartySize(){
        return listCharacters.size();
    }

    public ArrayList<Character> getTeam(){
        return listCharacters;
    }



    //Añade un personaje creado fuera de la clase
    public void addCharacter(Character character){
        listCharacters.add(character);
    }



    //Devuelve el personaje por índice, en caso de poner un indice fuera de rango devuelve el primero
    public Character getCharacterByIndex(int i){
        if(i<0 || i > listCharacters.size()) {
            return listCharacters.get(0);
        }else{
            return listCharacters.get(i);
        }
    }



    //Método que compara el nombre del parametro con los nombres de la lista, si coincide devuelve TRUE
    public boolean containsName(String name){
        for(Character character : this.listCharacters){
            if (character.getName() == name){return true;}
            else{ return false;}
        }
        return false;
    }

    public Character checkName(Character character) {
        do{
            if (containsName(character.getName()) && containsName(character.getName() + " Jr")) {
                character.setName(character.nameGenerator());
            } else if (containsName(character.getName())) {
                character.setName(character.getName() + " Jr");
            }
        } while ((containsName(character.getName()) || containsName(character.getName() + " Jr")));
        return character;
    }





    //showTeams (solo puedo enseñar un equipo a la vez, para enseñar los dos se tendría que llamar la función desde fuera a los dos equipos)
    //generateRandomParty
    //getGraveyard





}
