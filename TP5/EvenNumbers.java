package TP5;

import java.util.Scanner;

public class EvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number A between 0 and 500: ");
        int a = scanner.nextInt();
        scanner.close();
        if (a < 1 || a >= 500) {
            System.out.println("Invalid input. A must be between 1 and 499.");
        } else {
            RangeUtil rangeUtil = new RangeUtil(a + (a % 2), 500, 2);
            System.out.print("Even numbers between " + a + " and 500: ");
            System.out.print(rangeUtil.toString());
        }
    }
}
