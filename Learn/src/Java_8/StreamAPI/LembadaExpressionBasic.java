package Java_8.StreamAPI;

import Java_8.Interfaces.TestFunctionalInterface;

public final class LembadaExpressionBasic {

	int number = 50;
	public static void main(String[] args) {

		LembadaExpressionBasic lb = new LembadaExpressionBasic();
		lb.test();
	}
	public void test(){
		LembadaExpressionBasic lb = new LembadaExpressionBasic();
		
		int num = 10;
		TestFunctionalInterface fi = (n) -> {
			System.out.println("number before: "+ (num + n++));
			number = 200;
			System.out.println("number after: "+ (number + n));
			return lb.number;
		};
		
		fi.test(5);
		fi.printName();
	}

}
