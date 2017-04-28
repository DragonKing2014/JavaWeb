package socket;
 
 import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.InputStreamReader;
 import java.io.PrintWriter;
 import java.net.Socket;
 
 /**
  * @author wang.jl
  */
 public class SocketClient {
     // ��ͻ���
     public static void main(String[] args) throws IOException {
         try {
             // 1�������ͻ���Socket��ָ����������ַ�Ͷ˿�
             Socket socket = new Socket("127.0.0.1", 3318);
             System.out.println("�ͻ��������ɹ�");
             // 2����ȡ���������������˷�����Ϣ
             // �򱾻���3318�˿ڷ����ͻ�����
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             // ��ϵͳ��׼�����豸����BufferedReader����
             PrintWriter write = new PrintWriter(socket.getOutputStream());
             // ��Socket����õ��������������PrintWriter����
             //3����ȡ������������ȡ�������˵���Ӧ��Ϣ 
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             // ��Socket����õ�����������������Ӧ��BufferedReader����
             String readline;
             readline = br.readLine(); // ��ϵͳ��׼�������һ�ַ���
             while (!readline.equals("end")) {
                 // ���ӱ�׼���������ַ���Ϊ "end"��ֹͣѭ��
                 write.println(readline);
                 // ����ϵͳ��׼���������ַ��������Server
                 write.flush();
                 // ˢ���������ʹServer�����յ����ַ���
                 System.out.println("�ͻ��˷�����Ϣ:" + readline);
                 // ��ϵͳ��׼����ϴ�ӡ������ַ���
                 System.out.println("Server:" + in.readLine());
                 // ��Server����һ�ַ���������ӡ����׼�����
                 readline = br.readLine(); // ��ϵͳ��׼�������һ�ַ���
             } // ����ѭ��
             //4���ر���Դ 
             write.close(); // �ر�Socket�����
             in.close(); // �ر�Socket������
             socket.close(); // �ر�Socket
         } catch (Exception e) {
             System.out.println("can not listen to:" + e);// ��������ӡ������Ϣ
         }
     }
 
 }