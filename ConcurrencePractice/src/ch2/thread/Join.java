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
		//�����ʹ��join�ȴ�ADDThread,��ô�õ���i�ܿ�����0����һ����С�����֣�
		//��Ϊ�̻߳�û�б�ִ�У�i���Ѿ��������
		System.out.println(i);
	}
}
