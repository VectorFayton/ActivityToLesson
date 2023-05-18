package com.example.testui;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class OutputClient implements Runnable{

    OutputStream outputStream;

    public OutputClient(OutputStream outputStream){
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        PrintStream ps = new PrintStream(outputStream);
        Scanner scan = new Scanner(System.in);

        while(true){
            String message = scan.nextLine();
            ps.println(message);
        }

    }
}
