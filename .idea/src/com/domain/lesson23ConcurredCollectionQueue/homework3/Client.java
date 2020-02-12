package com.domain.lesson23ConcurredCollectionQueue.homework3;

import java.io.*;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static String server;
    public static int port;
    private Scanner scanner;
    private Socket clientSocket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public Client(String server, int port) {
        this.server = server;
        this.port = port;
        this.scanner = new Scanner(System.in);

        try {
            this.clientSocket = new Socket(server, port);
            out = new ObjectOutputStream(this.clientSocket.getOutputStream());
            in = new ObjectInputStream(this.clientSocket.getInputStream());

            new WriteTread().start();
            new ReadTread().start();

        } catch (IOException e) {
            e.printStackTrace();
            exit();
        }

    }

    // write - поток (создания и отправки сообщений на сервер)
    public class WriteTread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    out.writeObject(createMsg()); // создаем и отправляем на сервер сообщение
                    out.flush();
                } catch (IOException e) {
                    Client.this.exit();
                }
            }
        }
    }

    // read - поток (чтения сообщений с сервера)
    private class ReadTread extends Thread {
        @Override
        public void run() {
            Message message;
            try {
                while (true) {

            message = (Message) in.readObject();
            System.out.println("ответ от сервера: " + message);
                }
            } catch (IOException | ClassNotFoundException e) {
                Client.this.exit();
            }
        }
    }

    public Message createMsg(){
        System.out.println("Введите имя");

        String name = scanner.nextLine();
        String messageText;
        while (true){
            System.out.println("Введите сообщение");
            messageText = scanner.nextLine();
            Message message = new Message(name, messageText);
            return message;
        }
    }

    // закрытие сокета
    private void exit() {
        try {
            if (!clientSocket.isClosed()) {
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException ignored) {}
    }

    public static void main(String[] args) {
        try (InputStream inputStream = Client.class.getClassLoader().getResourceAsStream("config.properties")){
            Properties properties = new Properties();// для работы с конфиг-файлами
            properties.load(inputStream);
            String server = properties.getProperty("server");//"127.0.0.1";
            int port = Integer.parseInt(properties.getProperty("port")); //8090;

            new Client(server, port);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



