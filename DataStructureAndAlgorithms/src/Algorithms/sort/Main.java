package Algorithms.sort;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Stack<Integer> nums = new Stack<Integer>(); // ��������
		Stack<Character> opes = new Stack<Character>(); // ���������
		
		String string = scanner.nextLine();
		
		int n = 0; // ����ÿһ������
		char[] cs = string.toCharArray();
		
		for (int i = 0; i < cs.length; i++) {
			char temp = cs[i];
			if (Character.isDigit(cs[i])) {
				n = 10 * n + Integer.parseInt(String.valueOf(cs[i])); // ����10�����ֱ���
			} else {
				if (n != 0) {
					nums.push(n);
					n = 0;
				}
				 else  {
					if (opes.isEmpty()) { // ջΪ��ֱ����ջ
						opes.push(temp);
					} 
				}
			}
		}
		
		// ���һ���ַ���������,δ��ջ
		if (n != 0) {
			nums.push(n);
		}
		while (!opes.isEmpty()) {
			int t = cal(nums.pop(), nums.pop(), opes.pop());
			nums.push(t);
		}
		System.out.println(nums.pop());
	}


	// ��������Ƿ���,����ջ��ջ�����й�
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
