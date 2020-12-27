package algorithm;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

// note to self: use more named constants

public class Main {
	private static final int GRAPHICS_WINDOW_WIDTH = 872;
	private static final int GRAPHICS_WINDOW_HEIGHT = 872;
	private static final int OPTION_WINDOW_WIDTH = 300;
	private static final int OPTION_WINDOW_HEIGHT = 200;
	private static BarChart algorithmGraphics;
	private static QuicksortArray quicksortArray;
	
	public static void main(String[] args) throws InterruptedException {
		constructGraphicsPane();
		constructOptionPane();		
				
	}
	
	private static void constructOptionPane() {
		OptionFrame optionFrame = new OptionFrame(OPTION_WINDOW_WIDTH, OPTION_WINDOW_HEIGHT);	
		JPanel optionPanel = new JPanel();
		JButton refreshButton = new JButton("Refresh");
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		JButton startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					algorithmGraphics.repaint();
					quicksortArray.quicksort(0, quicksortArray.getArray().length-1, algorithmGraphics);
					
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					System.out.println("????");
				}
			}
		});
		
		optionPanel.add(startButton);
		optionPanel.add(refreshButton);
		optionFrame.add(optionPanel);
		optionFrame.setLocation(GRAPHICS_WINDOW_WIDTH,0);
	}
	private static void constructGraphicsPane() {
		quicksortArray = new QuicksortArray(42, 25, 700);
		algorithmGraphics = new BarChart(quicksortArray);
		Frame algorithmFrame = new Frame(GRAPHICS_WINDOW_WIDTH, GRAPHICS_WINDOW_HEIGHT); 		
		algorithmFrame.add(algorithmGraphics);
		
	}
	private static void reset() {
		quicksortArray.refreshArray(42, 25, 700);
		algorithmGraphics.repaint();
	}
}
