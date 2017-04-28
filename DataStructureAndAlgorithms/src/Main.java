
import java.math.BigDecimal;       
import java.math.RoundingMode;       
import java.util.ArrayList;       
import java.util.LinkedList;       
import java.util.List;       
            
public class Main {       
                  
    private String exp;       
       
    private int precision=2;       
      
    private RoundingMode roundingMode=RoundingMode.HALF_UP;       
      
    private List<String> expList = new ArrayList<String>();       
       
    private List<String> rpnList = new ArrayList<String>();       
       
    
    public Main(String exp,int precision,RoundingMode roundingMode) {       
        this.exp = exp;       
        this.precision=precision;       
        this.roundingMode=roundingMode;       
               
        parse();       
        createRPN();       
    }       
       
      
    private void parse() {       
        int length = exp.length();       
       
        String tempStr = "";       
        for (int i = 0; i < length; i++) {       
            String tempChar = exp.substring(i, i + 1);       
            if (isNumber(tempChar)) {       
                tempStr += tempChar;       
            } else {       
                if (!tempStr.equals("")) {       
                    expList.add(tempStr);       
                }       
                expList.add(tempChar);       
                tempStr = "";       
            }       
        }       
        if (!tempStr.equals("")) {       
            expList.add(tempStr);       
        }       
               
    }       
   
    private boolean isNumber(String str) {       
        return str.startsWith("0")        
                || str.startsWith("1")       
                || str.startsWith("2")        
                || str.startsWith("3")       
                || str.startsWith("4")        
                || str.startsWith("5")       
                || str.startsWith("6")        
                || str.startsWith("7")       
                || str.startsWith("8")        
                || str.startsWith("9")        
                || str.startsWith(".");       
       
    }       
              
   
    private boolean isHeighOperator(String str) {       
        if (str.equals("*")        
                || str.equals("/")) {       
            return true;       
        } else {       
            return false;       
        }       
    }       
       
     
    private boolean compare(String str1, String str2) {       
             
        if (isHeighOperator(str2)) {       
            return false;       
        } else {       
            if (isHeighOperator(str1)) {       
                return true;       
            } else {       
               return false;       
            }       
        }       
    }       
    
    private void createRPN() {       
        Stack stack = new Stack();       
               
        int length = expList.size();       
        for (int i = 0; i < length; i++) {       
            String c = expList.get(i);       
                   
            //如果是数字，直接放到逆波兰链表的最后       
            if (isNumber(c)) {       
                rpnList.add(c);       
            } else {       
                //如果不是数字       
                      
                    //如果栈内为空       
                    if (stack.isEmpty()) {       
                        //将当前字符串直接压栈       
                        stack.push(c);       
                    } else {       
                        //如果栈不为空       
                               
                        //比较栈顶字符串与当前字符串的优先级，       
                        if (compare(stack.top(), c)) {       
                            //如果栈顶元素的优先级大于当前字符串,则进行出栈操作       
                            //将栈顶元素直接放到逆波兰链表的最后       
                            //直到栈内为空，或者当前元素的优先级不小于栈顶元素优先级       
                            while (!stack.isEmpty() && compare(stack.top(), c)) {       
                                rpnList.add(stack.pop());       
                            }       
                        }       
                        //将当前字符串直接压栈       
                        stack.push(c);       
                    }       
                      
       
            }       
        }       
       
        //如果栈不为空，则将栈中所有元素出栈放到逆波兰链表的最后       
        while (!stack.isEmpty()) {       
            rpnList.add(stack.pop());       
        }       
    }       
                
    public String calculate() {       
        Stack numberStack = new Stack();       
               
        int length=rpnList.size();     
        
        for(int i=0;i<length;i++){       
            String temp=rpnList.get(i);       
            if(isNumber(temp)){       
                numberStack.push(temp);       
            }else{       
                BigDecimal tempNumber1 = getBigDecimal(numberStack.pop(),       
                        precision,       
                        roundingMode);       
                       
                BigDecimal tempNumber2 = getBigDecimal(numberStack.pop(),       
                        precision,       
                        roundingMode);       
                       
                BigDecimal tempNumber = getBigDecimal("",       
                        precision,       
                        roundingMode);         
                       
                if(temp.equals("+")){       
                    tempNumber=tempNumber2.add(tempNumber1);       
                }else if(temp.equals("-")){       
                    tempNumber=tempNumber2.subtract(tempNumber1);       
                }else if(temp.equals("*")){       
                    tempNumber=tempNumber2.multiply(tempNumber1);       
                }else if(temp.equals("^")){
                	numberStack.push(tempNumber2.toString()); 
                	tempNumber=tempNumber1.add(new BigDecimal(1));
                }
                       
                numberStack.push(tempNumber.toString());       
                       
            }       
        }       
               
        return numberStack.pop();       
    }       
                
    public String getRPN(){       
       
        String rpn="";       
       
        int rpnLength=rpnList.size();       
        for(int i=0;i<rpnLength;i++){       
            rpn+=rpnList.get(i)+" ";       
        }       
               
        return rpn;       
    }       
                
    public static BigDecimal getBigDecimal(String numString,       
            int precision,       
            RoundingMode roundingMode){       
        String precisionFlag="0";       
        if(numString==null || numString.equals("")){       
            precisionFlag="0.00";       
        }else{       
            precisionFlag=numString;       
        }       
        BigDecimal bigDecimal = new BigDecimal(precisionFlag);       
        bigDecimal.setScale(precision,roundingMode);       
        return bigDecimal;       
    }       
       
    /**    
     * 栈     
     *    
     */      
    private class Stack {       
               
        LinkedList<String> stackList = new LinkedList<String>();       
       
        public Stack() {       
                   
        }       
       
        /**    
         * 入栈    
         * @param expression    
         */      
        public void push(String expression) {       
            stackList.addLast(expression);       
        }       
       
        /**    
         * 出栈    
         * @return    
         */      
        public String pop() {       
            return stackList.removeLast();       
        }       
       
        /**    
         * 栈顶元素    
         * @return    
         */      
        public String top() {       
            return stackList.getLast();       
        }       
       
        /**    
         * 栈是否为空    
         * @return    
         */      
        public boolean isEmpty() {       
            return stackList.isEmpty();       
        }       
    }       
       
    public static void main(String[] args) {       
               
        String str = "1+20+30+55^+60^-90^";   
        
        //将四则运算字符串分解为后缀表达式      
        Main arithmetic=new Main(str,10,RoundingMode.HALF_UP);       
        String rpn=arithmetic.getRPN();       
        System.out.println("逆波兰表达式 : "+rpn);       
        System.out.println("计算结果 : "+arithmetic.calculate());       
    }       
       
}   
