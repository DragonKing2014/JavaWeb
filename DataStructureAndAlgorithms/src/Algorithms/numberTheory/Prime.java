package Algorithms.numberTheory;

public class Prime {

	//�����㷨(��������ٷ�)
	static int isPrime(int a){
		int i;
		for(i=2;i<a;i++){
			if(a%i==0){
				return 0;     //��������
			}
		}
		return 1;             //������
	}
	
	public static void main(String[] args) {
		int i,n,count;
		n=90000;
		count=0;
		System.out.printf("�о�1��%d֮�����е�������\n",n);
		
		for(i=1;i<n;i++){
			
			if (isPrime(i)==1) {
				System.out.printf("%7d", i);
				count++;
				if (count%10==0) {
					//ʮ��һ��
					System.out.printf("\n");
				}
			}

			
		}
	}
}
