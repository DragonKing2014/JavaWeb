package DatasStructure.Tree;

import java.util.Scanner;

/**
 *  @author Dragon King
 *  @date 2017-03-25
 */

// ����������������
class CBTType {
	String data; // Ԫ������
	CBTType left; // �������������
	CBTType right; // �������������
}

public class BinaryTree {
	static final int MAXLEN = 20;
	static Scanner input = new Scanner(System.in);

	// ��ʼ���������ĸ�
	@SuppressWarnings("unused")
	CBTType InitTree() {

		CBTType node;
		if ((node = new CBTType()) != null) { // �����ڴ�

			System.out.printf("��������һ����������ݣ�\n");
			node.data = input.next();
			node.left = null;
			node.right = null;

			if (node != null) {
				return node;
			} else {
				return null;
			}
		}

		return null;
	}

	// ��ӽ��
	void AddTreeNode(CBTType treeNode) {

		CBTType pnode, parent;
		String data;
		int menusel;

		if ((pnode = new CBTType()) != null) { // �����ڴ�
			System.out.printf("���������������ݣ�\n");

			pnode.data = input.next();
			pnode.left = null; // ������������Ϊ��
			pnode.right = null;

			System.out.println("������ý��ĸ��ڵ����ݣ�");
			data = input.next();

			parent = TreeFindNode(treeNode, data); // �鵽ָ�����ݵĽ��
			if (parent == null) {
				System.out.println("δ�ҵ��ø���㣡");
				pnode = null; // �ͷŴ����Ľ���ڴ�
				return;

			}

			System.out.println("1.��ӽ�㵽������\n2.��Ӹý�㵽������");

			do {
				menusel = input.nextInt(); // ����ѡ����

				if (menusel == 1 || menusel == 2) {
					if (parent == null) {
						System.out.println("�����ڸ���㣬�������ø���㣡");
					} else {

						switch (menusel) {

						// ��ӵ�����
						case 1:
							// ��������Ϊ��
							if (parent.left != null) {
								System.out.println("��������㲻Ϊ�գ�");
							} else {
								parent.left = pnode;
							}
							break;

						// ��ӵ��ҽ��
						case 2:
							// ��������Ϊ��
							if (parent.right != null) {
								System.out.println("��������㲻Ϊ�գ�");
							} else {
								parent.right = pnode;
							}
							break;

						default:
							System.out.println("��Ч������");

						}
					}
				}

			} while (menusel != 1 && menusel != 2);

		}
	}

	// ���ҽ��
	CBTType TreeFindNode(CBTType treeNode, String data) { // ���ҽ��

		CBTType ptr;

		if (treeNode == null) {
			return null;
		} else {
			if (treeNode.data.equals(data)) {
				return treeNode;
			} else {
				// �ֱ������������������ݹ����
				if ((ptr = TreeFindNode(treeNode.left, data)) != null) {
					return ptr;
				} else if ((ptr = TreeFindNode(treeNode.right, data)) != null) {
					return ptr;
				} else {
					return null;
				}
			}
		}

	}

	// ��ȡ������
	CBTType TreeLeftNode(CBTType treeNode) {
		if (treeNode != null) {
			return treeNode.left;
		} else {
			return null;
		}
	}

	// ��ȡ������
	CBTType TreeRightNode(CBTType treeNode) {
		if (treeNode != null) {
			return treeNode.right;
		} else {
			return null;
		}
	}

	// �жϿ���
	int TreeIsEmpty(CBTType treeNode) {
		if (treeNode != null) {
			return 0;
		} else {
			return 1;
		}
	}

	//������������
	int TreeDepth(CBTType treeNode){
		int depLeft,depRight;
		
		if(treeNode==null){
			//���ڿ������������0
			return 0;
		}else {
			//���������(�ݹ����)
			depLeft=TreeDepth(treeNode.left);
			//���������(�ݹ����)
			depRight=TreeDepth(treeNode.right);
			
			if (depLeft>depRight) {
				return depLeft+1;
			}else {
				return depRight+1;
			}
			
		}
	}
	
	//��ն�����
	void ClearTree(CBTType treeNode){
		if (treeNode!=null) {
			ClearTree(treeNode.left);     //���������
			ClearTree(treeNode.right);    //���������
			treeNode=null;                //�ͷŵ�ǰ�����ռ�ڴ�
		}
	}
	
	//��ʾ�������
	void TreeNodeData(CBTType p){
		//����������
		System.out.printf("%s ",p.data);
	}
	
	//�������
	void LevelTree(CBTType treeNode){
		
	}
	
	//ǰ�����
	void DLRTree(CBTType treeNode){
		if (treeNode!=null) {
			TreeNodeData(treeNode);
			DLRTree(treeNode.left);
			DLRTree(treeNode.right);
		}
	}
	
	//�������
	void LDRTree(CBTType treeNode){
		if (treeNode!=null) {
			LDRTree(treeNode.left);
			TreeNodeData(treeNode);
			LDRTree(treeNode.right);
		}
	}
	
	//�������
	void LRDTree(CBTType treeNode){
		if (treeNode!=null) {
			LRDTree(treeNode.left);
			LRDTree(treeNode.right);
			TreeNodeData(treeNode);
		}
	}
	
	public static void main(String[] args) {
		//rootΪָ�����������������
		CBTType root=null;
		int menusel;
		BinaryTree t=new BinaryTree();
		
		//���ø�Ԫ��
		root=t.InitTree();
		//��ӽ��
		do {
			System.out.println("��ѡ��˵���Ӷ������Ľ�㣺");
			System.out.println("0.�˳�    1.��Ӷ��������");
			menusel=input.nextInt();
			switch (menusel) {
			case 1:
				t.AddTreeNode(root);      //��ӽ��
				break;
			case 0:
				break;
			default:
					;
			}	
		} while (menusel!=0);
		
		//����
		do {
			System.out.println("ѡ������������˵�������0��ʾ�˳���");
			System.out.println("1.ǰ�����DLR");
			System.out.println("2.�������LDR");
			System.out.println("3.�������LRD");
			
			menusel=input.nextInt();
			switch (menusel) {
			case 0:
				break;
			case 1:
				System.out.println("ǰ������Ľ���ǣ�");
				t.DLRTree(root);
				break;
			case 2:
				System.out.println("��������Ľ���ǣ�");
				t.LDRTree(root);
				break;
			case 3:
				System.out.println("��������Ľ���ǣ�");
				t.LRDTree(root);
				break;
			
			default:
				;
			}
		} while (menusel!=0);
		
		//���
		System.out.println("�����������Ϊ��"+t.TreeDepth(root));
		
		//��ն�����
		t.ClearTree(root);
		root=null;
		
		
		
		
	}
	
	
	
	
	
	
	
}