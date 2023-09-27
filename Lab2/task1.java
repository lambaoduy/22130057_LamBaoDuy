package Lab2;

import java.util.regex.Matcher;

public class task1 {
	public static int getSn1(int n) {
		int result=1;
		if(n==1) {
			return 1;
		}else {
		return (int) Math.pow(-1,n-1)*n+getSn1(n-1);
		}
	}
	
	public static int getSn2(int n) {
		int result=1;
		if(n==1) {
			return 1;
		}else {
		return (int) getSn2(n-1)+n*factorial(n-1);
		}
	}
	
	private static int factorial(int i) {
		if(i==1) {
			return 1;
		}else {
		return i*factorial(i-1);
		}
	}
	
	public static int getSn3(int n) {
		int result=1;
		if(n==1) {
			return 1;
		}else {
		return  (int) ( getSn3(n-1)+Math.pow(n, 2));
		}
	}
	
	public static double getSn4(int n) {
		int result=1;
		if(n==0) {
			return 1;
		}else {
		return  getSn4(n-1)+(double)1/(Math.pow(2, n)*factorial(n));
		}
	}
	
	public static void main(String[] args) {
//		System.out.println(getSn1(2));
//		System.out.println(getSn2(3));
//		System.out.println(getSn3(3));
		System.out.println(getSn4(3));
	}
}
