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
 * 1.����Socketͨ�ţ�����ͨ�ŷ�������IP��Port
 * 2.����IO����������������������Ϣ
 * 3.����IO��������ȡ��������������������Ϣ
 */
public class Client {
   public static void main(String[] args) {
      try {
         Socket s = new Socket("127.0.0.1",2);
         
         //����IO��
         InputStream is = s.getInputStream();
         OutputStream os = s.getOutputStream();
         
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
         //IO����������������������Ϣ
         bw.write("��Ϣ\n");
         bw.flush();
         
         //IO��������ȡ��������������������Ϣ
         BufferedReader br = new BufferedReader(new InputStreamReader(is));
         String mess = br.readLine();
         System.out.println("��������"+mess);
         
         s.close();
         
      } catch (UnknownHostException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}