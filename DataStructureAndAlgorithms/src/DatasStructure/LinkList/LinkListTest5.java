package DatasStructure.LinkList;

import java.util.LinkedList;

public class LinkListTest5 {
   public static void main(String[] args) {
      LinkedList<String> lList = new LinkedList<String>();
      lList.add("1");
      lList.add("2");
      lList.add("3");
      lList.add("4");
      lList.add("5");
      lList.add("2");
      System.out.println("Ԫ�� 2 ��һ�γ��ֵ�λ�ã�" + lList.indexOf("2"));
      System.out.println("Ԫ�� 2 ���һ�γ��ֵ�λ�ã�"+ lList.lastIndexOf("2"));
   }
}
