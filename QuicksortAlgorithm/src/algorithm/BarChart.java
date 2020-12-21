package algorithm;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class BarChart extends JPanel {
	private int elementWidth = 14;
	private int gapWidth = 2;
	private int pivotIndex;
	private int currentIndex;
	private int smallerIndex;
	QuicksortArray array;
	
	/**
	 * Creates an object which visualizes the data of an array, creating a bar chart representing the value of each element.
	 * @param array
	 */
	public BarChart(QuicksortArray array) {
		this.array = array;
		this.pivotIndex = -1;
		this.currentIndex = -1;
		this.smallerIndex = -1;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);	
		
		Graphics2D g2D = (Graphics2D) g; // Will give a wider selection of useful functions for drawing
		
		g2D.setColor(Color.WHITE);
		g2D.setStroke(new BasicStroke(elementWidth));
		
		for(int i = 0; i < array.getArray().length; i++) {
			if (i == this.pivotIndex) {
				g2D.setColor(Color.ORANGE);
				g2D.drawLine(100 + i*gapWidth + i*elementWidth, 872, 100 + i*gapWidth + i*elementWidth, array.getArray()[i]);
				g2D.setColor(Color.WHITE);
			}
			else if (i == this.currentIndex) {
				g2D.setColor(Color.GREEN);
				g2D.drawLine(100 + i*gapWidth + i*elementWidth, 872, 100 + i*gapWidth + i*elementWidth, array.getArray()[i]);
				g2D.setColor(Color.WHITE);
			}
			else if (i == this.smallerIndex) {
				g2D.setColor(Color.BLUE);
				g2D.drawLine(100 + i*gapWidth + i*elementWidth, 872, 100 + i*gapWidth + i*elementWidth, array.getArray()[i]);
				g2D.setColor(Color.WHITE);
			}
			else {
				g2D.drawLine(100 + i*gapWidth + i*elementWidth, 872, 100 + i*gapWidth + i*elementWidth, array.getArray()[i]);
			}
			
		}
		
	}
	public void setPivot(int pivotIndex) {
		this.pivotIndex = pivotIndex;
	}
	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}
	public void setSmallerIndex(int smallerIndex) {
		this.smallerIndex = smallerIndex;
	}
}
