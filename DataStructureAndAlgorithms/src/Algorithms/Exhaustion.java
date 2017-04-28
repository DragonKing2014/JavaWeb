package Algorithms;

import java.util.Scanner;

/**
 * @author Dragon King
 * 穷举算法
 */
public class Exhaustion {

	//1.鸡兔同笼问题
	public static boolean ChickenAndRabbit() {
		
		//用于判断是否有解
		boolean hasSolution=false;
		//方程的条件和方程的解
		int foot,head;
		int chicken = 0,rabbit=0;
		
		@SuppressWarnings("resource")Scanner input=new Scanner(System.in);
		System.out.println("穷举法解决鸡兔同笼问题：");
		System.out.println("请输入头数：");
		head=input.nextInt();
		System.out.println("请输入脚数：");
		foot=input.nextInt();
		
		//算法开始
		for(int i=0;i<=head;i++){
			int j=head-i;
			if(i*2+j*4==foot){
				hasSolution=true;
				chicken=i;
				rabbit=j;
			}
		}
		if (hasSolution) {
			System.out.println("鸡有"+chicken+ "只，兔有"+rabbit+"只");
		}else{
			System.out.println("无解！");
		}
		
		return hasSolution;
	}
	
	public static void main(String[] args) {
		//测试
		ChickenAndRabbit();
		
	}
	
}
