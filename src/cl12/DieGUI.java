package cl12;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

public class DieGUI extends JComponent {
	
	private Die die;
	private static final int PIP_DIAM = 18;
	
	public DieGUI(){
		super();
		this.setPreferredSize(new Dimension(120, 120));
		this.setDie(new Die());
	}

	public Die getDie() {
		return die;
	}

	private void setDie(Die die) {
		this.die = die;
	}
	
	public int getCurrentValue(){
		return this.getDie().getCurrentValue();
	}
	
	public int roll(){
		this.getDie().roll();
		this.repaint();
		return this.getCurrentValue();
	}
	
	public void paintComponent(Graphics g){
		int width = this.getWidth();
		int height = this.getHeight();
		
		g.setColor(Color.WHITE);
		g.fillRoundRect(0, 0, width, height, 50, 50);
		
		g.setColor(Color.BLACK);
		g.drawRoundRect(0, 0, width - 1, height - 1, 50, 50);
		
		switch(this.getCurrentValue()){
			case 1:
				this.drawPip(g, width/2, height/2);
				break;
			case 3:
				this.drawPip(g, width/2, height/2);
			case 2:
				this.drawPip(g, width/4, height/4);
				this.drawPip(g, 3*width/4,  3*height/4);
				break;
			case 5:
				this.drawPip(g, width/2, height/2);
			case 4:
				this.drawPip(g, width/4, height/4);
				this.drawPip(g, 3*width/4,  3*height/4);
				this.drawPip(g, 3*width/4, height/4);
				this.drawPip(g, width/4,  3*height/4);
				break;
			case 6:
				this.drawPip(g, width/4, height/4);
				this.drawPip(g, 3*width/4,  3*height/4);
				this.drawPip(g, 3*width/4, height/4);
				this.drawPip(g, width/4,  3*height/4);
				this.drawPip(g, width/4,  height/2);
				this.drawPip(g, 3*width/4,  height/2);
				break;
			default:
				System.err.println("Error occurred");
				// should not reach this
		}
	}

	private void drawPip(Graphics g, int x, int y) {
		g.fillOval(x - PIP_DIAM, y - PIP_DIAM, PIP_DIAM, PIP_DIAM);
	}

}
