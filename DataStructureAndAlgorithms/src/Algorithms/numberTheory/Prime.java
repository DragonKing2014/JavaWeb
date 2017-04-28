package Algorithms.numberTheory;

public class Prime {

	//素数算法(类似于穷举法)
	static int isPrime(int a){
		int i;
		for(i=2;i<a;i++){
			if(a%i==0){
				return 0;     //不是素数
			}
		}
		return 1;             //是素数
	}
	
	public static void main(String[] args) {
		int i,n,count;
		n=90000;
		count=0;
		System.out.printf("列举1—%d之间所有的素数：\n",n);
		
		for(i=1;i<n;i++){
			
			if (isPrime(i)==1) {
				System.out.printf("%7d", i);
				count++;
				if (count%10==0) {
					//十个一行
					System.out.printf("\n");
				}
			}

			
		}
	}
}
