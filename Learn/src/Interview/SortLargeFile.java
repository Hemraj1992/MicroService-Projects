package Interview;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class SortLargeFile {

	
	public static void main(String[] args) {

		try {
			Scanner sc= new Scanner(System.in);
			System.out.print("Enter first number- ");
			int k= sc.nextInt();
			String fileName = "mbFile.txt";
			createFileWithRandNumber(fileName);

			File f = new File(fileName);
			// split the file in specified size. Here size is in MB
			List<File> fileList = splitFile(f, 1);

			System.out.println("file list size is: " + fileList.size());
			int count = 1;

			// Sorting all the files one by one.
			for (File file : fileList) {
				FileSort fileSort = new FileSort(file, count);
				fileSort.start();
				count++;
//				List<Integer> lst = readFile(file);
//				Collections.sort(lst);
//
//				System.out.println(file.getName() + ": is sorted");
//				writeIntoFile(lst, "SortedFile" + count++ + ".txt");

			}
			Thread.sleep(1000);
			System.out.println("sorting done");

			// get kth smallest number
			int kSmall = getKthSmallestNumber(fileList.size(), "SortedFile", k);
			System.out.println("Kth smallest number is: "+ kSmall);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	/**
	 * @apiNote: find the kth smallest number from various sorted files
	 * @param fileCount
	 * @param baseFileName
	 * @param k: position of minimum number that we have to return
	 * @return kth minimum number
	 * @throws IOException
	 */
	public static int getKthSmallestNumber(int fileCount, String baseFileName, int k) throws IOException {
		List<Scanner> scannerList = new ArrayList<Scanner>();
		int count = 0; 
		int KthItem = Integer.MIN_VALUE;
		//Getting pointer for all the files
		while (fileCount > 0) {
			File file = new File(baseFileName + fileCount + ".txt");
			Scanner scan = new Scanner(file);
			scannerList.add(scan);
			fileCount--;
		}

		int min = Integer.MAX_VALUE;
		int indx = -1;
		int arr[] = new int[scannerList.size()];

		try {
			while (!scannerList.isEmpty()) {
				for (int i = 0; i < scannerList.size(); i++) {

					if (arr[i] == 0) {
						if (scannerList.get(i).hasNext()) {
							arr[i] = scannerList.get(i).nextInt();
						} else {
							scannerList.remove(i);
							continue;
						}
					}
					if (arr[i] <= min && arr[i] != 0) {
						min = arr[i];
						indx = i;
					}
				}
				if (indx != -1) {
					count++;
					if(count == k) {
						return min;
					}
					min = Integer.MAX_VALUE;
					arr[indx] = 0;
					indx = -1;
				}
			}
			
			//Insert remaining values into file
			Arrays.sort(arr);
			for (int number : arr) {
				if (number != 0) {
					count++;
					if(count == k) {
						return number;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return KthItem;

	}

	/**
	 * @apiNote: create a file with random numbers
	 * @param fileName
	 */
	public static void createFileWithRandNumber(String fileName) {
		Random ran = new Random();
		int number = 0;
		try (PrintWriter file = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));) {

			// It will create a file of around 10GB. filled with line separated random
			// number between 0-1000.
			//Run loop by 2000000000 times to generate 10GB of file
			for (int i = 1; i <= 2000000; i++) {
				number = ran.nextInt(1000) + 1;
				file.println(number);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}

	/**
	 * @apiNote: read file into list
	 * @param file
	 * @return list of numbers fetched from file
	 * @throws Exception
	 */
	static List<Integer> readFile(File file) throws Exception {
		Scanner scanner = new Scanner(file);
		List<Integer> fileItems = new ArrayList<Integer>();
		while (scanner.hasNextInt()) {
			fileItems.add(scanner.nextInt());
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

	/**
	 * @apiNote: split the file into given file size
	 * @param file
	 * @param sizeOfFileInMB
	 * @return: list of files
	 * @throws IOException
	 */
	public static List<File> splitFile(File file, int sizeOfFileInMB) throws IOException {
		int counter = 1;
		List<File> files = new ArrayList<File>();
		int sizeOfChunk = 1024 * 1024 * sizeOfFileInMB;
		String eof = System.lineSeparator();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String name = file.getName();
			String line = br.readLine();
			while (line != null) {
				File newFile = new File(file.getParent(), name + "." + String.format("%03d", counter++));
				try (OutputStream out = new BufferedOutputStream(new FileOutputStream(newFile))) {
					int fileSize = 0;
					while (line != null) {
						byte[] bytes = (line + eof).getBytes(Charset.defaultCharset());
						if (fileSize + bytes.length > sizeOfChunk)
							break;
						out.write(bytes);
						fileSize += bytes.length;
						line = br.readLine();
					}
				}
				files.add(newFile);
			}
		}
		return files;
	}

}
