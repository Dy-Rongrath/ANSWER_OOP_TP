package TP5;

import java.util.Scanner;

public class PalindromeMaker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a word: ");
        String input = scanner.nextLine();
        String palindrome = makePalindrome(input);
        System.out.println(palindrome);
    }

    public static String makePalindrome(String str) {
        String reversedStr = new StringBuilder(str).reverse().toString();
        return str + reversedStr;
    }
}
