package com.example.testui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client extends Application {
    private static TextField message_field;
    private static TextArea chat_history_area;
    private static ListView<String> user_list;
    public static void main(String[] args) throws IOException {
        launch();
        String server_address = "localhost";
        int port_number = 678;
        Socket socket = new Socket(server_address, port_number);
        chat_history_area.setText("Connected to server: " + socket.getInetAddress() + "\n");
        System.out.println("Connected to server: " + socket.getInetAddress());
        chat_history_area.setText("Request sent successfully!" + "\n");
        System.out.println("Request sent successfully!");

        BufferedReader input_from_console = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader input_from_server = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream output_to_server = new PrintStream(socket.getOutputStream());

        while (true) {
            chat_history_area.setText("Server: " + input_from_server.readLine() + "\n");
            System.out.println("Server: " + input_from_server.readLine());
            System.out.println("Client: ");
            chat_history_area.setText("Client: ");
            output_to_server.println(input_from_console.readLine() + "\n");
            output_to_server.flush();
        }
    }

    public void start(Stage primary_stage) throws IOException {
        BorderPane root = new BorderPane();
        root.setPrefSize(600, 400);

        // Chat history panel
        chat_history_area = new TextArea();
        chat_history_area.setEditable(false);
        root.setCenter(chat_history_area);

        // User list
        user_list = new ListView<>();
        user_list.setPrefWidth(150);
        root.setRight(user_list);

        // Chatbox
        message_field = new TextField();
        Button sendButton = new Button("Send");
        message_field.setOnAction(e -> sendMessage());
        sendButton.setOnAction(e -> sendMessage());
        HBox chatBox = new HBox(message_field, sendButton);
        chatBox.setPadding(new Insets(10));
        root.setBottom(chatBox);

        // Create the scene
        Scene scene = new Scene(root);

        // Set the stage
        primary_stage.setTitle("Client");
        primary_stage.setScene(scene);
        primary_stage.show();
    }

    private void sendMessage() {
        String message = message_field.getText();
        if (!message.isEmpty()) {
            chat_history_area.appendText("You: " + message + "\n");
            message_field.clear();
        }
    }
}

