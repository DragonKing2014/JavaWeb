package ch2.thread;

public class Join {

	public volatile static int i=0;
	public static class AddThread extends Thread{
		public void run(){
			for(i=0;i<10000000;i++);
		}
	}
	public static void main(String[] args) throws InterruptedException{
		AddThread at=new AddThread();
		at.start();
		at.join();
		//如果不使用join等待ADDThread,那么得到的i很可能是0或者一个很小的数字，
		//因为线程还没有被执行，i就已经被输出了
		System.out.println(i);
	}
}
