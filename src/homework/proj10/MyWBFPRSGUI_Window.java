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
    
    private final FacePanel panel0;
    private final FacePanel panel2;
    private final FacePanel panel4;
    private final FacePanel panel6;
    private final FacePanel panel8;
    private final FacePanel panel10;

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
        
        // color blender: http://meyerweb.com/eric/tools/color-blend/#F0F8FF:000066:4:rgbd
        panel0 = new FacePanel(new Color(240,248,255), 
                new Color(152, 248, 28), true, 200);
        panel2 = new FacePanel(new Color(192,198,224), 
                new Color(255, 187, 51), true, 100);
        panel4 = new FacePanel(new Color(144,149,194), 
                new Color(250, 249, 119), true, 10);
        panel6 = new FacePanel(new Color(96,99,163), 
                new Color(243, 112, 2), false, 20);
        panel8 = new FacePanel(new Color(48,50,133), 
                new Color(50, 181, 232), false, 100);
        panel10 = new FacePanel(new Color(0,0,102), 
                new Color(79, 120, 198), false, 200);
        
        this.contentPane.setBackground(Color.WHITE);
        
        this.contentPane.add(button0);
        this.contentPane.add(button2);
        this.contentPane.add(button4);
        this.contentPane.add(button6);
        this.contentPane.add(button8);
        this.contentPane.add(button10);
        
        this.contentPane.add(panel0);
        this.contentPane.add(panel2);
        this.contentPane.add(panel4);
        this.contentPane.add(panel6);
        this.contentPane.add(panel8);
        this.contentPane.add(panel10);
        
        this.hideAllPanels();
    } // end of contructor

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println(actionEvent.getActionCommand()+" clicked");
        switch(actionEvent.getActionCommand()){
            case "0":
                this.hideAllPanels();
                this.panel0.setVisible(true);
                this.showAllButtons();
                this.button0.setVisible(false);
                break;
            case "2":
                this.hideAllPanels();
                this.panel2.setVisible(true);
                this.showAllButtons();
                this.button2.setVisible(false);
                break;
            case "4":
                this.hideAllPanels();
                this.panel4.setVisible(true);
                this.showAllButtons();
                this.button4.setVisible(false);
                break;
            case "6":
                this.hideAllPanels();
                this.panel6.setVisible(true);
                this.showAllButtons();
                this.button6.setVisible(false);
                break;
            case "8":
                this.hideAllPanels();
                this.panel8.setVisible(true);
                this.showAllButtons();
                this.button8.setVisible(false);
                break;
            case "10":
                this.hideAllPanels();
                this.panel10.setVisible(true);
                this.showAllButtons();
                this.button10.setVisible(false);
                break;
            default:
                System.out.println("Unexpected ActionEvent!");
                break;
        } // end switch
    } // end of actionPerformed
    
    private void showAllButtons(){
        this.button0.setVisible(true);
        this.button2.setVisible(true);
        this.button4.setVisible(true);
        this.button6.setVisible(true);
        this.button8.setVisible(true);
        this.button10.setVisible(true);
    }
    
    private void hideAllPanels(){
        this.panel0.setVisible(false);
        this.panel2.setVisible(false);
        this.panel4.setVisible(false);
        this.panel6.setVisible(false);
        this.panel8.setVisible(false);
        this.panel10.setVisible(false);
    }
    
} // end of class
