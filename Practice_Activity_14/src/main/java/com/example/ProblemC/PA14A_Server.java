package com.example.ProblemC;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class PA14A_Server extends Application {
    private TextArea taLog = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        // Create UI for server
        VBox vbox = new VBox();
        vbox.getChildren().add(new Label("Loan Calculator - Server Log:"));
        vbox.getChildren().add(taLog);
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);

        Scene scene = new Scene(vbox, 400, 250);
        primaryStage.setTitle("Loan Calculator - Server");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Set up server socket to listen for connections
        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            taLog.appendText("Server started.\n");

            while (true) {
                // Wait for client connection
                Socket socket = serverSocket.accept();
                taLog.appendText("Client connected from " + socket.getInetAddress().getHostAddress() + "\n");

                // Create input/output streams
                ObjectInputStream fromClient = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream toClient = new ObjectOutputStream(socket.getOutputStream());

                // Receive loan information from client
                double annualInterestRate = fromClient.readDouble();
                int numberOfYears = fromClient.readInt();
                double loanAmount = fromClient.readDouble();

                // Calculate loan payments
                double monthlyInterestRate = annualInterestRate / 1200;
                double monthlyPayment = loanAmount * monthlyInterestRate / (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
                double totalPayment = monthlyPayment * numberOfYears * 12;

                // Send loan payments back to client
                toClient.writeDouble(monthlyPayment);
                toClient.writeDouble(totalPayment);
                toClient.flush();

                // Log loan information and payments
                taLog.appendText("Loan Information:\n");
                taLog.appendText("Annual Interest Rate: " + annualInterestRate + "\n");
                taLog.appendText("Number of Years: " + numberOfYears + "\n");
                taLog.appendText("Loan Amount: " + loanAmount + "\n");
                taLog.appendText("Loan Payments:\n");
                taLog.appendText("Monthly Payment: " + monthlyPayment + "\n");
                taLog.appendText("Total Payment: " + totalPayment + "\n");

                // Close connection to client
                socket.close();
                taLog.appendText("Client disconnected.\n");
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}


