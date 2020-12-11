package algorithm;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class BarChart extends JPanel {
	int elementWidth = 14;
	int gapWidth = 2;
	int[] array;
	
	/**
	 * Creates an object which visualizes the data of an array, creating a bar chart representing the value of each element.
	 * @param array
	 */
	public BarChart(int[] array) {
		this.array = array;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);	
		
		Graphics2D g2D = (Graphics2D) g; // Will give a wider selection of useful functions for drawing
		
		g2D.setColor(Color.WHITE);
		g2D.setStroke(new BasicStroke(elementWidth));
		
		for(int i = 0; i < array.length; i++) {
			g2D.drawLine(100 + i*gapWidth + i*elementWidth, 872, 100 + i*gapWidth + i*elementWidth, array[i]);
		}
	}
}
