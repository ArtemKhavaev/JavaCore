package com.domain.lesson27BuilderListenerPrototypeCommand.command;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MessageServer {
    private int port;
    private Connection connection;
    private int connectionCount;

    public MessageServer(int port){
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server started...");
            while (true){
                Socket socket = serverSocket.accept();
                connection = new Connection(socket);
                connectionCount++;
                String clientCommand = connection.readMessage().getText();
                System.out.println(clientCommand);
                executeCommand(ServerCommand.getCommand(clientCommand, this));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getConnectionCount() {
        return connectionCount;
    }

    public Connection getConnection() {
        return connection;
    }

    private void printMessage(Message message){
        System.out.println("получено сообщение: " + message);
    }

    public void executeCommand(ServerCommand command){
        command.execute();
    }

    public static void main(String[] args) {
        int port = 8090;
        MessageServer messageServer = new MessageServer(port);
        try {
            messageServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
