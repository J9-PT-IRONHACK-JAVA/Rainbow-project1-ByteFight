package com.ironhack.RPG.Logs;

import com.ironhack.RPG.Displays.DisplayCharacters;
import com.ironhack.RPG.Model.Character;
import com.ironhack.RPG.Model.Party;
import com.ironhack.RPG.Model.Warrior;
import com.ironhack.RPG.Model.Wizard;
import com.ironhack.RPG.Utils.Banner;
import com.ironhack.RPG.Utils.Colors;
import com.ironhack.RPG.Utils.Emoji;

public class DuelLog {

                    //Shows the attacks the characters will execute
    public static void displayAttack(int round, Character character1, Character character2 ){

        System.out.println("\033[105C" + Colors.YELLOW_BOLD + "[ROUND " + round + "]\n\n" + Colors.RESET);
        System.out.print("\033[90C");
        displayAttackByCharacter(character1);
        System.out.print("\033[90C");
        displayAttackByCharacter(character2);

    }
                //Method that returns the attack of one fighter to de Method -> displayAttack: in this class
    public static void displayAttackByCharacter(Character character){
        if (character.getType().equals("warrior")){
            System.out.print("Warrior " + character.getName() + " -> ");
            if (character.getIsStrongAttack()){
                System.out.print(Emoji.DAGGER + Colors.RED_BOLD + "  HEAVY ATTACK\n\n" + Colors.RESET);
            }else{
                System.out.print(Emoji.PUSH_PIN + Colors.BLUE_BOLD + "  WEAK ATTACK\n\n" + Colors.RESET);
            }
        }else if (character.getType().equals("wizard")){
            System.out.print("Wizard " + character.getName() + " -> ");
            if (character.getIsStrongAttack()){
                System.out.print(Emoji.ATTACK + Colors.RED_BOLD + "  FIREBALL ATTACK\n\n" + Colors.RESET);
            }else{
                System.out.print(Emoji.MAGIC_WAND + Colors.BLUE_BOLD + "  STAFF HIT ATTACK\n\n" + Colors.RESET);
            }
            System.out.print("\n\n");
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
                //Shows the stats of the characters after the attack/round
    public static void displayStats(Character character1, Character character2){
        System.out.print("\033[90C" + Emoji.BLOOD + Colors.PURPLE_BOLD + "  Stats of the fighters after the attacks  " + Emoji.BLOOD +  "\n\n\n" +  Colors.RESET);
        System.out.print(character1);
        System.out.print("\n\n\n");
        System.out.print(character2);
        System.out.print("\n\n\n");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //Shows the stats of the characters after the attack/round
    public static void displayWinnerAndLooser(Character character1, Character character2){
         if (!character1.isAlive() && !character2.isAlive()){
             System.out.println(Banner.TIE);
         }else{
             System.out.println(Banner.WINNER);
             if (!character1.isAlive()) DisplayCharacters.displayCharacterInfo(character2);
             else if(!character2.isAlive()) DisplayCharacters.displayCharacterInfo(character1);
             else System.out.println("something goes wrong.....");
         }
    }


            /*Displays the chosen characters for this battle -> BigImages without info*/
    public static void chosenCharacters(Character fighter1, Character fighter2){
            System.out.println("\n");
            if (fighter1.getType().equals("warrior") && fighter2.getType().equals("wizard"))
                for (int i = 0; i < DisplayCharacters.WARRIOR.size(); i++)
                    System.out.print(DisplayCharacters.WARRIOR.get(i) + DisplayCharacters.VS.get(i) + DisplayCharacters.WIZARD.get(i) + "\n");
            else if (fighter1.getType().equals("warrior") && fighter2.getType().equals("warrior"))
                for (int i = 0; i < DisplayCharacters.WARRIOR.size(); i++)
                    System.out.print(DisplayCharacters.WIZARD.get(i) + DisplayCharacters.VS.get(i) + DisplayCharacters.WARRIOR.get(i) + "\n");
            else if (fighter1.getType().equals("wizard") && fighter2.getType().equals("warrior"))
                for (int i = 0; i < DisplayCharacters.WARRIOR.size(); i++)
                    System.out.print(DisplayCharacters.WIZARD.get(i) + DisplayCharacters.VS.get(i) + DisplayCharacters.WARRIOR.get(i) + "\n");
            else if (fighter1.getType().equals("wizard") && fighter2.getType().equals("wizard"))
                for (int i = 0; i < DisplayCharacters.WIZARD.size(); i++)
                    System.out.print(DisplayCharacters.WIZARD.get(i) + DisplayCharacters.VS.get(i) + DisplayCharacters.WIZARD.get(i) + "\n");
            System.out.println(Colors.RESET);
    }

}