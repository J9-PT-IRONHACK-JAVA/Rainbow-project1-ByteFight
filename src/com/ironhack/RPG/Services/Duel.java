package com.ironhack.RPG.Services;
import com.ironhack.RPG.Logs.DuelLog;
import com.ironhack.RPG.Model.Character;
import com.ironhack.RPG.Model.Graveyard;
import com.ironhack.RPG.Model.Party;


//Servicio en el que se implementa la lógica del duelo.
public class Duel {
    private static int round; //Num ronda

    ////Dos objetos tipo Character que se batirán en duelo
    public static void duel(Character character1, Character character2, Party party1, Party party2, Graveyard graveyard){
        round = 1;
        DuelLog.chosenCharacters(character1, character2);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n\n\n\n");
        while ( character1.isAlive() && character2.isAlive()){
            DuelLog.displayAttack( round, character1, character2);
            character1.attack(character2);
            character2.attack(character1);
            DuelLog.displayStats(character1, character2);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            round++;
        }
        actualizePartyAndGraveyard(party1, party2, graveyard);
        DuelLog.displayWinnerAndLooser(character1,character2);
    }

    public static void actualizePartyAndGraveyard(Party party1, Party party2, Graveyard graveyard){
        for(Character character : party1.getTeam()){
            if (!character.isAlive()){
                graveyard.addToGraveyard(character);
             //   party1.removeCharacter(character);

            }
        }
        for(Character character : party2.getTeam()){
            if (!character.isAlive()){
                graveyard.addToGraveyard(character);
              //  party2.removeCharacter(character);
            }
        }
    }

}
