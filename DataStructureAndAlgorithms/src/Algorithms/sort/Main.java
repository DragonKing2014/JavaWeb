package Algorithms.sort;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Stack<Integer> nums = new Stack<Integer>(); // 保存数字
		Stack<Character> opes = new Stack<Character>(); // 保存操作符
		
		String string = scanner.nextLine();
		
		int n = 0; // 保存每一个数字
		char[] cs = string.toCharArray();
		
		for (int i = 0; i < cs.length; i++) {
			char temp = cs[i];
			if (Character.isDigit(cs[i])) {
				n = 10 * n + Integer.parseInt(String.valueOf(cs[i])); // 大于10的数字保存
			} else {
				if (n != 0) {
					nums.push(n);
					n = 0;
				}
				 else  {
					if (opes.isEmpty()) { // 栈为空直接入栈
						opes.push(temp);
					} 
				}
			}
		}
		
		// 最后一个字符若是数字,未入栈
		if (n != 0) {
			nums.push(n);
		}
		while (!opes.isEmpty()) {
			int t = cal(nums.pop(), nums.pop(), opes.pop());
			nums.push(t);
		}
		System.out.println(nums.pop());
	}


	// 运算次序是反的,跟入栈出栈次序有关
	public static int cal(int m, int n, char c) {
		int sum = -987654321;
		if (c == '+') {
			sum = n + m;
		} else if (c == '-') {
			sum = n - m;
		} else if (c=='^'){
			sum=n++;
		}
		return sum;
	}
}
