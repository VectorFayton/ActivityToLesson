package Problem_A;

import java.io.IOException;

public class Calculator {
    int Number_A;
    int Number_B;

    public Calculator(int a, int b) {
        this.Number_A = a;
        this.Number_B = b;
    }
    public Calculator(Object a, Object b) throws ArithmeticException {
        throw new NumberFormatException("Write numbers in integer format.");
    }

    public int getNumber_A() {
        return Number_A;
    }

    public int getNumber_B() {
        return Number_B;
    }

    public void setNumber_A(int number_A) {
        Number_A = number_A;
    }

    public void setNumber_B(int number_B) {
        Number_B = number_B;
    }

    public int Add() throws ArithmeticException {
        if (Number_A < 0 || Number_B < 0)
            throw new ArithmeticException("Please use positive numbers.");
        else
            return Number_A + Number_B;
    }

    public int Subtract() throws ArithmeticException{
        if (Number_A < 0 || Number_B < 0)
            throw new ArithmeticException("Please use positive numbers");
        else
            return Number_A - Number_B;
    }

    public int Multiply() throws ArithmeticException{
        if (Number_A < 0 || Number_B < 0)
            throw new ArithmeticException("one of numbers is zero");
        else
            return Number_A * Number_B;
    }

    public int Division() throws ArithmeticException{
        if (Number_A < 0 || Number_B < 0)
            throw new ArithmeticException("one of numbers is zero");
        else
            return Number_A / Number_B;
    }
}
