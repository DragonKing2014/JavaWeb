package FileWriteAndRead;

import java.io.*;
/*�������ȴ����ļ�test.txt��
���Ѹ����������Զ�������ʽд�����ļ���
ͬʱ���������̨�ϡ�
���ϴ��������Ƕ�����д�룬���ܴ������룬
��Ҫ��д��һ�γ������������⡣*/
public class fileStreamTest{
	public static void main(String args[]){
	    try{
	      byte bWrite [] = {11,21,3,40,5};
	      //�����ļ�test.txt
	      OutputStream os = new FileOutputStream("test.txt");
	      for(int x=0; x < bWrite.length ; x++){
	      // writes the bytes in the loop
	      os.write( bWrite[x] ); 
	    }
	      os.close();
 
	    InputStream is = new FileInputStream("test.txt");
	    //�ļ����ַ���
	    int size = is.available();
	 
	    for(int i=0; i< size; i++){
	      System.out.print((char)is.read() + "  ");
	    }
	      is.close();
	    }catch(IOException e){
	      System.out.print("Exception");
	    }  
  }
}