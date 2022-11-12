package com.ironhack.RPG.Services;

import com.ironhack.RPG.Displays.DisplayCharacters;
import com.ironhack.RPG.Logs.Log;
import com.ironhack.RPG.Logs.PartyLog;
import com.ironhack.RPG.Model.Party;
import com.ironhack.RPG.Model.Warrior;
import com.ironhack.RPG.Model.Wizard;
import com.ironhack.RPG.Model.Character;
import com.ironhack.RPG.Utils.Banner;
import com.ironhack.RPG.Utils.Colors;
import com.ironhack.RPG.Utils.Emoji;

import java.util.Scanner;

public class ManualParty {
    public static void manuallyCreateBothParties(Scanner scanner, Party party1, Party party2) {
        int partySize;
        partySize = askPartyNameAndLength_BuildParty(scanner, party1, 0);
        for (int i = 0; i < partySize; i++) {
            askDetails_BuildCharacter_And_AddToParty(scanner, party1, (partySize - i));
        }
        System.out.println("\n" + "\033[95C" + Emoji.OK + Colors.PURPLE_BOLD + " The FIRST party is Created!\n\n " + Colors.RESET);
        PartyLog.displayParty(party1);
        Banner.partyCreatorConfirmation();
        System.out.println("\033[90C" + Emoji.FINGER + Colors.CYAN_BOLD + "  Press " + Colors.GREEN_BOLD +  "[ENTER] " +
                Colors.CYAN_BOLD + "to create the second Party\n\n" + Colors.RESET);
        System.out.print("\033[110C");
        while (!scanner.nextLine().equals(""))
            Log.errorInputLog("\033[90C" + Emoji.CROSS_MARK + Colors.CYAN_BOLD + "  Invalid INPUT. Press " + Colors.GREEN_BOLD + "[ENTER] " +
                    Colors.CYAN_BOLD + "to continue\n\n" + Colors.RESET);

        partySize = askPartyNameAndLength_BuildParty(scanner, party2, partySize);
        for (int i = 0; i < partySize; i++) {
            askDetails_BuildCharacter_And_AddToParty(scanner, party2, (partySize - i));
        }
        System.out.println("\n" + "\033[95C" + Emoji.OK + Colors.PURPLE_BOLD + " The SECOND party is Created!\n\n " + Colors.RESET);
        PartyLog.displayParty(party2);
        Banner.partyCreatorConfirmation();
        System.out.println("\033[90C" + Emoji.FINGER + Colors.CYAN_BOLD + "  Press " + Colors.GREEN_BOLD +  "[ENTER] " +
                Colors.CYAN_BOLD + "to START the Fight\n\n" + Colors.RESET);
        System.out.print("\033[110C");
        while (!scanner.nextLine().equals(""))
            Log.errorInputLog("\033[90C" + Emoji.CROSS_MARK + Colors.CYAN_BOLD + "  Invalid INPUT. Press " + Colors.GREEN_BOLD + "[ENTER] " +
                    Colors.CYAN_BOLD + "to continue\n\n" + Colors.RESET);
        Menu.clean();
    }

