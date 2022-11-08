package com.ironhack.RPG.Displays;

import com.ironhack.RPG.Model.Character;
import com.ironhack.RPG.Model.Warrior;
import com.ironhack.RPG.Model.Wizard;
import com.ironhack.RPG.Utils.Colors;


import java.util.ArrayList;
import java.util.List;

public class DisplayCharacters {

    //ARRAY_LIST
    public static final ArrayList<String> WIZARD = new ArrayList<>(List.of(Colors.WIZARD + "\t\t\t\t                    ____\t\t\t\to",
            Colors.WIZARD + "\t\t\t\t                  .'* *.'\t\t\t\to",
            Colors.WIZARD + "\t\t\t\t               __/_*_*(_\t\t\t\to",
            Colors.WIZARD + "\t\t\t\t              / _______ \\\t\t\t\to",
            Colors.WIZARD + "\t\t\t\t             _\\_)/___\\(_/_\t\t\t\to",
            Colors.WIZARD + "\t\t\t\t            / _((\\- -/))_ \\\t\t\t\to",
            Colors.WIZARD + "\t\t\t\t             \\ \\())(-)(()/ /\t\t\t\to",
            Colors.WIZARD + "\t\t\t\t             ' \\(((()))/ '\t\t\t\to",
            Colors.WIZARD + "\t\t\t\t            / ' \\)).))/ ' \\\t\t\t\to",
            Colors.WIZARD + "\t\t\t\t          / _ \\ - | - /_  \\\t\t\t\to",
            Colors.WIZARD + "\t\t\t\t         (   ( .;''';. .'  )\t\t\t\to",
            Colors.WIZARD + "\t\t\t\t          _\\\"__ /    )\\ __\"/_\t\t\t\to",
            Colors.WIZARD + "\t\t\t\t            \\/  \\   ' /  \\/\t\t\t\to",
            Colors.WIZARD + "\t\t\t\t             .'  '...' ' )\t\t\t\to",
            Colors.WIZARD + "\t\t\t\t              / /  |  \\ \\\t\t\t\to",
            Colors.WIZARD + "\t\t\t\t             / .   .   . \\\t\t\t\to",
            Colors.WIZARD + "\t\t\t\t            /   .     .   \\\t\t\t\to",
            Colors.WIZARD + "\t\t\t\t           /   /   |   \\   \\\t\t\t\to",
            Colors.WIZARD + "\t\t\t\t         .'   /    b    '.  '.\t\t\t\to",
            Colors.WIZARD + "\t\t\t\t     _.-'    /     Bb     '-. '-._\t\t\to",
            Colors.WIZARD + "\t\t\t\t _.-'       |      BBb       '-.  '-.\t\t\to",
            Colors.WIZARD + "\t\t\t\t(________mrf\\____.dBBBb.________)____)\t\t\to"));

