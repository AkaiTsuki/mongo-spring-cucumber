package me.msc.overview;

/**
 * Created by jiachiliu on 3/17/15.
 */
public class Calculator {
    /**
     * Calculate the given formula
     *
     * @param formula a formula has the format "a + b"
     * @return the calculated result
     */
    public int compute(String formula) {
        String[] tokens = formula.split(" ");

        if (tokens.length != 3) {
            throw new RuntimeException("Invalid formula");
        }

        return getResult(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[2]), tokens[1]);
    }

    private int getResult(int a, int b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new RuntimeException("Invalid formula");
        }
    }

}
