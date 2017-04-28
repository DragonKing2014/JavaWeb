package Algorithms.sort;

/**
 * 冒泡排序算法
 */
public class BubbleSort {

	static final int SIZE=10;
	
	public static void bubbleSort(int[] array){
		
		int temp;
		for (int i = 1;i < array.length;i++) {
			for (int j = 0; j < array.length-i; j++) {
				//将相邻的两个数进行比较，较大的数往后冒泡
				if (array[j]>array[j+1]) {
					//交换相邻的两个数
					temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
			//输出每步排序的结果
			System.out.print("第"+i+"步排序的结果是：");
			for (int k = 0; k < array.length; k++) {
				System.out.print(array[k]+"  ");      //循环打印
			}
			System.out.print("\n");
		}
	}
	
	public static void main(String[] args) {
		
		int[] sortArray=new int[SIZE];
		int i;
		
		for(i=0;i<sortArray.length;i++){
			//初始化数组为随机数序列
			sortArray[i]=(int)(100+Math.random()*(100+1));
		}
		
		System.out.println("排序前的数组为：");
		for(i=0;i<sortArray.length;i++){
			System.out.print(sortArray[i]+"\t");
		}
		System.out.print("\n\n");
		
		bubbleSort(sortArray);
		
		System.out.println();
		System.out.println("排序后的数组为：");
		for(i=0;i<sortArray.length;i++){
			System.out.print(sortArray[i]+"\t");
		}
		System.out.println("\n");
		
	}
	
}
