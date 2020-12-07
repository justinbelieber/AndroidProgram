
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

            // socket
        Socket connection = null;
        PrintStream serverOut = null;
        BufferedReader serverIn = null;

        try {
            System.out.println("Client: Waiting for connection...");
            connection = new Socket("127.0.0.1", 9999);
            serverOut = new PrintStream(connection.getOutputStream(), true);
            serverIn = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            System.out.println("Client: Connected.");
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            System.out.println("Connection failed.");
            // e1.printStackTrace();
        }

        Scanner input=new Scanner(System.in);

        try {
            while(true) {
               String line = input.next();
               serverOut.println(line);
            }
            
        } catch (Exception e) {
            //TODO: handle exception
          
            serverOut.close();
            System.out.println("Out of connection.");
        }
    }
    
}
