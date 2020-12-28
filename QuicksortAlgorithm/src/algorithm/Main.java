package algorithm;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
/* 2020-12-28
 * - Provide the alternative to use "median-of-three" as choice of pivot
 * - Tidy up code by keeping better track of constants and using less magic numbers
 * - Increase the size of the array and decrease delay between steps
 */

public class Main {
	private static final int GRAPHICS_WINDOW_WIDTH = 872;
	private static final int GRAPHICS_WINDOW_HEIGHT = 872;
	private static final int OPTION_WINDOW_WIDTH = 250;
	private static final int OPTION_WINDOW_HEIGHT = 120;
	private static BarChart algorithmGraphics;
	private static QuicksortArray quicksortArray;
	
	public static void main(String[] args) {
		constructGraphicsPane();
		constructOptionPane();				
	}
	
	private static void constructOptionPane() {
		Frame optionFrame = new Frame(OPTION_WINDOW_WIDTH, OPTION_WINDOW_HEIGHT);	
		JPanel optionPanel = new JPanel(new GridBagLayout());
		JButton refreshButton = new JButton("Refresh");
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		JButton startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					algorithmGraphics.repaint();
					quicksortArray.quicksort(0, quicksortArray.getArray().length-1, algorithmGraphics);
					
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		optionPanel.add(startButton);
		optionPanel.add(refreshButton);
		optionFrame.add(optionPanel);
		optionFrame.setLocation(GRAPHICS_WINDOW_WIDTH,0); // To make the window appear to the right of the graphics pane
	}
	private static void constructGraphicsPane() {
		quicksortArray = new QuicksortArray(42, 25, 700);
		algorithmGraphics = new BarChart(quicksortArray);
		Frame algorithmFrame = new Frame(GRAPHICS_WINDOW_WIDTH, GRAPHICS_WINDOW_HEIGHT); 		
		algorithmFrame.add(algorithmGraphics);
		
	}
	private static void refresh() {
		quicksortArray.refreshArray(42, 25, 700);
		algorithmGraphics.resetIndexes(quicksortArray);
		algorithmGraphics.repaint();
	}
}
