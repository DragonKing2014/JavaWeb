package Demo;

/** 
 *@functon ���߳�ѧϰ,�̳�Thread����Դ���ܹ��� 
 *@author Dragon King 
 *@time 2017.3.23 
 */  
class Thread1 extends Thread{  
	
    private int count=5;  
    private String name; 
    
    public Thread1(String name) {  
       this.name=name;  
    }  
    
    public void run() {  
        for (int i = 0; i < 5; i++) {  
            System.out.println(name + "����  count= " + count--);  
            try {  
                sleep((int) Math.random() * 10);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
         
    }  
}  
  
//��ͬ���߳�֮��count�ǲ�ͬ����Դ���������Ʊϵͳ��˵�ͻ��кܴ������
public class Test1 {  
  
    public static void main(String[] args) {  
        Thread1 mTh1=new Thread1("A");  
        Thread1 mTh2=new Thread1("B");  
        mTh1.start();  
        mTh2.start();  
  
    }  
  
}  