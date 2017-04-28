package DatasStructure.Queue;

import java.util.LinkedList;
import java.util.Queue;
 /** 
  * @author Dragon King
  * 一个典型的队列的实例
  */
public class MyQueue {
    public static void main(String[] args) {
        //add()和remove()方法在失败的时候会抛出异常(不推荐)
        Queue<String> queue = new LinkedList<String>();
        //添加元素
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        
        //遍历队列并打印
        System.out.println("遍历队列并打印：");
        for(String q : queue){
            System.out.print(q+" ");
        }
        
        //依次出队列演示
        System.out.println("\n删除第一个元素：");
        //返回第一个元素，并在队列中删除
        queue.poll();
        for(String q : queue){
            System.out.print(q+" ");
        }
        
        System.out.println("\nelement方法返回第一个元素：");
        System.out.println(queue.element()); //返回第一个元素 

        System.out.println("peek方法返回第一个元素：");
        System.out.println(queue.peek()); //返回第一个元素 
        
    }
}