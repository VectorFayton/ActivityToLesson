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
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Application {

    private static TextField message_field;
    private static TextArea chat_history_area;
    private static ListView<String> user_list;

    public static void main(String[] args) throws IOException {
        launch(args);
        int port_number = 678;
        ServerSocket server_socket = new ServerSocket(port_number);
        chat_history_area.setText("Server started on port " + port_number + "\n");
        chat_history_area.setText("Waiting for client request... \n");
        System.out.println("Server started on port " + port_number);
       System.out.println("Waiting for client request...");
        Socket socket = server_socket.accept();
        chat_history_area.setText("Client is pop up: " + socket.getInetAddress() + "!\n");
        System.out.println("Client is pop up: " + socket.getInetAddress() + "!");

        BufferedReader input_from_console = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader input_from_client = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream output_to_client = new PrintStream(socket.getOutputStream());

        while (true) {
            chat_history_area.setText("Server: \n");
            System.out.println("Server: ");
            String message = message_field.getText();
            output_to_client.println(message + "\n");
            output_to_client.flush();
            chat_history_area.setText("Clients: " + input_from_client.readLine() + "\n");
            System.out.println("Clients: " + input_from_client.readLine());
        }
    }

    @Override
    public void start(Stage primaryStage) {
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
        sendButton.setOnAction(e -> sendMessage());
        HBox chatBox = new HBox(message_field, sendButton);
        chatBox.setPadding(new Insets(10));
        root.setBottom(chatBox);

        // Create the scene
        Scene scene = new Scene(root);

        // Set the stage
        primaryStage.setTitle("Server");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    private void sendMessage() {
        String message = message_field.getText();
        if (!message.isEmpty()) {
            chat_history_area.appendText("You: " + message + "\n");
            message_field.clear();
        }
    }
}
