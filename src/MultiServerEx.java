import java.io.*;
import java.net.*;
public class MultiServerEx {
    public static void main(String[] args) {
        try {
            ServerSocket srvsock = new ServerSocket(9999);
            System.out.println("Server started ... \n");
            for (int i=0; i<1; i++) { // 최대 5개의 클라이언트까지 "순차적으로" 접속 허용
                Socket sock = srvsock.accept();
                System.out.println("IP: " + sock.getInetAddress() + ", port: " + sock.getPort());
                BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                PrintWriter out = new PrintWriter(sock.getOutputStream());
                while(true) { // 현재 클라이언와 대화 시작
                    String msg = in.readLine(); //수신
                    System.out.println(msg);
                    out.println("OK");
                    out.flush();
                    if (msg.equals("bye")) {
                        out.println("bye");
                        sock.close(); // 현재 클라이언트와의 접속 종료
                        break; // 전달된 메시지가 bye일 경우 현재 클라이언트와 접속 종료
                    }
                }

            }
            srvsock.close();
            System.out.println("\nServer stopped ...");
        } catch (IOException ex) { ex.printStackTrace(); }
    }
}
