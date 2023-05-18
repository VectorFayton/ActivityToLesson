package com.example.practice_activities_5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Text label_of_coffee_shop = new Text("My Coffee Shop");
        Text name = new Text("My Coffee Shop");

        Text drink_label = new Text("Drink:");

        ChoiceBox drink_choice = new ChoiceBox();
        drink_choice.getItems().addAll("Latte", "Americano", "Cappuccino", "Black Tea", "Green tea");

        Text milk_label = new Text("Milk option:");

        ToggleGroup milk_choice = new ToggleGroup();
        RadioButton whole_milk = new RadioButton("Whole milk");
        whole_milk.setToggleGroup(milk_choice);
        RadioButton almond_milk = new RadioButton("Almond milk");
        almond_milk.setToggleGroup(milk_choice);
        RadioButton no_milk = new RadioButton("No Milk");
        no_milk.setToggleGroup(milk_choice);

        Text add_label = new Text("Add:");

        CheckBox sugar_box = new CheckBox("Sugar");
        sugar_box.setIndeterminate(false);

        CheckBox extra_hot_box = new CheckBox("Extra Hot");
        extra_hot_box.setIndeterminate(false);

        CheckBox extra_milk_box = new CheckBox("Extra Milk");
        extra_milk_box.setIndeterminate(false);

        Button place_order = new Button("Place Order");

        TextArea first_choice = new TextArea();
        first_choice.setPrefSize(40, 5);

        TextArea second_choice = new TextArea();
        second_choice.setPrefSize(40, 5);

        TextArea third_choice = new TextArea();
        third_choice.setPrefSize(40, 5);

        GridPane grid_place = new GridPane();
        grid_place.setMinSize(700, 700);

        grid_place.setPadding(new Insets(15, 15, 15, 15));

        grid_place.setVgap(15);
        grid_place.setHgap(5);

        grid_place.setAlignment(Pos.CENTER);

        grid_place.add(label_of_coffee_shop, 3, 1);

        grid_place.add(name, 3, 0);

        grid_place.add(drink_label, 3, 4);
        grid_place.add(drink_choice, 3, 5);

        grid_place.add(milk_label, 0, 10);
        grid_place.add(whole_milk, 0, 11);
        grid_place.add(almond_milk, 0, 12);
        grid_place.add(no_milk, 0, 13);

        grid_place.add(add_label, 5, 10);
        grid_place.add(sugar_box, 5, 11);
        grid_place.add(extra_hot_box, 5, 12);
        grid_place.add(extra_milk_box, 5, 13);

        grid_place.add(place_order, 3, 14);

        grid_place.add(first_choice, 0, 15);
        grid_place.add(second_choice, 3, 15);
        grid_place.add(third_choice, 5, 15);

        grid_place.setStyle("-fx-background-color: BEIGE;");

        name.setStyle("-fx-font: normal bold 30px 'Comic Sans MS' ");
        drink_label.setStyle("-fx-font: normal bold 15px 'Elephant' ");
        milk_label.setStyle("-fx-font: normal bold 15px 'Elephant' ");
        add_label.setStyle("-fx-font: normal bold 15px 'Elephant' ");

        place_order.setOnMouseClicked(e ->{
            // For first section
            String first_label = drink_choice.getValue().toString();

            // For second section
            RadioButton null_button = ((RadioButton)milk_choice.getSelectedToggle());
            String second_label = "";
            if (null_button != null){
                second_label = null_button.getText();
            }

            // For third section
            String third_label = "";
            if (sugar_box.isSelected()){
                third_label = third_label + " " + sugar_box.getText();
            }
            if (extra_hot_box.isSelected()){
                third_label = third_label + " " + extra_hot_box.getText();
            }
            if (extra_milk_box.isSelected()){
                third_label = third_label + " " + extra_milk_box.getText();
            }

            first_choice.clear();
            first_choice.appendText(first_label);
            second_choice.clear();
            second_choice.appendText(second_label);
            third_choice.clear();
            third_choice.appendText(third_label);
        });
        HBox hBox = new HBox(20);
        hBox.setPadding(new Insets(20));
        hBox.getChildren().addAll(label_of_coffee_shop);

        VBox Main = new VBox(20);
        Main.setPadding(new Insets(20));
        Main.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        Main.getChildren().addAll(hBox);

        Scene scene = new Scene(grid_place);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}