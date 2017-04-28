package demo;

import java.net.MalformedURLException;
import java.net.URL;

/*
 * URL��������
 */
public class Test02 {

	public static void main(String[] args) {
		
		try {
			//����һ��URLʵ��
			URL baidu=new URL("http://www.baidu.com");
			//?�����ʾ������#�����ʾê��
			URL url=new URL(baidu,"/index.html?username=Tom#test");
			System.out.println("Э�飺"+url.getProtocol());
			System.out.println("������"+url.getHost());
			//���δָ���˿ںţ���ʹ��Ĭ�϶˿ںţ���ʱgetPort()�����ķ���ֵΪ-1
			System.out.println("�˿ڣ�"+url.getPort());
			System.out.println("�ļ�·����"+url.getPath());
			System.out.println("�ļ�����"+url.getFile());
			System.out.println("���·����"+url.getRef());
			System.out.println("��ѯ�ַ�����"+url.getQuery());
			
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
	}
}
