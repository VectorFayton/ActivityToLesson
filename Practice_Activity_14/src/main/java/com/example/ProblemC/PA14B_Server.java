package com.example.ProblemC;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class PA14B_Server extends Application {

    private TextArea serverMessagesArea;
    private TextArea serverInputArea;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private DataInputStream inputFromClient;
    private DataOutputStream outputToClient;

    @Override
    public void start(Stage primaryStage) {
        serverMessagesArea = new TextArea();
        serverMessagesArea.setEditable(false);
        serverMessagesArea.setPrefHeight(200);

        serverInputArea = new TextArea();
        serverInputArea.setPrefHeight(100);
        serverInputArea.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    String message = serverInputArea.getText();
                    sendMessageToClient(message);
                    serverInputArea.clear();
                }
            }
        });

        VBox root = new VBox();
        root.getChildren().addAll(serverMessagesArea, serverInputArea);

        primaryStage.setTitle("Server");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();

        startServer();
    }

    private void startServer() {
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(8000);
                serverMessagesArea.appendText("Server started at " + new Date() + "\n");

                // Listen for a connection request
                clientSocket = serverSocket.accept();

                // Create data input and output streams
                inputFromClient = new DataInputStream(clientSocket.getInputStream());
                outputToClient = new DataOutputStream(clientSocket.getOutputStream());

                // Continuously receive and process messages from the client
                while (true) {
                    String message = inputFromClient.readUTF();
                    Platform.runLater(() -> {
                        serverMessagesArea.appendText("Client: " + message + "\n");
                    });
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    private void sendMessageToClient(String message) {
        try {
            outputToClient.writeUTF(message);
            serverMessagesArea.appendText("Server: " + message + "\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

