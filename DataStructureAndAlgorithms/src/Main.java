
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
                   
            //��������֣�ֱ�ӷŵ��沨����������       
            if (isNumber(c)) {       
                rpnList.add(c);       
            } else {       
                //�����������       
                      
                    //���ջ��Ϊ��       
                    if (stack.isEmpty()) {       
                        //����ǰ�ַ���ֱ��ѹջ       
                        stack.push(c);       
                    } else {       
                        //���ջ��Ϊ��       
                               
                        //�Ƚ�ջ���ַ����뵱ǰ�ַ��������ȼ���       
                        if (compare(stack.top(), c)) {       
                            //���ջ��Ԫ�ص����ȼ����ڵ�ǰ�ַ���,����г�ջ����       
                            //��ջ��Ԫ��ֱ�ӷŵ��沨����������       
                            //ֱ��ջ��Ϊ�գ����ߵ�ǰԪ�ص����ȼ���С��ջ��Ԫ�����ȼ�       
                            while (!stack.isEmpty() && compare(stack.top(), c)) {       
                                rpnList.add(stack.pop());       
                            }       
                        }       
                        //����ǰ�ַ���ֱ��ѹջ       
                        stack.push(c);       
                    }       
                      
       
            }       
        }       
       
        //���ջ��Ϊ�գ���ջ������Ԫ�س�ջ�ŵ��沨����������       
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
     * ջ     
     *    
     */      
    private class Stack {       
               
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
       
    public static void main(String[] args) {       
               
        String str = "1+20+30+55^+60^-90^";   
        
        //�����������ַ����ֽ�Ϊ��׺���ʽ      
        Main arithmetic=new Main(str,10,RoundingMode.HALF_UP);       
        String rpn=arithmetic.getRPN();       
        System.out.println("�沨�����ʽ : "+rpn);       
        System.out.println("������ : "+arithmetic.calculate());       
    }       
       
}   
