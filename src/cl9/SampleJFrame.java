package cl9;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SampleJFrame extends JFrame implements ActionListener {

	private Container contentPane;
	private JButton sunnyButton;
	private JButton cloudyButton;
	private SunnyPanel sunnyPanel;
	
	public SampleJFrame(){
		super();
		
		this.setTitle("window title");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.contentPane = this.getContentPane();
		this.contentPane.setLayout(new FlowLayout());
		
		this.sunnyButton = new JButton("Sunny");
		this.sunnyButton.addActionListener(this);
		this.cloudyButton = new JButton("Cloudy");
		this.cloudyButton.addActionListener(this);
		
		this.sunnyPanel = new SunnyPanel();
		
		this.contentPane.add(this.sunnyButton);
		this.contentPane.add(this.cloudyButton);
		this.contentPane.add(this.sunnyPanel);
		
		this.sunnyPanel.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		if ("Sunny".equals(command)){
			sunnyButton.setVisible(false);
			cloudyButton.setVisible(true);
			sunnyPanel.setVisible(true);
		} else if ("Cloudy".equals(command)) {
			sunnyButton.setVisible(true);
			cloudyButton.setVisible(false);
			sunnyPanel.setVisible(false);
		}
	}

}
