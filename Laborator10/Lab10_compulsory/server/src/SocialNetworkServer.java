import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocialNetworkServer {
    public static final int PORT = 8100;

    public SocialNetworkServer() throws IOException {

        // Create a socket to listen to (TCP)
        // socket - capete ale comunicarii intre 2 programe
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println("The server is waiting for a client...");
                // Wait until a connection is made, then accept it.
                Socket socket = serverSocket.accept(); //se creeaza un socket

                new SocialNetworkClientThread(socket).start(); // se porneste un thread care executa cererile clientului
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert serverSocket != null;
            serverSocket.close();
        }
    }

}
