package ProblemB;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.print("Write number: ");
        Scanner Input = new Scanner(System.in);
        SumCalculator calculator = new SumCalculator(Input.nextInt());
        calculator.calculateSum();
    }
}
