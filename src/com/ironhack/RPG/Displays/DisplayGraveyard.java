package com.ironhack.RPG.Displays;

import com.ironhack.RPG.Model.*;
import com.ironhack.RPG.Model.Character;
import com.ironhack.RPG.Services.Menu;
import com.ironhack.RPG.Utils.Emoji;

import java.util.ArrayList;

public class DisplayGraveyard {

    public static void displayPartyGraveyard(Graveyard grav){
        ArrayList<Character> graveyard = grav.getGraveyard();
        for(Character character : graveyard) {
                //Check type
            if (character.getType().equals("warrior"))
                displayWarriorAtGraveyard((Warrior) character);
            else if (character.getType().equals("wizard"))
                displayWizardAtGraveyard((Wizard) character);
        }
    }

    public static void displayWarriorAtGraveyard(Warrior character){
        Menu.clean();
        System.out.println("\033[120C" + Emoji.SKULL);
        System.out.print(character.toString());
        System.out.println("\n\n\n");
    }

    public static void displayWizardAtGraveyard(Wizard character){
        Menu.clean();
        System.out.println("\033[120C" + Emoji.SKULL);
        System.out.print(character.toString());
        System.out.println("\n\n\n");
    }

}
