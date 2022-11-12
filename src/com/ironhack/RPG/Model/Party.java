package com.ironhack.RPG.Model;

import java.util.ArrayList;
import java.util.Random;

public class Party {

    private String partyName;
    private ArrayList<Character> listCharacters = new ArrayList<>();
    private static int numTeams =1;

    //Main Constructor
    public Party(String partyName) {
        setPartyName(partyName);
        numTeams++;
    }
    //Overload Constructor
    public Party() {
        setPartyName("Team" + numTeams);
        numTeams++;
    }

    //Party automatic constructor giving size
    public void authomaticParty(int partySize) {
        Random ran = new Random();
        for (int i = 0; i < partySize; i++) {
            int randomWarriorOrWizard = ran.nextInt(2);
            if (randomWarriorOrWizard == 1) {
                var warrior = new Warrior();//generate a random warrior
                checkName(warrior);
                listCharacters.add(warrior);

            } else if (randomWarriorOrWizard == 0) { //Generate a random Wizard
                var wizard = new Wizard();
                checkName(wizard);
                listCharacters.add(wizard);
            }
        }
    }
    //Overload authomaticParty with a default size
    public void authomaticParty() {
        int partySize = 15;
        Random ran = new Random();
        for (int i = 0; i < partySize; i++) {
            int randomWarriorOrWizard = ran.nextInt(2);
            if (randomWarriorOrWizard == 1) {
                var warrior = new Warrior();//generates a random warrior
                checkName(warrior);
                listCharacters.add(warrior);
            } else if (randomWarriorOrWizard == 0) { //Generate a random Wizard
                var wizard = new Wizard();//generates a random wizard
                checkName(wizard);
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



    //Add a character to the ArrayList of characters that represents the party
    public void addCharacter(Character character){
        listCharacters.add(character);
    }

    public void removeCharacter(int index) {

            listCharacters.remove(index);
    }


    //Return a character by the index, if index is out of Bounds, throw the Exception
    public Character getCharacterByIndex(int i) throws IndexOutOfBoundsException{
        if(i<0 || i > listCharacters.size()) {
            throw new IndexOutOfBoundsException();
        }else{
            return listCharacters.get(i);
        }
    }

    //Method that compares the names of the list and return TRUE if name already exists
    public boolean containsName(String name){
        for(Character character : this.listCharacters){
            if (character.getName().equals(name) ){return true;}
        }
        return false;
    }


    public void checkName(Character character) {
        while ((containsName(character.getName()) || containsName(character.getName() + " Jr"))){
            if (this.containsName(character.getName()) && this.containsName(character.getName().concat(" Jr"))) {
                character.setName(character.nameGenerator());  //generates a new random name
            } else if (containsName(character.getName())) {
                character.setName(character.getName().concat(" Jr"));
            }
        }
    }

    //Returns the arrayList of the character of the party is passed,  thar are isAlive=FALSE;
  /*  public ArrayList<Character> getGraveyard(){
        var graveyard = new ArrayList<Character>();
        for (Character character: this.listCharacters){
            if (!character.isAlive()){
                graveyard.add(character);
            }
        }
        return graveyard;
    }*/
}