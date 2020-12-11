package algorithm;

import java.util.Random;

public class QuicksortArray {
	int[] arrayToSort;	
	/**
	 * @param elementCount The amount of elements the object's array should have
	 * @param minValue The minimum value of an element
	 * @param maxValue The maximum value of an element
	 */
	public QuicksortArray(int elementCount, int minValue, int maxValue) {
		arrayToSort = new int[elementCount];
		
		Random rn = new Random();
		for(int i = 0; i < arrayToSort.length; i++) {
			arrayToSort[i] = rn.nextInt(maxValue - minValue + 1) + minValue;
		}
	}
	/**
	 *  Returns a string with a line for each element in the array, displaying its value.
	 *  Useful for debugging in the console.
	 * @return The multi-line string containing the values of each element
	 */
	public String listArrayElements() {
		String elements = "";
		for (int i = 0; i < arrayToSort.length; i++) {
			elements += "Element " + i + ":   " + arrayToSort[i] + "\n";
		}
		return elements;
	}
	/**
	 * @return The array of the QuicksortArray object
	 */
	public int[] getArray() {
		return arrayToSort;
	}
}
