package zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

//���ļ�����ѹ��
public class MyZip {

	private void zip(String zipFileName,File inpFile) throws Exception{
		
		//����ZipOutputStream�����
		ZipOutputStream out=new ZipOutputStream(
				new FileOutputStream(zipFileName));
		//�������ط���
		zip(out, inpFile,"");
		System.out.println("ѹ����...");
		out.close();
		
		
	}
	
	private void zip(ZipOutputStream out,File f,String base) throws Exception{
		//���Ȳ��Դ˳���·������ʾ���ļ��Ƿ���һ��Ŀ¼
		if(f.isDirectory()){
			File[] fl=f.listFiles();
			if (base.length()!=0) {
				out.putNextEntry(new ZipEntry(base+"/"));
			}
			//ѭ�������ļ������е��ļ�
			for(int i=0;i<fl.length;i++){
				zip(out, fl[i],base+fl[i]);
			}
		}else {
			//�����µĽ����
			out.putNextEntry(new ZipEntry(base));
			//����FileInputStream����
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
			//����ѹ������������Ϊѹ������ļ���Ҫѹ�����ļ�
			book.zip("E:/ZipTest.zip", new File("E:/ZipTest"));
			System.out.println("ѹ����ɣ�");
		} catch (Exception e) {

		}
	}
}
