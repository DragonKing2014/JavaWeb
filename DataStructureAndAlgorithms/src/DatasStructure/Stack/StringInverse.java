package DatasStructure.Stack;

import java.io.IOException;

public class StringInverse {
   private String input; 
   private String output;
   public StringInverse(String in) {
      input = in;
   }
   //实现字符串反转的方法
   public String doRev() {
      int stackSize = input.length(); 
      //新建一个堆栈
      Stack theStack = new Stack(stackSize); 
      for (int i = 0; i < input.length(); i++) {
         char ch = input.charAt(i); 
         theStack.push(ch); 
      }
      output = "";
      while (!theStack.isEmpty()) {
         char ch = theStack.pop(); 
         output = output + ch; 
      }
      return output;
   }
   public static void main(String[] args) 
   throws IOException {
      String input = "baidu.com";
      String output;
      StringInverse theReverser = 
      new StringInverse(input);
      output = theReverser.doRev();
      System.out.println("反转前： " + input);
      System.out.println("反转后： " + output);
   }
   
   //自定义一个栈类
   class Stack {
      private int maxSize;
      private char[] stackArray;
      private int top;
      //构造方法
      public Stack(int max) {
         maxSize = max;
         stackArray = new char[maxSize];
         top = -1;
      }
      //入栈方法
      public void push(char j) {
         stackArray[++top] = j;
      }
      //出栈方法
      public char pop() {
    	 //返回栈顶元素，栈顶下移
    	 //这包含两个步骤
         return stackArray[top--];
      }
      //返回栈顶元素
      public char peek() {
         return stackArray[top];
      }
      public boolean isEmpty() {
         return (top == -1);
      }
   }
}