    //Party preparing for fill
    public static int askPartyNameAndLength_BuildParty(Scanner scanner, Party party, int size) {

            //Party NAME
        System.out.println("\n" + "\033[90C" + Emoji.FINGER + Colors.CYAN_BOLD + "  Please enter a name for your party\n\n" + Colors.RESET);
        System.out.print("\033[110C");
        String name = scanner.nextLine();
        while (name.length() < 1) {
            Log.errorInputLog("\n\n" + "\033[80C" + Emoji.CROSS_MARK + Colors.CYAN_BOLD +
                    "  Invalid INPUT. The name has to contains at least " + Colors.YELLOW_BOLD + "[" +  1 + "]" +
                            Colors.CYAN_BOLD + " character\n\n" + Colors.RESET);
            name = scanner.nextLine();
        }
        Menu.clean();
        party.setPartyName(name);

            //Party SIZE
        if (size == 0){
            System.out.println("\n" + "\033[95C" + Emoji.OK + Colors.PURPLE_BOLD + " Party " +
                    Colors.YELLOW_BOLD + "[" + party.getPartyName() + "]" + Colors.CYAN_BOLD + "  has been created.\n" +
                    Colors.RESET);
            System.out.println("\n" + "\033[70C" + Emoji.FINGER + Colors.CYAN_BOLD +
                    "  Next, please set the size (number of players) of your party. It must be between " + Colors.YELLOW_BOLD + "[" + 3 + "]" +
                            Colors.CYAN_BOLD + " and " + Colors.YELLOW_BOLD + "[" + 20 + "]" + Colors.CYAN_BOLD + " players.\n\n" + Colors.RESET);
            System.out.print("\033[110C");
            String partySize = scanner.nextLine();
            while (!Menu.validValue(partySize, 20, 3)) {
                Log.errorInputLog("\033[80C" + Emoji.CROSS_MARK + Colors.CYAN_BOLD + "  Invalid INPUT. Enter a number between " +
                                Colors.YELLOW_BOLD + "[" + 3 + "]" + Colors.CYAN_BOLD + " and " +
                                Colors.YELLOW_BOLD + "[" + 20 + "]" + Colors.CYAN_BOLD + ", and press " +
                        Colors.GREEN_BOLD + "[ENTER]\n\n" + Colors.RESET);
                partySize = scanner.nextLine();
            }
            size = Integer.parseInt(partySize);
        }
        Menu.clean();
        System.out.println("\n\n" + "\033[85C" + Emoji.OK + Colors.PURPLE_BOLD + "  Thanks! The size for party " +
                Colors.YELLOW_BOLD + "[" + party.getPartyName() + "]" + Colors.CYAN_BOLD + " was set to " + Colors.YELLOW_BOLD + "[" + size + "]" + "\n" + Colors.RESET);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n\n" + "\033[85C" + Colors.GREEN_BOLD + "Remember that both teams/parties will have the same size!" + Colors.RESET);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n\n" + "\033[85C" + Colors.GREEN_BOLD +  "We are now ready to create the players for this party!" + Colors.RESET);
        return size;
    }

    //Create Characters and fills the party
    public static void askDetails_BuildCharacter_And_AddToParty(Scanner scanner, Party party, int size) {
        Menu.clean();
        String type = insertType(scanner);
        String name = insertName(type, scanner);
        Menu.clean();
        int hp = insertHp(type, scanner);
        Menu.clean();
        int energy = insertEnergy(type, scanner);
        Menu.clean();
        int force = insertForce(type, scanner);
        if (type.equals("warrior")){
            Character character = new Warrior(type, name, hp, energy, force);
            party.addCharacter(character);
            DisplayCharacters.displayCharacterInfo(character);
        }else if (type.equals("wizard")){
            Character character = new Wizard(type, name, hp, energy, force);
            party.addCharacter(character);
            DisplayCharacters.displayCharacterInfo(character);
        }
        System.out.println("\033[95C" + Colors.PURPLE_BOLD + Emoji.NEW_MEMBER + "  " + Colors.YELLOW_BOLD +
                "[" + (size - 1) + "]" + Colors.CYAN_BOLD + " characters left to create\n\n" + Colors.RESET);
        System.out.println("\033[95C" + Colors.CYAN_BOLD + Emoji.FINGER + "  Press " +
                Colors.GREEN_BOLD + "[ENTER] " + Colors.CYAN_BOLD + "to continue...\n\n" + Colors.RESET);
        System.out.print("\033[110C");
        while (!scanner.nextLine().equals(""))
            Log.errorInputLog("\033[90C" + Emoji.CROSS_MARK + Colors.CYAN_BOLD + "  Invalid INPUT. You must press " + Colors.GREEN_BOLD +
                    "[ENTER] " + Colors.CYAN_BOLD +  "to continue\n\n" + Colors.RESET);
        Menu.clean();
    }

