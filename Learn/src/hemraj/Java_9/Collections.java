package hemraj.Java_9;

import java.time.ZoneId;
import java.util.stream.Stream;
import java.util.List;
import java.util.stream.Collectors;
import java.io.IOException;

public class Collections {
	public static void main(String[] args) {
	      var names = List.of("Julie", "Robert", "Chris", "Joseph"); 
	      for (var name : names) {
	         System.out.println(name);
	      }
	      System.out.println("");
	      for (var i = 0; i < names.size(); i++) {
	         System.out.println(names.get(i));
	      }
	   }
}
