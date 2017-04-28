package FileWriteAndRead;

import java.io.*;
/*程序首先创建文件test.txt，
并把给定的数字以二进制形式写进该文件，
同时输出到控制台上。
以上代码由于是二进制写入，可能存在乱码，
需要编写另一段程序解决乱码问题。*/
public class fileStreamTest{
	public static void main(String args[]){
	    try{
	      byte bWrite [] = {11,21,3,40,5};
	      //创建文件test.txt
	      OutputStream os = new FileOutputStream("test.txt");
	      for(int x=0; x < bWrite.length ; x++){
	      // writes the bytes in the loop
	      os.write( bWrite[x] ); 
	    }
	      os.close();
 
	    InputStream is = new FileInputStream("test.txt");
	    //文件的字符数
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