package DatasStructure.Stack;

import java.io.IOException;

public class StringInverse {
   private String input; 
   private String output;
   public StringInverse(String in) {
      input = in;
   }
   //ʵ���ַ�����ת�ķ���
   public String doRev() {
      int stackSize = input.length(); 
      //�½�һ����ջ
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
      System.out.println("��תǰ�� " + input);
      System.out.println("��ת�� " + output);
   }
   
   //�Զ���һ��ջ��
   class Stack {
      private int maxSize;
      private char[] stackArray;
      private int top;
      //���췽��
      public Stack(int max) {
         maxSize = max;
         stackArray = new char[maxSize];
         top = -1;
      }
      //��ջ����
      public void push(char j) {
         stackArray[++top] = j;
      }
      //��ջ����
      public char pop() {
    	 //����ջ��Ԫ�أ�ջ������
    	 //�������������
         return stackArray[top--];
      }
      //����ջ��Ԫ��
      public char peek() {
         return stackArray[top];
      }
      public boolean isEmpty() {
         return (top == -1);
      }
   }
}
