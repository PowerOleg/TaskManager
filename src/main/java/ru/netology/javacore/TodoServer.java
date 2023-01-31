package ru.netology.javacore;

import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TodoServer {
    protected String host = "127.0.0.1";
    protected int port;
    protected Todos todos;

    public TodoServer(int port, Todos todos) {
    this.port = port;
    this.todos = todos;
    }

    public void start() /*throws IOException*/ {
        try (ServerSocket serverSocket = new ServerSocket()) {
            serverSocket.accept();
            while (true) {
                try (Socket socket = new Socket(host, port); BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

                    String clientRequest = in.readLine();
                    System.out.println(clientRequest);

                    out.write(clientRequest);
                    out.newLine();
                    out.flush();
                }


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        System.out.println("Starting server at " + port + "...");

    }
}
