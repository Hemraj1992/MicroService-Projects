package offic.test;

import java.util.List;

public class Consumer extends Thread {

	List<Integer> lst = null;
	Producer prod;
	Consumer(List<Integer> lst1){
		this.lst = lst1;
	}
	
	public void setProducer(Producer p) {
		this.prod = p;
	}
	
	@Override
	public void run() {
		if(lst.size() == 0) {
			try {
				Thread.currentThread().wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			while(lst.size() > 0) {
				lst.remove(0);
				System.out.println("inside consumer");
				prod.notify();
			}
		}
	}
}
