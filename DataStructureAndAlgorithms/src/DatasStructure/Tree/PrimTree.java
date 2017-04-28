package DatasStructure.Tree;

/**
 * 最小生成树Prim算法，加入最小邻接边生成最小生成树。
 * 首先构造一个零图，选择一个初始点加入到集合中，
 * 然后分别从原来顶点的集合中抽取一个顶点，
 * 选择的标准是到原集合点的边权值最小， 循序渐进最终生成一棵最小生成树
 */
public class PrimTree {
	/**
	 * @author Dragon
	 * @date 2017-04-15
	 */

	/*
	 * m:定义为无法到达的距离 
	 * weight:邻接矩阵表,weight表示权值 
	 * verNum:顶点的个数 
	 * lowerW:到新集合的最小权值
	 * edge:存储点集到新集合的边(数组下标代表的起始顶点，存储的数值代表到达的顶点)
	 * checked:判定某个顶点是否被抽取的集合，模拟新集合
	 */

	static int m = Integer.MAX_VALUE;
	static int[][] weight = { 
			{ 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, m, 6, 9, 5, 13 ,12},
			{ 0, 6, m, 6, 7, 8 ,1}, 
			{ 0, 9, 6, m, 9, 3 ,3}, 
			{ 0, 5, 7, 9, m, 3 ,5},
			{ 0, 13, 8, 1, 3, m ,8},
			{ 0, 12, 1, 3, 5, 8, m}};
	static int verNum = weight.length;
	static int[] lowerW = new int[verNum];
	static int[] edge = new int[verNum];
	static boolean[] checked = new boolean[verNum];

	public void prim(int n, int[][] w) {

		//初始化，顶点集合
		for (int i = 1; i <= n; i++) { // 初始化顶点集合
			lowerW[i] = w[1][i];
			edge[i] = 1;
			checked[i] = false;
		}

		checked[1] = true; // 抽取第一个顶点
		
		for (int i = 1; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			
			int j = 1;
			for (int k = 2; k <= n; k++) { // 判定是否抽取该顶点
				if (lowerW[k] < min && (!checked[k])) {
					min = lowerW[k];
					//j存储一次遍历后，决定选取的顶点
					j = k;
				}
			}

			if (i < n) {// 避免输出第一个顶点到第一个顶点的情况
				System.out.println("顶点"+j + "-->" + "顶点"+edge[j]+",该边权值是"+weight[j][edge[j]]);
			}

			checked[j] = true; // 将顶点加入到新集合中

			for (int k = 2; k <= n; k++) { // 根据新加入的顶点，求得最小的权值
				if ((w[j][k] < lowerW[k]) && (!checked[k])) {
					//存储最小权值
					lowerW[k] = weight[j][k];
					edge[k] = j;
				}
			}
		}
	}

	public static void main(String[] args) {

		PrimTree p = new PrimTree();
		System.out.println("最小生成树的边为：");
		p.prim(verNum - 1, weight);
	}
}
