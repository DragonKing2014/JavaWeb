package Dir;

import java.io.File;

public class DeleteFile {
  public static void main(String args[]) {
    //要删除的文件或文件夹的路径
	//该测试为删除一个文件夹下的所有内容（文件夹和文件）
    File folder = new File("D:/DirTest");
    String[] entries = folder.list();
    for(String s: entries){
        File currentFile = new File(folder.getPath(),s);
        currentFile.delete();
    }
  }
}