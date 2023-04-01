package TP5;

import java.util.Scanner;

public class CompanyProfits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] profits = new double[12];
        double totalProfit = 0;
        for (int i = 0; i < 12; i++) {
            System.out.print("Profit for month " + (i + 1) + " : ");
            profits[i] = scanner.nextDouble();
            totalProfit += profits[i];
        }
        scanner.close();
        System.out.println("Total profits for 12 months : " + String.format("%.2f", totalProfit));
    }
}
