package Dir;

import java.io.File;

public class DeleteFile {
  public static void main(String args[]) {
    //Ҫɾ�����ļ����ļ��е�·��
	//�ò���Ϊɾ��һ���ļ����µ��������ݣ��ļ��к��ļ���
    File folder = new File("D:/DirTest");
    String[] entries = folder.list();
    for(String s: entries){
        File currentFile = new File(folder.getPath(),s);
        currentFile.delete();
    }
  }
}