package DatasStructure.Tree;

/**
 * ��С������Prim�㷨��������С�ڽӱ�������С��������
 * ���ȹ���һ����ͼ��ѡ��һ����ʼ����뵽�����У�
 * Ȼ��ֱ��ԭ������ļ����г�ȡһ�����㣬
 * ѡ��ı�׼�ǵ�ԭ���ϵ�ı�Ȩֵ��С�� ѭ�򽥽���������һ����С������
 */
public class PrimTree {
	/**
	 * @author Dragon
	 * @date 2017-04-15
	 */

	/*
	 * m:����Ϊ�޷�����ľ��� 
	 * weight:�ڽӾ����,weight��ʾȨֵ 
	 * verNum:����ĸ��� 
	 * lowerW:���¼��ϵ���СȨֵ
	 * edge:�洢�㼯���¼��ϵı�(�����±�������ʼ���㣬�洢����ֵ������Ķ���)
	 * checked:�ж�ĳ�������Ƿ񱻳�ȡ�ļ��ϣ�ģ���¼���
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

		//��ʼ�������㼯��
		for (int i = 1; i <= n; i++) { // ��ʼ�����㼯��
			lowerW[i] = w[1][i];
			edge[i] = 1;
			checked[i] = false;
		}

		checked[1] = true; // ��ȡ��һ������
		
		for (int i = 1; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			
			int j = 1;
			for (int k = 2; k <= n; k++) { // �ж��Ƿ��ȡ�ö���
				if (lowerW[k] < min && (!checked[k])) {
					min = lowerW[k];
					//j�洢һ�α����󣬾���ѡȡ�Ķ���
					j = k;
				}
			}

			if (i < n) {// ���������һ�����㵽��һ����������
				System.out.println("����"+j + "-->" + "����"+edge[j]+",�ñ�Ȩֵ��"+weight[j][edge[j]]);
			}

			checked[j] = true; // ��������뵽�¼�����

			for (int k = 2; k <= n; k++) { // �����¼���Ķ��㣬�����С��Ȩֵ
				if ((w[j][k] < lowerW[k]) && (!checked[k])) {
					//�洢��СȨֵ
					lowerW[k] = weight[j][k];
					edge[k] = j;
				}
			}
		}
	}

	public static void main(String[] args) {

		PrimTree p = new PrimTree();
		System.out.println("��С�������ı�Ϊ��");
		p.prim(verNum - 1, weight);
	}
}
