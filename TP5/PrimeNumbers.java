package TP5;

import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number to list prime numbers from 2 to it: ");
        int num = scanner.nextInt();
        scanner.close();
        System.out.print("Prime numbers from 2 to " + num + " are: ");
        for (int i = 2; i <= num; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(i + " ");
            }
        }
        System.out.println("are prime numbers.");
    }
}
