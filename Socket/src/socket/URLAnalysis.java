package socket;

import java.net.URL;

public class URLAnalysis {
   public static void main(String[] args) 
   throws Exception {
      URL url = new URL("http://127.0.0.1");
      System.out.println("URL �� " + url.toString());
      System.out.println("Э���� " + url.getProtocol());
      System.out.println("�ļ����� " + url.getFile());
      System.out.println("������ " + url.getHost());
      System.out.println("·���� " + url.getPath());
      System.out.println("�˿ں��� " + url.getPort());
      System.out.println("Ĭ�϶˿ں��� " 
      + url.getDefaultPort());
   }
}