package ru.netology.javacore;

import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;                                               //???

public class TodoServer {
    protected int port;
    protected Todos todos;
    protected ServerLogic serverLogic;

    public TodoServer(int port, Todos todos) {
    this.port = port;
    this.todos = todos;
    serverLogic = new ServerLogic();
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Starting server at " + port + "...");
            while (true) {
                try (Socket socket = serverSocket.accept(); BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
                    System.out.println("1");                                                                //d
                    String clientRequest = in.readLine();
                    System.out.println(clientRequest);
                    System.out.println("2");                                                                //d

                    //serverLogic определяющий ADD or REMOVE

                    System.out.println("3");                                                                //d
                    /* ! */                    String response = todos.getAllTasks();
                    out.write(response);
                    out.newLine();
                    out.flush();
                }
            }
        }




    }

    public ServerLogic getServerLogic() {
        return serverLogic;
    }

    public void setServerLogic(ServerLogic serverLogic) {
        this.serverLogic = serverLogic;
    }
}
