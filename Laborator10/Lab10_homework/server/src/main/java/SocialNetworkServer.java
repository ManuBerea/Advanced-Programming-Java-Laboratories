import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocialNetworkServer {
    public static final int port = 8100;;

    public SocialNetworkServer() throws IOException {

        // Create a socket
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);

            while (true) {

                System.out.println("The server is waiting for connections");
                Socket socket;
                serverSocket.setSoTimeout(2000);
                try {
                    socket = serverSocket.accept();
                    new ClientThread(socket).start();
                }
                catch (java.io.InterruptedIOException e ) {
                    System.err.println( "Timed Out!" );
                    System.out.println("Connection terminated!");
                    System.exit(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
