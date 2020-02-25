package com.company;

import java.util.Random;

public class HangmanGame {

    String[] words = {
            "KLOPP", "ADRIAN", "ALISSON", "LOVREN", "CLYNE",
            "MATIP", "VIRGIL", "ROBERTSON", "GOMES", "ALEXANDER-ARNOLD",
            "LALLANA", "MILNER", "WIJNALDUM", "HENDERSON", "OXLADE-CHAMBERLANE",
            "FABINHO", "MINAMINO", "KEITA", "JONES", "ELLIOTT", "SHAQIRI",
            "FIRMINO", "SALAH", "MANE", "ORIGI"
    };

    Random random = new Random();
    int maxErrors = 8;
    int errors;
    String wordToFind;
    char[] wordFound;


    public static void main(String[] args) {


    }
}
