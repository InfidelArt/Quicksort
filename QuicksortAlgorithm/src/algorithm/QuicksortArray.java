package algorithm;

import java.util.Random;

// What determines the next step in the algorithm?

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
	@SuppressWarnings("unused") // Remember to remove this
	private static void partition(int[] array, int lo, int hi) {
		int pivot = array[hi]; // We choose the last element as pivot
		int smaller = lo - 1; // This will be incremented before it gets used. It keeps track of the last element found that was smaller than the pivot.
		
		for (int i = lo; i <= hi-1; i++) { // Go through the subset of the array
			if(array[i] < pivot) {
				smaller++; // Since the current element is smaller than the pivot, the position of the last smallest element found is increased.
				swap(array, i, smaller);
			}
		}
		swap(array, smaller + 1, hi);
	}
	/**
	 *  Swaps the position of two elements in the given array
	 * @return The same array with the positions of the elements at index a and b swapped
	 */
	private static final int[] swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
			
		return array;
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
	public void partitionAndPrint() {  // DEBUGGING METHOD, REMEMBER TO REMOVE
		System.out.println(listArrayElements());
		partition(this.arrayToSort, 0, this.arrayToSort.length-1);
		System.out.println(listArrayElements());
	}
	/**
	 * @return The array of the QuicksortArray object
	 */
	public int[] getArray() {
		return arrayToSort;
	}
}
