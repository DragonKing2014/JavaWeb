package socket;

import java.net.InetAddress;
import java.net.Socket;
 
public class WebPing {
    public static void main(String[] args) {
        try {
            InetAddress addr;
            Socket sock = new Socket("www.baidu.com", 80);
            addr = sock.getInetAddress();
            System.out.println("���ӵ� " + addr);
            sock.close();
        } catch (java.io.IOException e) {
            System.out.println("�޷����� " + args[0]);
            System.out.println(e);
        }
    }
}