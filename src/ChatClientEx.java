import java.net.*;
import java.io.*;
import java.util.*;

// 사용자로부터 메시지 입력받도록 Scanner 클래스 이용
// 콘솔에서 메시지 입력
// 사용자가 입력한 메시지가 bye일 경우 종료


public class ChatClientEx {
    public static void main(String[] args) {
        try {
            Socket sock = new Socket("localhost", 9999);
            System.out.println("server started.. \n");
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            PrintWriter out = new PrintWriter(sock.getOutputStream());
            Scanner sc = new Scanner(System.in);

            while(true) {
                System.out.println(">> ");
                String mymsg = sc.nextLine(); // 전송
                out.println(mymsg);
                out.flush();

                String msg = in.readLine();
                System.out.println(msg);
                if(mymsg.equals("bye")) break;
            }
            sc.close();
            sock.close();
            System.out.println("\nClient Stopped... ");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
