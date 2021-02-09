package algorithm;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Main {
	private static final int GRAPHICS_WINDOW_WIDTH = 872;
	private static final int GRAPHICS_WINDOW_HEIGHT = 872;
	private static final int OPTION_WINDOW_WIDTH = 280;
	private static final int OPTION_WINDOW_HEIGHT = 120;
	private static BarChart algorithmGraphics;
	private static QuicksortArray quicksortArray;
	
	public static void main(String[] args) {
		constructGraphicsPane();
		constructOptionPane();				
	}
	
	private static void constructOptionPane() {
		Frame optionFrame = new Frame(OPTION_WINDOW_WIDTH, OPTION_WINDOW_HEIGHT);
		JPanel optionPanel = new JPanel();
		JPanel buttonPanel = new JPanel(new GridBagLayout());
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
					optionFrame.setVisible(false);
					quicksortArray.quicksort(0, quicksortArray.getArray().length-1, algorithmGraphics);
					optionFrame.setVisible(true);
					
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		buttonPanel.add(startButton);
		buttonPanel.add(refreshButton);
		optionPanel.add(buttonPanel);
		
		// Slider
		final int SLIDER_MIN_VALUE = 1;
		final int SLIDER_MAX_VALUE = 100;
		final int SLIDER_INITIAL_VALUE = quicksortArray.getPauseBetweenSteps();
		JPanel sliderPanel = new JPanel(new GridBagLayout());
		JLabel sliderLabel = new JLabel("Speed");
		JSlider delaySlider = new JSlider(SLIDER_MIN_VALUE, SLIDER_MAX_VALUE, SLIDER_INITIAL_VALUE);
		delaySlider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider)e.getSource();
				quicksortArray.setPauseBetweenSteps((int)source.getValue());
				
			}
			
		});
		sliderPanel.add(sliderLabel);
		sliderPanel.add(delaySlider);
		
		optionPanel.add(sliderPanel);
		
		
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
