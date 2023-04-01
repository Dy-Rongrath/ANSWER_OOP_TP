package TP5;

public class OddNumbers {
    public static void main(String[] args) {
        RangeUtil rangeUtil = new RangeUtil(1, 500, 2);
        System.out.print("Odd numbers between 0 and 500: ");
        System.out.print(rangeUtil.toString());
    }
}
