package Demo;

/** 
 *@functon ���߳�ѧϰ �̳�runnable����Դ�ܹ��� 
 *@author Dragon King 
 *@time 2017.3.23 
 */  
class Thread2 implements Runnable{  
	//�̹߳������Դ
    private int count=15;  
    
    @Override  
    public void run() {  
          for (int i = 0; i < 5; i++) {  
              System.out.println(Thread.currentThread().getName() +
            		  "����  count= " + count--);  
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
        
        	//ͬһ��mt��������Thread�оͲ����ԣ������ͬһ��ʵ��������mt���ͻ�����쳣
            new Thread(my, "C").start();     
            new Thread(my, "D").start();  
            new Thread(my, "E").start();  
    }  
  
}
/**
����Ҫע��ÿ���̶߳�����ͬһ��ʵ���������������ͬһ����Ч���ͺ������һ���ˣ�
�ܽ᣺

ʵ��Runnable�ӿڱȼ̳�Thread�������е����ƣ�

1�����ʺ϶����ͬ�ĳ��������߳�ȥ����ͬһ����Դ

2�������Ա���java�еĵ��̳е�����

3�������ӳ���Ľ�׳�ԣ�������Ա�����̹߳�����������ݶ���


*/