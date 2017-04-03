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
 * @date 4.3.2017
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

        this.button0 = new JButton("0");
        this.button2 = new JButton("2");
        this.button4 = new JButton("4");
        this.button6 = new JButton("6");
        this.button8 = new JButton("8");
        this.button10 = new JButton("10");

        this.button0.addActionListener(this);
        this.button2.addActionListener(this);
        this.button4.addActionListener(this);
        this.button6.addActionListener(this);
        this.button8.addActionListener(this);
        this.button10.addActionListener(this);

        this.panel0 = new FacePanel(new Color(240, 248, 255),
                new Color(152, 248, 28), true, 200, "No Hurt");
        this.panel2 = new FacePanel(new Color(192, 198, 224),
                new Color(255, 187, 51), true, 100, "Hurts Little Bit");
        this.panel4 = new FacePanel(new Color(144, 149, 194),
                new Color(250, 249, 119), true, 10, "Hurts Little More");
        this.panel6 = new FacePanel(new Color(96, 99, 163),
                new Color(243, 112, 2), false, 20, "Hurts Event More");
        this.panel8 = new FacePanel(new Color(48, 50, 133),
                new Color(50, 181, 232), false, 100, "Hurts Whole Lot");
        this.panel10 = new FacePanel(new Color(0, 0, 102),
                new Color(79, 120, 198), false, 200, "Hurts Worst");

        this.contentPane.setBackground(Color.WHITE);

        this.contentPane.add(this.button0);
        this.contentPane.add(this.button2);
        this.contentPane.add(this.button4);
        this.contentPane.add(this.button6);
        this.contentPane.add(this.button8);
        this.contentPane.add(this.button10);

        this.contentPane.add(this.panel0);
        this.contentPane.add(this.panel2);
        this.contentPane.add(this.panel4);
        this.contentPane.add(this.panel6);
        this.contentPane.add(this.panel8);
        this.contentPane.add(this.panel10);

        this.hideAllPanels();
    } // end of contructor

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //System.out.println(actionEvent.getActionCommand()+" clicked");
        switch (actionEvent.getActionCommand()) {
            case "0":
                this.showPanel(this.panel0);
                this.hideButton(this.button0);
                break;
            case "2":
                this.showPanel(this.panel2);
                this.hideButton(this.button2);
                break;
            case "4":
                this.showPanel(this.panel4);
                this.hideButton(this.button4);
                break;
            case "6":
                this.showPanel(this.panel6);
                this.hideButton(this.button6);
                break;
            case "8":
                this.showPanel(this.panel8);
                this.hideButton(this.button8);
                break;
            case "10":
                this.showPanel(this.panel10);
                this.hideButton(this.button10);
                break;
            default:
                System.out.println("Unexpected ActionEvent!");
                break;
        } // end switch
    } // end of actionPerformed

    private void showAllButtons() {
        this.button0.setVisible(true);
        this.button2.setVisible(true);
        this.button4.setVisible(true);
        this.button6.setVisible(true);
        this.button8.setVisible(true);
        this.button10.setVisible(true);
    } // end showAllButtons

    private void hideButton(JButton button) {
        this.showAllButtons();
        button.setVisible(false);
    } // end hideButton

    private void hideAllPanels() {
        this.panel0.setVisible(false);
        this.panel2.setVisible(false);
        this.panel4.setVisible(false);
        this.panel6.setVisible(false);
        this.panel8.setVisible(false);
        this.panel10.setVisible(false);
    } // end hideAllPanels

    private void showPanel(FacePanel panel) {
        this.hideAllPanels();
        panel.setVisible(true);
    } // end showPanel

} // end of class