                    //Character TYPE
    private static String insertType(Scanner scanner){
        System.out.println("\n" + "\033[85C" + Emoji.FINGER + Colors.CYAN_BOLD + "  Please select the type of character to create\n\n" + Colors.RESET);
        System.out.println("\033[95C" + Colors.CYAN_BOLD + "[0] Warrior\t\t[1] Wizard\n\n" + Colors.RESET);
        System.out.print("\033[110C");
        String type = scanner.nextLine();
        while (!(type.equals("0") || type.equals("1"))) {
            Log.errorInputLog("\n\n" + "\033[80C" + Emoji.CROSS_MARK + Colors.CYAN_BOLD +
                    "  Invalid INPUT. Choose one of the next options and press " + Colors.GREEN_BOLD + "[ENTER]\n\n" +
                    "\033[100C" + Colors.CYAN_BOLD + "[0] Warrior\t\t[1] Wizard\n\n" + Colors.RESET);
            type = scanner.nextLine();
        }
        Menu.clean();
        return (type.equals("0") ? "warrior" : "wizard");
    }

                    //Character NAME
    private static String insertName(String type, Scanner scanner){
        System.out.println("\n" + "\033[90C" + Emoji.FINGER + Colors.CYAN_BOLD + "  Please, input the name for your " +
                Colors.YELLOW_BOLD + "[" + type + "]" + Colors.CYAN_BOLD + " player\n\n" + Colors.RESET);
        System.out.print("\033[110C");
        String name = scanner.nextLine();
        while (name.length() < 1) {
            Log.errorInputLog("\n\n" + "\033[80C" + Emoji.CROSS_MARK + Colors.CYAN_BOLD +
                    "  Invalid INPUT. The name has to contains at least " + Colors.YELLOW_BOLD + "[" + 1 + "]" + Colors.CYAN_BOLD + " character\n\n" + Colors.RESET);
            name = scanner.nextLine();
        }
        Menu.clean();
        return name;
    }

                                //Character HP
     private static int insertHp(String type, Scanner scanner){
        String hp = "";
        if (type.equals("warrior")){
            System.out.println("\n" + "\033[80C" + Emoji.FINGER + Colors.CYAN_BOLD + "  Please input the desired health points for your " +
                    Colors.YELLOW_BOLD + "[" + type + "]" + Colors.CYAN_BOLD + " player\n\n" + "\033[95C" + "you may input values between " +
                            Colors.YELLOW_BOLD + "[" + 100 + "]" + Colors.CYAN_BOLD + " and " + Colors.YELLOW_BOLD + "[" + 200 + "]\n\n" + Colors.RESET);
            System.out.print("\033[110C");
            hp = scanner.nextLine();
            while (!Menu.validValue(hp, 200, 100)) {
                Log.errorInputLog("\033[80C" + Emoji.CROSS_MARK + Colors.CYAN_BOLD + "  Invalid INPUT. Enter a number between " +
                                Colors.YELLOW_BOLD + "[" + 100 + "]" + Colors.CYAN_BOLD + " and " +
                                Colors.YELLOW_BOLD + "[" + 200 + "]" + Colors.CYAN_BOLD + ", and press " +
                        Colors.GREEN_BOLD + "[ENTER]\n\n" + Colors.RESET);
                hp = scanner.nextLine();
            }
        }else if (type.equals("wizard")){
            System.out.println("\n" + "\033[80C" + Emoji.FINGER + Colors.CYAN_BOLD + "  Please input the desired health points for your " +
                    type + " player\n\n" + "\033[95C" + "you may input values between " + Colors.YELLOW_BOLD + "[" + 50 + "]" +
                            Colors.CYAN_BOLD + " and "  + Colors.YELLOW_BOLD + "[" +  100 + "]n\n" + Colors.RESET);
            System.out.print("\033[110C");
            hp = scanner.nextLine();
            while (!Menu.validValue(hp, 100, 50)) {
                Log.errorInputLog("\033[80C" + Emoji.CROSS_MARK + Colors.CYAN_BOLD + "  Invalid INPUT. Enter a number between " +
                                Colors.YELLOW_BOLD + "[" + 50 + "]" + Colors.CYAN_BOLD + " and " +
                                Colors.YELLOW_BOLD + "[" + 100 + "]" + Colors.CYAN_BOLD + ", and press " +
                        Colors.GREEN_BOLD + "[ENTER]\n\n" + Colors.RESET);
                hp = scanner.nextLine();
            }
        }
         Menu.clean();
         return Integer.parseInt(hp);
    }

