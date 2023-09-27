package Lab2;

public class Fibonacci {
	public static int getFibonacci(int n) {
		if(n==1||n==2) {
			return 1;
		}
		return getFibonacci(n-1)+getFibonacci(n-2);
	}
	
	public static void printFibonacci(int n) {
		if(n==1) {
			System.out.println(getFibonacci(1));
		
		}else {
		printFibonacci(n-1);
		System.out.println(getFibonacci(n));}
	}
	
	
	
	public static void main(String[] args) {
//		System.out.println(getFibonacci(3));
		printFibonacci(2);
	}
}
