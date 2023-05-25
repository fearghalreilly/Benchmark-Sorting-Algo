package ie.atu.sw;

import java.io.FileWriter;
import java.net.http.HttpResponse.BodySubscriber;
import java.util.Arrays;
import java.util.Random;

public class Runner {

	public static void main(String[] args) {
		// Define an int array with different data sizes to be executed.
		int[] sizes = { 10, 100, 250, 500, 750, 1000, 1250, 2500, 3750, 5000, 6250, 7500, 8750, 10000 };
		// Define value for number of runs of each algorithm
		int numberOfRuns = 10;
		// Used to generate random numbers for the arrays.
		Random random = new Random();

		// Creating instances of the sorting algorithms
		BubbleSortAlgo bubbleS = new BubbleSortAlgo();
		SelectionSortAlgo selectionS = new SelectionSortAlgo();
		InsertionSortAlgo insertionS = new InsertionSortAlgo();
		MergeSortAlgo mergeS = new MergeSortAlgo();
		CountSortAlgo countS = new CountSortAlgo();
		GetAverage getAvg = new GetAverage();

		// Define a two dimensional array for each algorithm. The rows contains the size
		// of the array. The columns contains the value of times each sort algorithm is
		// be executed.
		double[][] bubbleSortTimes = new double[sizes.length][numberOfRuns];
		double[][] selectionSortTimes = new double[sizes.length][numberOfRuns];
		double[][] insertionSortTimes = new double[sizes.length][numberOfRuns];
		double[][] mergeSortTimes = new double[sizes.length][numberOfRuns];
		double[][] countingSortTimes = new double[sizes.length][numberOfRuns];

		// Output in the console following in format: Input Size Bubble Sort Selection
		// Sort Insertion Sort Merge Sort Counting Sort
		System.out.println("Input Size\tBubble Sort\tSelection Sort\tInsertion Sort\tMerge Sort\tCounting Sort");
		// Output to a CSV called output in the following format: Input Size Bubble Sort
		// Selection
		// Sort Insertion Sort Merge Sort Counting Sort
		try (FileWriter writer = new FileWriter("output.csv")) {
			writer.write("Input Size,Bubble Sort,Selection Sort,Insertion Sort,Merge Sort,Counting Sort\n");

			// Create arrays for the specified sizes from the sizes array with random int
			// values
			for (int i = 0; i < sizes.length; i++) {
				// On each iteration, define int size to value of the index
				int size = sizes[i];
				// Define an array to be size of int size.
				int[] arr = new int[size];
				// Populate the array with random int values.
				for (int j = 0; j < size; j++) {
					arr[j] = random.nextInt(size);
				}

				// Executes the bubbleSort method the number of times specified in int
				// numberOfRuns and stores the execution times
				for (int k = 0; k < numberOfRuns; k++) {
					// The array is copied. This prevents the original array data being altered
					int[] arrCopy = Arrays.copyOf(arr, arr.length);
					// Defines the start time
					long startTime = System.nanoTime();
					// Executes the bubbleSort method
					bubbleS.bubbleSort(arrCopy);
					// Defines the end time
					long endTime = System.nanoTime();
					double elapsedMillis = (endTime - startTime) / 1000000.0;
					// Populates the bubbleSortTimes array
					bubbleSortTimes[i][k] = elapsedMillis;

				}

				// Executes the selectionSort method the number of times specified in int
				// numberOfRuns and stores the execution times
				for (int k = 0; k < numberOfRuns; k++) {
					// The array is copied. This prevents the original array data being altered
					int[] arrCopy = Arrays.copyOf(arr, arr.length);
					// Defines the start time
					long startTime = System.nanoTime();
					// Executes the selectionSort method
					selectionS.selectionSort(arrCopy);
					// Defines the end time
					long endTime = System.nanoTime();
					// Populates the selectionSortTimes array
					double elapsedMillis = (endTime - startTime) / 1000000.0;
					selectionSortTimes[i][k] = elapsedMillis;
				}
				// Executes the selectionSort method the number of times specified in int
				// numberOfRuns and stores the execution times
				for (int k = 0; k < numberOfRuns; k++) {
					// The array is copied. This prevents the original array data being altered
					int[] arrCopy = Arrays.copyOf(arr, arr.length);
					// Defines the start time
					long startTime = System.nanoTime();
					// Executes the insertionSort method
					insertionS.insertionSort(arrCopy);
					// Defines the end time
					long endTime = System.nanoTime();
					// Populates the insertionSortTimes array
					double elapsedMillis = (endTime - startTime) / 1000000.0;
					insertionSortTimes[i][k] = elapsedMillis;
				}

				// Executes the mergeSortTimes method the number of times specified in int
				// numberOfRuns and stores the execution times
				for (int k = 0; k < numberOfRuns; k++) {
					// The array is copied. This prevents the original array data being altered
					int[] arrCopy = Arrays.copyOf(arr, arr.length);
					// Defines the start time
					long startTime = System.nanoTime();
					// Executes the mergeSort method
					mergeS.sort(arrCopy, 0, arrCopy.length - 1);
					// mergeSort(arrCopy);
					// Defines the end time
					long endTime = System.nanoTime();
					// Populates the mergeSortTimes array
					double elapsedMillis = (endTime - startTime) / 1000000.0;
					mergeSortTimes[i][k] = elapsedMillis;
				}

				// Executes the countingSort method the number of times specified in int
				// numberOfRuns and stores the execution times
				for (int k = 0; k < numberOfRuns; k++) {
					// The array is copied. This prevents the original array data being altered
					int[] arrCopy = Arrays.copyOf(arr, arr.length);
					// Defines the start time
					long startTime = System.nanoTime();
					// Executes the countingSort method
					countS.countSort(arrCopy, size);
					// countSort(arrCopy, size);
					// Defines the end time
					long endTime = System.nanoTime();
					// Populates the mergeSortTimes array
					double elapsedMillis = (endTime - startTime) / 1000000.0;
					countingSortTimes[i][k] = elapsedMillis;
				}

				// Outputs the average runtime for each method to 3 decimal places
				// Reference on how to round to decimal places:
				// https://www.javatpoint.com/two-decimal-places-java &
				// https://linuxhint.com/use-tab-escape-sequence-character-in-java/#:~:text=In%20Java%2C%20the%20%E2%80%9C%5Ct,the%20quotations%20(%E2%80%9D%20%E2%80%9C).

				String line = sizes[i] + "," + getAvg.getAverage(bubbleSortTimes[i]) + ","
						+ getAvg.getAverage(selectionSortTimes[i]) + "," + getAvg.getAverage(insertionSortTimes[i])
						+ "," + getAvg.getAverage(mergeSortTimes[i]) + "," + getAvg.getAverage(countingSortTimes[i])
						+ "\n";

				writer.write(line);
				System.out.printf(sizes[i] + "\t\t%.3f ms\t%.3f ms\t%.3f ms\t%.3f ms\t%.3f ms\n",
						getAvg.getAverage(bubbleSortTimes[i]), getAvg.getAverage(selectionSortTimes[i]),
						getAvg.getAverage(insertionSortTimes[i]), getAvg.getAverage(mergeSortTimes[i]),
						getAvg.getAverage(countingSortTimes[i]));
			}
			// "Error" is output when the exception is caught
		} catch (Exception e) {
			System.err.println("Error" + e.getMessage());
		}

	}

}
