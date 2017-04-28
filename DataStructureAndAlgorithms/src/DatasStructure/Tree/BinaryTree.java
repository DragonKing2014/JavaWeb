package DatasStructure.Tree;

import java.util.Scanner;

/**
 *  @author Dragon King
 *  @date 2017-03-25
 */

// 定义二叉树结点类型
class CBTType {
	String data; // 元素数据
	CBTType left; // 左子树结点引用
	CBTType right; // 右子树结点引用
}

public class BinaryTree {
	static final int MAXLEN = 20;
	static Scanner input = new Scanner(System.in);

	// 初始化二叉树的根
	@SuppressWarnings("unused")
	CBTType InitTree() {

		CBTType node;
		if ((node = new CBTType()) != null) { // 申请内存

			System.out.printf("请先输入一个根结点数据：\n");
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

	// 添加结点
	void AddTreeNode(CBTType treeNode) {

		CBTType pnode, parent;
		String data;
		int menusel;

		if ((pnode = new CBTType()) != null) { // 分配内存
			System.out.printf("输入二叉树结点数据：\n");

			pnode.data = input.next();
			pnode.left = null; // 设置左右子树为空
			pnode.right = null;

			System.out.println("请输入该结点的父节点数据：");
			data = input.next();

			parent = TreeFindNode(treeNode, data); // 查到指定数据的结点
			if (parent == null) {
				System.out.println("未找到该父结点！");
				pnode = null; // 释放创建的结点内存
				return;

			}

			System.out.println("1.添加结点到左子树\n2.添加该结点到右子树");

			do {
				menusel = input.nextInt(); // 输入选择项

				if (menusel == 1 || menusel == 2) {
					if (parent == null) {
						System.out.println("不存在父结点，请先设置父结点！");
					} else {

						switch (menusel) {

						// 添加到左结点
						case 1:
							// 左子树不为空
							if (parent.left != null) {
								System.out.println("左子树结点不为空！");
							} else {
								parent.left = pnode;
							}
							break;

						// 添加到右结点
						case 2:
							// 右子树不为空
							if (parent.right != null) {
								System.out.println("右子树结点不为空！");
							} else {
								parent.right = pnode;
							}
							break;

						default:
							System.out.println("无效参数！");

						}
					}
				}

			} while (menusel != 1 && menusel != 2);

		}
	}

	// 查找结点
	CBTType TreeFindNode(CBTType treeNode, String data) { // 查找结点

		CBTType ptr;

		if (treeNode == null) {
			return null;
		} else {
			if (treeNode.data.equals(data)) {
				return treeNode;
			} else {
				// 分别向左子树和右子树递归查找
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

	// 获取左子树
	CBTType TreeLeftNode(CBTType treeNode) {
		if (treeNode != null) {
			return treeNode.left;
		} else {
			return null;
		}
	}

	// 获取右子树
	CBTType TreeRightNode(CBTType treeNode) {
		if (treeNode != null) {
			return treeNode.right;
		} else {
			return null;
		}
	}

	// 判断空树
	int TreeIsEmpty(CBTType treeNode) {
		if (treeNode != null) {
			return 0;
		} else {
			return 1;
		}
	}

	//计算二叉树深度
	int TreeDepth(CBTType treeNode){
		int depLeft,depRight;
		
		if(treeNode==null){
			//对于空树，返回深度0
			return 0;
		}else {
			//左子树深度(递归调用)
			depLeft=TreeDepth(treeNode.left);
			//右子树深度(递归调用)
			depRight=TreeDepth(treeNode.right);
			
			if (depLeft>depRight) {
				return depLeft+1;
			}else {
				return depRight+1;
			}
			
		}
	}
	
	//清空二叉树
	void ClearTree(CBTType treeNode){
		if (treeNode!=null) {
			ClearTree(treeNode.left);     //清空左子树
			ClearTree(treeNode.right);    //清空右子树
			treeNode=null;                //释放当前结点所占内存
		}
	}
	
	//显示结点数据
	void TreeNodeData(CBTType p){
		//输出结点数据
		System.out.printf("%s ",p.data);
	}
	
	//按层遍历
	void LevelTree(CBTType treeNode){
		
	}
	
	//前序遍历
	void DLRTree(CBTType treeNode){
		if (treeNode!=null) {
			TreeNodeData(treeNode);
			DLRTree(treeNode.left);
			DLRTree(treeNode.right);
		}
	}
	
	//中序遍历
	void LDRTree(CBTType treeNode){
		if (treeNode!=null) {
			LDRTree(treeNode.left);
			TreeNodeData(treeNode);
			LDRTree(treeNode.right);
		}
	}
	
	//后序遍历
	void LRDTree(CBTType treeNode){
		if (treeNode!=null) {
			LRDTree(treeNode.left);
			LRDTree(treeNode.right);
			TreeNodeData(treeNode);
		}
	}
	
	public static void main(String[] args) {
		//root为指向二叉树根结点的引用
		CBTType root=null;
		int menusel;
		BinaryTree t=new BinaryTree();
		
		//设置根元素
		root=t.InitTree();
		//添加结点
		do {
			System.out.println("请选择菜单添加二叉树的结点：");
			System.out.println("0.退出    1.添加二叉树结点");
			menusel=input.nextInt();
			switch (menusel) {
			case 1:
				t.AddTreeNode(root);      //添加结点
				break;
			case 0:
				break;
			default:
					;
			}	
		} while (menusel!=0);
		
		//遍历
		do {
			System.out.println("选择二叉树遍历菜单，输入0表示退出：");
			System.out.println("1.前序遍历DLR");
			System.out.println("2.中序遍历LDR");
			System.out.println("3.后序遍历LRD");
			
			menusel=input.nextInt();
			switch (menusel) {
			case 0:
				break;
			case 1:
				System.out.println("前序遍历的结果是：");
				t.DLRTree(root);
				break;
			case 2:
				System.out.println("中序遍历的结果是：");
				t.LDRTree(root);
				break;
			case 3:
				System.out.println("后序遍历的结果是：");
				t.LRDTree(root);
				break;
			
			default:
				;
			}
		} while (menusel!=0);
		
		//深度
		System.out.println("二叉树的深度为："+t.TreeDepth(root));
		
		//清空二叉树
		t.ClearTree(root);
		root=null;
		
		
		
		
	}
	
	
	
	
	
	
	
}