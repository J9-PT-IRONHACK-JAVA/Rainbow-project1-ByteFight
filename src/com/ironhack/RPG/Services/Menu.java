package com.ironhack.RPG.Services;


import com.ironhack.RPG.Displays.DisplayCharacters;
import com.ironhack.RPG.Displays.DisplayGraveyard;
import com.ironhack.RPG.Logs.PartyLog;
import com.ironhack.RPG.Model.Character;
import com.ironhack.RPG.Model.Graveyard;
import com.ironhack.RPG.Model.Party;
import com.ironhack.RPG.Utils.Banner;
import com.ironhack.RPG.Logs.Log;
import com.ironhack.RPG.Utils.Colors;
import com.ironhack.RPG.Utils.Emoji;
import java.util.Scanner;

public class Menu {

                        /*Welcome message and descriptions of the game -> called from MENU*/
    public static void welcome(Scanner scanner){
        Banner.gameNameBanner();
        Log.gameDescription(scanner);
        clean();
    }

    public static Party party1 = new Party();
    public static Party party2 = new Party();

    public static Graveyard graveyard = new Graveyard();

                        /*METHOD: How to create the parties - 3 options. -> called from MAIN*/
    public static void howPartyWillBeCreated(Scanner scanner){
        System.out.println("\n" + "\033[95C" + Colors.CYAN_BOLD + "How do you want to create the parties?\n\n" + Colors.RESET);

        System.out.println("\033[80C" + Colors.CYAN_BOLD + "[0] Manually\t\t[1] Automatically\t\t[2] From CSV\n\n" + Colors.RESET);
        System.out.print("\033[110C");
        String choice = scanner.nextLine();
        while (!(choice.equals("0") || choice.equals("1") || choice.equals("2"))) {
            Log.errorInputLog("\n\n" + "\033[80C" + Emoji.CROSS_MARK + Colors.CYAN_BOLD +
                    "  Invalid INPUT. Choose one of the next options and press " + Colors.GREEN_BOLD +  "[ENTER]\n\n" +
                    "\033[80C" + Colors.CYAN_BOLD + "[0] Manually\t\t[1] Automatically\t\t[2] From CSV\n\n" + Colors.RESET);
            choice = scanner.nextLine();
        }
        Menu.clean();
        switch (Integer.parseInt(choice)) {
            case 0 -> ManualParty.manuallyCreateBothParties(scanner, party1, party2);
            case 1 -> AutomaticPartyCreator.autoCreator(scanner, party1, party2);
            case 2 -> AutomaticPartyCreator.fromCsvCreator(scanner, party1, party2);
            default -> System.out.println("An error has occurred");
        }
    }

                /*METHOD: Show both parties and allow user to choose characters for the fight -> called from MAIN*/
    public static void tryFighterForBattle(Scanner scanner){
        while (party1.getPartySize() != 0 && party2.getPartySize() != 0){
            clean();
            /*First FIGHTER*/
            Character character1 = getAndDisplayCharacterForBattle(scanner, party1, "First");
            /*Second FIGHTER*/
            Character character2 = getAndDisplayCharacterForBattle(scanner, party2, "Second");

            Banner.fightBanner();
            Duel.duel(character1, character2, party1, party2, graveyard);

            //Show Graveyard
            System.out.println("\033[80C" + Colors.CYAN_BOLD + "[0] Show Graveyard\t\t[1] Continue\n\n" + Colors.RESET);
            System.out.print("\033[110C");
            String choice = scanner.nextLine();
            while (!(choice.equals("0") || choice.equals("1"))) {
                Log.errorInputLog("\n\n" + "\033[80C" + Emoji.CROSS_MARK + Colors.CYAN_BOLD +
                        "  Invalid INPUT. Choose one of the next options and press " + Colors.GREEN_BOLD +  "[ENTER]\n\n" +
                        "\033[80C" + Colors.CYAN_BOLD + "[0] Show Graveyard\t\t[1] Automatically\n\n" + Colors.RESET);
                choice = scanner.nextLine();
            }
            if (choice.equals("0")) {
                DisplayGraveyard.displayPartyGraveyard(graveyard);
                System.out.println("\033[90C" + Colors.CYAN_BOLD + Emoji.FINGER + "  Press " +
                        Colors.GREEN_BOLD + "[ENTER] " + Colors.CYAN_BOLD + "to continue...\n\n" + Colors.RESET);
                System.out.print("\033[110C");
                while (!scanner.nextLine().equals(""))
                    Log.errorInputLog("\033[90C" + Emoji.CROSS_MARK + Colors.CYAN_BOLD + "  Invalid INPUT. You must press " + Colors.GREEN_BOLD +
                            "[ENTER] " + Colors.CYAN_BOLD + "to continue\n\n" + Colors.RESET);
            }
            Menu.clean();
        }
        if (party1.getPartySize() == 0){
            System.out.println(Banner.WINNER);
            System.out.println("\033[90C" + Colors.PURPLE_BOLD + " Our WINNER today is: " + Colors.YELLOW_BOLD + party2.getPartyName() + Colors.RESET);
        }else if (party2.getPartySize() == 0){
            System.out.println(Banner.WINNER);
            System.out.println("\033[90C" + Colors.PURPLE_BOLD + " Our WINNER today is: " + Colors.YELLOW_BOLD + party1.getPartyName() + Colors.RESET);
        }else {
            System.out.println(Banner.TIE);
        }

    }


