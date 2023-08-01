package Java_8.StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Spliterator;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Map operation
		Arrays.asList(1, 2, 3, 5).stream().map(e -> e * e).forEach(e -> System.out.print(e + " "));
		System.out.println("\n");

		
		
		List<List<Integer>> lstOfLst = new ArrayList<>();
		lstOfLst.add(Arrays.asList(1, 2));
		lstOfLst.add(Arrays.asList(3, 4));
		lstOfLst.add(Arrays.asList(1, 2, 8, 5));

		// Flat map operation.
		// e.stream().map(i -> i+10).sorted(): here sorting work on inner list not on final list
		lstOfLst.stream().flatMap(e -> e.stream().map(i -> i + 10).sorted()).forEach(e -> System.out.print(e + " "));
		System.out.println("\n");

		
		
		int seedValue = 2;
		int limitTerms = 5;
		// Generate infinite stream starting from seed value up to the limitTerm
		Stream.iterate(seedValue, n -> n + 10).limit(limitTerms).forEach(e -> System.out.print(e + " "));
		System.out.println("\n");

		
		
		// Create infinite stream using Stream.generate() method
		//The generate() method accepts a Supplier for generating elements and the resulting stream is infinite. 
		//So to restrict it, specify the desired size or the generate() method will work until it reaches the memory limit.
		Stream.generate(Math::random).limit(limitTerms).forEach(e -> System.out.print(e + " "));
		System.out.println("\n");
		
		
		
		List<String> list = Arrays.asList("Geeks", "For", "Geek", "GeeksForGeeks", "A Computer Portal");
		// Get the pattern
		Pattern p = Pattern.compile("^G");
		list.stream().filter(p.asPredicate()).forEach(e -> System.out.print(e + " "));
		System.out.println("\n");
		
		
		
		Stream<String> stream = Stream.of("Geeks", "For", "Geeks", "A", "Computer", "Portal");
		// Print the stream
		System.out.println(stream.collect(Collectors.toList()));
		System.out.println("\n");
		
		
		
		//var is available from java 10.
		//creating unmutable collection from stream
		var unmodifiableList = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
				.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
		System.out.println(unmodifiableList);
		System.out.println("\n");
		
		// Operations like this will result in an exception: unmodifiableList.add(12);
		
		
		
		// Print the stream using peek() by providing a terminal operation count()
		Arrays.asList(1, 2, 3, 5).stream().peek(s -> System.out.print(s + " "));			//this is not working
		System.out.println("\n");
        

		System.out.print("Printing intStream range: ");
		IntStream.range(1, 10).forEach(System.out::print);
		System.out.println("\n");
		
		

		System.out.print("Printing intStream range with skip: ");
		IntStream.range(1, 10).skip(5).forEach(x -> System.out.print(x));
		System.out.println("\n");
		
		
		
		System.out.println("Sum of IntStream range: "+ IntStream.range(1, 5).sum());
		System.out.println("\n");
		
		
		
		Stream.of("Java ", "Scala ", "Ruby ").sorted().findFirst().ifPresent(System.out::println);
		System.out.println("\n");
		
		

		Arrays.stream(new int[] { 2, 4, 6, 8, 10 }).map(x -> x * x).average().ifPresent(System.out::println);
		System.out.println("\n");
		
		

		List<String> people = Arrays.asList("AI", "Matlab", "Scikit", "TensorFlow", "OpenCV", "DeepLearning", "NLP", "NeuralNetworks");
		people.stream().map(String::toLowerCase).filter(x -> x.startsWith("a")).forEach(System.out::println);
		System.out.println("\n");
		
		

		double total = Stream.of(7.3, 1.5, 4.8).reduce(0.0, (Double a, Double b) -> a + b);
		System.out.println("total with reduce is: "+ total);
		System.out.println("\n");
		
		
		//convert iterable into stream
		Iterable<Integer> iterable = Arrays.asList(1,2,3,4,5);
		Spliterator<Integer> splIter = iterable.spliterator();
		Stream<Integer> stream1 = StreamSupport.stream(splIter, false);
		stream1.forEach(s -> System.out.print(s + " "));
		System.out.println("\n");
		
		
		
		
		//difference between Arrays.stream() and Stream.of() method
		int arr[] = { 1, 2, 3, 4, 5 };
		IntStream intStrm = Arrays.stream(arr);
		System.out.print("printing int stream: ");
		intStrm.forEach(x -> System.out.print(x + " "));
		System.out.println("\n");
		
		Stream<int[]> stream2 = Stream.of(arr);
		System.out.print("printing int stream as normal stream: ");
		stream2.forEach(x -> System.out.print(x + " "));		// it will return this [I@7e0babb1 not the actual numbers so casting required
		System.out.println("\n");
		
		Stream<int[]> stream3 = Stream.of(arr);
		IntStream intStrCast = stream3.flatMapToInt(Arrays::stream);
		System.out.print("printing int stream after casting: ");
		intStrCast.forEach(x -> System.out.print(x + " "));
		System.out.println("\n");
		
		
		
		//char stream will not work because its casting not supported
		char charArr[] = { '1', '2', '3', '4', '5' };
		Stream<char[]> charStream = Stream.of(charArr);
		System.out.print("printing char stream: ");
		charStream.forEach(str -> System.out.print(str + " "));
		
	}
	
	

}
