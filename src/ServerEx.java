import java.io.*;
import java.net.*;

public class ServerEx {
    public static void main(String[] args) {

        try {
            ServerSocket srvsock = new ServerSocket(9999);
            Socket sock = srvsock.accept(); // 클라이언트의 접속 대기

            // 접속 시 실행

            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            PrintWriter out = new PrintWriter(sock.getOutputStream());


            String msg = in.readLine();
            System.out.println(msg);
            out.println("Ok");
            out.flush();

            sock.close();
            System.out.println("Disconnected with Server");
        }

        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
