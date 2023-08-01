package Synchronization.byRunnable;

public class ThreadLearn implements Runnable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Current thread is: "+ Thread.currentThread().getName());

	}
	public void run() {
		System.out.println("Inside thread bu Runnable");
	}

}
