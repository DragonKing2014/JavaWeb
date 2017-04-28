package Test;

//��url��ץȡͼƬ������·��(�������·��)

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;




public class SaveImageFromURL {

	/**
	 * ����ͼƬ������  �ѱ���·������
	 * @param httpPath  ͼƬ�ĵ�ַ
	 * @return ����·��
	 * @throws IOException
	 */
	public static String saveImg(String httpPath) throws IOException {

        URL url = null;
		URLConnection conn = null;
		url = new URL(httpPath);
		conn = url.openConnection();
		
		// formatName��ͼƬ����չ���磺��jpg/gif���ȣ����汾����ʱ����
		String formatName = httpPath.substring(httpPath.lastIndexOf("."), httpPath.length());
		
		//��¼�����ʱ��
		Date date = new Date(System.currentTimeMillis());
		String pathDate= null;
		try  
		{  
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
		    pathDate = sdf.format(date);  
		}  
		catch (Exception e)  
		{  
		    //log.info(e.getMessage());  
		}  
		
		
		//����ͼƬ��·����˳�������ļ�����
		String imgPath = "D:/123.png";
		File f = new File(imgPath);
		f.getParentFile().mkdirs();
		try {
			// �������ļ�
			f.createNewFile();
			System.out.println("ץȡͼƬ�ɹ���");
			System.out.println("����ʱ�䣺"+pathDate);
		} catch (Exception e) {
			//��ӡ��־����������
			System.out.println("�������ļ�ʱ�����˴���...");
			e.printStackTrace();
		}

		BufferedImage image = ImageIO.read(conn.getInputStream());
		InputStream fis = getImageStream(image, formatName);
		FileOutputStream fos = new FileOutputStream(f);
		//��ȡ��д����Ϣ
		int len = 0;
		while ((len = fis.read()) != -1) {
			fos.write(len);
		}
		// �ر��� �ȿ���� ���ȹ�
		fos.close(); // ���ȹ�
		fis.close(); // �ȿ����
		return imgPath;
	}

	//ת��Ϊ��
	public static  InputStream getImageStream(BufferedImage image, String formatName) {
			InputStream iS = null;
			BufferedImage bI = image;
			bI.flush();
			ByteArrayOutputStream bs = new ByteArrayOutputStream();
			ImageOutputStream imOut;
			try {
				imOut = ImageIO.createImageOutputStream(bs);
				ImageIO.write(bI, "png", imOut);
				iS = new ByteArrayInputStream(bs.toByteArray());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return iS;
		}

	public static void main(String[] args) throws IOException {
		
		saveImg("http://210.76.70.94/file/mercCatalog/33.png");
	}

	
}
