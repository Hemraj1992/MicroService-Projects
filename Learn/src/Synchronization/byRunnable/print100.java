package Synchronization.byRunnable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class print100 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Executor ex = Executors.newCachedThreadPool();
		for(int i=1; i<100; i++) {
//			Thread t = new Thread(new PrintNumber(i));
//			t.start();
			ex.execute(new PrintNumber(i));
					
		}
	}

}
