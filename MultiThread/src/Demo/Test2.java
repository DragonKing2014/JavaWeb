package Demo;

/** 
 *@functon 多线程学习 继承runnable，资源能共享 
 *@author Dragon King 
 *@time 2017.3.23 
 */  
class Thread2 implements Runnable{  
	//线程共享的资源
    private int count=15;  
    
    @Override  
    public void run() {  
          for (int i = 0; i < 5; i++) {  
              System.out.println(Thread.currentThread().getName() +
            		  "运行  count= " + count--);  
                try {  
                    Thread.sleep((int) Math.random() * 10);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
            }  
          
    }  
      
}  
public class Test2 {  
  
    public static void main(String[] args) {  
          
        Thread2 my = new Thread2();  
        
        	//同一个mt，但是在Thread中就不可以，如果用同一个实例化对象mt，就会出现异常
            new Thread(my, "C").start();     
            new Thread(my, "D").start();  
            new Thread(my, "E").start();  
    }  
  
}
/**
这里要注意每个线程都是用同一个实例化对象，如果不是同一个，效果就和上面的一样了！
总结：

实现Runnable接口比继承Thread类所具有的优势：

1）：适合多个相同的程序代码的线程去处理同一个资源

2）：可以避免java中的单继承的限制

3）：增加程序的健壮性，代码可以被多个线程共享，代码和数据独立


*/