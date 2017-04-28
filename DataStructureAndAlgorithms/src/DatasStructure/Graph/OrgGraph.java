package DatasStructure.Graph;

import java.util.Scanner;

//׼����Ӧ����������ͼ�ṹ
class GraphMartix {

	static final int MaxNum = 20;
	static final int MaxValue = 65535;
	// ���涥������
	char[] Vertex = new char[MaxNum];
	// ͼ������(0.����ͼ 1.����ͼ)
	int Gtype;
	// ���������
	int VertexNum;
	// �ߵ�����
	int EdgeNum;
	// ����ߵ�Ȩֵ
	int[][] EdgeWeight = new int[MaxNum][MaxNum];
	// ������־
	int[] isTrav = new int[MaxNum];
}

public class OrgGraph {

	static Scanner input = new Scanner(System.in);

	/** �����ڽӾ���ͼ */
	static void CreateGraph(GraphMartix GM) {

		int i, j, k;
		int weight; // Ȩ
		char EstartV, EendV; // �ߵ���ʼ����

		System.out.println("����ͼ�и�����Ϣ");
		for (i = 0; i < GM.VertexNum; i++) {
			// ���붥��
			System.out.printf("��%d�����㣺", i + 1); // ���û����ֵ��±���1��ʼ
			// ���浽����������Ԫ����
			GM.Vertex[i] = (input.next().toCharArray())[0];
			/*
			 * toCharArray���� ���أ� һ���·�����ַ����飬���ĳ����Ǵ��ַ����ĳ��ȣ�
			 * �������ݱ���ʼ��Ϊ�������ַ�����ʾ���ַ����С�
			 */
		}

		System.out.println("���빹�ɸ��ߵĶ����Ȩֵ��");
		for (k = 0; k < GM.EdgeNum; k++) {
			// ����ߵ���Ϣ
			System.out.printf("��%d���ߣ�\n", k + 1);

			// ����ߵ���ʼ��
			EstartV = input.next().charAt(0);
			EendV = input.next().charAt(0);

			// ����ߵ�Ȩֵ
			weight = input.nextInt();
			/*
			 * charAt(int index) ������һ���ܹ����������ض������µ��ַ���Stringʵ���ķ���.
			 * charAt()��������ָ������λ�õ�charֵ��������ΧΪ0~length()-1
			 */

			for (i = 0; EstartV != GM.Vertex[i]; i++)
				; // �����ж����в��ҿ�ʼ��
			for (j = 0; EendV != GM.Vertex[j]; j++)
				; // �����ж����в��ҽ�����
			// ���⣬�Ҳ�����ô�죿

			// �ҵ��󣬶�Ӧλ�ñ���Ȩֵ����ʾֻ��һ����
			GM.EdgeWeight[i][j] = weight;
			if (GM.Gtype == 0) {
				// ���������ͼ�����ڶԽ�λ�ñ���Ȩֵ����ʾֻ��һ����
				GM.EdgeWeight[j][i] = weight;
			}
		}

	}

	/** ��վ��� */
	static void ClearGraph(GraphMartix GM) {
		int i, j;

		for (i = 0; i < GM.VertexNum; i++) {
			for (j = 0; j < GM.VertexNum; j++) {
				// �����ڽӾ����Ԫ�ص�ֵΪ���ֵ����ʾͼ�����������㶼������
				GM.EdgeWeight[i][j] = GraphMartix.MaxValue;
			}
		}
	}

	/** ����ڽӾ��� */
	static void OutGraph(GraphMartix GM) {
		int i, j;

		for (j = 0; j < GM.VertexNum; j++) {
			// �ڵ�һ�����������Ϣ
			System.out.printf("\t%c", GM.Vertex[j]);
		}
		System.out.printf("\n");

		for (i = 0; i < GM.VertexNum; i++) {
			// ÿ�еĵ�һ����ӡ��
			System.out.printf("%c", GM.Vertex[i]);

			for (j = 0; j < GM.VertexNum; j++) {
				if (GM.EdgeWeight[i][j] == GraphMartix.MaxValue) {
					// ��Z��ʾ���޴�
					System.out.printf("\tZ");
				} else {
					// ����ߵ�Ȩֵ
					System.out.printf("\t%d", GM.EdgeWeight[i][j]);

				}
			}
			System.out.printf("\n");
		}

	}

	/** �ӵ�n����㿪ʼ����ȱ���ͼ */
	static void DeepTraOne(GraphMartix GM, int n) {

		int i;
		GM.isTrav[n] = 1; // ��Ǹõ��Ѿ�������
		System.out.printf("->%c", GM.Vertex[n]); // ����õ�����

		// ��Ӵ�����Ĳ���
		for (i = 0; i < GM.VertexNum; i++) {
			if (GM.EdgeWeight[n][i] != GraphMartix.MaxValue
					&& GM.isTrav[n] == 0) {
				// �ݹ���б���
				DeepTraOne(GM, i);
			}
		}

	}

	/** ������ȱ��� */
	static void DeepTraGraph(GraphMartix GM) {
		int i;

		// ���������ı�����־
		for (i = 0; i < GM.VertexNum; i++) {
			GM.isTrav[i] = 0;
		}
		System.out.println("������ȱ�����㣺");
		for (i = 0; i < GM.VertexNum; i++) {
			if (GM.isTrav[i] == 0) { // ���õ�û������
				// ���ú�������
				DeepTraOne(GM, i);
			}
		}
		System.out.printf("\n");
	}

	public static void main(String[] args) {
		// ���屣���ڽӱ�ṹ��ͼ
		GraphMartix GM = new GraphMartix();

		System.out.println("��������ͼ�����ͣ�");
		GM.Gtype = input.nextInt(); // ����ͼ������
		System.out.println("����ͼ�Ķ���������");
		GM.VertexNum = input.nextInt(); // ����ͼ�Ķ�����
		System.out.println("����ͼ�ıߵ���Ŀ��");
		GM.EdgeNum = input.nextInt();
		ClearGraph(GM); // ���ͼ
		CreateGraph(GM); // �����ڽӱ�ṹ��ͼ
		System.out.println("��ͼ���ڽӾ�����������£�");
		OutGraph(GM); // ����ڽ�
		DeepTraGraph(GM); // ���������������ͼ

	}

}
