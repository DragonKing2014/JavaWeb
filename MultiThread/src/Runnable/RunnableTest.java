package Runnable;

public class RunnableTest implements Runnable {
	
	   private Thread t;
	   private String threadName;
	   
	   //构造方法
	   RunnableTest(String name) {
	      threadName = name;
	      System.out.println("Creating " +  threadName );
	   }
	   
	   public void run(){
	      System.out.println(threadName+" is Running");
	      
	      try {
	         for(int i = 10; i > 0; i--) {
	            System.out.println("Thread: " + threadName + ", " + i);
	            // 让线程睡眠一会
	            Thread.sleep(50);
	         }
	      }catch (InterruptedException e) {
	         System.out.println("Thread " +  threadName + " interrupted.");
	      }
	      
	      System.out.println("Thread " +  threadName + " exiting.");
	   }
	   
	   public void start () {
	      System.out.println("Starting " +  threadName );
	      if (t == null) {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	   }
	}
	 
	class TestThread {
	 
	   public static void main(String args[]) {
	      RunnableTest R1 = new RunnableTest( "THREAD-1");
	      R1.start();
	      
	      RunnableTest R2 = new RunnableTest( "THREAD-2");
	      R2.start();
	      
	      RunnableTest R3 = new RunnableTest( "THREAD-3");
	      R3.start();
	   }   
	}
