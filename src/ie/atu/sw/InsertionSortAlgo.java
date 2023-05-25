package ie.atu.sw;

public class InsertionSortAlgo {
	// Reference https://www.geeksforgeeks.org/insertion-sort/
	// Method insertionSort sorts an array of integers in ascending order
	public void insertionSort(int[] arr) {
		// Gets the length of the array
		int n = arr.length;
		// Loop through all elements of the array starting from index 1.
		for (int i = 1; i < n; i++) {
			// Store the current element in value key
			int key = arr[i];
			// Store the value of the element in the previous element
			int j = i - 1;
			// Loop backwards through the sorted part of the array, moving the elements to
			// the right until the correct position for key is found.
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			// Insert the key element into the correct position in the sorted part of the
			// array.
			arr[j + 1] = key;
		}
	}

}
