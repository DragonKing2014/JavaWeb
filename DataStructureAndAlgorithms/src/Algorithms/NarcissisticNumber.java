package Algorithms;

import java.util.Scanner;

/**
 * @author Dragon King
 * ����ˮ�ɻ���
 */
public class NarcissisticNumber {

	public static void NarcssusNum(int n){
		//�������n��ʾҪ���ҵ�ˮ�ɻ�����λ��
		
		long i,start,end,temp,num,sum;
		int j;
		
		//step1.������ʼ����ֹ����
		start=(long) Math.pow(10,n-1);         
		end=(long) Math.pow(10, n);             
		
		//����ˮ�ɻ����Ķ��壬�������������ȥ�ж�
		for(i=start;i<=end;i++){
			temp=0;
			num=i;
			sum=0;
			
			//�����ݸ���λ������������������n���ݵ��ۼ�
			for (j = 0; j < n; j++) {
				
				//��������num�ĸ���λ������������ֵ��temp
				temp=num%10;
				//�������λ��n���ݣ����ۼӵ�sum��
				sum=sum+(long)Math.pow(temp, n);
				//num����λ������num��ȥ��λ��temp�ٳ���10���൱����������һλ
				num=(num-temp)/10;
			}
			if(sum==i){
				System.out.printf("%d\n",i);   //���ˮ�ɻ���
			}
		}
		
		
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		System.out.println("�оټ�λ��ˮ�ɻ�����");
		int n=input.nextInt();
		
		System.out.printf("���������е�%dλˮ�ɻ�����",n);
		NarcssusNum(n);
		System.out.printf("\n");
		
	}

}
