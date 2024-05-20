package defaultPackage;

import java.io.*;
import java.net.*;
public class MultiServerEx{
    public static void main(String[] args) {
        try {
            ServerSocket srvsock = new ServerSocket(9999);
            System.out.println("Server started ... \n");
            for (int i=0; i<1; i++) { // 최대 5개의 클라이언트까지 "순차적으로" 접속 허용
                Socket sock = srvsock.accept();
                System.out.println("IP: " + sock.getInetAddress() + ", port: " + sock.getPort());


                ChatTread ct = new ChatTread(sock);
                ct.start();

            }
            srvsock.close();
            System.out.println("\nServer stopped ...");
        } catch (IOException ex) { ex.printStackTrace(); }
    }
}
