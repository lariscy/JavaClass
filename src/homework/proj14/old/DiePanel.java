package homework.proj14.old;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Steven Lariscy
 */
public class DiePanel extends JPanel implements ActionListener {
    
    private final DieComponent die1 = new DieComponent();
    private final DieComponent die2 = new DieComponent();
    private final DieComponent die3 = new DieComponent();
    private final DieComponent die4 = new DieComponent();
    private final DieComponent die5 = new DieComponent();
    
    private final JButton btnRoll;

    public DiePanel() {
        super();
        this.btnRoll = new JButton("Roll!");
        this.btnRoll.addActionListener(this);
        this.initPanel();
    }

    private void initPanel() {
        this.add(this.die1);
        this.add(this.die2);
        this.add(this.die3);
        this.add(this.die4);
        this.add(this.die5);
        this.add(this.btnRoll);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.die1.roll();
        this.die2.roll();
        this.die3.roll();
        this.die4.roll();
        this.die5.roll();
    }
    
}
