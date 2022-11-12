package com.ironhack.RPG.Utils;
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


    public static final String FIGHT_START = "\n\n\n\n" + Colors.YELLOW_BOLD +
            "\t\t\t\t\t|''||''| '||'  '||' '||''''|     '||''''| '||'  ..|'''.|  '||'  '||' |''||''|     '||''|.   '||''''|   ..|'''.|  '||' '|.   '|'  .|'''.| \n" +
            "\t\t\t\t\t   ||     ||    ||   ||  .        ||  .    ||  .|'     '   ||    ||     ||         ||   ||   ||  .    .|'     '   ||   |'|   |   ||..  ' \n" +
            "\t\t\t\t\t   ||     ||''''||   ||''|        ||''|    ||  ||    ....  ||''''||     ||         ||'''|.   ||''|    ||    ....  ||   | '|. |    ''|||. \n" +
            "\t\t\t\t\t   ||     ||    ||   ||           ||       ||  '|.    ||   ||    ||     ||         ||    ||  ||       '|.    ||   ||   |   |||  .     '||\n" +
            "\t\t\t\t\t  .||.   .||.  .||. .||.....|    .||.     .||.  ''|...'|  .||.  .||.   .||.       .||...|'  .||.....|  ''|...'|  .||. .|.   '|  |'....|' \n\n\n\n" + Colors.RESET;




    public static final String WINNER = "\n\n\n\n" +
            "\033[70C" + Colors.GREEN_BOLD + "oooooo   oooooo     oooo ooooo ooooo      ooo ooooo      ooo oooooooooooo ooooooooo.   \n" +
            "\033[70C" + Colors.GREEN_BOLD + " `888.    `888.     .8'  `888' `888b.     `8' `888b.     `8' `888'     `8 `888   `Y88. \n" +
            "\033[70C" + Colors.GREEN_BOLD + "  `888.   .8888.   .8'    888   8 `88b.    8   8 `88b.    8   888          888   .d88' \n" +
            "\033[70C" + Colors.GREEN_BOLD + "   `888  .8'`888. .8'     888   8   `88b.  8   8   `88b.  8   888oooo8     888ooo88P'  \n" +
            "\033[70C" + Colors.GREEN_BOLD + "    `888.8'  `888.8'      888   8     `88b.8   8     `88b.8   888    \"     888`88b.    \n" +
            "\033[70C" + Colors.GREEN_BOLD + "     `888'    `888'       888   8       `888   8       `888   888       o  888  `88b.  \n" +
            "\033[70C" + Colors.GREEN_BOLD + "      `8'      `8'       o888o o8o        `8  o8o        `8  o888ooooood8 o888o  o888o \n\n\n" + Colors.RESET;


    public static final String TIE = "\n\n\n\n" +
            "\033[70C" + Colors.PURPLE_BOLD + "ooooooooooooo ooooo oooooooooooo \n" +
            "\033[70C" + Colors.PURPLE_BOLD + "8'   888   `8 `888' `888'     `8 \n" +
            "\033[70C" + Colors.PURPLE_BOLD + "     888       888   888         \n" +
            "\033[70C" + Colors.PURPLE_BOLD + "     888       888   888oooo8    \n" +
            "\033[70C" + Colors.PURPLE_BOLD + "     888       888   888    \"    \n" +
            "\033[70C" + Colors.PURPLE_BOLD + "     888       888   888       o \n" +
            "\033[70C" + Colors.PURPLE_BOLD + "    o888o     o888o o888ooooood8 \n\n\n" + Colors.RESET;


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
