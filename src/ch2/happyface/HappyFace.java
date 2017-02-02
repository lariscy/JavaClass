package ch2.happyface;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class HappyFace extends JFrame {
	
	public HappyFace(){
		super();
		this.setTitle("My First GUI");
		this.setSize(400, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics coloredPencil){
		super.paint(coloredPencil);
		
		coloredPencil.setColor(Color.YELLOW);
		coloredPencil.fillOval(100, 150, 200, 200);
		
		coloredPencil.setColor(new Color(5, 176, 245));
		coloredPencil.fillOval(155, 200, 10, 20);
		coloredPencil.fillOval(230, 200, 10, 20);
		
		coloredPencil.setColor(Color.RED);
		coloredPencil.drawArc(150, 260, 100, 50, 180, 180);
	}

}
