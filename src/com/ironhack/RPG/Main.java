package com.ironhack.RPG;

import java.util.UUID;

public class Main {

    public static void main(String[] args) {


        try {
            System.out.println(UUID.randomUUID().toString());
        }
        catch(Exception e) {
            //  Block of code to handle errors
        }


    }
}