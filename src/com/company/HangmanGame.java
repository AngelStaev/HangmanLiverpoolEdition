package com.company;

import java.util.ArrayList;
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

    ArrayList<String> letters = new ArrayList<>();

    public void newGame() {

        errors = 0;
        letters.clear();
        wordToFind = words[random.nextInt()];
        wordFound = new char[wordToFind.length()];

        for (int i = 0; i < wordToFind.length(); i++) {
            wordFound[i] = '_';
        }
    }

    public boolean isWordFound() {

        return wordToFind.contentEquals(new String(wordFound));
        
    }

    public static void main(String[] args) {


    }
}
