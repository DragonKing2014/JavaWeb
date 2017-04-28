package Algorithms;

import java.math.BigDecimal;       
import java.math.RoundingMode;       
import java.util.ArrayList;       
import java.util.LinkedList;       
import java.util.List;       
       
/**    
 *     
 *  ͨ������������ʽ�ַ����������沨�����ʽ��������    
 *      
 * ��(1)��������ɨ����������ʽ���ӵ�һ���ַ���ʼ�жϣ�    
 *      ������ַ������֣�������������ִ��Ľ������������ִ�ֱ�������    
 *     
 *��(2)����������֣����ַ��������������ʱ��Ƚ����ȹ�ϵ��    
����    �������£������ַ��������ջ��������������ȹ�ϵ��Ƚϡ�    
       ��������ַ����ȹ�ϵ���ڴ������ջ������������򽫸��������ջ��    
       �������ǵĻ�����ջ�����������ջ�е�����ֱ��ջ������������ȼ�    
        ���ڵ�ǰ������������ַ���ջ��    
                                               
����(3)�ظ���������(1)-(2)ֱ��ɨ�����������������ʽ��ȷ�������ַ����õ���ȷ����    
      ���Ǳ���Խ���׺ʽ��ʾ�ļ��������ʽת��Ϊ�沨����ʾ�ļ��������ʽ��    
 *     
 *     
 */      
public class Arithmetic {       
           
    /**    
     * +    
     */      
    private final static String OP1 = "+";       
           
    /**    
     * -    
     */      
    private final static String OP2 = "-";       
           
    /**    
     * *    
     */      
    private final static String OP3 = "*";       
           
    /**    
     * /    
     */      
    private final static String OP4 = "/";       
           
    /**    
     * (    
     */      
    private final static String OPSTART = "(";       
           
    /**    
     * )    
     */      
    private final static String OPEND = ")";       
       
   //��������ʽ       
    private String exp;       
           
    //��ȷ��С�����λ       
    private int precision=2;       
           
    //ȡ��ģʽ       
    private RoundingMode roundingMode=RoundingMode.HALF_UP;       
          
    //�����������       
    private List<String> expList = new ArrayList<String>();       
       
    //����沨�����ʽ       
    private List<String> rpnList = new ArrayList<String>();       
       
    /**    
     * ��������    
     * @param exp            ����������ʽ    
     * @param precision        ��ȷ��С�����λ    
     * @param roundingMode        ȡ��ģʽ    
     */      
    public Arithmetic(String exp,int precision,RoundingMode roundingMode) {       
        this.exp = exp;       
        this.precision=precision;       
        this.roundingMode=roundingMode;       
               
        parse();       
        createRPN();       
    }       
       
    /**    
     * ��������������ʽ������������������зֽ�    
     */      
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
       
    /**    
     * �жϵ�ǰ�ַ����ַ����Ƿ�������    
     * @param str    
     * @return    
     */      
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
       
    /**    
     * �жϵ�ǰ�ַ��Ƿ��� (    
     * @param str    
     * @return    
     */      
    private boolean isParenthesesStart(String str) {       
        return str.equals(OPSTART);       
    }       
       
    /**    
    * �жϵ�ǰ�ַ��Ƿ���  )    
     * @param str    
     * @return    
     */      
    private boolean isParenthesesEnd(String str) {       
        return str.equals(OPEND);       
    }       
       
    /**    
     * �жϵ�ǰ�ַ��Ƿ��Ǹ����ȼ������  * /    
     * @param str    
     * @return    
     */      
    private boolean isHeighOperator(String str) {       
        if (str.equals(OP3)        
                || str.equals(OP4)) {       
            return true;       
        } else {       
            return false;       
        }       
    }       
       
    /**    
     * �Ա������ַ��������ȼ�    
     * @param str1    
     * @param str2    
     * @return    
     */      
    private boolean compare(String str1, String str2) {       
        if (str1.equals(OPSTART)) {       
            return false;       
        }       
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
       
    /**    
     * ���ֽ������������б������沨�����ʽ�б�    
     */      
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
                       
                //����������ţ���ֱ�ӽ�������ѹ��ջ       
                if (isParenthesesStart(c)) {       
                    stack.push(c);       
                } else if (isParenthesesEnd(c)) {       
                    //�����������       
                           
                    //���г�ջ������ֱ��ջΪ�ջ���������һ��������       
                    while (!stack.isEmpty()) {       
                        //��ջ���ַ�������ջ����       
                        String tempC = stack.pop();       
                        if (!tempC.equals(OPSTART)) {       
                            //������������ţ����ַ���ֱ�ӷŵ��沨����������       
                            rpnList.add(tempC);       
                        }else{       
                            //����������ţ��˳�ѭ������       
                            break;       
                        }       
                    }       
                } else {       
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
        }       
       
        //���ջ��Ϊ�գ���ջ������Ԫ�س�ջ�ŵ��沨����������       
        while (!stack.isEmpty()) {       
            rpnList.add(stack.pop());       
        }       
    }       
           
    /**    
     * ͨ���沨�����ʽ������    
     * @return    
     */      
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
                       
                if(temp.equals(OP1)){       
                    tempNumber=tempNumber2.add(tempNumber1);       
                }else if(temp.equals(OP2)){       
                    tempNumber=tempNumber2.subtract(tempNumber1);       
                }else if(temp.equals(OP3)){       
                    tempNumber=tempNumber2.multiply(tempNumber1);       
                }else if(temp.equals(OP4)){       
                    tempNumber=tempNumber2.divide(tempNumber1,       
                            precision,       
                            roundingMode);       
                }       
                       
                numberStack.push(tempNumber.toString());       
                       
            }       
        }       
               
        return numberStack.pop();       
    }       
           
    /**    
     * ��ȡ�沨�����ʽ�ַ���    
     * @return    
     */      
    public String getRPN(){       
       
        String rpn="";       
       
        int rpnLength=rpnList.size();       
        for(int i=0;i<rpnLength;i++){       
            rpn+=rpnList.get(i)+" ";       
        }       
               
        return rpn;       
    }       
           
    /**    
     * ����ȷ�ȼ�����    
     * @param numString    
     * @param precision    
     * @param roundingMode    
     * @return    
     */      
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
               
        String str = "1+(2+3)*(100-5*(9+8))/2.3+6-19";       
       
               
               
       
        System.out.println("====================================");       
               
        //�����������ַ����ֽ�Ϊ�沨�����ʽ�������       
        Arithmetic arithmetic=new Arithmetic(str,10,RoundingMode.HALF_UP);       
        String rpn=arithmetic.getRPN();       
        System.out.println("�沨�����ʽ : "+rpn);       
        System.out.println("������ : "+arithmetic.calculate());       
    }       
       
}   
