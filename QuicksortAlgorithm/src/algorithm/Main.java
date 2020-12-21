package algorithm;

// note to self: use more named constants

public class Main {

	public static void main(String[] args) throws InterruptedException {
		QuicksortArray quicksortArray = new QuicksortArray(42, 25, 700);
		Frame algorithmFrame = new Frame(); 
		BarChart algorithmGraphics = new BarChart(quicksortArray);
		algorithmFrame.add(algorithmGraphics);
		System.out.println(quicksortArray.listArrayElements());
		quicksortArray.quicksort(0, quicksortArray.getArray().length-1, algorithmGraphics);
		algorithmGraphics.repaint();
	}

}