    // ask & store character 'energy' (stamina-mana)
    private static int insertEnergy(String type, Scanner scanner) {
        System.out.println("\n" + "\033[90C" + Emoji.FINGER + Colors.CYAN_BOLD + "  Please, input the energy for your " +
                Colors.YELLOW_BOLD + "[" + type + "]" + Colors.CYAN_BOLD + " player\n\n" + Colors.RESET);
        System.out.println("\033[95C" + Colors.CYAN_BOLD +  "You may input values between " + Colors.YELLOW_BOLD + "[" + 10 + "]" +
                Colors.CYAN_BOLD + " and " + Colors.YELLOW_BOLD + "[" + 50 + "]\n" + Colors.RESET);
        System.out.print("\033[110C");
        String energy = scanner.nextLine();
        while (!Menu.validValue(energy, 50, 10)) {
            Log.errorInputLog("\033[80C" + Emoji.CROSS_MARK + Colors.CYAN_BOLD + "  Invalid INPUT. Enter a number between " +
                    Colors.YELLOW_BOLD + "[" + 10 + "]" + Colors.CYAN_BOLD + " and " +
                    Colors.YELLOW_BOLD + "[" + 50 + "]" + Colors.CYAN_BOLD + ", and press " +
                    Colors.GREEN_BOLD + "[ENTER]\n\n" + Colors.RESET);
            energy = scanner.nextLine();
        }
        Menu.clean();
        return Integer.parseInt(energy);
    }

                        // ask & store character 'force' (strength-intelligence)
    private static int insertForce(String type, Scanner scanner) {
        String userInput = "";
        if (type.equals("warrior")) {
            System.out.println("\n" + "\033[80C" + Emoji.FINGER + Colors.CYAN_BOLD + "  Please input the desired strength for your " +
                    Colors.YELLOW_BOLD + "[" + type + "]" + Colors.CYAN_BOLD + " player\n\n" +
                    "\033[95C" + "you may input values between 1 and 10\n\n" + Colors.RESET);
            System.out.print("\033[110C");
            userInput = scanner.nextLine();
            while (!Menu.validValue(userInput, 10, 1)) {
                Log.errorInputLog("\033[80C" + Emoji.CROSS_MARK + Colors.CYAN_BOLD + "  Invalid INPUT. Enter a number between " +
                                Colors.YELLOW_BOLD + "[" + 1 + "]" + Colors.CYAN_BOLD + " and " + Colors.YELLOW_BOLD + "[" + 10 + "]" +
                        Colors.CYAN_BOLD + "and press " + Colors.GREEN_BOLD + "[ENTER]\n\n" + Colors.RESET);
                userInput = scanner.nextLine();
            }
        } else if (type.equals("wizard")) {
            System.out.println("\n" + "\033[80C" + Emoji.FINGER + Colors.CYAN_BOLD + "  Please input the desired intelligence for your " +
                    Colors.YELLOW_BOLD + "[" + type + "]" + Colors.CYAN_BOLD + " player\n\n");
            System.out.println("\033[85C" + "you may input values between " + Colors.YELLOW_BOLD + "[" + 1 + "]" +
                            Colors.CYAN_BOLD + " and "  + Colors.YELLOW_BOLD + "[" + 50 + "]\n" + Colors.RESET);
            System.out.print("\033[110C");
            userInput = scanner.nextLine();
            while (!Menu.validValue(userInput, 50, 1)) {
                Log.errorInputLog("\033[80C" + Emoji.CROSS_MARK + Colors.CYAN_BOLD + "  Invalid INPUT. Enter a number between " +
                        Colors.YELLOW_BOLD + "[" + 1 + "]" + Colors.CYAN_BOLD + " and "  +
                        Colors.YELLOW_BOLD + "[" + 50 + "]" + Colors.CYAN_BOLD + ", and press " +
                        Colors.GREEN_BOLD + "[ENTER]\n\n" + Colors.RESET);
                userInput = scanner.nextLine();
            }
        }
        Menu.clean();
        return Integer.parseInt(userInput);
    }


}