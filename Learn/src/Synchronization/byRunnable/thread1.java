package Synchronization.byRunnable;

public class thread1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread t = new Thread(new ThreadLearn());
		t.start();
	}

}
