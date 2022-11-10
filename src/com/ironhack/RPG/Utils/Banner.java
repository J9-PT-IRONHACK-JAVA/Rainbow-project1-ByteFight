package com.ironhack.RPG.Utils;

import java.awt.*;

public class Banner {
    public static final String GAME_NAME = "\n\n\n\n\n\n" + "\033[75C" + Colors.PURPLE_BOLD + "______           _________ _______  _______ _________ _______          _________\n" +
            "\033[75C" + "(  ___ \\ |\\     /|\\__   __/(  ____ \\(  ____ \\\\__   __/(  ____ \\|\\     /|\\__   __/\n" +
            "\033[75C" + "| (   ) )( \\   / )   ) (   | (    \\/| (    \\/   ) (   | (    \\/| )   ( |   ) (   \n" +
            "\033[75C" + "| (__/ /  \\ (_) /    | |   | (__    | (__       | |   | |      | (___) |   | |   \n" +
            "\033[75C" + "|  __ (    \\   /     | |   |  __)   |  __)      | |   | | ____ |  ___  |   | |   \n" +
            "\033[75C" + "| (  \\ \\    ) (      | |   | (      | (         | |   | | \\_  )| (   ) |   | |   \n" +
            "\033[75C" + "| )___) )   | |      | |   | (____/\\| )      ___) (___| (___) || )   ( |   | |   \n" +
            "\033[75C" + "|/ \\___/    \\_/      )_(   (_______/|/       \\_______/(_______)|/     \\|   )_(   \n\n" + Colors.RESET;

    public static final String[] OUR_NAMES = {Colors.BLUE_BOLD + "Daniel Lopez", Colors.YELLOW_BOLD + "Alissia Frolova", Colors.GREEN_BOLD + "Adrián Trigo", GAME_NAME };

//Display of the game creators names and the Banner with the Game_Name
    public static void gameNameBanner(){
        System.out.println("\033[106C" + Colors.PURPLE_BOLD + "CREATED BY: \n\n");
        System.out.print("\033[55C");
        try {
            for (String name : OUR_NAMES) {
                Thread.sleep(1000);
                System.out.print(name + "\t\t\t\t\t");
            }
            System.out.println("\n\n\n\n");
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void partyCreatorConfirmation(){
        System.out.println("\033[50C" + Colors.GREEN_BOLD + " ______                                                            _                                          ___       _ _       _ \n" +
                "\033[50C" + Colors.GREEN_BOLD + "(_____ \\           _                                  _           | |                                        / __)     | | |     | |\n" +
                "\033[50C" + Colors.GREEN_BOLD + " _____) )___  ____| |_ _   _     ____  ____ ____ ____| |_  ____ _ | |    ___ _   _  ____ ____ ____  ___  ___| |__ _   _| | |_   _| |\n" +
                "\033[50C" + Colors.GREEN_BOLD + "|  ____/ _  |/ ___)  _) | | |   / ___)/ ___) _  ) _  |  _)/ _  ) || |   /___) | | |/ ___) ___) _  )/___)/___)  __) | | | | | | | |_|\n" +
                "\033[50C" + Colors.GREEN_BOLD + "| |   ( ( | | |   | |_| |_| |  ( (___| |  ( (/ ( ( | | |_( (/ ( (_| |  |___ | |_| ( (__( (__( (/ /|___ |___ | |  | |_| | | | |_| |_ \n" +
                "\033[50C" + Colors.GREEN_BOLD + "|_|    \\_||_|_|    \\___)__  |   \\____)_|   \\____)_||_|\\___)____)____|  (___/ \\____|\\____)____)____|___/(___/|_|   \\____|_|_|\\__  |_|\n" +
                "\033[50C" + Colors.GREEN_BOLD + "                      (____/                                                                                               (____/   \n" + Colors.RESET);
    }


    public static final String FIGHT_START = "\n\n" + Colors.YELLOW_BOLD +
            "\t\t\t\t\t\t|''||''| '||'  '||' '||''''|     '||''''| '||'  ..|'''.|  '||'  '||' |''||''|     '||''|.   '||''''|   ..|'''.|  '||' '|.   '|'  .|'''.| \n" +
            "\t\t\t\t\t\t   ||     ||    ||   ||  .        ||  .    ||  .|'     '   ||    ||     ||         ||   ||   ||  .    .|'     '   ||   |'|   |   ||..  ' \n" +
            "\t\t\t\t\t\t   ||     ||''''||   ||''|        ||''|    ||  ||    ....  ||''''||     ||         ||'''|.   ||''|    ||    ....  ||   | '|. |    ''|||. \n" +
            "\t\t\t\t\t\t   ||     ||    ||   ||           ||       ||  '|.    ||   ||    ||     ||         ||    ||  ||       '|.    ||   ||   |   |||  .     '||\n" +
            "\t\t\t\t\t\t  .||.   .||.  .||. .||.....|    .||.     .||.  ''|...'|  .||.  .||.   .||.       .||...|'  .||.....|  ''|...'|  .||. .|.   '|  |'....|' " + Colors.RESET;

//Display of the Beginning of the Fight
    public static void fightBanner() {
        try {
            Thread.sleep(1000);
            System.out.println(FIGHT_START);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



}
