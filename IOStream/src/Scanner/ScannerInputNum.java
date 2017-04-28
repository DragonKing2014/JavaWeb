package Scanner;

import java.util.Scanner;  

public class ScannerInputNum {  
    public static void main(String[] args) {  
        Scanner scan = new Scanner(System.in);  
        //从键盘接收数据  
        int i = 0 ;  
        float f = 0.0f ;  
        System.out.print("输入整数：");  
        if(scan.hasNextInt()){                 
        	//判断输入的是否是整数  
            i = scan.nextInt() ;                
            //接收整数  
            System.out.println("整数数据：" + i) ;  
        }else{                                 
        	//输入错误的信息  
            System.out.println("输入的不是整数！") ;  
        }  
        
        //如果输入失败，依然放在输入缓冲区，原理同之前
        
        System.out.print("输入小数：");  
        if(scan.hasNextFloat()){              
        	//判断输入的是否是小数  
            f = scan.nextFloat() ;             
            //接收小数  
            System.out.println("小数数据：" + f) ;  
        }else{                                
        //输入错误的信息  
            System.out.println("输入的不是小数！") ;  
        } 
        
        int m=0;
        double sum=0;
        while(scan.hasNextDouble())  
        {  
            double x = scan.nextDouble();  
            m = m + 1;  
            sum = sum + x;  
        }  
  
        System.out.println(m+"个数的和为"+sum);  
        System.out.println(m+"个数的平均值是"+(sum/m)); 
    }  
}
