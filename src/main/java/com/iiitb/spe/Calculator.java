package com.iiitb.spe;

import java.util.Scanner;

public class Calculator {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    }

    public static double squareRoot(double x) {
        if (x < 0) throw new IllegalArgumentException("Invalid input");
        return Math.sqrt(x);
    }

    public static long factorial(int x) {
        if (x < 0) throw new IllegalArgumentException("Invalid input");
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

        while (true) {

            System.out.println("\n===== Scientific Calculator =====");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Square Root");
            System.out.println("6. Factorial");
            System.out.println("7. Natural Log");
            System.out.println("8. Power");
            System.out.println("9. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter two numbers: ");
                        System.out.println("Result: " +
                                add(sc.nextDouble(), sc.nextDouble()));
                        break;

                    case 2:
                        System.out.print("Enter two numbers: ");
                        System.out.println("Result: " +
                                subtract(sc.nextDouble(), sc.nextDouble()));
                        break;

                    case 3:
                        System.out.print("Enter two numbers: ");
                        System.out.println("Result: " +
                                multiply(sc.nextDouble(), sc.nextDouble()));
                        break;

                    case 4:
                        System.out.print("Enter two numbers: ");
                        System.out.println("Result: " +
                                divide(sc.nextDouble(), sc.nextDouble()));
                        break;

                    case 5:
                        System.out.print("Enter number: ");
                        System.out.println("Result: " +
                                squareRoot(sc.nextDouble()));
                        break;

                    case 6:
                        System.out.print("Enter integer: ");
                        System.out.println("Result: " +
                                factorial(sc.nextInt()));
                        break;

                    case 7:
                        System.out.print("Enter number: ");
                        System.out.println("Result: " +
                                naturalLog(sc.nextDouble()));
                        break;

                    case 8:
                        System.out.print("Enter base and exponent: ");
                        System.out.println("Result: " +
                                power(sc.nextDouble(), sc.nextDouble()));
                        break;

                    case 9:
                        System.out.println("Exiting Calculator!");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
