package cl12;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DieGUIPanel extends JPanel implements ActionListener {

	private DieGUI leftDie;
	private DieGUI rightDie;
	private JButton btnRoll;
	
	public DieGUIPanel() {
		super();
		this.leftDie = new DieGUI();
		this.rightDie = new DieGUI();
		this.btnRoll = new JButton("Roll");
		this.btnRoll.addActionListener(this);
		
		this.setBackground(Color.BLUE);
		this.setLayout(new BorderLayout());
		this.add(this.leftDie, BorderLayout.WEST);
		this.add(this.rightDie, BorderLayout.EAST);
		this.add(this.btnRoll, BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.leftDie.roll();
		this.rightDie.roll();
	}

}