    public static final ArrayList<String> WARRIOR = new ArrayList<>(List.of(Colors.WARRIOR + "\t\t\t\t                                   Y\t\t\t\t\to",
            Colors.WARRIOR + "\t\t\t\t                                  _A_\t\t\t\t\to",
            Colors.WARRIOR + "\t\t\t\t                                 / | \\\t\t\t\t\to",
            Colors.WARRIOR + "\t\t\t\t                                |.-=-.|\t\t\t\t\to",
            Colors.WARRIOR + "\t\t\t\t                                )\\_|_/(\t\t\t\t\to",
            Colors.WARRIOR + "\t\t\t\t                             .=='\\   /`==.\t\t\t\to",
            Colors.WARRIOR + "\t\t\t\t                           .'\\   (`:')   /`.\t\t\t\to",
            Colors.WARRIOR + "\t\t\t\t                         _/_ |_.-' : `-._|__\\_\t\t\t\to",
            Colors.WARRIOR + "\t\t\t\t                        <___>'\\    :    /`<___>\t\t\t\to",
            Colors.WARRIOR + "\t\t\t\t                        /  /   >=======<  /  /\t\t\t\to",
            Colors.WARRIOR + "\t\t\t\t                      _/ .'   /  ,-:-.  \\/=,'\t\t\t\to",
            Colors.WARRIOR + "\t\t\t\t                     / _/    |__/v^v^v\\__) \\\t\t\t\to",
            Colors.WARRIOR + "\t\t\t\t                     \\(\\)     |V^V^V^V^V|\\_/\t\t\t\to",
            Colors.WARRIOR + "\t\t\t\t                      (\\\\     \\`---|---'/\t\t\t\to",
            Colors.WARRIOR + "\t\t\t\t                        \\\\     \\-._|_,-/\t\t\t\to",
            Colors.WARRIOR + "\t\t\t\t                         \\\\     |__|__|\t\t\t\t\to",
            Colors.WARRIOR + "\t\t\t\t                          \\\\   <___X___>\t\t\t\to",
            Colors.WARRIOR + "\t\t\t\t                           \\\\   \\..|../\t\t\t\t\to",
            Colors.WARRIOR + "\t\t\t\t                            \\\\   \\ | /\t\t\t\t\to",
            Colors.WARRIOR + "\t\t\t\t                             \\\\  /V|V\\\t\t\t\t\to",
            Colors.WARRIOR + "\t\t\t\t                              \\|/  |  \\\t\t\t\t\to",
            Colors.WARRIOR + "\t\t\t\t                               '--' `--`   \t\t\t\to"));


    public static final ArrayList<String> VS = new ArrayList<>(List.of(
            "                   ", "                   ", "                   ",
            "                   ", "                   ", "                   ", "                   ",
            "                   ", "                   ",
            Colors.BOLD_DARK_YELLOW + "'||'  '|'  .|'''.| ",
            Colors.BOLD_DARK_YELLOW + " '|.  .'   ||..  ' ",
            Colors.BOLD_DARK_YELLOW + "  ||  |     ''|||. ",
            Colors.BOLD_DARK_YELLOW + "   |||    .     '||",
            Colors.BOLD_DARK_YELLOW + "    |     |'....|' ",
            "                   ", "                   ", "                   ",
            "                   ", "                   ", "                   ",
            "                   ", "                   "
    ));

    public static void displayWizardInfo(Wizard wizard) {
        System.out.println(Colors.WIZARD + "\n\t\t\t\t\t\t\t\t                    ____ \n" +

                "\t\t\t\t\t\t\t\t                  .'* *.'\n" +
                "\t\t\t\t\t\t\t\t               __/_*_*(_\t\t\t\t\t" + Colors.CREATE + "A new WIZARD is created\n" +
                Colors.WIZARD + "\t\t\t\t\t\t\t\t              / _______ \\\n" +
                "\t\t\t\t\t\t\t\t             _\\_)/___\\(_/_ \n" +
                "\t\t\t\t\t\t\t\t            / _((\\- -/))_ \\\n" +
                "\t\t\t\t\t\t\t\t            \\ \\())(-)(()/ /\n" +
                "\t\t\t\t\t\t\t\t             ' \\(((()))/ '\t\t\t\t\t" + Colors.RESET + "Name:     " + wizard.getName().toUpperCase() + "\n" +
                Colors.WIZARD + "\t\t\t\t\t\t\t\t            / ' \\)).))/ ' \\\n" +
                "\t\t\t\t\t\t\t\t          / _ \\ - | - /_  \\\t\t\t\t\t" + Colors.RESET + "Hp:       " + wizard.getHp() + "\n" +
                Colors.WIZARD + "\t\t\t\t\t\t\t\t         (   ( .;''';. .'  )\n" +
                "\t\t\t\t\t\t\t\t          _\\\"__ /    )\\ __\"/_\t\t\t\t\t" + Colors.RESET + "Mana:     " + wizard.getMana() + "\n" +
                Colors.WIZARD + "\t\t\t\t\t\t\t\t            \\/  \\   ' /  \\/\n" +
                "\t\t\t\t\t\t\t\t             .'  '...' ' )\t\t\t\t\t" + Colors.RESET + "Strength: " + wizard.getIntelligence() + "\n" +
                Colors.WIZARD + "\t\t\t\t\t\t\t\t              / /  |  \\ \\\n" +
                "\t\t\t\t\t\t\t\t             / .   .   . \\\n" +
                "\t\t\t\t\t\t\t\t            /   .     .   \\\n" +
                "\t\t\t\t\t\t\t\t           /   /   |   \\   \\\n" +
                "\t\t\t\t\t\t\t\t         .'   /    b    '.  '.\n" +
                "\t\t\t\t\t\t\t\t     _.-'    /     Bb     '-. '-._ \n" +
                "\t\t\t\t\t\t\t\t _.-'       |      BBb       '-.  '-. \n" +
                "\t\t\t\t\t\t\t\t(________mrf\\____.dBBBb.________)____)\n\n" + Colors.RESET);
    }

