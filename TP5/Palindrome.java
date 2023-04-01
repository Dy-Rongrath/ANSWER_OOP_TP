package TP5;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please give a word to check: ");
        String word = scanner.nextLine();
        System.out.print("Choose method (REV, LOOP): ");
        String method = scanner.nextLine();
        scanner.close();
        boolean isPalindrome = false;
        if (method.equalsIgnoreCase("REV")) {
            isPalindrome = checkPalindromeReverse(word);
        } else if (method.equalsIgnoreCase("LOOP")) {
            isPalindrome = checkPalindromeLoop(word);
        } else {
            System.out.println("Invalid method selected. Please choose either REV or LOOP.");
        }
        if (isPalindrome) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is not a Palindrome");
        }
    }

    public static boolean checkPalindromeReverse(String word) {
        String reversedWord = new StringBuilder(word).reverse().toString();
        return word.equalsIgnoreCase(reversedWord);
    }

    public static boolean checkPalindromeLoop(String word) {
        int length = word.length();
        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
