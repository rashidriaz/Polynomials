package calculator.polynomials.dsa;

public class Main {
    private static Polynomial polynomial1 = new Polynomial();
    private static Polynomial polynomial2 = new Polynomial();
    private static final Polynomial resultingPolynomial = new Polynomial();

    public static void main(String[] args) {
        boolean exit;
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
            case displayResult -> displayPolynomials();
            case resetPolynomial -> resetPolynomials();
        }
        return false;
    }

    private static void displayPolynomials() {
        if (polynomial1.getCounter() == 0 || polynomial2.getCounter() == 0) {
            System.out.println("\n\nThere is nothing to show!!\n\n");
            return;
        }
        IOStream.displayResults(polynomial1);
        IOStream.displayResults(polynomial2);
        if (resultingPolynomial.getCounter() != 0) {
            IOStream.displayResults(resultingPolynomial);
        }
    }
    private static void addPolynomials() {
        int polynomial1Counter = 0;
        int polynomial2Counter = 0;
        while (polynomial1Counter < polynomial1.getCounter() || polynomial2Counter < polynomial2.getCounter()) {
            if (polynomial1.getCounter() > polynomial1Counter
                    && polynomial2Counter == polynomial2.getCounter()) {
                resultingPolynomial.addTerm(polynomial1.getTerm(polynomial1Counter));
                polynomial1Counter++;
            } else if (polynomial2.getCounter() > polynomial2Counter
                    && polynomial1Counter == polynomial1.getCounter()) {
                resultingPolynomial.addTerm(polynomial2.getTerm(polynomial2Counter));
                polynomial2Counter++;
            } else {
                compareValues(polynomial1Counter, polynomial2Counter);
                polynomial1Counter++;
                polynomial2Counter++;
            }
        }
        displayPolynomials();
    }

    private static void compareValues(int polynomial1Counter, int polynomial2Counter) {
        boolean exponentsAreEqual = polynomial1.getTerm(polynomial1Counter).exponent ==
                polynomial2.getTerm(polynomial2Counter).exponent;
        boolean exponentOf1stPolynomialsTermIsGreater =
                polynomial1.getTerm(polynomial1Counter).exponent > polynomial2.getTerm(polynomial2Counter).exponent;
        boolean exponentOf2ndPolynomialsTermIsGreater =
                polynomial1.getTerm(polynomial1Counter).exponent < polynomial2.getTerm(polynomial2Counter).exponent;
        if (exponentsAreEqual) {
            double newCoefficient = polynomial1.getTerm(polynomial1Counter).coefficient
                    + polynomial2.getTerm(polynomial2Counter).coefficient;
            AlgebraicTerm term = new AlgebraicTerm(newCoefficient,
                    polynomial1.getTerm(polynomial1Counter).variable,
                    polynomial1.getTerm(polynomial1Counter).exponent);
            resultingPolynomial.addTerm(term);
        } else if (exponentOf1stPolynomialsTermIsGreater) {
            resultingPolynomial.addTerm(polynomial1.getTerm(polynomial1Counter));
        } else if (exponentOf2ndPolynomialsTermIsGreater) {
            resultingPolynomial.addTerm(polynomial2.getTerm(polynomial2Counter));
        }
    }

    private static void getPolynomials() {
        if (polynomial1.isFull() || polynomial2.isFull()) {
            System.out.println("""


                    Error! The Polynomials already contains some value,Try resetting the polynomials First and then try again

                    """);
            return;
        }
        System.out.println("For Polynomial 1");
        polynomial1 = getPolynomial();
        System.out.println("For Polynomial 2");
        polynomial2 = getPolynomial();
        System.out.println("Polynomial Stored Successfully!!");
        IOStream.displayResults(polynomial1);
        IOStream.displayResults(polynomial2);
    }

    private static Polynomial getPolynomial() {
        Polynomial polynomial = new Polynomial();
        boolean end;
        do {
            AlgebraicTerm term = getTerm();
            polynomial.addTerm(term);
            end = polynomial.isFull() ||
                    (!IOStream.askForUsersPermission("Would you like to add another term to this polynomial(y/n)"));
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

    private static void resetPolynomials() {
        polynomial1.reset();
        polynomial2.reset();
        resultingPolynomial.reset();
        System.out.println("\n\n Polynomials Reset Successfully!!\n\n");
    }
}
