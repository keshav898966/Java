package Task1;

import java.util.Scanner;

public class Calculator {
    public static void add(double a, double b) {
        System.out.println(a+b);
    }

    public static void subtract(double a, double b) {
        System.out.println(a-b);
    }

    public static void multiply(double a, double b) {
        System.out.println(a*b);
    }

    public static void divide(double a, double b) {
       try {
           System.out.println(a/b);
       }catch (ArithmeticException e){
           System.out.println(e);
       }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Simple Calculator ===");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            int choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Exiting calculator. Goodbye!");
                System.exit(1);
                continue;
            } else if (choice>5) {
                System.out.println("You enter invalid no");
                continue;

            }

            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();


            switch (choice) {
                case 1:
                    add(num1, num2);
                    break;
                case 2:
                    subtract(num1, num2);
                    break;
                case 3:
                    multiply(num1, num2);
                    break;
                case 4:
                     divide(num1, num2);
                    break;
            }
        }
    }
    }
