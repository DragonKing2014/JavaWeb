package DatasStructure.LinkList;

import java.util.LinkedList;

public class LinkListTest2 {
    public static void main(String[] args) {
        LinkedList<String> lList = new LinkedList<String>();
        lList.add("100");
        lList.add("200");
        lList.add("300");
        lList.add("400");
        lList.add("500");
        System.out.println("����ĵ�һ��Ԫ���ǣ�" + lList.getFirst());
        System.out.println("����ĵڶ���Ԫ���ǣ�" + lList.getLast());
    }
}
