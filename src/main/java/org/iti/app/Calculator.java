package org.iti.app;

public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double mul(double a, double b) {
        double res =  a * b;
        if(res == -0.0){
            return Math.abs(res);
        }
        return res;

    }

    public double div(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero!!!");
        }
        return a / b;
    }

    public double mod(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Illegal Operation");
        }
        return a % b;
    }

    public double getSquareRoot(double a) {
        return Math.sqrt(a);
    }



}
