package ru.kiianov.foxminded.anagram;

import java.util.Scanner;

public class AnagramConsoleApplication {

    public static void main(String[] args) {
        AnagramMaker anagramMaker = new AnagramMaker();
        try (Scanner scanner = new Scanner(System.in)) {
            String inputString;
            do {
                inputString = scanner.nextLine();
                System.out.println(anagramMaker.makeAnagram(inputString));
            } while (!inputString.equalsIgnoreCase("exit"));
        }
    }
}
