package Lab2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PascalTriangle {
	public static void printPascalTriangle(int n) {
		if (n==1) {
			System.out.println(Arrays.toString(getPascalTriangle(1)));
		} else {
			printPascalTriangle(n-1);
			System.out.println(Arrays.toString(getPascalTriangle(n)));;
		}
	}
	
	public static int[]getPascalTriangle(int n){
		
		if(n==1) {
			return new int[]  {1};
		}
		return generateNextRow(getPascalTriangle(n-1));	
	}
	
	public static int[] generateNextRow(int[] prerow) {
		int[]result= new int [prerow.length+1];
			result[0]=1;
			result[result.length-1]=1;
			for (int i = 1; i < result.length-1; i++) {
				result[i]=prerow[i-1]+prerow[i];
			}
		return result;
	}
	public static void main(String[] args) {
//		int[]array= {1,3,3,1};
//		System.out.println(Arrays.toString(generateNextRow(array)));
//		System.out.println(Arrays.toString(getPascalTriangle(4)));
		printPascalTriangle(3);
	}
}
