package calculator.polynomials.dsa;

public class Main {
    private static Polynomial polynomial1 = new Polynomial();
    private static Polynomial polynomial2 = new Polynomial();
    private static Polynomial resultingPolynomial = new Polynomial();

    public static void main(String[] args) {
        boolean exit = false;
        do {
            IOStream.displayMenu();
            char choice = IOStream.getCharacter();
            exit = performTask(Operations.fromChar(choice));
        } while (!exit);
    }

    private static boolean performTask(Operations operation) {
        if (operation == Operations.exit) return true;
        switch (operation) {
            case getPolynomials -> getPolynomials();
            case addPolynomials -> addPolynomials();
        }
        return false;
    }

    private static void addPolynomials() {
        int i =0, j= 0;

        while (i < polynomial1.getCounter() &&j < polynomial2.getCounter()){
            if (polynomial1)
        }
    }

    private static void getPolynomials() {
        if (polynomial1.isFull() || polynomial2.isFull()) {
            System.out.println("""


                    Error! The Polynomials already contains some value,
                     Try resetting the polynomials First and then try again

                    """);
            return;
        }
        System.out.println("For Polynomial 1");
        polynomial1 = getPolynomial();
        System.out.println("For Polynomial 2");
        polynomial2 = getPolynomial();
        System.out.println("Polynomial Stored Successfully!!");
        IOStream.displayResults(polynomial1);
        IOStream.displayResults(polynomial1);
    }

    private static Polynomial getPolynomial() {
        Polynomial polynomial = new Polynomial();
        boolean end;
        do {
            AlgebraicTerm term = getTerm();
            polynomial.addTerm(term);
            end = polynomial.isFull() ||
                    IOStream.askForUsersPermission("Would you like to add another term to this polynomial(y/n)");
        } while (!end);
        polynomial.sort();
        return polynomial;
    }

    private static AlgebraicTerm getTerm() {
        AlgebraicTerm term = new AlgebraicTerm();
        term.coefficient = IOStream.getDouble("co-efficient");
        term.variable = getVariable();
        if (term.variable == '.') {
            term.exponent = 0;
        } else {
            term.exponent = IOStream.getDouble("exponent value");

        }
        return term;
    }

    private static char getVariable() {
        System.out.print("\tEnter Variable (a - z) or '.' for constant term:\t");
        while (true) {
            char variable = IOStream.getCharacter();
            if (Character.isLetter(variable) || variable == '.') {
                return variable;
            }
            System.out.println("\n\nInvalid Variable name!! Please Try Again!\n\n");
        }
    }
}
