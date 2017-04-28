package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
 
/**
 * @author wang.jl
 */
public class SocketService {
     //���������
     public static void main(String[] args) throws IOException{
         SocketService socketService = new SocketService();
         //1��a)����һ����������Socket����SocketService 
         socketService.oneServer();
         
         
     }
     public  void oneServer(){
         try{
             ServerSocket server=null;
             try{
                 server=new ServerSocket(3308);
                 //b)ָ���󶨵Ķ˿ڣ��������˶˿ڡ�
                 System.out.print("�����������ɹ�");
                 //����һ��ServerSocket�ڶ˿�3312�����ͻ�����
             }catch(Exception e) {
                     System.out.println("û������������"+e);
             }
             
             Socket socket=null;
             try{
                 socket=server.accept();
                 //2������accept()������ʼ�������ȴ��ͻ��˵����� 
                 //ʹ��accept()�����ȴ��ͻ������пͻ�
                 //�����������һ��Socket���󣬲�����ִ��
             }catch(Exception e) {
                 System.out.println("Error."+e);
             }
             //3����ȡ������������ȡ�ͻ�����Ϣ 
             String line;
             BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
             //��Socket����õ�����������������Ӧ��BufferedReader����
             PrintWriter writer=new PrintWriter(socket.getOutputStream());
             //��Socket����õ��������������PrintWriter����
             BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
             //��ϵͳ��׼�����豸����BufferedReader����
             System.out.println("�������������ͻ��˷�����������:"+in.readLine());
             //�ڱ�׼����ϴ�ӡ�ӿͻ��˶�����ַ���
             line=br.readLine();
             //�ӱ�׼�������һ�ַ���
             //4����ȡ���������Ӧ�ͻ��˵����� 
             while(!line.equals("end")){
             //������ַ���Ϊ "bye"����ֹͣѭ��
                 writer.println(line);
                 //��ͻ���������ַ���
                 writer.flush();
                 //ˢ���������ʹClient�����յ����ַ���
                 System.out.println("Server:"+line);
                 //��ϵͳ��׼����ϴ�ӡ������ַ���
                 System.out.println("Client:"+in.readLine());
                 //��Client����һ�ַ���������ӡ����׼�����
                 line=br.readLine();
                 //��ϵͳ��׼�������һ�ַ���
             } //����ѭ��
 
             //5���ر���Դ 
             writer.close(); //�ر�Socket�����
             in.close(); //�ر�Socket������
             socket.close(); //�ر�Socket
             server.close(); //�ر�ServerSocket
         }catch(Exception e) {
             System.out.println("Error."+e);
         }
     }
 }