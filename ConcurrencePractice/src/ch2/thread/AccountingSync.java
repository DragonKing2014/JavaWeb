package ch2.thread;

public class AccountingSync implements Runnable{

	static AccountingSync instance=new AccountingSync();
	static volatile int i=0;
	public static synchronized void increase(){
		i++;
	}
	public void run(){
		for(int j=0;j<10000000;j++){
			increase();
			
		}
	}
	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(instance);
		Thread t2=new Thread(instance);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(i);
	}
}
