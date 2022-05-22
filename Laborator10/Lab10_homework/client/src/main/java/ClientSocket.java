import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket {
    private final String serverAddress;
    private final int PORT;

    private Socket socket;

    // For responses coming from the server
    BufferedReader in;

    public ClientSocket(String serverAddress, int PORT) {
        this.serverAddress = serverAddress;
        this.PORT = PORT;
    }
    public void connect() throws IOException {
        socket = new Socket(serverAddress, PORT);
        // build the message for the server
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String request = null;
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
        int clientActive = 1;
        do {
            System.out.print("Input command: ");
            request = consoleInput.readLine();

            if(!request.equals("exit")) {
                // Send the request to the server

                    out.println(request);
                    out.flush();

                // Wait for the response
                String response = in.readLine();
                System.out.println("Server response: '" + response + "'");
            }
            else {
                System.out.println("\nGoodbye!!");
                clientActive=0;
            }

        } while (clientActive>0);
    }
    
}
