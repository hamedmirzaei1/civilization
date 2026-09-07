package ap.project.civilization.network.server;

import ap.project.civilization.network.connection.ServerSocketManager;

import java.net.Socket;

public class GameServer {
    private static final int PORT = 5000;

    private final ServerSocketManager serverSocketManager;
    private final Thread socketThread;

    public GameServer() {
        serverSocketManager = new ServerSocketManager(PORT, this);
        socketThread = new Thread(serverSocketManager, "ServerSocketThread");
    }

    public void start() {
        socketThread.start();
        System.out.println("Game Server Started.");
    }

    public void stop() {
        serverSocketManager.stop();
    }

    public void handleNewConnection(Socket socket) {

    }
}
