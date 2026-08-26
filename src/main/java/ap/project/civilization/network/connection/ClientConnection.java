package ap.project.civilization.network.connection;

import java.net.Socket;

public class ClientConnection {
    private Socket socket;

    public ClientConnection(Socket socket) {
        this.socket = socket;
    }

    public void send(String message) {

    }

    public String recieve() {
        return null;
    }
}
