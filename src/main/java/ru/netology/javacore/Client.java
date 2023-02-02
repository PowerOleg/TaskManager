package ru.netology.javacore;

import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (Socket clientSocket = new Socket("localhost", 8989);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
//{ "type": "ADD", "task": "Купить пирожок" }
            JSONObject jsonObject1 = new JSONObject();
//            jsonObject1.put("type", "RESTORE");
            jsonObject1.put("type", "ADD");
            jsonObject1.put("task", "2");
//            jsonObject1.put("task", "купить азбуку");

//            jsonObject1.put("type", "REMOVE");
//            jsonObject1.put("task", "1");

            out.println(jsonObject1.toJSONString());
            String serverResponse2 = in.readLine();
            System.out.println(serverResponse2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
