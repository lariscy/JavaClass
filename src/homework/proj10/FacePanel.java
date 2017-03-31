package homework.proj10;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 4.4.2017
 * @dueDate 4.6.2017
 * @description Wong-Baker FACES Pain Rating Scale
 */
public class FacePanel extends JPanel {
    
    // @TODO remove this
    // faces and colors used for smileys
    // https://lh5.ggpht.com/wf5ExKp6-pLRVprqinGAPT9XgdyTiiDY7F_VA3ZrxCfpMVoDioxtVpyRe_E1XTWclL8g=h900
    
    public static final int PANEL_WIDTH = 420;
    public static final int PANEL_HEIGHT = 420;
    
    public static final int SMILEY_WIDTH = (int) (PANEL_WIDTH * .71);
    public static final int SMILEY_HEIGHT = (int) (PANEL_WIDTH * .71);
    
    public static final int EYE_WIDTH = (int) (SMILEY_WIDTH * .1);
    public static final int EYE_HEIGHT = (int) (SMILEY_WIDTH * .1);
    public static final int EYE_OFFSET = (int) (SMILEY_WIDTH * .2);
    
    public static final int PUPIL_OFFSET = (int) (EYE_WIDTH * .1);
    
    private static final int MOUTH_WIDTH = (int) (SMILEY_WIDTH * .666);
    
    private final Color smileyColor;
    private final int mouthHeight;
    private final int mouthOffset;
    private final boolean isHappy;
    
    private final boolean showDebugLines = false;

    public FacePanel(Color backgroundColor, Color smileyColor, 
            boolean isHappy, int mouthHeight) {
        super();
        this.smileyColor = smileyColor;
        this.mouthHeight = mouthHeight;
        this.mouthOffset = (int) (this.mouthHeight * .25);
        this.isHappy = isHappy;
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(backgroundColor);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        /* face */
        g.setColor(smileyColor);
        g.fillOval(
            (PANEL_WIDTH / 2) - (SMILEY_WIDTH / 2), 
            (PANEL_HEIGHT / 2) - (SMILEY_HEIGHT / 2), 
            SMILEY_WIDTH, SMILEY_HEIGHT
        );
        
        /* face border */
        g.setColor(Color.BLACK);
        g.drawOval(
            (PANEL_WIDTH / 2) - (SMILEY_WIDTH / 2), 
            (PANEL_HEIGHT / 2) - (SMILEY_HEIGHT / 2), 
            SMILEY_WIDTH, SMILEY_HEIGHT
        );
        
        /* eyes */
        g.setColor(Color.WHITE);
        g.fillOval(
            (PANEL_WIDTH / 2) - (EYE_WIDTH / 2) - EYE_OFFSET,
            (PANEL_HEIGHT / 2) - (EYE_HEIGHT / 2) - EYE_OFFSET,
            EYE_WIDTH, EYE_HEIGHT
        );
        g.fillOval(
            (PANEL_WIDTH / 2) - (EYE_WIDTH / 2) + EYE_OFFSET,
            (PANEL_HEIGHT / 2) - (EYE_HEIGHT / 2) - EYE_OFFSET,
            EYE_WIDTH, EYE_HEIGHT
        );
        
        /* eyes border */
        g.setColor(Color.BLACK);
        g.drawOval(
            (PANEL_WIDTH / 2) - (EYE_WIDTH / 2) - EYE_OFFSET,
            (PANEL_HEIGHT / 2) - (EYE_HEIGHT / 2) - EYE_OFFSET,
            EYE_WIDTH, EYE_HEIGHT
        );
        g.drawOval(
            (PANEL_WIDTH / 2) - (EYE_WIDTH / 2) + EYE_OFFSET,
            (PANEL_HEIGHT / 2) - (EYE_HEIGHT / 2) - EYE_OFFSET,
            EYE_WIDTH, EYE_HEIGHT
        );
        
        /* eyes pupils */
        g.setColor(Color.BLACK);
        g.fillOval(
            (PANEL_WIDTH / 2) - (EYE_WIDTH / 2 / 2) - EYE_OFFSET,
            (PANEL_HEIGHT / 2) - (EYE_HEIGHT / 2 / 2) - EYE_OFFSET + PUPIL_OFFSET,
            EYE_WIDTH / 2, EYE_HEIGHT / 2
        );
        g.fillOval(
            (PANEL_WIDTH / 2) - (EYE_WIDTH / 2 / 2) + EYE_OFFSET,
            (PANEL_HEIGHT / 2) - (EYE_HEIGHT / 2 / 2) - EYE_OFFSET + PUPIL_OFFSET,
            EYE_WIDTH / 2, EYE_HEIGHT / 2
        );
        
        /* mouth */
        g.setColor(Color.BLACK);
        g.drawArc(
            (PANEL_WIDTH / 2) - (MOUTH_WIDTH / 2),
            (PANEL_HEIGHT / 2) - (mouthHeight / 2) + 
                    (this.isHappy ? (mouthOffset * -1) : mouthOffset),
            MOUTH_WIDTH,
            mouthHeight,
            0,
            (this.isHappy ? -180 : 180)
        );
        
        if (showDebugLines){
            /* debug lines to show center and assist with symmetry */
            g.setColor(Color.GRAY);
            g.drawLine(0, PANEL_WIDTH / 2, PANEL_HEIGHT, PANEL_WIDTH / 2);
            g.drawLine(PANEL_HEIGHT / 2, 0, PANEL_HEIGHT / 2, PANEL_WIDTH);   
        }
    }
    
    // @TODO remove this
    @Deprecated
    public void drawMouth(Graphics g){
        g.setColor(Color.BLACK);
        g.drawArc(
            (PANEL_WIDTH / 2) - (MOUTH_WIDTH / 2),
            (PANEL_HEIGHT / 2) - (mouthHeight / 2) + 
                    (this.isHappy ? (mouthOffset * -1) : mouthOffset),
            MOUTH_WIDTH,
            mouthHeight,
            0,
            (this.isHappy ? -180 : 180)
        );
    }
    
}
