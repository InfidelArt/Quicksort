package algorithm;

import java.util.Random;

// What determines the next step in the algorithm?

public class QuicksortArray {
	private int[] arrayToSort;	
	private int pivot;
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
		this.pivot = 0;
	}
	@SuppressWarnings("unused") // Remember to remove this
	private static int partition(int[] array, int lo, int hi, BarChart graphics) throws InterruptedException {
		int pivot = array[hi]; // We choose the last element as pivot
		graphics.setPivot(hi);
		int smaller = lo - 1; // This will be incremented before it gets used. It keeps track of the last element found that was smaller than the pivot.
		
		for (int i = lo; i <= hi-1; i++) { // Go through the subset of the array
			graphics.setCurrentIndex(i);
			if(array[i] < pivot) {
				smaller++; // Since the current element is smaller than the pivot, the position of the last smallest element found is increased.
				graphics.setSmallerIndex(smaller);
				swap(array, i, smaller);
				graphics.paintImmediately(0, 0, 872, 872);
				Thread.sleep(60);
				
			}
		}
		swap(array, smaller + 1, hi); // Take the pivot and put it to the right of the last element that was smaller than it
		graphics.paintImmediately(0,0,872,872);
		Thread.sleep(60);
		return smaller + 1;
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
	public void quicksort(int lo, int hi, BarChart graphics) throws InterruptedException {
		if(lo < hi) {
			pivot = partition(this.arrayToSort, lo, hi, graphics);
			quicksort(lo, pivot - 1, graphics);
			quicksort(pivot + 1, hi, graphics);
		}
	}
	public void refreshArray(int elementCount, int minValue, int maxValue) {
		arrayToSort = new int[elementCount];
		Random rn = new Random();
		for(int i = 0; i < arrayToSort.length; i++) {
			arrayToSort[i] = rn.nextInt(maxValue - minValue + 1) + minValue;
		}
	}
	/**
	 * @return The array of the QuicksortArray object
	 */
	public int[] getArray() {
		return arrayToSort;
	}
}
