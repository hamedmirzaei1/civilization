package ap.project.civilization.network.connection;


import ap.project.civilization.network.server.GameServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketManager implements Runnable {
    private final int port;
    private final GameServer gameServer;

    private ServerSocket serverSocket;

    public ServerSocketManager(int port, GameServer gameServer) {
        this.port = port;
        this.gameServer = gameServer;
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port);

            System.out.println("Server listening on port " + port);

            while(!Thread.currentThread().isInterrupted()) {
                Socket socket = serverSocket.accept();
                System.out.println("New connection: " + socket.getInetAddress());

                gameServer.handleNewConnection(socket);
            }

        } catch (IOException e) {
            if(!Thread.currentThread().isInterrupted()) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        try {
            if(serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
