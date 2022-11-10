package com.ironhack.RPG.Services;
import com.ironhack.RPG.Logs.DuelLog;
import com.ironhack.RPG.Model.Character;




//Servicio en el que se implementa la lógica del duelo.
public class Duel {
    private static int round; //Num ronda

    ////Dos objetos tipo Character que se batirán en duelo
    public static void duel(Character character1, Character character2) throws InterruptedException {
        round = 1;
        //DuelLog duelLog = new DuelLog();
        DuelLog.chosenCharacters(character1, character2);
        while ( character1.isAlive() && character2.isAlive()){
            DuelLog.displayAttack( round, character1, character2);
            character1.attack(character2);
            Thread.sleep(500);
            character2.attack(character1);
            DuelLog.displayStats( round, character1, character2);
            Thread.sleep(500);
            round++;
        }
        DuelLog.displayWinnerAndLooser(character1,character2);
    }

}
