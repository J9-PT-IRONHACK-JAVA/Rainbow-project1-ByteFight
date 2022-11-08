package com.ironhack.RPG.Services;

import com.ironhack.RPG.Model.Character;
import com.ironhack.RPG.Model.Party;
import com.ironhack.RPG.Utils.Colors;

public class DuelLog {

    /*prints the current status of the party -> all the characters in order - with the index name to select them*/
    public void showParty(Party party){
        Party showParty = getPartyByRefNum(partyReferenceNum);



    }

//Shows the attack the characters will execute
    public static void displayStats(int round, Character character1, Character caracter2 ){
        System.out.println("ROUND: " + round);

    }

//Shows the stats of the characters after the attack/round
    public static displayAttack(int round, Character character1, Character caracter2 ){

    }

    /*Prints the chosen characters for this battle*/
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
}