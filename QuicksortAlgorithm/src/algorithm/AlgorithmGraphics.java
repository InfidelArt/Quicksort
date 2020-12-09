package algorithm;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class AlgorithmGraphics extends JPanel {
	int elementWidth = 14;
	int gapWidth = 1;
	int[] array;
	
	public AlgorithmGraphics(int[] array) {
		this.array = array;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);	
		
		Graphics2D g2D = (Graphics2D) g; // Will give a wider selection of useful functions for drawing
		
		g2D.setColor(Color.WHITE);
		g2D.setStroke(new BasicStroke(elementWidth));
		g2D.drawLine(100, 800, 100, 100);
	}
}
