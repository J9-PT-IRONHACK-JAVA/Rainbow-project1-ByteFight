package com.ironhack.RPG.Displays;

import com.ironhack.RPG.Model.Character;
import com.ironhack.RPG.Model.Party;
import com.ironhack.RPG.Model.Warrior;
import com.ironhack.RPG.Model.Wizard;
import com.ironhack.RPG.Utils.Emoji;

import java.util.ArrayList;

public class DisplayGraveyard {

    public static void displayPartyGraveyard(Party party){
        ArrayList<Character> graveyard = party.getGraveyard();
        for(Character character : graveyard) {
                //Check type
            if (character.getType().equals("warrior"))
                displayWarriorAtGraveyard((Warrior) character);
            else if (character.getType().equals("wizard"))
                displayWizardAtGraveyard((Wizard) character);
        }
    }

    public static void displayWarriorAtGraveyard(Warrior character){
        System.out.print(Emoji.SKULL);
        System.out.println(character.toString());
    }

    public static void displayWizardAtGraveyard(Wizard character){
        System.out.print(Emoji.SKULL);
        System.out.println(character.toString());
    }

}
