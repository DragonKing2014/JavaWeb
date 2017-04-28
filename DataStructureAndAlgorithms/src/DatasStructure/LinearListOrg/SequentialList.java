package DatasStructure.LinearListOrg;

import java.util.Scanner;


/**
 * @author Dragon King
 * һ��˳������ʵ��ʵ��
 */
public class SequentialList {

	//���������ڲ���
	public static void main(String[] args) {
		
		int i;
		SLtype SL=new SLtype();     //����˳������
		SLDATA pdata;                 //�����㱣�����õ����ñ���
		String key;                 //�ؼ��ֱ������
		
		//��ʼ��˳���
		SL.SLInit(SL);
		
		System.out.println("˳����ʼ����ɣ�");
		
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		
		//ѭ����ӽ������
		do {
			System.out.println("������ӵĽ��(ѧ�� ���� ����)��");
			SLDATA data=new SLDATA();
			data.key=input.next();
			data.name=input.next();
			data.age=input.nextInt();
			
			if (data.age!=0) {
				
				//�����ӽ��ʧ��
				if (SL.SLAdd(SL, data)==0) {
					break;    //�˳���ѭ��
				}
			}else{
				break;
				//������Ϊ0��Ҳ�˳���ѭ��
			}
			
		} while (true);
		
		System.out.println("˳����еĽ�㰴˳���ӡ��");
		//��ʾ���н������
		SL.SLAll(SL);
		
		System.out.println("����Ҫȡ���Ľ����ţ�");
		i=input.nextInt();
		
		//����Ų�ѯ���
		pdata=SL.SLFindByNum(SL, i);
		if (pdata!=null) {
			System.out.printf("��%d�����Ϊ��(%s,%s,%d)\n"
					,i,pdata.key,pdata.name,pdata.age);
		}
		
		//���ؼ��ֲ�ѯ���
		System.out.println("������Ҫ���ҵĹؼ��֣�");
		key=input.next();
		//���ؼ��ֲ��ң����ؽ�����
		i=SL.SLFindByCont(SL, key);
		//����Ų��ң����ؽ�������
		pdata=SL.SLFindByNum(SL, i);
		if (pdata!=null) {
			System.out.printf("��%d�����Ϊ��(%s,%s,%d)\n"
					,i,pdata.key,pdata.name,pdata.age);
		}
		
	}
	
}

//һ�����
class SLDATA{
	String key;       //���Ĺؼ���
	String name;
	int age;
}

//����˳������ݽṹ
class SLtype{
	static final int MAXLEN=100;
	//����˳�������ݽṹ
	SLDATA[] ListData=new SLDATA[MAXLEN+1];
	//˳����Ѿ������������
	int ListLen;
	
	/**��ʼ��˳���*/
	void SLInit(SLtype SL){
		//��ʼ��Ϊ�ձ�
		SL.ListLen=0;
	}
	
	/**����˳����Ԫ������*/
	int SLLength(SLtype SL){
		return (SL.ListLen);
	}
	
	/**��ĳһλ�ò�����*/
	int SLInsert(SLtype SL,int n,SLDATA data){
		
		int i;
		if (SL.ListLen>=MAXLEN) {
			System.out.println("˳������������ܲ����㣡");
			return 0;         //����0��ʾ���벻�ɹ�
		}
		
		//��������Ų���ȷ
		if (n<1||n>SL.ListLen-1) {
			System.out.println("����Ԫ�����󣬲��ܲ���Ԫ�أ�");
			return 0;         //����0��ʾ���벻�ɹ�
		}
		
		//��������֮���Ԫ����������ƶ�
		for(i=SL.ListLen;i>=n;i--){
			
			SL.ListData[i+1]=SL.ListData[i];

		}
		SL.ListData[n]=data;      //������
		SL.ListLen++;             //˳�������������1
		return 1;                 //�ɹ������򷵻�1
	}
	
	/**����Ԫ�ص�˳���β��*/
	int SLAdd(SLtype SL,SLDATA data){
		
		if (SL.ListLen>=MAXLEN) {
			System.out.println("˳���������������ӽ�㣡");
			return 0;         //����0��ʾ���벻�ɹ�
		}
		
		//����˵����DATA�������Ǵӵ�һ�ʼ��������
		SL.ListData[++SL.ListLen]=data;
		return 1;
	}
	
	/**ɾ��˳����е�����Ԫ��*/
	int SLDelete(SLtype SL,int n){
		
		int i;
		if(n<1||n>SL.ListLen+1){
			System.out.println("ɾ�������Ŵ����޷�������");
			return 0;
		}
		
		//��ɾ�����֮���Ԫ��������ǰ�ƶ�һλ
		for(i=n;i<SL.ListLen;i++){
			
			SL.ListData[i]=SL.ListData[i+1];
			
		}
		
		//˳���Ԫ��������һ
		SL.ListLen--;
		return 1;
	}
	
	/**������ŷ�������Ԫ��*/
	SLDATA SLFindByNum(SLtype SL,int n){
		
		if(n<1||n>SL.ListLen){
			System.out.println("�����Ŵ��󣬲��ܷ��ؽ�㣡");
			return null;
		}
		
		return SL.ListData[n];
	}
	
	/**���ؼ��ֲ�ѯ���*/
	int SLFindByCont(SLtype SL,String key){
		
		int i;
		for(i=1;i<=SL.ListLen;i++){
			if (SL.ListData[i].key.compareTo(key)==0) {
				//���ز�ѯ���Ľ�����
				return i;
			}
		}
		
		//����������û���ҵ����򷵻�0
		return 0;
	}
	
	/**��ʾ˳����е����н��*/
	int SLAll(SLtype SL){
		int i;
		for(i=1;i<=SL.ListLen;i++){
			
			System.out.printf("(%s,%s,%d)\n",
					SL.ListData[i].key,SL.ListData[i].name,SL.ListData[i].age);
		}
		return 0;
	}
	
}

















