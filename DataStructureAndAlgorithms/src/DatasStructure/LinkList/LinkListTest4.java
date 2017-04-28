package DatasStructure.LinkList;

//LinkedList µœ÷’ª
import java.util.*;

public class LinkListTest4 {
   private LinkedList<Object> list = new LinkedList<Object>();
   public void push(Object v) {
      list.addFirst(v);
   }
   public Object top() {
      return list.getFirst();
   }
   public Object pop() {
      return list.removeFirst();
   }
   public static void main(String[] args) {
      LinkListTest4 stack = new LinkListTest4();
      for (int i = 30; i < 40; i++){
         stack.push(new Integer(i));
      }
      System.out.println(stack.top());
      System.out.println(stack.pop());
      System.out.println(stack.pop());
      System.out.println(stack.pop());
   }
}