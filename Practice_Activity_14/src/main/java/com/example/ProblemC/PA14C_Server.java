package com.example.ProblemC;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PA14C_Server extends Application {
    // Text area for displaying messages
    private TextArea ta = new TextArea();

    // List of sockets for all clients
    private List<DataOutputStream> clientStreams =
            Collections.synchronizedList(new ArrayList<>());

    // Number of clients
    private int clientCount = 0;

    @Override // Override the start method in
    public void start(Stage primaryStage) {
        // Create a scene and place it in the stage
        Scene scene = new Scene(new ScrollPane(ta), 450, 200);
        primaryStage.setTitle("PA14C_Server"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        // Start the server
        new Thread(() -> {
            try {
                // Create a server socket
                ServerSocket serverSocket = new ServerSocket(8000);
                ta.appendText("PA14C_Server started at "
                        + new java.util.Date() + '\n');

                while (true) {
                    // Listen for a new connection request
                    Socket socket = serverSocket.accept();
                    clientCount++;
                    ta.appendText("Starting thread for client " + clientCount
                            + " at " + new java.util.Date() + '\n');

                    // Create a new thread for the connection
                    new Thread(new HandleAClient(socket)).start();
                }
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }).start();
    }

    // Inner class for handling a client
    class HandleAClient implements Runnable {
        private Socket socket; // A connected socket
        private DataInputStream fromClient;
        private DataOutputStream toClient;

        /** Construct a thread */
        public HandleAClient(Socket socket) {
            this.socket = socket;
            try {
                // Create data input and output streams
                fromClient = new DataInputStream(socket.getInputStream());
                toClient = new DataOutputStream(socket.getOutputStream());

                // Add output stream to the list
                clientStreams.add(toClient);
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }

        /** Run a thread */
        public void run() {
            try {
                while (true) {
                    // Receive message from the client
                    String message = fromClient.readUTF();

                    // Add message to the list
                    ta.appendText("Message received from client " + clientCount + ": " + message + "\n");

                    // Send message to all clients
                    synchronized (clientStreams) {
                        for (DataOutputStream stream : clientStreams) {
                            stream.writeUTF("Client " + clientCount + ": " + message);
                            stream.flush();
                        }
                    }
                }
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
