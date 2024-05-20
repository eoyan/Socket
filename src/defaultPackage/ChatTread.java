package defaultPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatTread extends Thread{

    private Socket sock = null;
    public ChatTread(Socket s) {
        sock = s;
    }
    public void run() {

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            PrintWriter out = new PrintWriter(sock.getOutputStream());
            while (true) { // 현재 클라이언와 대화 시작
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
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
