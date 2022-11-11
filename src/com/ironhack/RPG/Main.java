package com.ironhack.RPG;

import com.ironhack.RPG.Services.Menu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Menu.welcome(scanner);
        Menu.howPartyWillBeCreated(scanner);
        Menu.tryFighterForBattle(scanner);
        scanner.close();
    }
}