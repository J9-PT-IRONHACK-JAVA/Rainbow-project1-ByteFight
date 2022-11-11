package com.ironhack.RPG.Services;

import com.ironhack.RPG.Logs.Log;
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

public class AutomaticPartyCreator {

                //Method that fill both parties with random values -> called from MENU
    public static void autoCreator(Scanner scan, Party party1, Party party2) {
                        //Party METHOD: that Fills the first Party with a Random Generator
        party1.authomaticParty();
        PartyLog.displayParty(party1);
                        //Displays banner with the party Creation Confirmation
        Banner.partyCreatorConfirmation();
        System.out.println("\033[90C" + Colors.CYAN_BOLD + Emoji.FINGER + "  Press " + Colors.GREEN_BOLD + "[ENTER] " +
                        Colors.CYAN_BOLD + "to create the Second Party\n\n" + Colors.RESET);
        System.out.print("\033[110C");
                        //Treatment of the error input with a correct Log
        while (!scan.nextLine().equals(""))
            Log.errorInputLog("\033[85C" + Emoji.CROSS_MARK + Colors.CYAN_BOLD + "  Invalid INPUT. Press " + Colors.GREEN_BOLD + "[ENTER] " +
                            Colors.CYAN_BOLD + "to create the Second Party\n\n" + Colors.RESET);
        Menu.clean();
                        //Party METHOD: that Fills the second Party with a Random Generator, but with fixed size
        party2.authomaticParty(party1.getPartySize());
        PartyLog.displayParty(party2);
                        //Displays banner with the party Creation Confirmation
        Banner.partyCreatorConfirmation();
        System.out.println("\033[95C" + Emoji.FINGER + Colors.CYAN_BOLD + "  Press " + Colors.GREEN_BOLD +  "[ENTER] " +
                Colors.CYAN_BOLD + "to continue...\n\n" + Colors.RESET);
        System.out.print("\033[110C");
        while (!scan.nextLine().equals(""))
            Log.errorInputLog("\033[90C" + Emoji.CROSS_MARK + Colors.CYAN_BOLD + "  Invalid INPUT. Press " + Colors.GREEN_BOLD + "[ENTER] " +
                    Colors.CYAN_BOLD + "to continue\n\n" + Colors.RESET);
    }


                //METHOD that ills both parties reading from a done CSV file -> Called from MENU
    public static void fromCsvCreator(Scanner response, Party party1, Party party2){
        File partiesCreator = new File("../partiesCreator.csv");
        try {
            Scanner csvReader = new Scanner(partiesCreator);
                        //Fill the first Party using the static method fillParty
            fillParty(party1, csvReader);
            PartyLog.displayParty(party1);
                        //Displays banner with the party Creation Confirmation
            Banner.partyCreatorConfirmation();
            System.out.println("\033[90C" + Emoji.FINGER + Colors.CYAN_BOLD + "  Press " + Colors.GREEN_BOLD +
                    "[ENTER] " + Colors.CYAN_BOLD+  "to create the Second Party\n\n" + Colors.RESET);
            System.out.print("\033[110C");
            while (!response.nextLine().equals(""))
                Log.errorInputLog("\033[90C" + Emoji.CROSS_MARK + Colors.CYAN_BOLD + "  Invalid INPUT. You must press" +
                                Colors.GREEN_BOLD + "[ENTER] " + Colors.CYAN_BOLD + "to continue\n\n" + Colors.RESET);
            Menu.clean();
                        //Fill the second Party using the static method fillParty
            fillParty(party2, csvReader);
            PartyLog.displayParty(party2);
                        //Displays banner with the party Creation Confirmation
            Banner.partyCreatorConfirmation();
            System.out.println("\033[95C" + Colors.CYAN_BOLD + Emoji.FINGER + "  Press " + Colors.GREEN_BOLD +
                    "[ENTER] " + Colors.CYAN_BOLD + "to continue...\n\n" + Colors.RESET);
            System.out.print("\033[110C");
            while (!response.nextLine().equals(""))
                Log.errorInputLog("\033[90C" + Emoji.CROSS_MARK + Colors.CYAN_BOLD + "  Invalid INPUT. You must press " +
                        Colors.GREEN_BOLD + "[ENTER] " + Colors.CYAN_BOLD +  "to continue\n\n" + Colors.RESET);
            Menu.clean();
            csvReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


    //Private METHOD that one fills the parties from CSV -> used in fromCsvCreator() -> same File
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
}
