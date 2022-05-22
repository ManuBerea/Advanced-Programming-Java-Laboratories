import java.io.IOException;

public class Server {
    public static void main(String[] args) {
        try {
            SocialNetworkServer s = new SocialNetworkServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
