import java.io.IOException;

public class Client {
    public static void main(String[] args) {
        ClientSocket client = new ClientSocket("127.0.0.1", 8100);
        try {
            client.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
