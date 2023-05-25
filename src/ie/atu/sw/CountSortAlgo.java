package ie.atu.sw;

public class CountSortAlgo {
	// https://www.geeksforgeeks.org/counting-sort/
	// Method countSort sorts an integer array in ascending order
	public int[] countSort(int[] theArray, int maxValue) {

		// Creates an array to count the number of occurrences of each integer in the
		// input array.
		int[] counts = new int[maxValue + 1];
		// Counts the number of occurrences of each integer in the input array.
		for (int item : theArray) {
			counts[item] += 1;
		}

		// overwrite counts to hold the next index an item with
		// a given value goes.
		int numItemsBefore = 0;
		for (int i = 0; i < counts.length; i++) {
			int count = counts[i];
			counts[i] = numItemsBefore;
			numItemsBefore += count;
		}

		// Creates an output array to hold the sorted integers
		int[] sortedArray = new int[theArray.length];

		// Run through the input array and place each integer in the output array
		// according to the counts array.
		for (int item : theArray) {

			// Place the item in the sorted array at the index specified by the counts
			// array.
			sortedArray[counts[item]] = item;

			// Increment the count for the current item, so that the next item with the same
			// value goes after it.
			counts[item] += 1;
		}
		// Return the sorted array.
		return sortedArray;
	}

}
