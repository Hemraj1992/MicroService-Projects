package Interview.Java.Generic;

public class GenericTypeClassMain {

	public static void main(String[] args) {
		// any type of value can be passed in this constructor.

		// String passed
		GenericTypeClass GTCvar = new GenericTypeClass("This is global");
		System.out.println(GTCvar.getEmployee());

		// int passes. So this is the problem with object type. Type sefty can not be
		// achived
		GTCvar.setEmployee(123);
		System.out.println(GTCvar.getEmployee());

		// String passed
		GenericTypeClass<String> GTCStr = new GenericTypeClass("This is global");
		System.out.println(GTCStr.getEmployee());

		// not able to pass anything else than string now.
		// This type safety also achieved.
//		GTCStr.setEmployee(123);
		System.out.println(GTCStr.getEmployee());

		// can get type of the variable at run time.
		System.out.println(GTCStr.employee.getClass().getName());

		
		
		
		// Integer passed
		GenericTypeClass<Integer> GTCInt = new GenericTypeClass(123);
		System.out.println(GTCInt.getEmployee());

		// can get type of the variable at run time.
		System.out.println(GTCInt.employee.getClass().getName());

	}

}
