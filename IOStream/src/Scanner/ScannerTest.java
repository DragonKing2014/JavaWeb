package Scanner;

import java.util.Scanner; 

public class ScannerTest {  
    /**
     * @param args
     */
    public static void main(String[] args) {
    	// 从键盘接收数据
        Scanner scan = new Scanner(System.in); 

        //next方式可以接收输入的字符串
        //以next只能接受一个字符串，如果含有空格，则不能接收
        System.out.println("next方式接收：");
        // 判断是否还有输入
        if(scan.hasNext()){   
          String str1 = scan.next();
          System.out.println("输入的数据为："+str1);  
        }
        
        //next不能接收的数据，还停留在输入缓冲区，若再执行next方法，
        //则不需要输入，就可以接接收的以前输入过的数据
        
        //nextLine方式可以接收输入的字符串
        System.out.println("\nnextLine方式接收:");
        //判断是否还有输入
        if (scan.hasNextLine()) {
		  String str2 = scan.nextLine();
		  System.out.println("输入的数据为："+str2);
		}
    }  
}
/**
next():
1、一定要读取到有效字符后才可以结束输入。
2、对输入有效字符之前遇到的空白，next()方法会自动将其去掉。
3、只有输入有效字符后才将其后面输入的空白作为分隔符或者结束符。
next() 不能得到带有空格的字符串。
nextLine()：
1、以Enter为结束符,也就是说 nextLine()方法返回的是输入回车之前的所有字符。
2、可以获得空白。
*/