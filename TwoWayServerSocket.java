import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TwoWayServerSocket {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9999);
        Socket s = ss.accept();
        System.out.println("Client connected!");
        InputStream in = s.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String receivedmsg = br.readLine();
        System.out.println("msg from client : "+receivedmsg);
        OutputStream out = s.getOutputStream();
        PrintStream ps = new PrintStream(out);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter msg: ");
        String msg = sc.nextLine();
        ps.println(msg);
        ss.close();
        s.close();
        ps.close();
    }
}
