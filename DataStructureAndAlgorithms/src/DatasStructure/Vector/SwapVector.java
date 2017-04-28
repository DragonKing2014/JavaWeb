package DatasStructure.Vector;

import java.util.Collections;
import java.util.Vector;

/**
 * @author Administrator
 * 旋转一个向量的实例
 */
public class SwapVector {
   public static void main(String[] args) {
      Vector<String> v = new Vector<String>();
      v.add("1");
      v.add("2");
      v.add("3");
      v.add("4");
      v.add("5");
      v.add("6");
      System.out.println(v);
      Collections.swap(v, 0, 5);
      System.out.println("旋转后");
      System.out.println(v);
   }
}