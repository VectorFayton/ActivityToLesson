package ProblemB_Alternative;

import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = Input.nextInt();
        Input.close();
        SumCalculator calculator = new SumCalculator(number);
        calculator.calculateSum();
    }
}
