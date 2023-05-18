package com.example.problema;

public class TrafficLight implements Runnable {
    private TrafficLightController controller;

    public TrafficLight(TrafficLightController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                controller.changeColor();
                Thread.sleep(200);
                controller.changeColor();
                Thread.sleep(500);
                controller.changeColor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

