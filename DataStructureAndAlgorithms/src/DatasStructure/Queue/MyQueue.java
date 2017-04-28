package DatasStructure.Queue;

import java.util.LinkedList;
import java.util.Queue;
 /** 
  * @author Dragon King
  * һ�����͵Ķ��е�ʵ��
  */
public class MyQueue {
    public static void main(String[] args) {
        //add()��remove()������ʧ�ܵ�ʱ����׳��쳣(���Ƽ�)
        Queue<String> queue = new LinkedList<String>();
        //���Ԫ��
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        
        //�������в���ӡ
        System.out.println("�������в���ӡ��");
        for(String q : queue){
            System.out.print(q+" ");
        }
        
        //���γ�������ʾ
        System.out.println("\nɾ����һ��Ԫ�أ�");
        //���ص�һ��Ԫ�أ����ڶ�����ɾ��
        queue.poll();
        for(String q : queue){
            System.out.print(q+" ");
        }
        
        System.out.println("\nelement�������ص�һ��Ԫ�أ�");
        System.out.println(queue.element()); //���ص�һ��Ԫ�� 

        System.out.println("peek�������ص�һ��Ԫ�أ�");
        System.out.println(queue.peek()); //���ص�һ��Ԫ�� 
        
    }
}