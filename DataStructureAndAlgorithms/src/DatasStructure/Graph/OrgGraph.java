package DatasStructure.Graph;

import java.util.Scanner;

//准备相应数据来保存图结构
class GraphMartix {

	static final int MaxNum = 20;
	static final int MaxValue = 65535;
	// 保存顶点类型
	char[] Vertex = new char[MaxNum];
	// 图的类型(0.无向图 1.有向图)
	int Gtype;
	// 顶点的数量
	int VertexNum;
	// 边的数量
	int EdgeNum;
	// 保存边的权值
	int[][] EdgeWeight = new int[MaxNum][MaxNum];
	// 遍历标志
	int[] isTrav = new int[MaxNum];
}

public class OrgGraph {

	static Scanner input = new Scanner(System.in);

	/** 创建邻接矩阵图 */
	static void CreateGraph(GraphMartix GM) {

		int i, j, k;
		int weight; // 权
		char EstartV, EendV; // 边的起始顶点

		System.out.println("输入图中各项信息");
		for (i = 0; i < GM.VertexNum; i++) {
			// 输入顶点
			System.out.printf("第%d个顶点：", i + 1); // 给用户呈现的下标以1开始
			// 保存到各顶点数组元素中
			GM.Vertex[i] = (input.next().toCharArray())[0];
			/*
			 * toCharArray方法 返回： 一个新分配的字符数组，它的长度是此字符串的长度，
			 * 而且内容被初始化为包含此字符串表示的字符序列。
			 */
		}

		System.out.println("输入构成各边的顶点和权值：");
		for (k = 0; k < GM.EdgeNum; k++) {
			// 输入边的信息
			System.out.printf("第%d条边：\n", k + 1);

			// 输入边的起始点
			EstartV = input.next().charAt(0);
			EendV = input.next().charAt(0);

			// 输入边的权值
			weight = input.nextInt();
			/*
			 * charAt(int index) 方法是一个能够用来检索特定索引下的字符的String实例的方法.
			 * charAt()方法返回指定索引位置的char值。索引范围为0~length()-1
			 */

			for (i = 0; EstartV != GM.Vertex[i]; i++)
				; // 在已有顶点中查找开始点
			for (j = 0; EendV != GM.Vertex[j]; j++)
				; // 在已有顶点中查找结束点
			// 问题，找不到怎么办？

			// 找到后，对应位置保存权值，表示只有一条边
			GM.EdgeWeight[i][j] = weight;
			if (GM.Gtype == 0) {
				// 如果是无向图，则在对角位置保存权值，表示只有一条边
				GM.EdgeWeight[j][i] = weight;
			}
		}

	}

	/** 清空矩阵 */
	static void ClearGraph(GraphMartix GM) {
		int i, j;

		for (i = 0; i < GM.VertexNum; i++) {
			for (j = 0; j < GM.VertexNum; j++) {
				// 设置邻接矩阵各元素的值为最大值，表示图中任意两个点都不相邻
				GM.EdgeWeight[i][j] = GraphMartix.MaxValue;
			}
		}
	}

	/** 输出邻接矩阵 */
	static void OutGraph(GraphMartix GM) {
		int i, j;

		for (j = 0; j < GM.VertexNum; j++) {
			// 在第一行输出顶点信息
			System.out.printf("\t%c", GM.Vertex[j]);
		}
		System.out.printf("\n");

		for (i = 0; i < GM.VertexNum; i++) {
			// 每行的第一个打印符
			System.out.printf("%c", GM.Vertex[i]);

			for (j = 0; j < GM.VertexNum; j++) {
				if (GM.EdgeWeight[i][j] == GraphMartix.MaxValue) {
					// 以Z表示无限大
					System.out.printf("\tZ");
				} else {
					// 输出边的权值
					System.out.printf("\t%d", GM.EdgeWeight[i][j]);

				}
			}
			System.out.printf("\n");
		}

	}

	/** 从第n个结点开始，深度遍历图 */
	static void DeepTraOne(GraphMartix GM, int n) {

		int i;
		GM.isTrav[n] = 1; // 标记该店已经被遍历
		System.out.printf("->%c", GM.Vertex[n]); // 输出该点数据

		// 添加处理结点的操作
		for (i = 0; i < GM.VertexNum; i++) {
			if (GM.EdgeWeight[n][i] != GraphMartix.MaxValue
					&& GM.isTrav[n] == 0) {
				// 递归进行遍历
				DeepTraOne(GM, i);
			}
		}

	}

	/** 深度优先遍历 */
	static void DeepTraGraph(GraphMartix GM) {
		int i;

		// 清除各个点的遍历标志
		for (i = 0; i < GM.VertexNum; i++) {
			GM.isTrav[i] = 0;
		}
		System.out.println("深度优先遍历结点：");
		for (i = 0; i < GM.VertexNum; i++) {
			if (GM.isTrav[i] == 0) { // 若该点没被遍历
				// 调用函数遍历
				DeepTraOne(GM, i);
			}
		}
		System.out.printf("\n");
	}

	public static void main(String[] args) {
		// 定义保存邻接表结构的图
		GraphMartix GM = new GraphMartix();

		System.out.println("输入生成图的类型：");
		GM.Gtype = input.nextInt(); // 定义图的种类
		System.out.println("输入图的顶点数量：");
		GM.VertexNum = input.nextInt(); // 输入图的顶点数
		System.out.println("输入图的边的数目：");
		GM.EdgeNum = input.nextInt();
		ClearGraph(GM); // 清空图
		CreateGraph(GM); // 生成邻接表结构的图
		System.out.println("该图的邻接矩阵的数据如下：");
		OutGraph(GM); // 输出邻接
		DeepTraGraph(GM); // 深度优先搜索遍历图

	}

}
