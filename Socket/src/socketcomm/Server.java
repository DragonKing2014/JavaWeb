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
 * 1.����������ͨ��ServerSocket
 * 2.����������Socket���տͻ�������
 * 3.����IO��������ȡ�ͻ��˷��͵�����
 * 4.����IO�������ͻ��˷���������Ϣ
 */
public class Server {
   public static void main(String[] args) {
      try {
    	 //����������ͨ��ServerSocket
         ServerSocket ss = new ServerSocket(2);
         System.out.println("����������....");
         
         //����������Socket���տͻ�������,���û�н��յ����ӣ�
         //���������г��򣬵ȴ��ͻ�������
         Socket s = ss.accept();
         System.out.println("�ͻ���:"+s.getInetAddress().getLocalHost()+"�����ӵ�������");
         
         BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
         //��ȡ�ͻ��˷���������Ϣ
         String mess = br.readLine();
         System.out.println("�ͻ��˷�����"+mess);
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
         bw.write(mess+"\n");
         bw.flush();
         
         
         s.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}