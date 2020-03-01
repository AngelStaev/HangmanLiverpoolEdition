package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
        wordToFind = words[random.nextInt(words.length)];
        wordFound = new char[wordToFind.length()];

        for (int i = 0; i < wordToFind.length(); i++) {
            wordFound[i] = '_';
        }
    }

    public boolean isWordFound() {

        return wordToFind.contentEquals(new String(wordFound));

    }

    public void enterLetter(String newCharEntered) {

        if (!letters.contains(newCharEntered)) {
            if (wordToFind.contains(newCharEntered)) {
                int index = wordToFind.indexOf(newCharEntered);

                while (index >= 0) {
                    wordFound[index] = newCharEntered.charAt(0);
                    index = wordToFind.indexOf(newCharEntered, index + 1);
                }
            } else {
                errors++;
            }


            letters.add(newCharEntered);
        }
    }

    public String wordFoundContent() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < wordFound.length; i++) {
            builder.append(wordFound[i]);

            if (i < wordFound.length - 1) {
                builder.append(" ");
            }
        }

        return builder.toString();
    }

    public void play() {
        try (Scanner input = new Scanner(System.in)) {
            while (errors < maxErrors) {
                System.out.println("\nEnter a letter : ");

                String str = input.next();

                if (str.length() > 1) {
                    str = str.substring(0, 1);
                }

                enterLetter(str);

                System.out.println("\n" + wordFoundContent());

                if (isWordFound()) {
                    System.out.println("\nYou win!");
                    break;
                } else {
                    System.out.println("\n=> Nb tries remaining : " + (maxErrors - errors));
                }
            }

            if (errors == maxErrors) {
                System.out.println("\nYou lose!");
                System.out.println("=> Word to find was : " + wordToFind);
            }
        }
    }


    public static void main(String[] args) {
        HangmanGame hangmanGame = new HangmanGame();
        hangmanGame.newGame();
        hangmanGame.play();

    }
}
