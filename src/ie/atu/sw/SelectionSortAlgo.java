package ie.atu.sw;

public class SelectionSortAlgo {
	// Reference https://www.geeksforgeeks.org/selection-sort/
	// Method selectionSort sorts an array of integers
	public void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			// Find the index of the smallest element in the unsorted portion of the array
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			// Swap the smallest element with the first element in the unsorted portion of
			// the array
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
	}

}
