package comparetowebservice;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class WeatherClient{
	 
    public static void main(String[] args) throws UnknownHostException, IOException{
         
        //1.����Socket���󣬺ͷ���˽�������
        Socket socket = new Socket("127.0.0.1",12346);
         
        //2.���ͳ�������
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF("����");
        System.out.println("�����ѯ����: ����");
         
        //3.���ܷ��ؽ��ʹ��������
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String result = dis.readUTF();
        System.out.println("����������: " + result);
         
        //4.�ر���
        dis.close();
        dos.close();
    }
}