import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import offic.test.Employee;

public class test {
	public static void main(String []str) {
		Set<Employee> emp = new HashSet<>();
		emp.add(new Employee(100));
		emp.add(new Employee(100));
		emp.forEach(e -> System.out.println(e.getId()));
		Employee emp1 = new Employee(50);
		Employee emp2 = new Employee(50);
		System.out.println(emp1.equals(emp2));
		
	}

	
}
