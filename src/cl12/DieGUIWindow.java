package cl12;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class DieGUIWindow extends JFrame {
	
	public DieGUIWindow() {
		super();
		this.setSize(new Dimension(300, 300));
		this.setTitle("as);dlkfajsdf ");
		this.getContentPane().setBackground(Color.RED);
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(new DieGUIPanel());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
