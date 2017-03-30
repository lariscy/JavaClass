package cl9;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SunnyPanel extends JPanel {
	
	public SunnyPanel(){
		super();
		this.setPreferredSize(new Dimension(420, 420));
		this.setBackground(Color.YELLOW);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.GREEN);
		g.fillOval(100, 50, 200, 200);
	}

}
