package com.iiitb.spe;

import java.util.Scanner;

public class Calculator {

    public static double squareRoot(double x) {
        if (x < 0) throw new IllegalArgumentException("Negative input");
        return Math.sqrt(x);
    }

    public static long factorial(int x) {
        if (x < 0) throw new IllegalArgumentException("Negative input");
        long result = 1;
        for (int i = 1; i <= x; i++) {
            result *= i;
        }
        return result;
    }

    public static double naturalLog(double x) {
        if (x <= 0) throw new IllegalArgumentException("Invalid input");
        return Math.log(x);
    }

    public static double power(double x, double y) {
        return Math.pow(x, y);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Scientific Calculator");
        System.out.println("1. Square Root");
        System.out.println("2. Factorial");
        System.out.println("3. Natural Log");
        System.out.println("4. Power");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println(squareRoot(sc.nextDouble()));
                break;
            case 2:
                System.out.println(factorial(sc.nextInt()));
                break;
            case 3:
                System.out.println(naturalLog(sc.nextDouble()));
                break;
            case 4:
                double base = sc.nextDouble();
                double exp = sc.nextDouble();
                System.out.println(power(base, exp));
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}