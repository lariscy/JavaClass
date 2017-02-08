package homework.ch2;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 * @author Steven Lariscy
 * @project# P84830
 * @date 02.07.2016
 * @duedate 02.09.2016
 * @description Self portrait attempt using java.awt graphics
 */
public class SelfPortrait extends JFrame {
    
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_HEIGHT = 300;
    
    private static final Color COLOR_SKIN = new Color(255,224,189);
    private static final Color COLOR_SKIN_SHADOW = new Color(255,204,169);
    private static final Color COLOR_HAZEL = new Color(86,102,56);
    private static final Color COLOR_BROWN = new Color(107,73,17);
    private static final Color COLOR_LIP = new Color(228,168,168);
    
    public SelfPortrait() {
        super();
        this.setTitle("Self Portrait");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLocationRelativeTo(null); // set location to center of screen
        this.setResizable(false);
        //this.setUndecorated(true); // remove default window / menu decoration
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JLabel lblClose = new JLabel("X");
        lblClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblClose.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseExited(MouseEvent e) {
                lblClose.setForeground(Color.BLACK);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                lblClose.setForeground(Color.GRAY);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        lblClose.setBorder(new EmptyBorder(5, 0, 0, 5)); // adds padding to label
        
        JLabel lblTitle = new JLabel(this.getTitle());
        lblTitle.setBorder(new EmptyBorder(5, 5, 0, 0)); // adds padding to label
        
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        
        Box box  = Box.createHorizontalBox();
        box.add(lblTitle);
        box.add(Box.createHorizontalGlue());
        box.add(lblClose);
        this.add(box);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        // face
        int faceOffset = 40;
        g.setColor(COLOR_SKIN);
        g.fillOval(75, 50, 150, 200);
        
        // ears
        g.fillOval(67, 130, 15, 40);
        g.fillOval(218, 130, 15, 40);
        
        // eyes
        g.setColor(Color.WHITE);
        g.fillOval(100, 130, 35, 15);
        g.fillOval(165, 130, 35, 15);
        g.setColor(COLOR_HAZEL);
        g.fillOval(113, 132, 12, 12);
        g.fillOval(178, 132, 12, 12);
        g.setColor(Color.BLACK);
        g.fillOval(117, 137, 4, 4);
        g.fillOval(182, 137, 4, 4);
        
        // eyebrows
        g.setColor(COLOR_BROWN);
        g.drawArc(72, 123, 90, 40, 65, 50);
        g.drawArc(72, 124, 90, 40, 65, 50);
        g.drawArc(72, 125, 90, 40, 65, 50);
        g.drawArc(135, 123, 90, 40, 65, 50);
        g.drawArc(135, 124, 90, 40, 65, 50);
        g.drawArc(135, 125, 90, 40, 65, 50);
        
        // nose
        g.setColor(COLOR_SKIN_SHADOW);
        g.drawLine(148, 140, 144, 180);
        g.drawLine(153, 140, 159, 180);
        
        // mouth
        g.setColor(COLOR_LIP);
        g.drawArc(122, 170, 60, 40, 235, 70);
        g.drawArc(122, 171, 60, 40, 235, 70);
    }
    
    public static void main(String[] args) {
        SelfPortrait me = new SelfPortrait();
        me.setVisible(true);
    }
    
}
