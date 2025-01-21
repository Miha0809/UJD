import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server {
    private static final int PORT = 12345;
    private static final Map<String, String> resources = new HashMap<>();
    private static final List<PrintWriter> clientWriters = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Server is running...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                clientWriters.add(out);

                String message;

                while ((message = in.readLine()) != null) {
                    String[] parts = message.split(" ", 3);
                    String command = parts[0];
                    String key = parts.length >= 2 ? parts[1] : null;
                    String value = parts.length == 3 ? parts[2] : null;

                    synchronized (resources) {
                        switch (command.toLowerCase()) {
                            case "add":
                                resources.put(key, value);
                                broadcast("Added: " + key + " = " + value);
                                break;
                            case "remove":
                                resources.remove(key);
                                broadcast("Removed: " + key);
                                break;
                            case "update":
                                resources.put(key, value);
                                broadcast("Updated: " + key + " = " + value);
                                break;
                            case "list":
                                out.println("Current resources: " + resources);
                                break;
                            default:
                                out.println("Unknown command");
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Connection error: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                clientWriters.remove(out);
            }
        }

        private void broadcast(String message) {
            for (PrintWriter writer : clientWriters) {
                writer.println(message);
            }
        }
    }
}
