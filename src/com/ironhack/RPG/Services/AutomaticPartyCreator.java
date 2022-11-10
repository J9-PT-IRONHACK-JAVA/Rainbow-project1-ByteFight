package com.ironhack.RPG.Services;

import com.ironhack.RPG.Logs.PartyLog;
import com.ironhack.RPG.Model.Party;
import com.ironhack.RPG.Model.Warrior;
import com.ironhack.RPG.Model.Wizard;
import com.ironhack.RPG.Utils.Banner;
import com.ironhack.RPG.Utils.Colors;
import com.ironhack.RPG.Utils.Emoji;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Fill both parties with random values
public class AutomaticPartyCreator {
    public static void autoCreator(Party party1, Party party2){
        Scanner scan = new Scanner (System.in);
//Fills the first Party with a Random Generator
        party1.authomaticParty();
        PartyLog.displayParty(party1);
//banner....
        Banner.partyCreatorConfirmation();
        System.out.println("\033[95C" + Colors.CYAN_BOLD + "Press [ENTER] to create the Second Party\n\n" + Colors.RESET);
        while (!scan.nextLine().equals(""))
            System.out.println("\033[95C" + Emoji.CROSS_MARK + "  Invalid INPUT. Press [ENTER] to create the Second Party\n\n");
        Menu.clean();
//Fills the second Party with a Random Generator, but with fixed size
        party2.authomaticParty(party1.getPartySize());
        PartyLog.displayParty(party2);
 //banner
        Banner.partyCreatorConfirmation();
        System.out.println("\033[100C" + Colors.CYAN_BOLD + "Press [ENTER] to continue...\n\n");
        while (!scan.nextLine().equals("")) {
            System.out.println("\033[95C" + Emoji.CROSS_MARK + "  Invalid INPUT. Press [ENTER] to continue\n\n");
        }
        scan.close();
    }

//Static class that extract the method fillParty, that fills the parties from CSV
    private static void fillParty(Party party, Scanner scan) {
        String line;
        while(party.getPartySize() < 20 && scan.hasNext()){
            line = scan.nextLine();
            String[] characterInfo = line.split(", ");
            if (characterInfo[0].equals("warrior"))
                party.addCharacter(new Warrior(characterInfo[0], characterInfo[1], Integer.parseInt(characterInfo[2]),
                        Integer.parseInt(characterInfo[3]), Integer.parseInt(characterInfo[4])));
            else if (characterInfo[0].equals("wizard"))
                party.addCharacter(new Wizard(characterInfo[0], characterInfo[1], Integer.parseInt(characterInfo[2]),
                        Integer.parseInt(characterInfo[3]), Integer.parseInt(characterInfo[4])));
        }
    }

//Fills both parties reading from a done CSV file
    public static void fromCsvCreator(Party party1, Party party2){
        Scanner response = new Scanner(System.in);
        File partiesCreator = new File("../partiesCreator.csv");
        try {
            Scanner scan = new Scanner(partiesCreator);
//Fill the first Party using the static method fillParty
            fillParty(party1, scan);
            PartyLog.displayParty(party1);
            System.out.println(party1.getPartySize());
//banner
            Banner.partyCreatorConfirmation();
            System.out.println("\033[95C" + Colors.CYAN_BOLD + "Press [ENTER] to create the Second Party\n\n" + Colors.RESET);
            while (!response.nextLine().equals(""))
                System.out.println("\033[95C" + Emoji.CROSS_MARK + "  Invalid INPUT. You must press [ENTER] to continue\n\n");
            Menu.clean();
//Fill the second Party using the static method fillParty
            fillParty(party2, scan);
            PartyLog.displayParty(party2);
//banner
            Banner.partyCreatorConfirmation();
            System.out.println("\033[100C" + Colors.CYAN_BOLD + "Press [ENTER] to continue...\n\n");
            while (!response.nextLine().equals(""))
                System.out.println("\033[95C" + Emoji.CROSS_MARK + "  Invalid INPUT. You must press [ENTER] to continue\n\n");
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        response.close();
    }
}
