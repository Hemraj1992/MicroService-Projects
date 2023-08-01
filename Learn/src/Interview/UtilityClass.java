package Interview;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class UtilityClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
//			createFileWithRandNumber();
//			readFile("file2.txt");
//			mergTwoFiles(3, "file");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
	public static void mergMultipleSortedFiles(int fileCount, String baseFileName) throws IOException {
		// TODO: complete this function by loop
		List<Scanner> scannerList = new ArrayList<Scanner>();
		while (fileCount > 0) {
			File file = new File(baseFileName + fileCount + ".txt");
			Scanner scan = new Scanner(file);
			scannerList.add(scan);
			fileCount--;
		}

		int min = Integer.MAX_VALUE;
		int indx = -1;
		int arr[] = new int[scannerList.size()];

//		List<Integer> buffer = new ArrayList<Integer>();
		try (PrintWriter file = new PrintWriter(new BufferedWriter(new FileWriter("combinedFile.txt")));) {
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
					file.println(min);
					min = Integer.MAX_VALUE;
					arr[indx] = 0;
					indx = -1;
				}
			}
			Arrays.sort(arr);   
			for(int number : arr) {
				if(number != 0) {
					file.println(number);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
		
	
	
	public static void createFileWithRandNumber(int val) {
		Random ran = new Random();
        int number = 0;
        try (PrintWriter file = new PrintWriter(new BufferedWriter( new FileWriter("mbFile.txt")));) {

        	// It will create a file of around 10GB. filled with line separated random number between 0-1000.
//            for (int i = 1; i <= 2000000000; i++) {
//        	for (int i = 1; i <= 20; i++) {
            	
                number = ran.nextInt(1000) + 1;
                file.println(val);
                file.close();
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
	}
	
	public static void writeIntoFile(List<Integer> intlist) {
		try (PrintWriter file = new PrintWriter(new BufferedWriter( new FileWriter("test_file_sorted.txt")));) {
        	for (Integer number : intlist) {
            	
                file.println(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		return;
	}
	
	static List<Integer> readFile(String fileName) throws Exception {
	    Scanner scanner = new Scanner(new File(fileName));
	    List<Integer> tall = new ArrayList<Integer>();
	    while (scanner.hasNextInt()) {
	        tall.add(scanner.nextInt());
	    }

	    return tall;
	}
	

}
