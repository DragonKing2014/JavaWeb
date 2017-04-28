package zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class DecompressZip {

	public static void main(String[] args) {
		File file=new File("E:\\ZipTest.zip");
		//����ZipInput����
		ZipInputStream zin;
		
		try {
			//����ѹ���ļ�����
			ZipFile zipFile=new ZipFile(file);
			//ʵ��������ָ��Ҫ���н�ѹ���ļ�
			zin=new ZipInputStream(new FileInputStream(file));
			//������Ŀ¼����ȡ��һ��ZipEntry
			ZipEntry entry=zin.getNextEntry();
			
			while(((entry=zin.getNextEntry())!=null)&&!entry.isDirectory()){
				File tmp=new File("E:\\"+entry.getName());
				if (!tmp.exists()) {
					tmp.getParentFile().mkdirs();
					OutputStream os=new FileOutputStream(tmp);
					InputStream in=zipFile.getInputStream(entry);
					int count=0;
					while((count=in.read())!=-1){
						os.write(count);
					}
					os.close();
					in.close();
				}
				zin.closeEntry();
				System.out.println(entry.getName()+"��ѹ�ɹ�");
			}
			zin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
