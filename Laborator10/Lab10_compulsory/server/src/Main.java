import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            SocialNetworkServer server = new SocialNetworkServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
