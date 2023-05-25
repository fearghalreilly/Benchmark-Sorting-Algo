package ie.atu.sw;

public class GetAverage {

	// Method getAverage returns a double. This method is used to return the average
	// run time for each Algorithm.
	public double getAverage(double[] arr) {
		// Initialize the sum variable to zero.
		double sum = 0;
		// Loop through each element of the array and add it to the sum.
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		// Divide the sum by the length of the array to calculate the average.
		return (double) sum / arr.length;
	}

}
