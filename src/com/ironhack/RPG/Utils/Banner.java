package com.ironhack.RPG.Utils;

public class Banner {
    public static final String GAME_NAME = "\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t" + Colors.PURPLE_BOLD + "______           _________ _______  _______ _________ _______          _________\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t(  ___ \\ |\\     /|\\__   __/(  ____ \\(  ____ \\\\__   __/(  ____ \\|\\     /|\\__   __/\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t| (   ) )( \\   / )   ) (   | (    \\/| (    \\/   ) (   | (    \\/| )   ( |   ) (   \n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t| (__/ /  \\ (_) /    | |   | (__    | (__       | |   | |      | (___) |   | |   \n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t|  __ (    \\   /     | |   |  __)   |  __)      | |   | | ____ |  ___  |   | |   \n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t| (  \\ \\    ) (      | |   | (      | (         | |   | | \\_  )| (   ) |   | |   \n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t| )___) )   | |      | |   | (____/\\| )      ___) (___| (___) || )   ( |   | |   \n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t|/ \\___/    \\_/      )_(   (_______/|/       \\_______/(_______)|/     \\|   )_(   \n\n" + Colors.RESET;

    public static final String[] OUR_NAMES = {Colors.RED + "Ester Ramos", Colors.CYAN + "Daniel Lopez", Colors.BLUE + "Alissia Frolova", Colors.GREEN + "Adrián Trigo", GAME_NAME };

//Display of the game creators names and the Banner with the Game_Name
    public static void gameNameBanner(){
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + Colors.PURPLE + "CREATED BY: \n");
        System.out.print("\t\t\t\t\t\t\t\t\t\t");
        try {
            for (String name : OUR_NAMES) {
                Thread.sleep(1000);
                System.out.print(name + "\t\t\t\t\t");
            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
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
