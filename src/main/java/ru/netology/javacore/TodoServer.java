package ru.netology.javacore;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    protected final int port;
    protected final Todos todos;
    protected ServerLogic serverLogic;
    protected Command command;

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
                    String clientRequest = in.readLine();
                    System.out.println("Запрос клиента: " + clientRequest);
                    ClassForParsing classForParsing = serverLogic.parse(clientRequest);
                    command = serverLogic.getCommandType(classForParsing.getCommandType());
                    command.execute(classForParsing.getTask());

                    String response = todos.getAllTasks();
                    out.write(response);
                    out.newLine();
                    out.flush();
                    System.out.println("Ответ сервера: "+ response);                                                                //d
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
