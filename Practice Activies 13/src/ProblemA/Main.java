package ProblemA;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);

        trafficLight light = new trafficLight();
        Thread thread = new Thread(light);
        thread.start();
        Input.nextLine();
        trafficLight.stop();
    }
}

