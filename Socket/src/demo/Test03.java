package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


/*
 * ʹ��URL��ȡҳ������
 */
public class Test03 {

	public static void main(String[] args) throws IOException {
		
		try {
			//����һ��URLʵ��
			URL url=new URL("http://www.baidu.com");
			//ͨ��URL��openStream������ȡURL�����ʾ����Դ�ֽ�������
			InputStream is=url.openStream();
			//���ֽ�������ת��Ϊ�ַ�������
			InputStreamReader isr=new InputStreamReader(is,"utf-8");
			//Ϊ�ַ���������ӻ���
			BufferedReader br=new BufferedReader(isr);
			//��ȡ����
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
