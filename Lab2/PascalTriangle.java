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
	// task 1.4
	public static void moveTower(int disk, String source, String dest, String spare) {
		if (disk == 1) {
			System.out.println("move disk" + " " + disk + " " + "from " + source + " to " + dest);
		} else {
			moveTower(disk - 1, source, spare, dest);
			System.out.println("move disk" + " " + disk + " " + "from " + source + " to " + dest);
			moveTower(disk - 1, spare, dest, source);
		}
	}

	public static void main(String[] args) {
//		int[]array= {1,3,3,1};
//		System.out.println(Arrays.toString(generateNextRow(array)));
//		System.out.println(Arrays.toString(getPascalTriangle(4)));
//		printPascalTriangle(3);
		
		moveTower(3, "source", "dest", "spare");
	}
}

