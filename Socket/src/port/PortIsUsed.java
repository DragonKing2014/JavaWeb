package port;

import java.net.*;
import java.io.*;
 
public class PortIsUsed {

public static void IsUse(String host,int port) {
      Socket Skt;
      try {
            System.out.println("查看 "+ port);
            //能创建成功说明端口已经被占用
            Skt = new Socket(host, port);

            System.out.println("端口 " + port + " 已被使用");
			
            
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
        
      