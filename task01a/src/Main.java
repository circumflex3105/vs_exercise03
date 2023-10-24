public class Main {
    static String serverName = "localhost";
    static int serverPort = 1234;

    public static void main(String[] args) {
        new Thread(new Server(serverName, serverPort)).start();
        new Thread(new Client(serverName, serverPort)).start();
    }
}