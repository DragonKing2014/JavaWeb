package Algorithms.sort;

/**
 * ð�������㷨
 */
public class BubbleSort {

	static final int SIZE=10;
	
	public static void bubbleSort(int[] array){
		
		int temp;
		for (int i = 1;i < array.length;i++) {
			for (int j = 0; j < array.length-i; j++) {
				//�����ڵ����������бȽϣ��ϴ��������ð��
				if (array[j]>array[j+1]) {
					//�������ڵ�������
					temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
			//���ÿ������Ľ��
			System.out.print("��"+i+"������Ľ���ǣ�");
			for (int k = 0; k < array.length; k++) {
				System.out.print(array[k]+"  ");      //ѭ����ӡ
			}
			System.out.print("\n");
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
		
		bubbleSort(sortArray);
		
		System.out.println();
		System.out.println("����������Ϊ��");
		for(i=0;i<sortArray.length;i++){
			System.out.print(sortArray[i]+"\t");
		}
		System.out.println("\n");
		
	}
	
}
