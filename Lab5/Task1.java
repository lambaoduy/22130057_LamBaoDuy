package Lab5;

import java.util.Arrays;

public class Task1 {
	// add 2 matrices
	public static int[][] add(int[][] a, int[][] b) {
		int[][]result= new int[a.length][a[0].length];
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				result[i][j]= a[i][j]+b[i][j];
			}
		}
		return result;
	}
	
	public static void print(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
	}
	
	// subtract 2 matrices
	public static int[][]subtract(int[][] a, int[][] b) {
		int[][]result= new int[a.length][a[0].length];
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				result[i][j]= a[i][j]-b[i][j];
			}
		}
		return result;
	}
	
	// multiply 2 matrices
	public static int[][] multiply(int[][] a, int[][] b) {
		int[][]result= new int[a.length][a[0].length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
//				System.out.println(result.length);
				result[i][j]+= a[i][j]*b[j][i];
//				for (int j2 = 0; j2 < b.length; j2++) {
//					System.out.println(i+" "+j2);
//					
//				}
				
			}
		}
		return result;
	}
	
	// tranpose a matrix
	public static int[][] transpose(int[][] a) {
	int[][] result= new int [a[0].length][a.length];
	for (int i = 0; i < result.length; i++) {
		for (int j = 0; j < result[0].length; j++) {
			result[i][j]= a[j][i];
		}
	}
	return result;
	}
	public static void main(String[] args) {
		int[][] a= {{7,2},{5,3}};
		int[][] b= {{2,1},{3,1}};
		
		int[][] c= {{7,2,3,2},{5,3,2,3}};
		int[][] d= {{2,1,3},{3,1,2},{2,2,3},{3,2,4}};
//		print(add(a, b));
//		print(subtract(a, b));
//		print(multiply(c, d));
		print(transpose(c));
	}
}
