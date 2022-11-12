package com.ironhack.RPG.Services;
import com.ironhack.RPG.Logs.DuelLog;
import com.ironhack.RPG.Model.Character;




//Servicio en el que se implementa la lógica del duelo.
public class Duel {
    private static int round; //Num ronda

    ////Dos objetos tipo Character que se batirán en duelo
    public static void duel(Character character1, Character character2){
        round = 1;
        DuelLog.chosenCharacters(character1, character2);
        while ( character1.isAlive() && character2.isAlive()){
            DuelLog.displayAttack( round, character1, character2);
            character1.attack(character2);
            character2.attack(character1);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            DuelLog.displayStats( round, character1, character2);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            round++;
        }
        DuelLog.displayWinnerAndLooser(character1,character2);
    }

}
