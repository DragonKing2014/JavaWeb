package Demo;

/** 
 * wait�÷� 
 * @author Dragon King  
 * @time 2017.3.23  
 */  

/*Obj.wait()����Obj.notify()����Ҫ��synchronized(Obj)һ��ʹ�ã�
Ҳ����wait,��notify������Ѿ���ȡ��Obj�����в�����
���﷨�Ƕ���˵����Obj.wait(),Obj.notify������synchronized(Obj){...}�����ڡ�
�ӹ�������˵wait����˵�߳��ڻ�ȡ�������������ͷŶ�������ͬʱ���߳����ߡ�
ֱ���������̵߳��ö����notify()���Ѹ��̣߳����ܼ�����ȡ��������������ִ�С�
��Ӧ��notify()���ǶԶ������Ļ��Ѳ���������һ����Ҫע�����notify()���ú�
���������Ͼ��ͷŶ������ģ���������Ӧ��synchronized(){}����ִ�н�����
�Զ��ͷ�����JVM����wait()���������߳������ѡȡһ�̣߳�
������������������̣߳�����ִ�С��������ṩ�����̼߳�ͬ�������ѵĲ�����

Thread.sleep()��Object.wait()���߶�������ͣ��ǰ�̣߳��ͷ�CPU����Ȩ��
��Ҫ����������Object.wait()���ͷ�CPUͬʱ���ͷ��˶������Ŀ��ơ�*/

public class Test5 implements Runnable {     
        
    private String name;     
    private Object prev;     
    private Object self;     
    
    private Test5(String name, Object prev, Object self) {     
        this.name = name;     
        this.prev = prev;     
        this.self = self;     
    }     
    
    @Override    
    public void run() {     
        int count = 10;     
        while (count > 0) {     
            synchronized (prev) {     
                synchronized (self) {     
                    System.out.print(name);     
                    count--;    
                      
                    
                    self.notify();     
                }     
                try {     
                    prev.wait();     
                } catch (InterruptedException e) {     
                    e.printStackTrace();     
                }     
            }     
    
        }     
    }     
    
    public static void main(String[] args) throws Exception {     
        Object a = new Object();     
        Object b = new Object();     
        Object c = new Object();     
        Test5 pa = new Test5("A", c, a);     
        Test5 pb = new Test5("B", a, b);     
        Test5 pc = new Test5("C", b, c);     
             
             
        new Thread(pa).start();  
        Thread.sleep(100);  //ȷ����˳��A��B��Cִ��  
        new Thread(pb).start();  
        Thread.sleep(100);    
        new Thread(pc).start();     
        Thread.sleep(100);    
        }     
}    


/*�Ӵ�ķ�����������������Ϊ���̼߳��ͬ�����Ѳ�����
��Ҫ��Ŀ�ľ���ThreadA->ThreadB->ThreadC->ThreadAѭ��ִ�������̡߳�
Ϊ�˿����߳�ִ�е�˳����ô�ͱ���Ҫȷ�����ѡ��ȴ���˳��
����ÿһ���̱߳���ͬʱ�������������������ܼ���ִ�С�
һ����������prev������ǰһ���߳������еĶ�������
����һ�������������������Ҫ��˼����ǣ�Ϊ�˿���ִ�е�˳��
����Ҫ�ȳ���prev����Ҳ��ǰһ���߳�Ҫ�ͷ������������
��ȥ������������������߼汸ʱ��ӡ��֮�����ȵ���self.notify()�ͷ������������
������һ���ȴ��̣߳��ٵ���prev.wait()�ͷ�prev����������ֹ��ǰ�̣߳�
�ȴ�ѭ���������ٴα����ѡ������������룬���Է��������߳�ѭ����ӡABC��
��10�Ρ��������е���Ҫ���̾���A�߳��������У�
����C,A�����������ͷ�A,C��������B���߳�B�ȴ�A����������B�������ӡB�����ͷ�B��A����
����C���߳�C�ȴ�B����������C�������ӡC�����ͷ�C,B����
����A���������ƺ�ûʲô���⣬
���������ϸ��һ�£��ͻᷢ�������⣬���ǳ�ʼ������
�����̰߳���A,B,C��˳��������������ǰ���˼����
A����B��B����C��C�ٻ���A���������ּ���������JVM���̵߳��ȡ�ִ�е�˳��*/





