package com.ironhack.RPG.Logs;

import com.ironhack.RPG.Services.Menu;
import com.ironhack.RPG.Utils.Colors;
import com.ironhack.RPG.Utils.Emoji;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Log {

//Initial information about the GAME
    public static void gameDescription(Scanner scanner){

        String paragraph1 = "In a universe existing amidst a dense\n" +
                "\033[90C" + "mesh of silicon atoms, after aeons of normalcy and routine\n" +
                "\033[90C" + "execution of logical operations,\n" +
                "\033[90C" + "it's inhabitants finally discovered the possibility of\n" +
                "\033[90C" + "doing something besides work.";
        String paragraph2 = "hey gathered in an unused corner of their Condensed \n" +
                "\033[90C" + "Possibilities Universe and started to tell tales about \n" +
                "\033[90C" + "fictional warriors and wizards engaging in amazing battles.";
        String paragraph3 = "Soon, this merely narrative after-office activity \n" +
                "\033[90C" + "became dull. The CPUnians needed more. The started crafting \n" +
                "\033[90C" + "armors, weapons, suits and wands. Many learned to \n" +
                "\033[90C" + "fight and cast spells. ";
        String paragraph4 = "Well, you know... time goes by, things get a bit out hand, \n" +
                "\033[90C" + "someone makes a drunken proposal, someone replies \n" +
                "\033[90C" + "\"you don't have the balls to do that\" and...";
        String paragraph5 = "... now they meet to fight 'till death!! ";
        String paragraph6 = "Two 1s come in... but one will leave converted into a 0. \n" +
                "\033[90C" + "Who will it be? Come and find out!\n" +
                "\033[90C" + "Welcome to... \n" +
                "\033[90C" + "BYTEFIGHT!!!!!";
                ArrayList <String> paragraphs = new ArrayList<>(List.of(paragraph1, paragraph2, paragraph3, paragraph4, paragraph5, paragraph6));
        for (String phrase : paragraphs){
            System.out.print("\033[90C");
            System.out.print(phrase + "\n\n");
            System.out.print("\033[s");
            System.out.print(Colors.CYAN_BOLD + "\033[100C" + "Press " + Colors.GREEN_BOLD + "[ENTER]" +
                    Colors.CYAN_BOLD + " to continue..." + Colors.RESET);
            while (!scanner.nextLine().equals("")){
                System.out.print("\033[u");
                System.out.print("\033[2K");
                System.out.print("\033[95C" + Emoji.CROSS_MARK +" Not a valid value. Press " + Colors.GREEN_BOLD + "[ENTER]" +
                        Colors.CYAN_BOLD + " to continue" + Colors.RESET);
            }
            System.out.print("\033[u");
            System.out.print("\033[2K");
        }
    }

    public static void errorInputLog(String message){
        Menu.clean();
        System.out.println("\n\n");
        System.out.println(message);
        System.out.print("\033[110C");
    }

}
