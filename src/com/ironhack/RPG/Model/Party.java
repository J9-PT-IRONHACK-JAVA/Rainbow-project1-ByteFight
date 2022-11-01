package com.ironhack.RPG.Model;

import java.util.ArrayList;
import java.util.Random;

public class Party {


    private String partyName;
    private ArrayList<Character> listCharacters;


    //Main Constructor
    public Party(String partyName) {
        setPartyName(partyName);
    }

    //Overload Constructor
    public Party() {
        setPartyName("Team1");
    }

    //Party automatic constructor
    public void authomaticParty(int partySize) {
        Random ran = new Random();
        int randomWarriroOrWizard = ran.nextInt(2);
        for (int y = 0; y < partySize; y++) {
            if (randomWarriroOrWizard == 1) {
                var warrior = new Warrior();//generate a random warrior
                warrior = (Warrior) checkName(warrior,listCharacters);
                listCharacters.add(warrior);

            } else if (randomWarriroOrWizard == 0) { //Generate a random Wizard
                var wizard = new Wizard();
                wizard = (Wizard) checkName(wizard,listCharacters);
                listCharacters.add(wizard);
            }

        }
    }
//Overload authomaticParty with a default size of the parties of 10
    public void authomaticParty() {
        int partySize = 10;
        Random ran = new Random();
        int randomWarriroOrWizard = ran.nextInt(2);
        for (int y = 0; y < partySize; y++) {
            if (randomWarriroOrWizard == 1) {
                var warrior = new Warrior();//generate a random warrior
                warrior = (Warrior) checkName(warrior,listCharacters);
                listCharacters.add(warrior);

            } else if (randomWarriroOrWizard == 0) { //Generate a random Wizard
                var wizard = new Wizard();
                wizard = (Wizard) checkName(wizard,listCharacters);
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
    public static boolean containsName(String name, ArrayList<Character> listCharacters){
        for(Character character : listCharacters){
            if (character.getName() == name){return true;}
            else{ return false;}
        }
        return false;
    }

    public static Character checkName(Character character, ArrayList<Character> listCharacters) {
        do{
            if (containsName(character.getName(), listCharacters) && containsName(character.getName() + " Jr", listCharacters)) {
                character.setName(character.nameGenerator());
            } else if (containsName(character.getName(), listCharacters)) {
                character.setName(character.getName() + " Jr");
            }
        } while ((containsName(character.getName(), listCharacters) || containsName(character.getName() + " Jr", listCharacters)));
        return character;
    }





    //showTeams (solo puedo enseñar un equipo a la vez, para enseñar los dos se tendría que llamar la función desde fuera a los dos equipos)
    //generateRandomParty
    //getGraveyard





}
