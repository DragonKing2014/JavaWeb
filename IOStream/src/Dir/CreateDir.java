package Dir;

//ʹ��IO�������ļ���
import java.io.File;

public class CreateDir {
  public static void main(String args[]) {
	//�������ļ��е�·��
    String dirname = "D:/DirTest";
    File d = new File(dirname);
    // ���ڴ���Ŀ¼
    d.mkdirs();
  }
}