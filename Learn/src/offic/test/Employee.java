package offic.test;

public class Employee {

	int id;
	String name;
	String address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public Employee(int I, String nm, String add) {
		this.id = I;
		this.name = nm;
		this.address = add;
	}
	public Employee(int I) {
		this.id = I;
	}
	
	
}
