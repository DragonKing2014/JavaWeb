package DatasStructure.LinearListOrg;

import java.util.Scanner;


/**
 * @author Dragon King
 * 一个顺序表具体实现实例
 */
public class SequentialList {

	//公共类用于测试
	public static void main(String[] args) {
		
		int i;
		SLtype SL=new SLtype();     //定义顺序表变量
		SLDATA pdata;                 //定义结点保存所用的引用变量
		String key;                 //关键字保存变量
		
		//初始化顺序表
		SL.SLInit(SL);
		
		System.out.println("顺序表初始化完成！");
		
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		
		//循环添加结点数据
		do {
			System.out.println("输入添加的结点(学号 姓名 年龄)：");
			SLDATA data=new SLDATA();
			data.key=input.next();
			data.name=input.next();
			data.age=input.nextInt();
			
			if (data.age!=0) {
				
				//如果添加结点失败
				if (SL.SLAdd(SL, data)==0) {
					break;    //退出死循环
				}
			}else{
				break;
				//若年龄为0，也退出死循环
			}
			
		} while (true);
		
		System.out.println("顺序表中的结点按顺序打印：");
		//显示所有结点数据
		SL.SLAll(SL);
		
		System.out.println("输入要取出的结点序号：");
		i=input.nextInt();
		
		//按序号查询结点
		pdata=SL.SLFindByNum(SL, i);
		if (pdata!=null) {
			System.out.printf("第%d个结点为：(%s,%s,%d)\n"
					,i,pdata.key,pdata.name,pdata.age);
		}
		
		//按关键字查询结点
		System.out.println("输入需要查找的关键字：");
		key=input.next();
		//按关键字查找，返回结点序号
		i=SL.SLFindByCont(SL, key);
		//按序号查找，返回结点的引用
		pdata=SL.SLFindByNum(SL, i);
		if (pdata!=null) {
			System.out.printf("第%d个结点为：(%s,%s,%d)\n"
					,i,pdata.key,pdata.name,pdata.age);
		}
		
	}
	
}

//一个结点
class SLDATA{
	String key;       //结点的关键字
	String name;
	int age;
}

//定义顺序表数据结构
class SLtype{
	static final int MAXLEN=100;
	//保存顺序表的数据结构
	SLDATA[] ListData=new SLDATA[MAXLEN+1];
	//顺序表已经保存结点的数量
	int ListLen;
	
	/**初始化顺序表*/
	void SLInit(SLtype SL){
		//初始化为空表
		SL.ListLen=0;
	}
	
	/**返回顺序表的元素数量*/
	int SLLength(SLtype SL){
		return (SL.ListLen);
	}
	
	/**向某一位置插入结点*/
	int SLInsert(SLtype SL,int n,SLDATA data){
		
		int i;
		if (SL.ListLen>=MAXLEN) {
			System.out.println("顺序表已满，不能插入结点！");
			return 0;         //返回0表示插入不成功
		}
		
		//插入结点序号不正确
		if (n<1||n>SL.ListLen-1) {
			System.out.println("插入元素有误，不能插入元素！");
			return 0;         //返回0表示插入不成功
		}
		
		//将插入结点之后的元素依次向后移动
		for(i=SL.ListLen;i>=n;i--){
			
			SL.ListData[i+1]=SL.ListData[i];

		}
		SL.ListData[n]=data;      //插入结点
		SL.ListLen++;             //顺序表结点数量增加1
		return 1;                 //成功插入则返回1
	}
	
	/**增加元素到顺序表尾部*/
	int SLAdd(SLtype SL,SLDATA data){
		
		if (SL.ListLen>=MAXLEN) {
			System.out.println("顺序表已满，不能添加结点！");
			return 0;         //返回0表示插入不成功
		}
		
		//这里说明，DATA数组总是从第一项开始，无零项
		SL.ListData[++SL.ListLen]=data;
		return 1;
	}
	
	/**删除顺序表中的数据元素*/
	int SLDelete(SLtype SL,int n){
		
		int i;
		if(n<1||n>SL.ListLen+1){
			System.out.println("删除结点序号错误，无法操作！");
			return 0;
		}
		
		//将删除结点之后的元素依次向前移动一位
		for(i=n;i<SL.ListLen;i++){
			
			SL.ListData[i]=SL.ListData[i+1];
			
		}
		
		//顺序表元素数量减一
		SL.ListLen--;
		return 1;
	}
	
	/**根据序号返回数据元素*/
	SLDATA SLFindByNum(SLtype SL,int n){
		
		if(n<1||n>SL.ListLen){
			System.out.println("结点序号错误，不能返回结点！");
			return null;
		}
		
		return SL.ListData[n];
	}
	
	/**按关键字查询结点*/
	int SLFindByCont(SLtype SL,String key){
		
		int i;
		for(i=1;i<=SL.ListLen;i++){
			if (SL.ListData[i].key.compareTo(key)==0) {
				//返回查询到的结点序号
				return i;
			}
		}
		
		//搜索整个表都没有找到，则返回0
		return 0;
	}
	
	/**显示顺序表中的所有结点*/
	int SLAll(SLtype SL){
		int i;
		for(i=1;i<=SL.ListLen;i++){
			
			System.out.printf("(%s,%s,%d)\n",
					SL.ListData[i].key,SL.ListData[i].name,SL.ListData[i].age);
		}
		return 0;
	}
	
}

















