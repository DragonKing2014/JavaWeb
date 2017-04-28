package socketcomm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
 

/**
 * @author Dragon King
 * 1.服务器建立通信ServerSocket
 * 2.服务器建立Socket接收客户端连接
 * 3.建立IO输入流读取客户端发送的数据
 * 4.建立IO输出流向客户端发送数据消息
 */
public class Server {
   public static void main(String[] args) {
      try {
    	 //服务器建立通信ServerSocket
         ServerSocket ss = new ServerSocket(2);
         System.out.println("启动服务器....");
         
         //服务器建立Socket接收客户端连接,如果没有接收到连接，
         //则不往下运行程序，等待客户端请求
         Socket s = ss.accept();
         System.out.println("客户端:"+s.getInetAddress().getLocalHost()+"已连接到服务器");
         
         BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
         //读取客户端发送来的消息
         String mess = br.readLine();
         System.out.println("客户端发来："+mess);
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
         bw.write(mess+"\n");
         bw.flush();
         
         
         s.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}