/*wait��sleep����
��ͬ�㣺 

1. ���Ƕ����ڶ��̵߳Ļ����£��������ڳ���ĵ��ô�����ָ���ĺ������������ء� 
2. wait()��sleep()������ͨ��interrupt()���� ����̵߳���ͣ״̬ ��
�Ӷ�ʹ�߳������׳�InterruptedException�� 
  ����߳�Aϣ�����������߳�B������Զ��߳�B��Ӧ��Threadʵ������interrupt������
  ����˿��߳�B����wait/sleep /join�����߳�B�������׳�InterruptedException��
  ��catch() {} ��ֱ��return���ɰ�ȫ�ؽ����̡߳� 
  ��Ҫע����ǣ�InterruptedException���߳��Լ����ڲ��׳��ģ�
  ������interrupt()�����׳��ġ�
  ��ĳһ�̵߳��� interrupt()ʱ��������߳�����ִ����ͨ�Ĵ��룬
  ��ô���̸߳����Ͳ����׳�InterruptedException��
  ���ǣ�һ�����߳̽��뵽 wait()/sleep()/join()��
  �ͻ������׳�InterruptedException �� 
  
��ͬ�㣺 
1. Thread��ķ�����sleep(),yield()�� 
  Object�ķ�����wait()��notify()�� 
2. ÿ��������һ����������ͬ�����ʡ�Synchronized�ؼ��ֿ��ԺͶ������������
��ʵ���̵߳�ͬ���� 
  sleep����û���ͷ�������wait�����ͷ�������ʹ�������߳̿���ʹ��ͬ�����ƿ���߷����� 
3. wait��notify��notifyAllֻ����ͬ�����Ʒ�������ͬ�����ƿ�����ʹ�ã���sleep�������κεط�ʹ�� 
4. sleep���벶���쳣����wait��notify��notifyAll����Ҫ�����쳣
����sleep()��wait()��������������ǣ�
������sleep()˯��ʱ�����ֶ���������Ȼռ�и�����
��������wait()˯��ʱ���ͷŶ�������
������wait()��sleep()������ͨ��interrupt()��������̵߳���ͣ״̬���Ӷ�ʹ�߳������׳�InterruptedException����������ʹ�ø÷�������
sleep��������
sleep()ʹ��ǰ�߳̽���ͣ��״̬��������ǰ�̣߳����ó�CUP��ʹ�á�Ŀ���ǲ��õ�ǰ�̶߳��԰�ռ�ý��������CPU��Դ������һ��ʱ��������߳�ִ�еĻ���;
�� sleep()��Thread���Static(��̬)�ķ�������������ܸı����Ļ��������Ե���һ��Synchronized���е���Sleep()�����ǣ��߳���Ȼ�����ˣ����Ƕ���Ļ�����ľ�б��ͷţ������߳��޷�����������󣨼�ʹ˯��Ҳ���ж���������
����sleep()����ʱ�������󣬸��̲߳�һ��������ִ�У�������Ϊ�����߳̿����������ж���û�б�����Ϊ����ִ�У����Ǵ��߳̾��и��ߵ����ȼ��� 
wait��������
wait()������Object����ķ�������һ���߳�ִ�е�wait()����ʱ�����ͽ��뵽һ���͸ö�����صĵȴ����У�ͬʱʧȥ���ͷţ��˶���Ļ�������ʱʧȥ������wait(long timeout)��ʱʱ�䵽����Ҫ�������������������߳̿��Է��ʣ�
��wait()ʹ��notify����notifyAlll����ָ��˯��ʱ�������ѵ�ǰ�ȴ����е��̡߳�
��wiat()�������synchronized block�У��������program runtimeʱ�ӳ���java.lang.IllegalMonitorStateException���쳣��*/