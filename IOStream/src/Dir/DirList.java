package Dir;

import java.io.File;

/**一个目录其实就是一个 File 对象，它包含其他文件和文件夹。
 *如果创建一个 File 对象并且它是一个目录，
 *那么调用isDirectory()方法会返回 true。
 *可以通过调用该对象上的 list() 方法，
 *来提取它包含的文件和文件夹的列表。*/
public class DirList {
	//判断和识别一个路径或一个路径下的文件和文件夹
    public static void main(String args[]) {
	    String dirname = "E:/QQPCmgr/Desktop/大三下学习资料包";
	    File f1 = new File(dirname);
	    if (f1.isDirectory()) {
	      System.out.println( "目录 " + dirname);
	      String s[] = f1.list();
	      for (int i=0; i < s.length; i++) {
	        File f = new File(dirname + "/" + s[i]);
	        if (f.isDirectory()) {
	          System.out.println(s[i] + " 是一个目录");
	        } else {
	          System.out.println(s[i] + " 是一个文件");
	        }
	      }
	    } else {
	      System.out.println(dirname + " 不是一个目录");
	    }
  }
}