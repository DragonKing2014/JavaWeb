package Algorithms;

import java.util.Scanner;

/**
 * @author Dragon King
 * 计算水仙花数
 */
public class NarcissisticNumber {

	public static void NarcssusNum(int n){
		//输入参数n表示要查找的水仙花数的位数
		
		long i,start,end,temp,num,sum;
		int j;
		
		//step1.计算起始和终止数据
		start=(long) Math.pow(10,n-1);         
		end=(long) Math.pow(10, n);             
		
		//根据水仙花数的定义，对所有数据逐个去判断
		for(i=start;i<=end;i++){
			temp=0;
			num=i;
			sum=0;
			
			//将数据各个位分离出来，并逐个进行n次幂的累加
			for (j = 0; j < n; j++) {
				
				//计算数据num的各个位数，并将它赋值给temp
				temp=num%10;
				//计算各个位的n次幂，并累加到sum中
				sum=sum+(long)Math.pow(temp, n);
				//num的移位操作，num减去个位数temp再除以10，相当于数据右移一位
				num=(num-temp)/10;
			}
			if(sum==i){
				System.out.printf("%d\n",i);   //输出水仙花数
			}
		}
		
		
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		System.out.println("列举几位的水仙花数？");
		int n=input.nextInt();
		
		System.out.printf("以下是所有的%d位水仙花数：",n);
		NarcssusNum(n);
		System.out.printf("\n");
		
	}

}
