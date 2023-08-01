package Interview.Java.Generic;

public class GenericTypeClass<T> {

	T employee;
	
	public GenericTypeClass(T employee) {
		this.employee = employee;
	}

	public T getEmployee() {
		return employee;
	}

	public void setEmployee(T employee) {
		this.employee = employee;
	}
}
