package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


/*
 * 使用URL读取页面内容
 */
public class Test03 {

	public static void main(String[] args) throws IOException {
		
		try {
			//创建一个URL实例
			URL url=new URL("http://www.baidu.com");
			//通过URL的openStream方法获取URL对象表示的资源字节输入流
			InputStream is=url.openStream();
			//将字节输入流转化为字符输入流
			InputStreamReader isr=new InputStreamReader(is,"utf-8");
			//为字符输入流添加缓冲
			BufferedReader br=new BufferedReader(isr);
			//读取数据
			String data=br.readLine();
			
			while(data!=null){
				System.out.println(data);
				data=br.readLine();
			}
			br.close();
			
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
		
	}
}
