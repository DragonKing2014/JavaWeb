package Dir;

import java.io.File;

/**һ��Ŀ¼��ʵ����һ�� File ���������������ļ����ļ��С�
 *�������һ�� File ����������һ��Ŀ¼��
 *��ô����isDirectory()�����᷵�� true��
 *����ͨ�����øö����ϵ� list() ������
 *����ȡ���������ļ����ļ��е��б�*/
public class DirList {
	//�жϺ�ʶ��һ��·����һ��·���µ��ļ����ļ���
    public static void main(String args[]) {
	    String dirname = "E:/QQPCmgr/Desktop/������ѧϰ���ϰ�";
	    File f1 = new File(dirname);
	    if (f1.isDirectory()) {
	      System.out.println( "Ŀ¼ " + dirname);
	      String s[] = f1.list();
	      for (int i=0; i < s.length; i++) {
	        File f = new File(dirname + "/" + s[i]);
	        if (f.isDirectory()) {
	          System.out.println(s[i] + " ��һ��Ŀ¼");
	        } else {
	          System.out.println(s[i] + " ��һ���ļ�");
	        }
	      }
	    } else {
	      System.out.println(dirname + " ����һ��Ŀ¼");
	    }
  }
}