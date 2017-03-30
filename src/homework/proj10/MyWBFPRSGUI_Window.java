package homework.proj10;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 4.4.2017
 * @dueDate 4.6.2017
 * @description Wong-Baker FACES Pain Rating Scale
 */
public class MyWBFPRSGUI_Window extends JFrame implements ActionListener {
    
    // instance variables
    private final Container contentPane;
    private final JButton button0;
    private final JButton button2;
    private final JButton button4;
    private final JButton button6;
    private final JButton button8;
    private final JButton button10;

    // constructor
    public MyWBFPRSGUI_Window() {
        super();
        
        this.setTitle("MyWBFPRSGUI_Demo");
        this.setSize(new Dimension(500, 500));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.contentPane = this.getContentPane();
        this.contentPane.setLayout(new FlowLayout());
        
        button0 = new JButton("0");
        button2 = new JButton("2");
        button4 = new JButton("4");
        button6 = new JButton("6");
        button8 = new JButton("8");
        button10 = new JButton("10");
        
        button0.addActionListener(this);
        button2.addActionListener(this);
        button4.addActionListener(this);
        button6.addActionListener(this);
        button8.addActionListener(this);
        button10.addActionListener(this);
        
        this.contentPane.setBackground(Color.WHITE);
        this.contentPane.add(button0);
        this.contentPane.add(button2);
        this.contentPane.add(button4);
        this.contentPane.add(button6);
        this.contentPane.add(button8);
        this.contentPane.add(button10);
    } // end of contructor

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch(actionEvent.getActionCommand()){
            case "0":
                System.out.println(actionEvent.getActionCommand()+" clicked");
                break;
            case "2":
                System.out.println(actionEvent.getActionCommand()+" clicked");
                break;
            case "4":
                System.out.println(actionEvent.getActionCommand()+" clicked");
                break;
            case "6":
                System.out.println(actionEvent.getActionCommand()+" clicked");
                break;
            case "8":
                System.out.println(actionEvent.getActionCommand()+" clicked");
                break;
            case "10":
                System.out.println(actionEvent.getActionCommand()+" clicked");
                break;
            default:
                System.out.println("Unexpected ActionEvent!");
                break;
        } // end switch
    } // end of actionPerformed
    
} // end of class
