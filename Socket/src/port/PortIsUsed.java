package port;

import java.net.*;
import java.io.*;
 
public class PortIsUsed {

public static void IsUse(String host,int port) {
      Socket Skt;
      try {
            System.out.println("�鿴 "+ port);
            //�ܴ����ɹ�˵���˿��Ѿ���ռ��
            Skt = new Socket(host, port);

            System.out.println("�˿� " + port + " �ѱ�ʹ��");
			
            
         }
         catch (UnknownHostException e) {
            System.out.println("Exception occured"+ e);
         }
         catch (IOException e) {
         }
      }
   
   public static void main(String[] args) {
	   
	   IsUse("localhost", 3305);
   }
}
        
      