    public static void displayWarriorInfo(Warrior warrior) {
        System.out.println(Colors.WARRIOR + "\n\t\t\t\t\t\t                                   Y \n" +
                "\t\t\t\t\t\t                                  _A_\n" +
                "\t\t\t\t\t\t                                 / | \\\t\t\t\t\t\t" + Colors.CREATE + "A new WARRIOR is created\n" +
                Colors.WARRIOR + "\t\t\t\t\t\t                                |.-=-.|\n" +
                "\t\t\t\t\t\t                                )\\_|_/(\n" +
                "\t\t\t\t\t\t                             .=='\\   /`==.\n" +
                "\t\t\t\t\t\t                           .'\\   (`:')   /`.\n" +
                "\t\t\t\t\t\t                         _/_ |_.-' : `-._|__\\_\t\t\t\t\t" + Colors.RESET + "Name:     " + warrior.getName().toUpperCase() + "\n" +
                Colors.WARRIOR + "\t\t\t\t\t\t                        <___>'\\    :    /`<___>\n" +
                "\t\t\t\t\t\t                        /  /   >=======<  /  / \t\t\t\t\t" + Colors.RESET + "Hp:       " + warrior.getHp() + "\n" +
                Colors.WARRIOR + "\t\t\t\t\t\t                      _/ .'   /  ,-:-.  \\/=,'\n" +
                "\t\t\t\t\t\t                     / _/    |__/v^v^v\\__) \\ \t\t\t\t\t" + Colors.RESET + "Stamina:  " + warrior.getStamina() + "\n" +
                Colors.WARRIOR + "\t\t\t\t\t\t                     \\(\\)     |V^V^V^V^V|\\_/\n" +
                "\t\t\t\t\t\t                      (\\\\     \\`---|---'/ \t\t\t\t\t" + Colors.RESET + "Strength: " + warrior.getStrength() + "\n" +
                Colors.WARRIOR + "\t\t\t\t\t\t                        \\\\     \\-._|_,-/\n" +
                "\t\t\t\t\t\t                         \\\\     |__|__|\n" +
                "\t\t\t\t\t\t                          \\\\   <___X___>\n" +
                "\t\t\t\t\t\t                           \\\\   \\..|../\n" +
                "\t\t\t\t\t\t                            \\\\   \\ | /\n" +
                "\t\t\t\t\t\t                             \\\\  /V|V\\\n" +
                "\t\t\t\t\t\t                              \\|/  |  \\\n" +
                "\t\t\t\t\t\t                               '--' `--`   \n\n" + Colors.RESET);
    }

// Displays the character info when you confirm the creation

    public static void displayCharacterInfo(Character character){
        if (character.getType().equals("warrior"))
            displayWarriorInfo((Warrior)character);
        else if (character.getType().equals("wizard"))
            displayWizardInfo((Wizard)character);
    }

}
