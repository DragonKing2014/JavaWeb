package demo;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Test01 {

	public static void main(String[] args) throws UnknownHostException {
		// ��ȡ������InetAddressʵ��
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("���������" + address.getHostName());
		System.out.println("IP��ַ��" + address.getHostAddress());

		// ��ȡ�ֽ�������ʽ��IP��ַ
		byte[] bytes = address.getAddress();
		System.out.println("�ֽ�������ʽ��IP��" + Arrays.toString(bytes));
		// ֱ�����InetAddress����
		System.out.println(address);

		// ������������ȡ��InetAddressʵ��
		InetAddress address2 = InetAddress.getByName("PC-20140705OQOQ");
		System.out.println("���������" + address2.getHostName());
		System.out.println("IP��ַ��" + address2.getHostAddress());

	}
}
