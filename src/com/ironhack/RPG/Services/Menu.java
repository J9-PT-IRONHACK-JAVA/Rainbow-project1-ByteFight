package com.ironhack.RPG.Services;


import com.ironhack.RPG.Displays.DisplayCharacters;
import com.ironhack.RPG.Logs.DuelLog;
import com.ironhack.RPG.Logs.PartyLog;
import com.ironhack.RPG.Model.Character;
import com.ironhack.RPG.Model.Party;
import com.ironhack.RPG.Utils.Banner;
import com.ironhack.RPG.Logs.Log;
import com.ironhack.RPG.Utils.Colors;
import com.ironhack.RPG.Utils.Emoji;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {



//Welcome message and descriptions of the game
    public static void welcome(Scanner scanner){
        Banner.gameNameBanner();
        Log.gameDescription(scanner);
        clean();
    }

    public static Party party1 = new Party();
    public static Party party2 = new Party();
//How to create the parties - 3 options
    public static void howPartyWillBeCreated(Scanner scanner){
        System.out.println("\n" + "\033[95C" + Colors.DARK_GREEN + "How do you want to create the parties?\n\n");

        System.out.println("\033[80C" + Colors.CYAN_BOLD + "[0] Manually\t\t[1] Automatically\t\t[2] From CSV\n\n");
        System.out.print("\033[s");
        System.out.print("\033[110C");
        String choice = scanner.nextLine();
        while (!(choice.equals("0") || choice.equals("1") || choice.equals("2"))) {
            System.out.print("\033[u");
            System.out.println("\033[80C" + Emoji.CROSS_MARK + "Invalid INPUT. Enter a number between 0 and 2, and press [ENTER]");
            System.out.print("\033[s");
            System.out.print("\033[110C");
            choice = scanner.nextLine();
        }
        Menu.clean();
        switch (Integer.parseInt(choice)) {
            case 0 -> System.out.println("Daniel class");//DanielClass > manualCreator(party1, party2);
            case 1 -> AutomaticPartyCreator.autoCreator(party1, party2);
            case 2 -> AutomaticPartyCreator.fromCsvCreator(party1, party2);
            default -> System.out.println("An error has occurred");
        }
    }

/*Static method that allows check the input before casting it to Number in order to avoid Exceptions*/
    private static boolean validValue(String characterIndex, int partyLength){
        if (!characterIndex.matches("[0-9]+"))
            return false;
        return Integer.parseInt(characterIndex) <= (partyLength) && Integer.parseInt(characterIndex) >= 1;
    }

/*Private Method thar reads from user input -> checks (using another private method) -> if the input is correct, and returns the
    index of the selected Character*/

    private static String getCharacterIndex(Scanner scanner, Party party) {
        String characterIndex = scanner.nextLine();
        System.out.print("\033[s");
        System.out.print("\033[110C");
        while (!validValue(characterIndex, party.getPartySize())){
            System.out.print("\033[u");
            System.out.println("\033[80C" + Emoji.CROSS_MARK + "Invalid INPUT. Enter a number between 1 and 20, and press [ENTER]");
            System.out.print("\033[s");
            System.out.print("\033[110C");
            characterIndex = scanner.nextLine();
        }
/*Displays the selection character process*/

/*Displays the image of the character with the complete info*/
        DisplayCharacters.displayCharacterInfo(party.getCharacterByIndex(Integer.parseInt(characterIndex) - 1));
        Menu.clean();
        return characterIndex;
    }

/*Show both parties and allow user to chose character for the fight*/
    public static void tryFighterForBattle(Scanner scanner){
        System.out.println("\n" + "\033[85C" + Colors.CYAN_BOLD + "Choose a character from the First Party for the Fight\n\n");
        System.out.println("\n" + "\033[85C" + Colors.CYAN_BOLD + "Introduce his index \"[NUM]\", and press [ENTER]\n\n");
        PartyLog.displayParty(party1);
/*While receives the index, the private method getCharacterIndex displays the character selections, and the character completeInfo*/
        Character character1 = party1.getCharacterByIndex((Integer.parseInt(getCharacterIndex(scanner, party1))) - 1);

        PartyLog.displayParty(party2);
        Character character2 = party2.getCharacterByIndex((Integer.parseInt(getCharacterIndex(scanner, party2))) - 1);
        Banner.fightBanner();
        Duel.duel(character1, character2);
    }




    public static void clean() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }




}
