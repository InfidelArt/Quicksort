package algorithm;

// note to self: use more named constants

public class Main {

	public static void main(String[] args) {
		QuicksortArray quicksortArray = new QuicksortArray(42, 25, 700);
		Frame algorithmFrame = new Frame(); 
		BarChart algorithmGraphics = new BarChart(quicksortArray.getArray());
		algorithmFrame.add(algorithmGraphics);
		System.out.println(quicksortArray.listArrayElements());
		quicksortArray.partitionAndPrint();
	}

}
