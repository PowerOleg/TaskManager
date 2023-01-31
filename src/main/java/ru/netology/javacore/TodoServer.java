package ru.netology.javacore;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    protected int port;
    protected Todos todos;
    protected ServerLogic serverLogic;                                                                 //?????????
/* ! */    protected Command command;

    public TodoServer(int port, Todos todos) {
    this.port = port;
    this.todos = todos;
    serverLogic = new ServerLogic();                                                                //??????????
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
//serverLogic будет парсить и определять ADD or REMOVE
//                    сейчас тестим { "type": "ADD", "task": "Купить пирожок" }
                    command = /*будет serverLogic.chooseCommand(clientRequest);*/new CommandAdd();    //убери new CommandAdd()
                    command.execute(/*serverLogic.getTask*/             clientRequest);         //убери clientRequest






//
                    System.out.println("3");                                                                //d
                    /* ! */                    String response = todos.getAllTasks();
                    out.write(response);
                    out.newLine();
                    out.flush();
                    System.out.println("4 "+ response);                                                                //d
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
