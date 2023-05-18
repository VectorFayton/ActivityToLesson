package com.example.testui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputServer implements Runnable{

    InputStream inputStream;

    public InputServer(InputStream inputStream){
        this.inputStream = inputStream;
    }


    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            while (true) {
                System.out.println("Client: "+br.readLine());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}