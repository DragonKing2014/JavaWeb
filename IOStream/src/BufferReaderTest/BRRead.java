package BufferReaderTest;

//ʹ�� BufferedReader �ڿ���̨��ȡ�ַ�

import java.io.*;

public class BRRead {

	public static void main(String args[]) throws IOException {

		char c;
		// ʹ��System.in����BufferedReader
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		System.out.println("�����ַ�, ���� 'q' ���˳���");
		// �ڿ���̨��ȡ�ַ�
		do {
			c = (char) bufferedReader.read();
			System.out.println(c);
		} while (c != 'q');

		// �ڿ���̨��ȡ�ַ���
		// JDK 5 ��İ汾����Ҳ����ʹ��Java Scanner������ȡ����̨������
		String str;
		do {
			str = bufferedReader.readLine();
			System.out.println(str);
		} while (!str.equals("end"));
	}
}