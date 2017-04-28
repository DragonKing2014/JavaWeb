package Algorithms.sort;

public class SelectSort {

	static final int SIZE=10;
	public static void selectSort(int[] array){
		int index,temp;
		for (int i = 0; i < array.length-1; i++) {
			index=i;
			for (int j = i+1; j < array.length; j++) {
				if (array[j]<array[index]) {
					//index���ս�����α�������СԪ�ص��±�
					index=j;
				}
			}
			
			//������������ʹ��С��Ԫ��ʼ����ǰ��
			if (index!=i) {
				temp=array[i];
				array[i]=array[index];
				array[index]=temp;
			}
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
		
		selectSort(sortArray);
		
		System.out.println();
		System.out.println("����������Ϊ��");
		for(i=0;i<sortArray.length;i++){
			System.out.print(sortArray[i]+"\t");
		}
		System.out.println("\n");
	}
}
