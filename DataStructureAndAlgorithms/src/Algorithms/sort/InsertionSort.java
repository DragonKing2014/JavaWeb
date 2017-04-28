package Algorithms.sort;

public class InsertionSort {

	static final int SIZE=10;
	
	static void insertionSort(int[] array){
		int i,j,t;
		
		for (i = 1; i < array.length; i++) {
			t=array[i];
			//j是i的前一个下标
			j=i-1;
			while(j>=0&&t<array[j]){
				//选择合适的位置插入，如果小于当前元素就往前移动一位
				array[j+1]=array[j];
				j--;
			}
			
			array[j+1]=t;
			
			System.out.print("第"+i+"步排序结果是：");
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
			//初始化数组为随机数序列
			sortArray[i]=(int)(100+Math.random()*(100+1));
		}
		
		System.out.println("排序前的数组为：");
		for(i=0;i<sortArray.length;i++){
			System.out.print(sortArray[i]+"\t");
		}
		System.out.print("\n\n");
		
		insertionSort(sortArray);
		
		System.out.println();
		System.out.println("排序后的数组为：");
		for(i=0;i<sortArray.length;i++){
			System.out.print(sortArray[i]+"\t");
		}
		System.out.println("\n");
	}
}
