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

        String paragraph1 = "History of the game than we are creating....";
        String paragraph2 = "Game description, with the details of the actions we can do";
        String paragraph3 = "Basic rules, how we have to interact with the panel";
        ArrayList <String> paragraphs = new ArrayList<>(List.of(paragraph1, paragraph2, paragraph3));
        for (String phrase : paragraphs){
            System.out.print("\033[70C");
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
