package Interview;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MinElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> lists = null;
	    List<Integer> result;
	    
	    ExecutorService executorService = Executors.newFixedThreadPool(4); 
		// Sorting all the files one by one.
	    for (List list : lists) {
			Thread fileSortR = new Thread(new FinMinRun());
			executorService.execute(fileSortR);
//			
		}
	  

	}

}
