package Lab4;

import java.util.Arrays;

public class Task2 {
	public static void mergeSort(int[] array) {
		int left = 0;
		int right = array.length;
		helpMergeSort(array, left, right);
	}

	private static void helpMergeSort(int[] array, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			helpMergeSort(array, left, mid);
			helpMergeSort(array, mid + 1, right);
			merge(array, left, mid, right);
		}

	}

	private static void merge(int[] array, int left, int mid, int right) {
		// TODO Auto-generated method stub
		int n = right - left;
		for (int i = left + 1; i < n; i++) {
			int cur = array[i];
			int j = i;
			while (j > 0 && array[j - 1] > cur) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = cur;
		}
	}

	public static void quickSort(int[] array) {
		helpquickSort(array, array.length);

	}

	private static void helpquickSort(int[] array, int length) {
		// TODO Auto-generated method stub
		if (length <= 1) {
			return;
		} else {
			int pivot = array[length - 1];
			int leftlength = 0;
			for (int i = 0; i < array.length; i++) {
				if (array[i] < pivot)
					leftlength++;
			}
			int[] left = new int[leftlength];
			int[] right = new int[length - leftlength - 1];
			int indexleft = 0;
			int indexright = 0;
			for (int i = 0; i < array.length; i++) {
				if (array[i] < pivot) {
					left[indexleft] = array[i];
					indexleft++;
				} else {
					if (array[i] > pivot) {
						right[indexright] = array[i];
						indexright++;
					}
				}
			}
			helpquickSort(left, leftlength);
			helpquickSort(right,length - leftlength - 1 );
			mergeQuickSort(array,left,right,pivot);
		}
	}

	public static void mergeQuickSort(int[] array, int[] left, int[] right, int pivot) {
		// TODO Auto-generated method stub
		for (int i = 0; i < left.length; i++) {
			array[i]=left[i];
		}
		array[left.length]=pivot;
		for (int i = left.length+1; i < array.length; i++) {
			array[i]=right[i-left.length-1];
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 4, 2, 3, 9, 7, 8 };
//		mergeSort(array);
//		quickSort(array);
		System.out.println(Arrays.toString(array));
	}
}
