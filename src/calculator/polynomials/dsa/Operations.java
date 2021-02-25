package calculator.polynomials.dsa;

public enum Operations {
    getPolynomials('1'),
    addPolynomials('2'),
    displayResult('3'),
    resetPolynomial('4'),
    exit('5');
    public final char operation;

    Operations(char code) {
        this.operation = code;
    }

    public static Operations fromChar(char code) {
        return switch (code) {
            case '1' -> Operations.getPolynomials;
            case '2' -> Operations.addPolynomials;
            case '3' -> Operations.displayResult;
            case '4' -> Operations.resetPolynomial;
            default -> Operations.exit;
        };
    }
}
