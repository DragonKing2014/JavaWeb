package Scanner;

import java.util.Scanner;  

public class ScannerInputNum {  
    public static void main(String[] args) {  
        Scanner scan = new Scanner(System.in);  
        //�Ӽ��̽�������  
        int i = 0 ;  
        float f = 0.0f ;  
        System.out.print("����������");  
        if(scan.hasNextInt()){                 
        	//�ж�������Ƿ�������  
            i = scan.nextInt() ;                
            //��������  
            System.out.println("�������ݣ�" + i) ;  
        }else{                                 
        	//����������Ϣ  
            System.out.println("����Ĳ���������") ;  
        }  
        
        //�������ʧ�ܣ���Ȼ�������뻺������ԭ��֮ͬǰ
        
        System.out.print("����С����");  
        if(scan.hasNextFloat()){              
        	//�ж�������Ƿ���С��  
            f = scan.nextFloat() ;             
            //����С��  
            System.out.println("С�����ݣ�" + f) ;  
        }else{                                
        //����������Ϣ  
            System.out.println("����Ĳ���С����") ;  
        } 
        
        int m=0;
        double sum=0;
        while(scan.hasNextDouble())  
        {  
            double x = scan.nextDouble();  
            m = m + 1;  
            sum = sum + x;  
        }  
  
        System.out.println(m+"�����ĺ�Ϊ"+sum);  
        System.out.println(m+"������ƽ��ֵ��"+(sum/m)); 
    }  
}
