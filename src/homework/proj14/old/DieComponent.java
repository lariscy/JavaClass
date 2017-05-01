package homework.proj14.old;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 * @author Steven Lariscy
 */
public class DieComponent extends JComponent {

    private static final int PIP_DIAMETER = 18;
    private static final int PREF_COMPONENT_WIDTH = 100;
    private static final int PREF_COMPONENT_HEIGHT = 100;
    
    private final Die die = new Die();
    
    public DieComponent() {
        super();
        this.initComponent();
    }
    
    private void initComponent(){
        this.setPreferredSize(new Dimension(PREF_COMPONENT_WIDTH, PREF_COMPONENT_HEIGHT));
    }
    
    public void roll(){
        this.die.roll();
        this.repaint();
    }
    
    public int getCurrentValue(){
        return this.die.getCurrentValue();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int actualWidth = this.getWidth();
        int actualHeight = this.getHeight();
        
        g.setColor(Color.WHITE);
        g.fillRoundRect(0, 0, actualWidth, actualHeight, 50, 50);

        g.setColor(Color.BLACK);
        g.drawRoundRect(0, 0, actualWidth, actualHeight, 50, 50);
        
        switch (this.getCurrentValue()) {
            case 1:
            case 6:
                g.setColor(Color.BLACK);
                break;
            case 2:
            case 5:
                g.setColor(Color.RED);
                break;
            case 3:
            case 4:
                g.setColor(Color.GREEN);
                break;
            default:
                // do nothing
        }
        
        switch(this.getCurrentValue()){
            case 1:
                this.drawPip(g, actualWidth/2, actualHeight/2);
                break;
            case 3:
                this.drawPip(g, actualWidth/2, actualHeight/2);
            case 2:
                this.drawPip(g, actualWidth/4, actualHeight/4);
                this.drawPip(g, 3*actualWidth/4,  3*actualHeight/4);
                break;
            case 5:
                this.drawPip(g, actualWidth/2, actualHeight/2);
            case 4:
                this.drawPip(g, actualWidth/4, actualHeight/4);
                this.drawPip(g, 3*actualWidth/4,  3*actualHeight/4);
                this.drawPip(g, 3*actualWidth/4, actualHeight/4);
                this.drawPip(g, actualWidth/4,  3*actualHeight/4);
                break;
            case 6:
                this.drawPip(g, actualWidth/4, actualHeight/4);
                this.drawPip(g, 3*actualWidth/4,  3*actualHeight/4);
                this.drawPip(g, 3*actualWidth/4, actualHeight/4);
                this.drawPip(g, actualWidth/4,  3*actualHeight/4);
                this.drawPip(g, actualWidth/4,  actualHeight/2);
                this.drawPip(g, 3*actualWidth/4,  actualHeight/2);
                break;
            default:
                // no pips are drawn
        }
    }
    
    private void drawPip(Graphics g, int x, int y) {
        g.fillOval(x - (DieComponent.PIP_DIAMETER / 2), 
                y - (DieComponent.PIP_DIAMETER / 2), 
                DieComponent.PIP_DIAMETER, DieComponent.PIP_DIAMETER);
    }
    
}
