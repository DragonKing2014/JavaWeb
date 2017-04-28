package Dir;

//使用IO流创建文件夹
import java.io.File;

public class CreateDir {
  public static void main(String args[]) {
	//创建的文件夹的路径
    String dirname = "D:/DirTest";
    File d = new File(dirname);
    // 现在创建目录
    d.mkdirs();
  }
}