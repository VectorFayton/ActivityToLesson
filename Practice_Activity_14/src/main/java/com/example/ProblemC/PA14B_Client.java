package com.example.ProblemC;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class PA14B_Client extends Application {

    private DataInputStream inputFromServer;
    private DataOutputStream outputToServer;
    private Socket clientSocket;

    private TextArea taServerMsg = new TextArea();
    private TextArea taClientMsg = new TextArea();
    private TextField tfClientMsg = new TextField();
    private Button sendButton = new Button("Send");

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        // Create UI for the client
        taServerMsg.setEditable(false);
        taClientMsg.setEditable(false);
        taClientMsg.setPromptText("Enter your message here...");
        sendButton.setDisable(true);

        HBox inputBox = new HBox(10);
        inputBox.getChildren().addAll(tfClientMsg, sendButton);
        root.setBottom(inputBox);

        root.setCenter(taServerMsg);
        root.setRight(taClientMsg);

        // Set actions for the send button and client message input field
        tfClientMsg.setOnAction(event -> sendMessage());
        sendButton.setOnAction(event -> sendMessage());

        primaryStage.setTitle("Client");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();

        connectToServer();
    }

    private void connectToServer() {
        new Thread(() -> {
            try {
                // Create a socket to connect to the server
                clientSocket = new Socket("localhost", 8000);

                // Create data input and output streams
                inputFromServer = new DataInputStream(clientSocket.getInputStream());
                outputToServer = new DataOutputStream(clientSocket.getOutputStream());

                // Enable the send button and client message input field after successful connection
                Platform.runLater(() -> {
                    sendButton.setDisable(false);
                    tfClientMsg.setEditable(true);
                });

                // Create a new thread to listen for server messages
                new Thread(() -> {
                    while (true) {
                        try {
                            String message = inputFromServer.readUTF();
                            Platform.runLater(() -> taServerMsg.appendText("Server: " + message + "\n"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void sendMessage() {
        try {
            // Get the client message and send it to the server
            String message = tfClientMsg.getText().trim();
            outputToServer.writeUTF(message);
            Platform.runLater(() -> {
                taClientMsg.appendText("Me: " + message + "\n");
                tfClientMsg.clear();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

