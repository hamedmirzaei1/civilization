package ap.project.civilization.network.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketManager {
    static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);

        System.out.println("Server started");
        Thread listener = new Thread(() -> {

        });
        Socket socket = serverSocket.accept();
        System.out.println("client connected");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String message = in.readLine();
        System.out.println("client said: " + message);
        out.println("hello from server");

        socket.close();
        serverSocket.close();
    }
}
