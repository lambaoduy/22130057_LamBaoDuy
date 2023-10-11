package Lab4;

import java.util.Arrays;

public class Task1 {
	public static void selectionSort(int[] array) {
		int index = 0;
		for (int i = 0; i < array.length - 1; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = i; j < array.length; j++) {
				if (min > array[j]) {
					min = array[j];
					index = j;
				}
			}
			swap(array, i, index);
		}
	}

	public static void swap(int[] array, int num1, int num2) {
		int k;
		k = array[num1];
		array[num1] = array[num2];
		array[num2] = k;
	}

	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
				}
			}
		}
	}

	public static void insertionSort(int[] array) {
		int n = array.length;
		for (int i = 1; i < array.length; i++) {
			int cur = array[i];
			int j = i;
			while (j > 0 && array[j - 1] > cur) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = cur;
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 4, 2, 3, 9, 7, 8 };
//		selectionSort(array);
//		bubbleSort(array);
//		insertionSort(array);
		System.out.println(Arrays.toString(array));
	}
}
