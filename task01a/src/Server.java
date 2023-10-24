import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private String name;
    private int port;

    public Server(String name, int port) {
        this.name = name;
        this.port = port;
    }

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while(true) {
                try {
                    Socket s = serverSocket.accept();
                    InputStream in = s.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                    OutputStream out = s.getOutputStream();
                    PrintWriter writer = new PrintWriter(out);

                    writer.println("Warte auf Verbindungen...");
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
