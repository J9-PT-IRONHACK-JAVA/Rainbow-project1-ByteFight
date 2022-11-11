package com.ironhack.RPG.Services;

import com.ironhack.RPG.Displays.DisplayCharacters;
import com.ironhack.RPG.Model.Party;
import com.ironhack.RPG.Model.Warrior;
import com.ironhack.RPG.Model.Wizard;

import java.util.Scanner;

public class ManualParty {
    static Integer partiesSize = null;
    static boolean isParty1Created = false;
    static Party party1;
    static Party party2;
    static Warrior warrior;
    static Wizard wizard;


    public static void manuallyCreateBothParties() {
        askPartyNameAndLength_BuildParty();
        for (int i = 0; i < partiesSize; i++) {
            askDetails_BuildCharacter_And_AddToParty(party1);
        }
        askPartyNameAndLength_BuildParty();
        for (int i = 0; i < partiesSize; i++) {
            askDetails_BuildCharacter_And_AddToParty(party2);
        }
    }

    public static void askPartyNameAndLength_BuildParty() {
        var sc = new Scanner(System.in);
        String userInput = sc.nextLine();

        if (isParty1Created == false) {
            System.out.println("Please enter a name for your party/team...");
            String partyName = userInput;
            party1 = new Party(partyName);
            System.out.println("Party " + party1.getPartyName() + " has been created.\n" + "Next, please set the size (number of players)" +
                    "of your party. It must be between 3 and 20 players.\n");
            // TO-DO: change sout for call to a log method that prints party created to screen
            isParty1Created = true;

            while (partiesSize == null) {
                System.out.println("Please, input the desired size as a number: ");
                if ((Integer.parseInt(userInput) >= 3 && Integer.parseInt(userInput) <= 20)) {
                    partiesSize = Integer.parseInt(userInput);
                } else {
                    partiesSize = null;
                }
            }
            System.out.println("Thanks! The size for party " + party1.getPartyName() + " was set to " + partiesSize +
                    "\nRemember that both teams/parties will have the same size..." +
                    "\nWe are now ready to create the players for your first party...");

        } else if (isParty1Created) {
            System.out.println("Please enter a name for your party/team...");
            String partyName = userInput;
            party2 = new Party(partyName);
            System.out.println("Party " + party2.getPartyName() + " has been created.\n" + "To match the size of the other party, the " +
                    "size (number of players) of this party must be " + partiesSize);
            // TO-DO: change sout for call to a log method that prints party created to screen

            System.out.println("We are now ready to create the players for your second party...");
        }

        sc.close();
    }


    public static void askDetails_BuildCharacter_And_AddToParty(Party partyToFill) {
        String charType = null;
        String charName = null;
        Integer charHp = null;
        Integer charForce = null; // strength for warrior; intelligence for wizard.
        Integer charEnergy = null; // stamina for warrior; mana for wizard.
        var sc = new Scanner(System.in);
        String userInput = sc.nextLine();

        // ask & store character type
        while (charType == null) {
            System.out.println("Please select the type of character to create...\n" +
                    "   [0] warrior\n" +
                    "   [1] wizard\n");
            if (userInput == "0") {
                charType = "warrior";
            } else if (userInput == "1") {
                charType = "wizard";
            } else {
                charType = null;
            }
        }

        // ask & store character name
        while (charName == null) {
            System.out.println("Please, input a name for your " + charType + "player.");
            charName = userInput;
        }

        // ask & store character HP
        while (charHp == null) {
            if (charType == "warrior") {
                System.out.println("Please input the desired health points for your 'warrior' player\"" +
                        "you may input values between 100 and 200");
                if ((Integer.parseInt(userInput) >= 100) && (Integer.parseInt(userInput) <= 200)) {
                    charHp = Integer.parseInt(userInput);
                } else {
                    charHp = null;
                }

            } else if (charType == "wizard") {
                System.out.println("Please input the desired health points for your 'wizard' player\"" +
                        "you may input values between 50 and 100");

                if ((Integer.parseInt(userInput) >= 50) && (Integer.parseInt(userInput) <= 100)) {
                    charHp = Integer.parseInt(userInput);
                } else {
                    charHp = null;
                }

            }

        }


        // ask & store character 'force' (strength-intelligence)
        while (charForce == null) {
            if (charType == "warrior") {
                System.out.println("Please input the desired strength for your 'warrior' player\"" +
                        "you may input values between 1 and 10");
                if ((Integer.parseInt(userInput) >= 1) && (Integer.parseInt(userInput) <= 10)) {
                    charForce = Integer.parseInt(userInput);
                } else {
                    charForce = null;
                }

            } else if (charType == "wizard") {
                System.out.println("Please input the desired strength for your 'wizard' player\"" +
                        "you may input values between 1 and 50");

                if ((Integer.parseInt(userInput) >= 1) && (Integer.parseInt(userInput) <= 50)) {
                    charForce = Integer.parseInt(userInput);
                } else {
                    charForce = null;
                }

            }

        }


        // ask & store character 'energy' (stamina-mana)
        while (charEnergy == null) {
            System.out.println("Please input the desired stamina for your player\"" +
                    "you may input values between 10 and 50");
            if ((Integer.parseInt(userInput) >= 10) && (Integer.parseInt(userInput) <= 50)) {
                charEnergy = Integer.parseInt(userInput);
            } else {
                charEnergy = null;
            }
        }
        sc.close();

        // create Character (pass variables to constructor)
        if (charType == "warrior") {
            warrior = new Warrior(charType, charName, charHp, charEnergy, charForce);

            DisplayCharacters.displayWarriorInfo(warrior); // Alissia's display character
        } else if (charType == "wizard") {
            wizard = new Wizard(charType, charName, charHp, charEnergy, charForce);

            DisplayCharacters.displayWizardInfo(wizard); // Alissia's display character
        }


        // add Character to Party & confirm addition
        if (charType == "warrior") {
            partyToFill.addCharacter(warrior);
            // TO-DO: add call to log to display confirmation
        } else if (charType == "wizard") {
            partyToFill.addCharacter(wizard);
            // TO-DO: add call to log to display confirmation
        }


    }

}