    //Private method that Displays the character selections and return the selected character -> called in this file
    private static Character getAndDisplayCharacterForBattle(Scanner scanner, Party party, String whichParty) {
        System.out.println("\n\n\n\n" + "\033[85C" + Colors.CYAN_BOLD + "Choose a character from the " +  whichParty +  " Party for the Fight\n\n");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        PartyLog.displayParty(party);
        /*While receives the index, the private method getCharacterIndex displays the character selections, and the character completeInfo*/
        int index = getCharacterIndex(scanner, party);
        Character character = party.getCharacterByIndex(index);
                    /*Continue with the second character selection*/
        System.out.println("\033[90C" + Colors.CYAN_BOLD + Emoji.FINGER + "  Press " +
                Colors.GREEN_BOLD + "[ENTER] " + Colors.CYAN_BOLD + "to continue...\n\n" + Colors.RESET);
        System.out.print("\033[110C");
        while (!scanner.nextLine().equals(""))
            Log.errorInputLog("\033[90C" + Emoji.CROSS_MARK + Colors.CYAN_BOLD + "  Invalid INPUT. You must press " + Colors.GREEN_BOLD +
                    "[ENTER] " + Colors.CYAN_BOLD +  "to continue\n\n" + Colors.RESET);
        clean();
        return character;
    }

     /*Private Method thar reads from user input -> checks (using another private method) ->
     if the input is correct, and returns the index of the selected Character -> is used in this file*/
    public static int getCharacterIndex(Scanner scanner, Party party) {
        System.out.println("\n" + "\033[80C" + Emoji.FINGER + Colors.CYAN_BOLD + "  Introduce the character index " + Colors.YELLOW_BOLD +
                "[NUM]" + Colors.CYAN_BOLD + ", and press " + Colors.GREEN_BOLD + "[ENTER]\n\n" + Colors.RESET);
    //    System.out.print("\033[s");
        System.out.print("\033[110C");
        String characterIndex = scanner.nextLine();
        while (!validValue(characterIndex, party.getPartySize(), 1) || characterIndex.equalsIgnoreCase("show")) {
            if (characterIndex.equalsIgnoreCase("show")) {
                clean();
                PartyLog.displayParty(party);
                System.out.println("\n" + "\033[80C" + Emoji.FINGER + Colors.CYAN_BOLD + "  Introduce the character index " + Colors.YELLOW_BOLD +
                        "[NUM]" + Colors.CYAN_BOLD + ", and press " + Colors.GREEN_BOLD + "[ENTER]\n\n" + Colors.RESET);
                System.out.print("\033[110C");
            }else{
                Log.errorInputLog("\033[80C" + Emoji.CROSS_MARK + Colors.CYAN_BOLD + "  Invalid INPUT. Enter a number between " +
                        Colors.YELLOW_BOLD + "[" + 1 + "]" + Colors.CYAN_BOLD + " and " + party.getPartySize() + ", and press " +
                        Colors.GREEN_BOLD + "[ENTER]\n\n" + Colors.RESET + "\033[85C" + Emoji.FINGER + Colors.CYAN_BOLD + "  Enter " +
                        Colors.GREEN_BOLD + "[SHOW]" + Colors.CYAN_BOLD + " if you want to see all party\n\n" + Colors.RESET);
            }
            characterIndex = scanner.nextLine();
        }
        clean();
        int index = Integer.parseInt(characterIndex) - 1 ;
        /*Displays the selection character process*/
        PartyLog.displayCharacterSelection(party1, index);
        /*Displays the image of the character with the complete info*/
        DisplayCharacters.displayCharacterInfo(party.getCharacterByIndex(index));
        return index;
    }

    /*method that allows check the input before casting it to Number in order to avoid Exceptions ->
    is used in the METHOD: TryFightersForBattle, in this File*/
    public static boolean validValue(String characterIndex, int max, int min){
        if (!characterIndex.matches("[0-9]+"))
            return false;
        return (Integer.parseInt(characterIndex) <= (max) && Integer.parseInt(characterIndex) >= min);
    }



    public static void clean() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}


