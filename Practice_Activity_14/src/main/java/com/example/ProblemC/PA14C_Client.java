package com.example.ProblemC;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class PA14C_Client extends Application {
    // IO streams
    DataOutputStream toServer = null;
    DataInputStream fromServer = null;

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Pane to hold the text area, text field, and button
        BorderPane paneForTextField = new BorderPane();
        TextArea ta = new TextArea();
        paneForTextField.setCenter(new ScrollPane(ta));
        TextField tf = new TextField();
        tf.setOnAction(e -> {
            try {
                // Send message to the server
                toServer.writeUTF(tf.getText().trim());
                toServer.flush();
            } catch (IOException ex) {
                System.err.println(ex);
            }
            tf.setText("");
        });
        paneForTextField.setLeft(tf);
        Button btnExit = new Button("Exit");
        btnExit.setOnAction(e -> Platform.exit());
        paneForTextField.setRight(btnExit);

        // Create a scene and place it in the stage
        Scene scene = new Scene(paneForTextField, 450, 200);
        primaryStage.setTitle("PA14C_Client"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        // Connect to the server
        try {
            // Create a socket to connect to the server
            Socket socket = new Socket("localhost", 8000);

            // Create an input stream to receive data from the server
            fromServer = new DataInputStream(socket.getInputStream());

            // Create an output stream to send data to the server
            toServer = new DataOutputStream(socket.getOutputStream());

            // Create a thread to receive messages from the server
            new Thread(() -> {
                try {
                    while (true) {
                        // Read a message from the server
                        String message = fromServer.readUTF();

                        // Update the UI on the JavaFX Application Thread
                        Platform.runLater(() -> {
                            ta.appendText(message + "\n");
                        });
                    }
                } catch (IOException ex) {
                    System.err.println(ex);
                }
            }).start();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
