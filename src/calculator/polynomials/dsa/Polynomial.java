package calculator.polynomials.dsa;

public class Polynomial {
    public final int polynomialSize = 25;
    private AlgebraicTerm[] polynomial;
    private int counter = 0;

    public Polynomial() {
        polynomial = new AlgebraicTerm[polynomialSize];
    }

    public AlgebraicTerm getTerm(int index) {
        return polynomial[index];
    }

    public void addTerm(AlgebraicTerm term) {
        polynomial[counter] = term;
        counter++;
    }

    public boolean isFull() {
        return counter == polynomialSize;
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public int getCounter() {
        return counter;
    }

    public void sort() {
        Sort.sort(polynomial, 0, counter - 1);
        simplifyPolynomial();
    }

    private void simplifyPolynomial() {
        AlgebraicTerm[] expression = new AlgebraicTerm[polynomialSize];
        int expCounter = 0;
        for (int i = 0; i < counter; i++) {
            if (polynomial[i] == null) continue;
            for (int j = i + 1; j < counter; j++) {
                if (polynomial[j] == null)continue;
                boolean exponentsAreEqual = polynomial[i].exponent == polynomial[j].exponent;
                boolean variablesAreSame = polynomial[i].variable == polynomial[j].variable;
                if (exponentsAreEqual && variablesAreSame) {
                    polynomial[i] = evaluate(polynomial[i], polynomial[j]);
                    polynomial[j] = null;
                }
            }
            expression[expCounter] = polynomial[i];
            expCounter++;
            polynomial[i] = null;
        }
        polynomial = expression;
        counter = expCounter;
    }
    public AlgebraicTerm evaluate(AlgebraicTerm term1, AlgebraicTerm term2){
        double coefficient = term1.coefficient + term2.coefficient;
        return new AlgebraicTerm(coefficient,
                term1.variable, term1.exponent);
    }
}
