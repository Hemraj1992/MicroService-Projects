package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdentifySpecialChar {

	public static void main(String args[]) {
		
		test();
		System.out.println("after test");
	}
	
	public static void test() {
		try {
		Pattern ptrn = Pattern.compile("[@,.!:;\"'#%$]");
		Matcher match = ptrn.matcher("Hi $this");
		String str = null;
		if(match.find()) {
//			System.out.println("match found" + str.toUpperCase());
			
		}else {
			System.out.println("match not found");
		}
		}catch(Exception e){
			System.out.println("in catch block: "+e.getLocalizedMessage());
		}finally {
			System.out.println("I will execute always");
		}
		System.out.println("after finally");
	}
}
