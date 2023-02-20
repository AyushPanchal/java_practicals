import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class TwoClientSocket {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost",9999);

        OutputStream out = s.getOutputStream();
        PrintStream ps = new PrintStream(out);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter msg: ");
        String msg = sc.nextLine();
        ps.println(msg);
        InputStream in = s.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String receivedmsg = br.readLine();
        System.out.println("Server msg : "+receivedmsg);
        s.close();
        ps.close();
    }
}
