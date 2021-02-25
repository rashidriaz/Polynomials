package calculator.polynomials.dsa;

import java.util.Scanner;

public class IOStream {
    private static final Scanner input = new Scanner(System.in);

    public static double getDouble(String message) {
        System.out.print("\n Please Enter " + message + ":\t ");
        while (!input.hasNextDouble()) {
            System.out.println("Error!! You have entered an invalid number. Please Try Again");
            System.out.print("\n Please Enter a number:\t ");
            input.next();
        }
        double number = input.nextDouble();
        input.nextLine();
        return number;
    }

    public static int getInteger(String message) {
        System.out.print("\n Please Enter " + message + " number:\t ");
        while (!input.hasNextInt()) {
            System.out.println("\n\t\tError! Invalid number entered. Please Try Again!\n");
            System.out.print("\n Please Enter a number:\t ");
            input.next();
        }
        int number = input.nextInt();
        input.nextLine();
        return number;
    }

    public static char getCharacter() {
        return input.next().charAt(0);
    }

    public static void displayMenu() {
        System.out.println("Please choose one of the following options: ");
        System.out.println("\t1. Get Polynomials");
        System.out.println("\t2. Add Polynomials.");
        System.out.println("\t3. Display Result");
        System.out.println("\t3. Reset Polynomials");
        System.out.println("\t\t Press any other key to exit");
        System.out.print("\n\tPlease Enter your choice:\t");
    }

    public static void displayResults(Polynomial expression) {
        System.out.println("\n\n");
        for (int i = 0; i < expression.getCounter(); i++) {
            AlgebraicTerm term = expression.getTerm(i);
            if (i > 0 && term.coefficient > 0) {
                System.out.print(" + ");
            }
            printTerm(term);
            System.out.print("\t");
        }
        System.out.println("\n\n");
    }

    public static void printTerm(AlgebraicTerm term) {
        printNumber(term.coefficient, term.isCoefficientAnInteger());
        if (term.variable != '.'){
            System.out.print(" " + term.variable + "^");
            printNumber(term.exponent, term.isExponentAnInteger());
        }
    }
    public static void printNumber(double number, boolean isInteger){
        if (isInteger){
            System.out.print((int)number);
        }else{
            System.out.print(number);
        }
    }

    public static boolean askForUsersPermission(String message) {
        while (true) {
            System.out.print("\n" + message + ":\t");
            char decision = input.next().toLowerCase().charAt(0);
            if (decision == 'y') {
                return true;
            } else if (decision == 'n') {
                return false;
            } else {
                System.out.println("\nError!! Wrong option chosen. Please try again\n");
            }
        }
    }
}

