package DatasStructure.HashMap;

import java.util.*;
/**
 * @author Administrator
 * ����һ��HashMap
 */
public class TraverseHashMap {
	
   @SuppressWarnings("rawtypes")
public static void main(String[] args) {
      HashMap< String, String> hMap = 
    		  new HashMap< String, String>();
      hMap.put("1", "1st");
      hMap.put("2", "2nd");
      hMap.put("3", "3rd");
      
      //����key
      Collection cl0 = hMap.keySet();
      Iterator itr0=cl0.iterator();
      while(itr0.hasNext()){
    	  System.out.println(itr0.next());
      }
      
      //����value
      Collection cl = hMap.values();
      Iterator itr = cl.iterator();
      while (itr.hasNext()) {
         System.out.println(itr.next());
     }
   }
}