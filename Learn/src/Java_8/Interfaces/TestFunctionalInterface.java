package Java_8.Interfaces;

@FunctionalInterface
public interface TestFunctionalInterface {

	int test(int t);
	default void printName() {
		System.out.println("Inside default print");
	}
	
	static void printNameStatic() {
		System.out.println("Inside static print");
	}
}
