package com.example.problema;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class TrafficLightController extends AnchorPane {
    private Circle redCircle, yellowCircle, greenCircle;
    private int currentState;

    public TrafficLightController() {
        redCircle = new Circle(50, 50, 30);
        yellowCircle = new Circle(50, 120, 30);
        greenCircle = new Circle(50, 190, 30);
        redCircle.setStyle("-fx-fill: gray");
        yellowCircle.setStyle("-fx-fill: gray");
        greenCircle.setStyle("-fx-fill: gray");
        getChildren().addAll(redCircle, yellowCircle, greenCircle);
        currentState = 0;
        changeColor();
    }

    public void changeColor() {
        switch (currentState) {
            case 0:
                greenCircle.setStyle("-fx-fill: green");
                yellowCircle.setStyle("-fx-fill: gray");
                redCircle.setStyle("-fx-fill: gray");
                currentState = 1;
                break;
            case 1:
                greenCircle.setStyle("-fx-fill: gray");
                yellowCircle.setStyle("-fx-fill: yellow");
                redCircle.setStyle("-fx-fill: gray");
                currentState = 2;
                break;
            case 2:
                greenCircle.setStyle("-fx-fill: gray");
                yellowCircle.setStyle("-fx-fill: gray");
                redCircle.setStyle("-fx-fill: red");
                currentState = 0;
                break;
        }
    }
}
