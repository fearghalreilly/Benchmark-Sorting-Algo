package ie.atu.sw;

public class BubbleSortAlgo {

	// Reference https://www.geeksforgeeks.org/bubble-sort/
	// Method bubbleSort sorts an array of integers.
	public void bubbleSort(int[] arr) {
		// Loops through all the elements in the array
		for (int i = 0; i < arr.length - 1; i++) {
			// Compares next elements and swap them if they are out of order.
			for (int j = 0; j < arr.length - i - 1; j++) {
				// Swaps the element if the current element is greater than the next element
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

}
