package homework.proj14.old;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * @author Steven Lariscy
 */
public class GameWindow extends JFrame {

    public GameWindow() {
        super();
        this.initFrame();
    }

    private void initFrame() {
        this.setSize(new Dimension(600, 600));
        this.setTitle("Kismet");
        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(new DiePanel());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
