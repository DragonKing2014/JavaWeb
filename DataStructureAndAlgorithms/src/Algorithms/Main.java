package Algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(line != null && !line.isEmpty()) {
            int res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }
    }

    // write your code here
    public static int resolve(String expr) {
       return 0;
    }
    
    
}


class Stack {       
    
    LinkedList<String> stackList = new LinkedList<String>();       
   
    public Stack() {       
               
    }       
   
    /**    
     * ��ջ    
     * @param expression    
     */      
    public void push(String expression) {       
        stackList.addLast(expression);       
    }       
   
    /**    
     * ��ջ    
     * @return    
     */      
    public String pop() {       
        return stackList.removeLast();       
    }       
   
    /**    
     * ջ��Ԫ��    
     * @return    
     */      
    public String top() {       
        return stackList.getLast();       
    }       
   
    /**    
     * ջ�Ƿ�Ϊ��    
     * @return    
     */      
    public boolean isEmpty() {       
        return stackList.isEmpty();       
    }       
} 


