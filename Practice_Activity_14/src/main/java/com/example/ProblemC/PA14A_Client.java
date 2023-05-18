package com.example.ProblemC;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class PA14A_Client extends Application {
    private TextField tfAnnualInterestRate = new TextField();
    private TextField tfNumberOfYears = new TextField();
    private TextField tfLoanAmount = new TextField();
    private Button btSubmit = new Button("Submit");
    private TextArea taResult = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        // Create UI for client
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Annual Interest Rate:"), 0, 0);
        gridPane.add(tfAnnualInterestRate, 1, 0);
        gridPane.add(new Label("Number of Years:"), 0, 1);
        gridPane.add(tfNumberOfYears, 1, 1);
        gridPane.add(new Label("Loan Amount:"), 0, 2);
        gridPane.add(tfLoanAmount, 1, 2);
        gridPane.add(btSubmit, 1, 3);
        gridPane.setPadding(new Insets(10));

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setBottom(taResult);
        BorderPane.setMargin(taResult, new Insets(10));

        Scene scene = new Scene(borderPane, 400, 250);
        primaryStage.setTitle("Loan Calculator - Client");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Set up event handling for submit button
        btSubmit.setOnAction(e -> {
            try {
                // Connect to server
                Socket socket = new Socket("localhost", 8000);

                ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream());

                // Send loan information to server
                double annualInterestRate = Double.parseDouble(tfAnnualInterestRate.getText());
                int numberOfYears = Integer.parseInt(tfNumberOfYears.getText());
                double loanAmount = Double.parseDouble(tfLoanAmount.getText());
                toServer.writeDouble(annualInterestRate);
                toServer.writeInt(numberOfYears);
                toServer.writeDouble(loanAmount);
                toServer.flush();

                // Receive loan payments from server
                double monthlyPayment = fromServer.readDouble();
                double totalPayment = fromServer.readDouble();
                taResult.setText("Monthly Payment: " + monthlyPayment + "\nTotal Payment: " + totalPayment);

                // Close connection to server
                socket.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
