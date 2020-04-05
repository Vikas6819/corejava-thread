package mypack.thread;

class TaskA extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("TaskA Running Thread Name:: -> "+Thread.currentThread().getName());
	}
	
	
}

class TaskB implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("TaskB Running Thread Name:: -> "+Thread.currentThread().getName());
	}
	
	
}

public class ThreadAndRunnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=1;i<=5;i++) {
			
			TaskA ta=new TaskA();
			ta.setName("TaskA"+i);
			ta.start();
		}
		
		for(int i=1;i<=5;i++) {
			
			Thread t=new Thread(new TaskB());
			t.setName("TaskB"+i);
			t.start();
		}
	}

}
