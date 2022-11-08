package com.ironhack.RPG.Logs;

import com.ironhack.RPG.Model.Party;
import com.ironhack.RPG.Utils.Colors;

public class PartyLog {

    /*prints the current status of the party -> all the characters in order - with the index name to select them*/
    public static void showParty(Party party) {

        for (int i = 0; i < party.getTeam().size(); i++) {
            try {
                Thread.sleep(100);
                System.out.println("\033[70C" + Colors.YELLOW_BOLD + "[" + i + "]\n");
                System.out.println(party.getTeam().get(i) + "\n\n\n");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
