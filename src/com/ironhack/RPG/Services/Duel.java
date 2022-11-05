package com.ironhack.RPG.Services;
import com.ironhack.RPG.Model.Character;
import com.ironhack.RPG.Model.Warrior;
import com.ironhack.RPG.Model.Wizard;




//Servicio en el que se implementa la lógica del duelo.
public class Duel {

    private static int round;
    //Num ronda
    ////Dos objetos tipo Character que se batirán en duelo


    public static void duel(Character character1, Character character2){
        round = 1;
        duelLog.displayStats( round, character1, character2);

        while ( character1.isAlive() && character2.isAlive()){


            duelLog.displayAttacks( round, character1, character2);
            character1.attack(character2);
            character2.attack(character1);
            duelLog.displayStats( round, character1, character2);
            round++;
        }


    }




}
