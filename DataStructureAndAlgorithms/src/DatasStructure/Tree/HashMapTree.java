package DatasStructure.Tree;


import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  


/*本实例实现的任务是通过HashMap来构建通用树，
然后显示某一节点的子节点，父节点。*/
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
          
        a.add("世界","亚洲");  
        a.add("世界","欧洲");  
        a.add("世界","美洲");  
          
        a.add("亚洲","中国");  
        a.add("亚洲","日本");  
        a.add("亚洲","韩国");  
          
        a.add("中国","北京");  
        a.add("中国","上海");  
        a.add("中国","湖北");  
        a.add("中国","江苏");  
          
        System.out.println(a.getParent("湖北"));  
        System.out.println(a.getChild("中国"));  
    }  
  
}  
