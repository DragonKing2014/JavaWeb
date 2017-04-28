package zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

//对文件进行压缩
public class MyZip {

	private void zip(String zipFileName,File inpFile) throws Exception{
		
		//创建ZipOutputStream类对象
		ZipOutputStream out=new ZipOutputStream(
				new FileOutputStream(zipFileName));
		//调用重载方法
		zip(out, inpFile,"");
		System.out.println("压缩中...");
		out.close();
		
		
	}
	
	private void zip(ZipOutputStream out,File f,String base) throws Exception{
		//首先测试此抽象路径名表示的文件是否是一个目录
		if(f.isDirectory()){
			File[] fl=f.listFiles();
			if (base.length()!=0) {
				out.putNextEntry(new ZipEntry(base+"/"));
			}
			//循环遍历文件数组中的文件
			for(int i=0;i<fl.length;i++){
				zip(out, fl[i],base+fl[i]);
			}
		}else {
			//创建新的进入点
			out.putNextEntry(new ZipEntry(base));
			//创建FileInputStream对象
			FileInputStream in=new FileInputStream(f);
			int b;
			System.out.println(base);
			while((b=in.read())!=-1){
				out.write(b);
			}
			in.close();
		}
	}
	
	public static void main(String[] args) {
		MyZip book=new MyZip();
		try {
			//调用压缩方法，参数为压缩后的文件和要压缩的文件
			book.zip("E:/ZipTest.zip", new File("E:/ZipTest"));
			System.out.println("压缩完成！");
		} catch (Exception e) {

		}
	}
}
