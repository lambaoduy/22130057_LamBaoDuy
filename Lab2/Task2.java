package Lab2;

public class Task2 {
	public static void drawPyramid(int n,int space) {
		if (n == 1) {
			for (int i = 0; i <space; i++) {
				System.out.print(" ");
			}
			System.out.println("*");
		} else {
			drawPyramid(n - 1,space+1);
			for (int i = 0; i <space; i++) {
				System.out.print(" ");
			}
			for (int i = 0; i < 2 * n-1; i++) {
				System.out.print("*");
			}
			System.out.println();

		}
	}

	public static void main(String[] args) {
//		drawPyramid(4,0);
	}
}
