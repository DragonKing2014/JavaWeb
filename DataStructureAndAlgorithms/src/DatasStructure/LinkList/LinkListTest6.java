package DatasStructure.LinkList;

import java.util.LinkedList;

public class LinkListTest6 {
   public static void main(String[] a) {
      LinkedList<String> officers = new LinkedList<String>();
      officers.add("B");
      officers.add("B");
      officers.add("T");
      officers.add("H");
      officers.add("P");
      System.out.println(officers);
      officers.set(2, "M");
      System.out.println(officers);
   }
}
