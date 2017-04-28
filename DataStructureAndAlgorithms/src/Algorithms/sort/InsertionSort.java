package Algorithms.sort;

public class InsertionSort {

	static final int SIZE=10;
	
	static void insertionSort(int[] array){
		int i,j,t;
		
		for (i = 1; i < array.length; i++) {
			t=array[i];
			//j��i��ǰһ���±�
			j=i-1;
			while(j>=0&&t<array[j]){
				//ѡ����ʵ�λ�ò��룬���С�ڵ�ǰԪ�ؾ���ǰ�ƶ�һλ
				array[j+1]=array[j];
				j--;
			}
			
			array[j+1]=t;
			
			System.out.print("��"+i+"���������ǣ�");
			for (int k = 0; k < array.length; k++) {
				System.out.print(array[k]+"  ");
			}
			System.out.println(" ");
		}
		
	}
	
	public static void main(String[] args) {
		int[] sortArray=new int[SIZE];
		int i;
		
		for(i=0;i<sortArray.length;i++){
			//��ʼ������Ϊ���������
			sortArray[i]=(int)(100+Math.random()*(100+1));
		}
		
		System.out.println("����ǰ������Ϊ��");
		for(i=0;i<sortArray.length;i++){
			System.out.print(sortArray[i]+"\t");
		}
		System.out.print("\n\n");
		
		insertionSort(sortArray);
		
		System.out.println();
		System.out.println("����������Ϊ��");
		for(i=0;i<sortArray.length;i++){
			System.out.print(sortArray[i]+"\t");
		}
		System.out.println("\n");
	}
}
