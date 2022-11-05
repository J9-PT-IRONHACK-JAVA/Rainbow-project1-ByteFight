package com.ironhack.RPG.Utils;

public class Banner {

    public static final String GAME_NAME = "\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t______           _________ _______  _______ _________ _______          _________\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t(  ___ \\ |\\     /|\\__   __/(  ____ \\(  ____ \\\\__   __/(  ____ \\|\\     /|\\__   __/\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t| (   ) )( \\   / )   ) (   | (    \\/| (    \\/   ) (   | (    \\/| )   ( |   ) (   \n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t| (__/ /  \\ (_) /    | |   | (__    | (__       | |   | |      | (___) |   | |   \n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t|  __ (    \\   /     | |   |  __)   |  __)      | |   | | ____ |  ___  |   | |   \n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t| (  \\ \\    ) (      | |   | (      | (         | |   | | \\_  )| (   ) |   | |   \n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t| )___) )   | |      | |   | (____/\\| )      ___) (___| (___) || )   ( |   | |   \n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t|/ \\___/    \\_/      )_(   (_______/|/       \\_______/(_______)|/     \\|   )_(   \n" +
            "                                                                                 ";

    public static final String[] OUR_NAMES = {Colors.RED + "Ester Ramos", Colors.CYAN + "Daniel Lopez", Colors.BLUE + "Alissia Frolova", Colors.GREEN + "Adrián Trigo", Colors.PURPLE + GAME_NAME };

    public static void printNames(){
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + Colors.PURPLE + "CREATED BY: \n");
        System.out.print("\t\t\t\t\t\t\t\t\t\t");
        try {
            for (String name : OUR_NAMES) {
                Thread.sleep(1000);
                System.out.print(name + "\t\t\t\t\t");
            }
        }catch(Exception e) {
            System.out.println(e);
        }
    }





}
