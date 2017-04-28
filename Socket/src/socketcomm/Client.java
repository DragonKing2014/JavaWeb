package socketcomm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Dragon King
 * 1.创建Socket通信，设置通信服务器的IP和Port
 * 2.建立IO输出流向服务器发送数据消息
 * 3.建立IO输入流读取服务器发送来的数据消息
 */
public class Client {
   public static void main(String[] args) {
      try {
         Socket s = new Socket("127.0.0.1",2);
         
         //构建IO流
         InputStream is = s.getInputStream();
         OutputStream os = s.getOutputStream();
         
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
         //IO输出流向服务器发送数据消息
         bw.write("信息\n");
         bw.flush();
         
         //IO输入流读取服务器发送来的数据消息
         BufferedReader br = new BufferedReader(new InputStreamReader(is));
         String mess = br.readLine();
         System.out.println("服务器："+mess);
         
         s.close();
         
      } catch (UnknownHostException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}