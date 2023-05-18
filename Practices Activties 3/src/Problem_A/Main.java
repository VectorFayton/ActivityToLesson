package Problem_A;

import Problem_A.Calculator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner Input = new Scanner(System.in);
        int a = Input.nextInt();
        int b = Input.nextInt();
        Calculator addition = new Calculator(a, b);
        Calculator subtraction = new Calculator(a, b);
        Calculator multiplication = new Calculator(a, b);
        Calculator division = new Calculator(a, b);
        System.out.println(String.format("Addition of numbers is: %s",addition.Add()));
        System.out.println(String.format("Subtraction of two numbers is: %s", subtraction.Subtract()));
        System.out.println(String.format("Multiplication of two numbers is: %s", multiplication.Multiply()));
        System.out.println(String.format("Division of two numbers is: %s", division.Division()));
    }
}
