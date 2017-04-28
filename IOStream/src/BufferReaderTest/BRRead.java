package BufferReaderTest;

//使用 BufferedReader 在控制台读取字符

import java.io.*;

public class BRRead {

	public static void main(String args[]) throws IOException {

		char c;
		// 使用System.in创建BufferedReader
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		System.out.println("输入字符, 按下 'q' 键退出。");
		// 在控制台读取字符
		do {
			c = (char) bufferedReader.read();
			System.out.println(c);
		} while (c != 'q');

		// 在控制台读取字符串
		// JDK 5 后的版本我们也可以使用Java Scanner类来获取控制台的输入
		String str;
		do {
			str = bufferedReader.readLine();
			System.out.println(str);
		} while (!str.equals("end"));
	}
}