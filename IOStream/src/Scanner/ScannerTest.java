package Scanner;

import java.util.Scanner; 

public class ScannerTest {  
    /**
     * @param args
     */
    public static void main(String[] args) {
    	// �Ӽ��̽�������
        Scanner scan = new Scanner(System.in); 

        //next��ʽ���Խ���������ַ���
        //��nextֻ�ܽ���һ���ַ�����������пո����ܽ���
        System.out.println("next��ʽ���գ�");
        // �ж��Ƿ�������
        if(scan.hasNext()){   
          String str1 = scan.next();
          System.out.println("���������Ϊ��"+str1);  
        }
        
        //next���ܽ��յ����ݣ���ͣ�������뻺����������ִ��next������
        //����Ҫ���룬�Ϳ��Խӽ��յ���ǰ�����������
        
        //nextLine��ʽ���Խ���������ַ���
        System.out.println("\nnextLine��ʽ����:");
        //�ж��Ƿ�������
        if (scan.hasNextLine()) {
		  String str2 = scan.nextLine();
		  System.out.println("���������Ϊ��"+str2);
		}
    }  
}
/**
next():
1��һ��Ҫ��ȡ����Ч�ַ���ſ��Խ������롣
2����������Ч�ַ�֮ǰ�����Ŀհף�next()�������Զ�����ȥ����
3��ֻ��������Ч�ַ���Ž����������Ŀհ���Ϊ�ָ������߽�������
next() ���ܵõ����пո���ַ�����
nextLine()��
1����EnterΪ������,Ҳ����˵ nextLine()�������ص�������س�֮ǰ�������ַ���
2�����Ի�ÿհס�
*/