package Synchronization.byRunnable;

public class PrintNumber extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}
	int num = 0;
	
	public PrintNumber(int nm) {
		this.num = nm;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName()+": "+ num);
	}

}
