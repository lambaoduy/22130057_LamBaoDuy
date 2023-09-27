package Lab1;

import java.util.Arrays;

public class MyArray {

	public int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	// Method mirror that outputs the contents of an array in a
	// reverse order like a mirror
	// Example: input [1, 2, 3] ==> output: [1, 2, 3, 3, 2, 1]
	public int[] mirror() {
		// TODO
		int result[] = new int[array.length * 2];
		for (int i = 0; i < array.length; i++) {
			result[i] = result[result.length - 1 - i] = array[i];
		}
		return result;
	}

	// removes all duplicate elements from an array and returns a
	// new array
	// Input: 1 3 5 1 3 7 9 8
	// Output: 1 3 5 7 9 8
	public int[] removeDuplicates() {
		int[] result = new int[array.length - countDuplicates()];
		int k = 0;
		result[0] = array[0];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < i; j++) {
				if (result[i] == result[j]) {
					k++;
				}
				result[i] = array[i + k];
			}

		}

		return result;
	}

	public int countDuplicates() {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] == array[j]) {
					result++;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 3, 4, 5, 4, 7, 1, 2 };
		MyArray myArray = new MyArray(array);
		System.out.println(Arrays.toString(myArray.removeDuplicates()));
		// System.out.println(Arrays.toString(myArray.mirror()));
	}
}
