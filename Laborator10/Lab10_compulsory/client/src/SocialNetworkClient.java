import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocialNetworkClient {
    private final String serverAddress;
    private final int PORT;

    // For responses coming from the server
    BufferedReader input;

    public SocialNetworkClient(String serverAddress, int PORT) {
        this.serverAddress = serverAddress;
        this.PORT = PORT;
    }

    public void connect() throws IOException {
        Socket socket = new Socket(serverAddress, PORT);

        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Send a request to the server
        String request = null;
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\nWelcome Client!\n");
        do {
            System.out.print("Type a command: ");
            request = consoleInput.readLine();
//            System.out.println("Read the request: '" + request + "'");

            // Send the request to the server
            output.println(request);
            output.flush();

            // Wait for the response from the server
            String response = input.readLine();
            if(request.equals("exit")){
                System.out.println("\nGoodbye!\n");
            }
            else if(request.equals("stop")){
                output.close();
                output.flush();
                System.exit(0);
            }
            else {
                System.out.println("Server response: '" + response + "'!");
            }
        } while (!request.equals("exit"));
    }
}
