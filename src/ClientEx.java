//import java.io.*;
//import java.net.*;
//import java.util.*;
//
//public class ClientEx {
//    public static void main(String[] args) {
//        try {
//            Socket sock = new Socket("localhost", 9999);
//
//            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
//            PrintWriter out = new PrintWriter(sock.getOutputStream());
//            Scanner sc = new Scanner(System.in);
//            while(true) {
//                System.out.println(">> ");
//                String mymsg = sc.next();
//                out.println(mymsg);
//                out.flush();
//
//                String msg = in.readLine();
//                System.out.println(msg);
//                if(mymsg.equals("bye")) break;
//            }
//
//            sock.close();
//            sc.close();
//            System.out.println("Client Server was Stopped..");
//        }
//        catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//}
