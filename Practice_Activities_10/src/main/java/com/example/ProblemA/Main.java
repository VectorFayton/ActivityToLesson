package com.example.ProblemA;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.ListIterator;

public class Main extends Application {
    Button next_button = new Button("Next");
    Button previous_button = new Button("Previous");
    Label label = new Label("color");
    Circle circle = new Circle(200);
    GridPane grid_pane = new GridPane();
    ArrayList<String> colors = getAllColors();
    ListIterator<String> color_list_iterator = colors.listIterator();
    String default_color = color_list_iterator.next();

    @Override
    public void start(Stage stage) throws IOException {
        grid_pane.setMinSize(1000, 1000);
        grid_pane.setPadding(new Insets(3, 3, 3, 3));
        grid_pane.setHgap(3);
        grid_pane.setVgap(3);
        grid_pane.setAlignment(Pos.CENTER);
        grid_pane.add(circle, 2, 0);
        grid_pane.add(previous_button, 1, 3);
        grid_pane.add(label, 2, 3);
        grid_pane.add(next_button, 3, 3);
        logic();
        Scene scene = new Scene(grid_pane);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void logic() {
        previous_button.setOnAction(e -> {
            if (!color_list_iterator.hasPrevious()){
                while (color_list_iterator.hasNext()){
                    default_color = color_list_iterator.next();
                }
            }
            String color = color_list_iterator.previous();
            if (color.equals(default_color)) {
                if (!color_list_iterator.hasPrevious()){
                    while (color_list_iterator.hasNext()){
                        default_color = color_list_iterator.next();
                    }
                }
                color = color_list_iterator.previous();
            }
            default_color = color;
            label.setText(color);
            circle.setFill(Color.web(color));
        });

        next_button.setOnAction(e -> {
            if (!color_list_iterator.hasNext()){
                while (color_list_iterator.hasPrevious()){
                    default_color = color_list_iterator.previous();
                }
            }
            String color = color_list_iterator.next();
            if (color.equals(default_color)) {
                if (!color_list_iterator.hasNext()){
                    while (color_list_iterator.hasPrevious()){
                        default_color = color_list_iterator.previous();
                    }
                }
                color = color_list_iterator.next();
            }
            default_color = color;
            label.setText(color);
            circle.setFill(Color.web(color));
        });

        label.setText(default_color);
        circle.setFill(Color.web(default_color));
        circle.setStrokeWidth(5);
        circle.setStroke(Color.BLACK);
    }
    public static void main(String[] args) {
        launch();
    }
    public ArrayList<String> getAllColors() {
        ArrayList<String> color_names = new ArrayList<>();
        Field[] fields = Color.class.getFields();
        for (Field field: fields) {
            color_names.add(field.getName());
        }
        return color_names;
    }

}