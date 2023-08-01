package offic.test;

import java.util.List;

public class Producer extends Thread {
	List<Integer> lst = null;
	Consumer con;
	Producer(List<Integer> lst1){
		this.lst = lst1;
	}
	
	public void setConsumer(Consumer c) {
		this.con = c;
	}
	
	@Override
	public void run() {
		if(lst.size() == 2) {
			try {
				Thread.currentThread().wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			while(lst.size() < 2) {
				lst.add(1);
				System.out.println("inside producer");
				con.notify();
			}
		}
	}

}
