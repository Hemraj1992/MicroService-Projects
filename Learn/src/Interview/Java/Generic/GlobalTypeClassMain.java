package Interview.Java.Generic;

public class GlobalTypeClassMain {

	public static void main(String[] args) {
		// any type of value can be passed in this constructor.
		
		//String passed
		GlobalTypeClass GTCvar = new GlobalTypeClass("This is global");
		System.out.println(GTCvar.getEmployee());
		
		//int passes. So this is the problem with object type. Type sefty can not be achived
		GTCvar.setEmployee(123);
		System.out.println(GTCvar.getEmployee());

	}

}
