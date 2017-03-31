package homework.proj10;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Steven Lariscy
 */
public class Panel0 extends FacePanel {

    private static final int MOUTH_WIDTH = 200;
    private static final int MOUTH_HEIGHT = 200;
    private static final int MOUTH_OFFSET = (int) (MOUTH_HEIGHT * .25);
    
    public Panel0(Color smileyColor) {
        super(Color.RED, smileyColor, true, 5);
    }

    @Override
    public void drawMouth(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawArc(
            (PANEL_WIDTH / 2) - (MOUTH_WIDTH / 2),
            (PANEL_HEIGHT / 2) - (MOUTH_HEIGHT / 2) - MOUTH_OFFSET,
            MOUTH_WIDTH,
            MOUTH_HEIGHT,
            0,
            -180
        );
    }
    
}
