
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            System.out.println("Server: Waiting for connection...");
            serverSocket = new ServerSocket(9999);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Didn't listen the port 9999");
            System.exit(1);
        }

        Socket socket = null;

        socket = serverSocket.accept();
        System.out.println("Server: Connected.");
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String fromUser = "";

        try {
            while (true) {
                fromUser = in.readLine();
                System.out.println("Receive: " + fromUser);//收到
                out.println("From Server: " + fromUser);//发出
                out.flush();
            }
        } catch (IOException e) {
            // TODO: handle exception
            out.close();
            in.close();
            serverSocket.close();
            socket.close();
            System.out.println("out of connection!");
        }

    }
}