package algorithm;

import javax.swing.JFrame;

public class Frame extends JFrame{
	AlgorithmGraphics frameGraphics;

	public Frame(AlgorithmGraphics graphics) {
		frameGraphics = graphics;
		this.setSize(800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(frameGraphics);
		this.setVisible(true);
	}
}
