package Interview.Collection;
import java.util.HashSet;
import java.util.Set;

import offic.test.Employee;

public class SetClass {

	public static void main(String []str) {
		
		//
		
		Employee emp1 = new Employee(50);
		Employee emp2 = new Employee(50);
		
		//These objects are not equal thus set will keep both. Internally set use equal method for equality check
		System.out.println(emp1.equals(emp2));
		Set<Employee> emp = new HashSet<>();
		emp.add(emp1);
		emp.add(emp2);
		emp.forEach(e -> System.out.println(e.getId()));
		
		
		Employee emp3 = new Employee(50, "name1", "add1");
		Employee emp4 = new Employee(50, "name1", "add1");
		//these two are also not equal
		System.out.println(emp3.equals(emp4));
		
		Employee emp5 = emp4;
		System.out.println("emp5.equals(emp4)=> "+emp5.equals(emp4));
		System.out.println("emp5 == emp4 => "+ (emp5 == emp4));
		
	}
	
	
	//Object class equal method
//	public boolean equals(Object anObject) {    
//	      if (this == anObject) {    
//	          return true;    
//	      }    
//	      if (anObject instanceof String) {    
//	          String anotherString = (String) anObject;    
//	          int n = value.length;    
//	          if (n == anotherString.value.length) {    
//	              char v1[] = value;    
//	              char v2[] = anotherString.value;    
//	              int i = 0;    
//	              while (n-- != 0) {    
//	                  if (v1[i] != v2[i])    
//	                          return false;    
//	                  i++;    
//	              }    
//	              return true;    
//	          }    
//	      }    
//	      return false;    
//	  }    
}
