import java.io.*;
import java.net.*;

public class ClientEx {
    public static void main(String[] args) {
        try {
            Socket sock = new Socket("localhost", 9999);

            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            PrintWriter out = new PrintWriter(sock.getOutputStream());

            out.println("Hello!");
            out.flush();
            String msg = in.readLine();
            System.out.println(msg);

            sock.close();
            System.out.println("Client Server was Stopped..");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
