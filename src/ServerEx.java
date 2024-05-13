//import java.io.*;
//import java.net.*;
//
//public class ServerEx {
//    public static void main(String[] args) {
//
//        try {
//            ServerSocket srvsock = new ServerSocket(9999);
//
//            for(int i = 0; i < 5; i++) {
//                Socket sock = srvsock.accept(); // 클라이언트의 접속 대기
//                System.out.println("IP: " + sock.getInetAddress() + ", port: " + sock.getPort());
//
//                // 접속 시 실행
//
//                BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
//                PrintWriter out = new PrintWriter(sock.getOutputStream());
//
//                while(true) {
//                    String msg = in.readLine();
//                    System.out.println(msg);
//                    out.println("Ok");
//                    out.flush();
//
//                    if (msg.equals("bye")) break;
//                }
//                sock.close();
//            }
//
//            srvsock.close();
//            System.out.println("Disconnected with Server");
//        }
//
//        catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//}
