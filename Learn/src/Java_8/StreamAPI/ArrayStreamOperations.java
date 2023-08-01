package Java_8.StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayStreamOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		variousMethods();
//		variousMethods1();
		variousMethods3();

	}
	
	public static void variousMethods() {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

		// Let's try the imperative style first(which we are familiar with)
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("Average using iteration :" + (sum / arr.length));

		
		
		// Let's try the declarative style now
		//here Arrays.stream(arr) this will give IntStream
		sum = Arrays.stream(arr).sum();
		System.out.println("Average using stream :" + (sum / arr.length));
		
		
		
		int arr_sample1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

		// asDoubleStream()
		// It converts the original array to double
		System.out.println("Example of asDoubleStream(): ");
		Arrays.stream(arr_sample1).asDoubleStream().forEach(e -> System.out.print(e + " "));

		
		// asLongStream()
		// It converts the original array to Long
		System.out.println("\nExample of asLongStream");
		Arrays.stream(arr_sample1).asLongStream().forEach(e -> System.out.print(e + " "));

		int arr_sample2[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 23, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

		
		// anyMatch()
		// This method find whether the given predicate
		// is in the array or not
		System.out.println("\nExample of anyMatch");
		
		// Test whether any of the element in array is
		// divisible by 11 or not
		IntPredicate predicate = e -> e % 11 == 0;
		System.out.println(Arrays.stream(arr_sample2).anyMatch(predicate));

		
		
		// You can directly write the lambda expression
		// which computes to IntPredicate
		System.out.println(Arrays.stream(arr).anyMatch(e -> e % 11 == 0));

		int arr_sample3[] = { 2, 4, 6, 8, 10 };
		int arr_sample4[] = { 1, 3, 5, 7, 11 };

		
		// allMatch()
		// This method finds whether the given predicate
		// matches the entire array or not
		System.out.println("Example of allMatch :");

		
		// Returns true as all the elements of arr_sample3 is even
		System.out.println(Arrays.stream(arr_sample3).allMatch(e -> e % 2 == 0));

		// Returns false as all the elements of arr_sammple4  is odd
		System.out.println(Arrays.stream(arr_sample4).allMatch(e -> e % 2 == 0));

		
		
		// noneMatch()
		System.out.println("Example of noneMatch");
		System.out.println(Arrays.stream(arr_sample4).noneMatch(e -> e % 2 == 0));
	}
	
	public static void variousMethods1() {
		int arr_sample1[] = { 11, 2, 3, 42, 5, 6, 17, 8, 9, 10, 11, 12, 13, 24, 55, 16, 47, 18, 19, 20 };
		System.out.println("These method returns Optional");

		// average()
		// This method returns a average of an array
		System.out.print("Example of average() : ");
		System.out.println((Arrays.stream(arr_sample1).average()));
		System.out.println();

		
		// findAny()
		// It can return any value from the stream
		// Most of the time it returns the first value
		// but it is not assured it can return any value
		System.out.print("Example of findAny() : ");
		System.out.println(Arrays.stream(arr_sample1).findAny());
		System.out.println();

		
		// findFirst()
		// It returns the first element of the stream
		System.out.print("Example of findFirst() :");
		System.out.println(Arrays.stream(arr_sample1).findFirst());
		System.out.println();

		// max()
		// It returns the max element in an array
		System.out.print("Example of max() :");
		System.out.println(Arrays.stream(arr_sample1).max());
		System.out.println();

		// min()
		// It returns the min element in an array
		System.out.print("Example of min() :");
		System.out.println(Arrays.stream(arr_sample1).min());
		System.out.println();

		// reduce()
		// It reduces the array by certain operation
		// Here it performs addition of array elements
		System.out.print("Example of reduce() :");
		System.out.println(Arrays.stream(arr_sample1).reduce((x, y) -> x + y));
		System.out.println();

		// reduce() have another variation which we will see in different example
		
		int arr_sample2[] = { 11, 2, 3, 42, 5, 6, 17, 8, 9, 10, 11, 12, 13, 24, 55, 16, 47, 18, 19, 20 };
		System.out.println("These method convert Optional to primitive");

		// OptionalDouble can be converted to double by using getAsDouble()
		// if average doesn't contains any value it throws NoSuchElementException
		System.out.print("Example of average() : ");
		System.out.println((Arrays.stream(arr_sample2).average().getAsDouble()));
		System.out.println();

		// OptionalInt can be converted to int by using getAsInt()
		System.out.print("Example of findAny() : ");
		System.out.println(Arrays.stream(arr_sample2).findAny().getAsInt());
		System.out.println();
		
		
	}
	
	public static void variousMethods3() {

//		int arr[][] = {{1,2,3},{4,5}};
//		Arrays.stream(arr).forEach(oneArr -> Arrays.stream(oneArr).forEach(System.out::println));
		
		
		
		//check if only alphabets are there
		String str = "hi how are you";
		long count = str.chars().filter(e -> !(e >= 'A' && e <= 'z') && e != ' ').count();
		if(count > 0) {
			System.out.println("Non alphabets are there");
		}else {
			System.out.println("Only alphabets are there");
		}
		
		boolean isAllAlpha = str.chars().allMatch(Character::isLetter);
		if(isAllAlpha) {
			System.out.println("Non alphabets are there");
		}else {
			System.out.println("Only alphabets are there");
		}
		

	}

}
