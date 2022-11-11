package com.ironhack.RPG.Logs;

import com.ironhack.RPG.Displays.DisplayCharacters;
import com.ironhack.RPG.Model.Character;
import com.ironhack.RPG.Model.Party;
import com.ironhack.RPG.Services.Menu;
import com.ironhack.RPG.Utils.Colors;

public class PartyLog {

    /*prints the current status of the party -> all the characters in order - with the index name to select them*/
    public static void displayParty(Party party) {
        System.out.println("\n\n");
        for (int i = 0; i < party.getTeam().size(); i++) {
            try {
                System.out.println("\033[110C" + Colors.YELLOW_BOLD + "[" + (i + 1) + "]\n");
                System.out.println(party.getTeam().get(i) + "\n\n\n");
                Thread.sleep(300);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

/*Displays the process of the character selection*/
    public static void displayCharacterSelection(Party party, int index){
        System.out.println("\n\n\n");
        System.out.print("\033[s");
        for (int i = 0; i < index; i++) {
            try {
                System.out.print("\033[u");
                System.out.println("\033[110C" + Colors.YELLOW_BOLD + "[" + i + "]\n");
                System.out.println(party.getTeam().get(i) + "\n\n\n");
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        Menu.clean();
    }
}
