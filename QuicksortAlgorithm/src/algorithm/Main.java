package algorithm;

public class Main {

	public static void main(String[] args) {
		QuicksortArray quicksortArray = new QuicksortArray(42, 10, 700);
		Frame algorithmFrame = new Frame(new AlgorithmGraphics(quicksortArray.getArray())); 
		System.out.println(quicksortArray.listArrayElements());
		
	}

}
