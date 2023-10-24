import java.io.*;
import java.net.Socket;

public class Client implements Runnable {
    private String serverName;
    private int serverPort;
    public Client(String serverName, int serverPort) {
        this.serverName = serverName;
        this.serverPort = serverPort;
    }

    public void run() {
        try {
            Socket s = new Socket(serverName, serverPort);
            InputStream in = s.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            OutputStream out = s.getOutputStream();
            PrintWriter writer = new PrintWriter(out);

            String eingang = reader.readLine();

            writer.println("Ich habe empfangen: " + eingang);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
