package Interview;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileSortRunnable implements Runnable{

	private File file;
	private int count;
//	List<Integer> lst;
	public FileSortRunnable(File fileIn, int fileNum) {
		this.file = fileIn;
		this.count = fileNum;
	}
	@Override
	public void run() {
		System.out.println("Current thread id is:"+ Thread.currentThread().getId());
		List<Integer> lst = readFile(file);
		Collections.sort(lst);

		System.out.println(file.getName() + ": is sorted");
		writeIntoFile(lst, "SortedFile" + count++ + ".txt");
	}
	
	/**
	 * @apiNote: read file into list
	 * @param file
	 * @return list of numbers fetched from file
	 * @throws Exception
	 */
	static List<Integer> readFile(File file) {
		List<Integer> fileItems = new ArrayList<Integer>();
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextInt()) {
				fileItems.add(scanner.nextInt());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileItems;
	}
	
	/**
	 * @apiNote: write the given list of numbers into file
	 * @param intlist
	 * @param fileName
	 */
	public static void writeIntoFile(List<Integer> intlist, String fileName) {
		try (PrintWriter file = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));) {
			for (Integer number : intlist) {
				file.println(number);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}

}
