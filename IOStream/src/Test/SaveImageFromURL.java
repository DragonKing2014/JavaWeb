package Test;

//从url上抓取图片到本地路径(或服务器路径)

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
	 * 保存图片到本地  把本地路径返回
	 * @param httpPath  图片的地址
	 * @return 本地路径
	 * @throws IOException
	 */
	public static String saveImg(String httpPath) throws IOException {

        URL url = null;
		URLConnection conn = null;
		url = new URL(httpPath);
		conn = url.openConnection();
		
		// formatName是图片的扩展名如：“jpg/gif”等，保存本地暂时无用
		String formatName = httpPath.substring(httpPath.lastIndexOf("."), httpPath.length());
		
		//记录保存的时间
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
		
		
		//保存图片的路径，顺便设置文件名称
		String imgPath = "D:/123.png";
		File f = new File(imgPath);
		f.getParentFile().mkdirs();
		try {
			// 创建新文件
			f.createNewFile();
			System.out.println("抓取图片成功！");
			System.out.println("创建时间："+pathDate);
		} catch (Exception e) {
			//打印日志。。。。。
			System.out.println("创建新文件时出现了错误...");
			e.printStackTrace();
		}

		BufferedImage image = ImageIO.read(conn.getInputStream());
		InputStream fis = getImageStream(image, formatName);
		FileOutputStream fos = new FileOutputStream(f);
		//读取和写入信息
		int len = 0;
		while ((len = fis.read()) != -1) {
			fos.write(len);
		}
		// 关闭流 先开后关 后开先关
		fos.close(); // 后开先关
		fis.close(); // 先开后关
		return imgPath;
	}

	//转换为流
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
