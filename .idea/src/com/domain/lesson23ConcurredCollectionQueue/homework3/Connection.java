package com.domain.lesson23ConcurredCollectionQueue.homework3;



import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;

public class Connection extends Thread implements AutoCloseable {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        out = new ObjectOutputStream(this.socket.getOutputStream());
        in = new ObjectInputStream(this.socket.getInputStream());
        start();

    }

    @Override
    public void run() {
        Message message = new Message("server", "text");
        try {
            message = readMessage();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // рассылка сообщения всем клиентам кроме отправителя
        for (Map.Entry<Socket, Connection> clients: Server.clientList.entrySet()) {
            if(clients.getKey().equals(socket))continue;
            try {
                clients.getValue().sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void sendMessage(Message message) throws IOException {
        out.writeObject(message);
        out.flush();
    }

    public Message readMessage() throws IOException, ClassNotFoundException {
        return (Message) in.readObject();
    }

    @Override
    public void close() throws Exception {
        // закрытие ресурсов
        out.close();
        in.close();
    }

}