package Algorithms;

import java.util.Scanner;

/**
 * @author Dragon King
 * ����㷨
 */
public class Exhaustion {

	//1.����ͬ������
	public static boolean ChickenAndRabbit() {
		
		//�����ж��Ƿ��н�
		boolean hasSolution=false;
		//���̵������ͷ��̵Ľ�
		int foot,head;
		int chicken = 0,rabbit=0;
		
		@SuppressWarnings("resource")Scanner input=new Scanner(System.in);
		System.out.println("��ٷ��������ͬ�����⣺");
		System.out.println("������ͷ����");
		head=input.nextInt();
		System.out.println("�����������");
		foot=input.nextInt();
		
		//�㷨��ʼ
		for(int i=0;i<=head;i++){
			int j=head-i;
			if(i*2+j*4==foot){
				hasSolution=true;
				chicken=i;
				rabbit=j;
			}
		}
		if (hasSolution) {
			System.out.println("����"+chicken+ "ֻ������"+rabbit+"ֻ");
		}else{
			System.out.println("�޽⣡");
		}
		
		return hasSolution;
	}
	
	public static void main(String[] args) {
		//����
		ChickenAndRabbit();
		
	}
	
}
