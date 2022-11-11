package com.ironhack.RPG.Logs;

import com.ironhack.RPG.Displays.DisplayCharacters;
import com.ironhack.RPG.Model.Character;
import com.ironhack.RPG.Model.Party;
import com.ironhack.RPG.Utils.Colors;

public class DuelLog {


                    //Shows the attack the characters will execute
    public static void displayAttack(int round, Character character1, Character character2 ){

    }
                //Shows the stats of the characters after the attack/round
    public static void displayStats(int round, Character character1, Character character2){

    }

            /*Displays the chosen characters for this battle -> BigImages without info*/
    public static void chosenCharacters(Character fighter1, Character fighter2){
            System.out.println("\n");
            if (fighter1.getType().equals("warrior") && fighter2.getType().equals("wizard"))
                for (int i = 0; i < DisplayCharacters.WARRIOR.size(); i++)
                    System.out.print(DisplayCharacters.WARRIOR.get(i) + DisplayCharacters.VS.get(i) + DisplayCharacters.WIZARD.get(i) + "\n");
            else if (fighter1.getType().equals("warrior") && fighter2.getType().equals("warrior"))
                for (int i = 0; i < DisplayCharacters.WARRIOR.size(); i++)
                    System.out.print(DisplayCharacters.WIZARD.get(i) + DisplayCharacters.VS.get(i) + DisplayCharacters.WARRIOR.get(i) + "\n");
            else if (fighter1.getType().equals("wizard") && fighter2.getType().equals("warrior"))
                for (int i = 0; i < DisplayCharacters.WARRIOR.size(); i++)
                    System.out.print(DisplayCharacters.WIZARD.get(i) + DisplayCharacters.VS.get(i) + DisplayCharacters.WARRIOR.get(i) + "\n");
            else if (fighter1.getType().equals("wizard") && fighter2.getType().equals("wizard"))
                for (int i = 0; i < DisplayCharacters.WIZARD.size(); i++)
                    System.out.print(DisplayCharacters.WIZARD.get(i) + DisplayCharacters.VS.get(i) + DisplayCharacters.WIZARD.get(i) + "\n");
            System.out.println(Colors.RESET);
    }

    //Shows the stats of the characters after the attack/round
    public static void displayWinnerAndLooser(Character character1, Character character2){

    }





}