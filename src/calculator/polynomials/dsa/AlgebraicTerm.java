package calculator.polynomials.dsa;

public class AlgebraicTerm {
    public double coefficient;
    public char variable;
    public double exponent;

    public AlgebraicTerm() {
    }
    public AlgebraicTerm(double coefficient, char variable, double exponent) {
        this.coefficient = coefficient;
        this.variable = variable;
        this.exponent = exponent;
    }

    public boolean isCoefficientAnInteger(){
        int number = (int) coefficient;
        return coefficient - number == 0;
    }
    public boolean isExponentAnInteger(){
        int number = (int) exponent;
        return exponent - number == 0;
    }
}
