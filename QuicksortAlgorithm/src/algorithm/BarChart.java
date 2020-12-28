package algorithm;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class BarChart extends JPanel {
	private final int ELEMENT_WIDTH = 14;
	private final int GAP_WIDTH = 2;
	private int pivotIndex;
	private int currentIndex;
	private int smallerIndex;
	public Graphics g;
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
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.g = g;
		this.setBackground(Color.BLACK);	
		
		Graphics2D g2D = (Graphics2D) g; // Will give a wider selection of useful functions for drawing
		
		g2D.setColor(Color.WHITE);
		g2D.setStroke(new BasicStroke(ELEMENT_WIDTH));
		
		for(int i = 0; i < array.getArray().length; i++) {
			if (i == this.pivotIndex) {
				g2D.setColor(Color.ORANGE);
				g2D.drawLine(100 + i*GAP_WIDTH + i*ELEMENT_WIDTH, 872, 100 + i*GAP_WIDTH + i*ELEMENT_WIDTH, array.getArray()[i]);
				g2D.setColor(Color.WHITE);
			}
			else if (i == this.currentIndex) {
				g2D.setColor(Color.GREEN);
				g2D.drawLine(100 + i*GAP_WIDTH + i*ELEMENT_WIDTH, 872, 100 + i*GAP_WIDTH + i*ELEMENT_WIDTH, array.getArray()[i]);
				g2D.setColor(Color.WHITE);
			}
			else if (i == this.smallerIndex) {
				g2D.setColor(Color.BLUE);
				g2D.drawLine(100 + i*GAP_WIDTH + i*ELEMENT_WIDTH, 872, 100 + i*GAP_WIDTH + i*ELEMENT_WIDTH, array.getArray()[i]);
				g2D.setColor(Color.WHITE);
			}
			else {
				g2D.drawLine(100 + i*GAP_WIDTH + i*ELEMENT_WIDTH, 872, 100 + i*GAP_WIDTH + i*ELEMENT_WIDTH, array.getArray()[i]);
			}
			
		}
		
	}
	public void resetIndexes(QuicksortArray array) {
		this.array = array;
		this.pivotIndex = -1;
		this.currentIndex = -1;
		this.smallerIndex = -1;		
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
