package mypack.thread;

class A1 implements Runnable {
	private int counter = 0;

	@Override
	public void run() {
		counter++;
		System.out.println("Running A1 -> " + counter);
	}
}

class B1 extends Thread {
	private int counter = 0;

	@Override
	public void run() {
		counter++;
		System.out.println("Running B1 -> " + counter);
	}
}

public class ThreadRunnableDiff {
	public static void main(String[] args) throws InterruptedException {
		A1 a = new A1(); // Create runnable instance
		B1 b = new B1(); // Create Thread instance

		new Thread(a).start();
		Thread.sleep(1000);
		new Thread(a).start();
		Thread.sleep(1000);
		new Thread(a).start();
		Thread.sleep(1000);

		new B1().start();
		Thread.sleep(1000);
		new B1().start();
		Thread.sleep(1000);
		new B1().start();
	}
}

//Differences.....

//1) A1 a = new A1(); does not make a thread. It’s just another class with no extra behavior. 
//If you call A1.run() then it is not new thread. And A1.start() is not available to this class.

//2)By extending Thread, each of your threads has a unique object associated with it.
//whereas implementing Runnable, many threads can share the same runnable instance.