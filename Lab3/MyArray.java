package Lab3;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		super();
		this.array = array;
	}

// task 1.1
	public int iterativeLineearSearch(int target) {
		int result = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				result = i;
			}
		}
		return result;
	}

	public int recursiveLineearSearch(int target) {
		int length = array.length;
		return supportrecursiveLineearSearch(target, length);
	}

	public int supportrecursiveLineearSearch(int target, int length) {
		if (length - 1 <= 0) {
			return -1;
		} else {
			if (array[length - 1] == target) {
				return length - 1;
			} else {
				return supportrecursiveLineearSearch(target, length - 1);
			}
		}
	}

	// task 1.2
	public int iterativeBinarySearch(int target) {
		int left = 0;
		int right = array.length - 1;
		int result = -1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (array[mid] == target) {
				result = mid;
				break;
			} else {
				if (array[mid] > target) {
					right = mid -1;
				} else {
					left = mid + 1;
				}
			}
		}
		return result;
	}

	public int recursiveBinarySearch(int target) {
		int left = 0;
		int right = array.length - 1;
		return supportrecursiveBinarySearch(target, left, right);
	}

	private int supportrecursiveBinarySearch(int target, int left, int right) {
		if (left >= right) {
			return -1;
		} else {
			int mid = (left + right) / 2;
			if (array[mid] == target) {
				return mid;
			} else {
				if (array[mid] < target) {
					return supportrecursiveBinarySearch(target, mid + 1,right);
				} else {
					return supportrecursiveBinarySearch(target,left, mid-1);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] array1 = { 1, 3, 2, 4, 5, 45, 5 };
		MyArray myArray1 = new MyArray(array1);
		int[] array2 = { 1, 2, 3, 4, 6, 7, 9 };
		MyArray myArray2 = new MyArray(array2);
//		System.out.println(myArray1.iterativeLineearSearch(19));
//		System.out.println(myArray1.recursiveLineearSearch(45));
//		System.out.println(myArray2.iterativeBinarySearch(3));
//		System.out.println(myArray2.recursiveBinarySearch(7));
	}

}
