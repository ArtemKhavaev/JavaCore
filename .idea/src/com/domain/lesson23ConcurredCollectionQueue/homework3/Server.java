package com.domain.lesson23ConcurredCollectionQueue.homework3;

import java.io.*;
import java.net.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {

    public static int port = 8090;
    private  Connection connection;
    public static ConcurrentHashMap<Socket, Connection> clientList = new ConcurrentHashMap<>();


    public Server(int port){
        this.port = port;
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("сервер запущен");
        try {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                try {
                    Connection connection = new Connection(clientSocket);
                    clientList.put(clientSocket, connection);

                } catch (IOException e) {
                    clientSocket.close();
                }
            }
        } finally {
            serverSocket.close();
        }
    }


}



