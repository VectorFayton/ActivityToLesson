package com.example.problema;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        TrafficLightController trafficLightController = new TrafficLightController();
        Scene scene = new Scene(trafficLightController, 150, 250);
        primaryStage.setTitle("Traffic Light Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();

        TrafficLight trafficLight = new TrafficLight(trafficLightController);
        Thread thread = new Thread(trafficLight);
        thread.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

