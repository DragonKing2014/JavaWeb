package DatasStructure.Tree;


import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  


/*��ʵ��ʵ�ֵ�������ͨ��HashMap������ͨ������
Ȼ����ʾĳһ�ڵ���ӽڵ㣬���ڵ㡣*/
class MyTree{  
    private Map map_up = new HashMap(); //child--->parent  
    private Map map_down = new HashMap();//parent--->child  
      
    public void add(String parent,String child){  
        map_up.put(child,parent);  
        List lst = (List)map_down.get(parent);  
        if(lst == null)  
        {  
            lst = new ArrayList();  
            map_down.put(parent, lst);  
        }  
        lst.add(child);  
    }  
      
    public String getParent(String x){  
        return (String) map_up.get(x);  
    }  
      
    public List getChild(String x){  
        return (List)map_down.get(x);  
    }  
}  
public class HashMapTree {  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        MyTree a = new MyTree();  
          
        a.add("����","����");  
        a.add("����","ŷ��");  
        a.add("����","����");  
          
        a.add("����","�й�");  
        a.add("����","�ձ�");  
        a.add("����","����");  
          
        a.add("�й�","����");  
        a.add("�й�","�Ϻ�");  
        a.add("�й�","����");  
        a.add("�й�","����");  
          
        System.out.println(a.getParent("����"));  
        System.out.println(a.getChild("�й�"));  
    }  
  
}  
