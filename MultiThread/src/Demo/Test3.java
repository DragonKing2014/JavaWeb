package Demo;

/** 
 *@functon ���߳�ѧϰ,join 
 *@author Dragon King 
 *@time 2017.3.23 
 */  

/**
 * �ںܶ�����£����߳����ɲ��������̣߳�
 * ������߳���Ҫ���д����ĺ�ʱ�����㣬���߳������������߳�֮ǰ������
 * ����������̴߳������������������Ҫ�õ����̵߳Ĵ�������
 * Ҳ�������߳���Ҫ�ȴ����߳�ִ�����֮���ٽ�����
 * ���ʱ���Ҫ�õ�join()�����ˡ�
 */

class Thread0 extends Thread{  
    private String name;  
    
    public Thread0(String name) {  
        super(name);  
       this.name=name;  
    }  
    
    public void run() {  
        System.out.println(Thread.currentThread().getName() + " �߳����п�ʼ!");  
        
        for (int i = 0; i < 5; i++) {  
            System.out.println("���߳�"+name + "���� : " + i);  
            try {  
                sleep((int) Math.random() * 10);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
        System.out.println(Thread.currentThread().getName() + " �߳����н���!");  
    }  
}  
  
public class Test3 {  
  
    public static void main(String[] args) {  
        System.out.println(Thread.currentThread().getName()+"���߳����п�ʼ!");  
        
        Thread0 mTh1=new Thread0("A");  
        Thread0 mTh2=new Thread0("B");  
        
        mTh1.start();  
        mTh2.start();  
        
        /**join��Thread���һ�������������̺߳�ֱ�ӵ��ã�
         * ��join()�������ǣ����ȴ����߳���ֹ����
         * ������Ҫ���ľ��Ǹ��߳���ָ�����̵߳ȴ����̵߳���ֹ��
         * Ҳ���������̵߳�����join()��������Ĵ��룬ֻ�еȵ����߳̽����˲���ִ�С�
         */
        try {  
            mTh1.join();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        try {  
            mTh2.join();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }
        
        System.out.println(Thread.currentThread().getName()+ "���߳����н���!");  
  
    }  
  
}  