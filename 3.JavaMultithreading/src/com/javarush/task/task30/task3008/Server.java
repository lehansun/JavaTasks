package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Введите порт сервера: ");
        int port = ConsoleHelper.readInt();

        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Сервер запущен!");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Handler(clientSocket).start();
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Сервер остановлен из-за возникшей ошибки: " + e.getMessage());
        }

    }

    public static void sendBroadcastMessage(Message message) {
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Во время отправки сообщения возникла исключительная ситуация: " + e);
            }
        }
    }

    private static class Handler extends Thread {

        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено новое соединение с удаленным адресом: " + socket.getRemoteSocketAddress());
            String userName = null;
            try (Connection connection = new Connection(socket)) {
                 userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом");
                if (userName != null) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
                ConsoleHelper.writeMessage("Соединение с удаленным адресом [" + socket.getRemoteSocketAddress() + "] закрыто");
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            connection.send(new Message(MessageType.NAME_REQUEST));
            Message answer = connection.receive();
            if (answer.getType() == MessageType.USER_NAME) {
                String name = answer.getData();
                if (name != null && name != "" && !connectionMap.containsKey(name)) {
                    connectionMap.put(name, connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED));
                    return name;
                }
            }

            return serverHandshake(connection);
        }

        private void notifyUsers(Connection connection, String userName) {
            connectionMap.forEach((name, userConnection) -> {
                if (!name.equals(userName)) {
                    try {
                        connection.send(new Message(MessageType.USER_ADDED, name));
                    } catch (IOException e) {

                    }
                }
            } );
        }

        private void serverMainLoop(Connection connection, String userName) {
            while (true) {
                try {
                    Message receive = connection.receive();
                    if (receive.getType() == MessageType.TEXT) {
                        String data = userName + ": " + receive.getData();
                        Message message = new Message(MessageType.TEXT, data);
                        Server.sendBroadcastMessage(message);
                    } else {
                        ConsoleHelper.writeMessage("Ошибка формата сообщения");
                    }
                } catch (IOException | ClassNotFoundException e) {

                }
            }
        }
    }
}
