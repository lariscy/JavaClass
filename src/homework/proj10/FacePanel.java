package homework.proj10;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 4.3.2017
 * @dueDate 4.6.2017
 * @description Wong-Baker FACES Pain Rating Scale
 */
public class FacePanel extends JPanel {

    // constants
    public static final int PANEL_WIDTH = 420;
    public static final int PANEL_HEIGHT = 420;

    public static final int SMILEY_WIDTH = (int) (PANEL_WIDTH * .71);
    public static final int SMILEY_HEIGHT = (int) (PANEL_WIDTH * .71);

    public static final int EYE_WIDTH = (int) (SMILEY_WIDTH * .1);
    public static final int EYE_HEIGHT = (int) (SMILEY_WIDTH * .1);
    public static final int EYE_OFFSET = (int) (SMILEY_WIDTH * .2);

    public static final int PUPIL_OFFSET = (int) (EYE_WIDTH * .1);

    public static final int MOUTH_WIDTH = (int) (SMILEY_WIDTH * .666);

    // instance variables
    private final Color smileyColor;
    private final int mouthHeight;
    private final int mouthOffset;
    private final boolean isHappy;
    private final String displayText;

    private final boolean showDebugLines = false;

    // constructor
    public FacePanel(Color backgroundColor, Color smileyColor,
            boolean isHappy, int mouthHeight, String displayText) {
        super();
        this.smileyColor = smileyColor;
        this.mouthHeight = mouthHeight;
        this.mouthOffset = (int) (this.mouthHeight * .25);
        this.isHappy = isHappy;
        this.displayText = displayText;
        this.setPreferredSize(new Dimension(FacePanel.PANEL_WIDTH, FacePanel.PANEL_HEIGHT));
        this.setBackground(backgroundColor);
    } // end constructor

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // face (start)
        g.setColor(this.smileyColor);
        g.fillOval(
                (FacePanel.PANEL_WIDTH / 2) - (FacePanel.SMILEY_WIDTH / 2),
                (FacePanel.PANEL_HEIGHT / 2) - (FacePanel.SMILEY_HEIGHT / 2),
                FacePanel.SMILEY_WIDTH, FacePanel.SMILEY_HEIGHT
        );
        // face (end)

        // face border (start)
        g.setColor(Color.BLACK);
        g.drawOval(
                (FacePanel.PANEL_WIDTH / 2) - (FacePanel.SMILEY_WIDTH / 2),
                (FacePanel.PANEL_HEIGHT / 2) - (FacePanel.SMILEY_HEIGHT / 2),
                FacePanel.SMILEY_WIDTH, FacePanel.SMILEY_HEIGHT
        );
        // face border (end)

        // eyes (start)
        g.setColor(Color.WHITE);
        g.fillOval(
                (PANEL_WIDTH / 2) - (EYE_WIDTH / 2) - EYE_OFFSET,
                (PANEL_HEIGHT / 2) - (EYE_HEIGHT / 2) - EYE_OFFSET,
                EYE_WIDTH, EYE_HEIGHT
        );
        g.fillOval(
                (FacePanel.PANEL_WIDTH / 2) - (FacePanel.EYE_WIDTH / 2) + FacePanel.EYE_OFFSET,
                (FacePanel.PANEL_HEIGHT / 2) - (FacePanel.EYE_HEIGHT / 2) - FacePanel.EYE_OFFSET,
                FacePanel.EYE_WIDTH, FacePanel.EYE_HEIGHT
        );
        // eyes (end)

        // eyes border (start)
        g.setColor(Color.BLACK);
        g.drawOval(
                (FacePanel.PANEL_WIDTH / 2) - (FacePanel.EYE_WIDTH / 2) - FacePanel.EYE_OFFSET,
                (FacePanel.PANEL_HEIGHT / 2) - (FacePanel.EYE_HEIGHT / 2) - FacePanel.EYE_OFFSET,
                FacePanel.EYE_WIDTH, FacePanel.EYE_HEIGHT
        );
        g.drawOval(
                (FacePanel.PANEL_WIDTH / 2) - (FacePanel.EYE_WIDTH / 2) + FacePanel.EYE_OFFSET,
                (FacePanel.PANEL_HEIGHT / 2) - (FacePanel.EYE_HEIGHT / 2) - FacePanel.EYE_OFFSET,
                FacePanel.EYE_WIDTH, FacePanel.EYE_HEIGHT
        );
        // eyes border (end)

        // eyes puplis (start)
        g.setColor(Color.BLACK);
        g.fillOval(
                (FacePanel.PANEL_WIDTH / 2) - (FacePanel.EYE_WIDTH / 2 / 2) - FacePanel.EYE_OFFSET,
                (FacePanel.PANEL_HEIGHT / 2) - (FacePanel.EYE_HEIGHT / 2 / 2)
                - FacePanel.EYE_OFFSET + FacePanel.PUPIL_OFFSET,
                FacePanel.EYE_WIDTH / 2, FacePanel.EYE_HEIGHT / 2
        );
        g.fillOval(
                (FacePanel.PANEL_WIDTH / 2) - (FacePanel.EYE_WIDTH / 2 / 2) + FacePanel.EYE_OFFSET,
                (FacePanel.PANEL_HEIGHT / 2) - (FacePanel.EYE_HEIGHT / 2 / 2)
                - FacePanel.EYE_OFFSET + FacePanel.PUPIL_OFFSET,
                FacePanel.EYE_WIDTH / 2, FacePanel.EYE_HEIGHT / 2
        );
        // eyes puplis (end)

        // mouth (start)
        g.setColor(Color.BLACK);
        g.drawArc(
                (FacePanel.PANEL_WIDTH / 2) - (FacePanel.MOUTH_WIDTH / 2),
                (FacePanel.PANEL_HEIGHT / 2) - (this.mouthHeight / 2)
                + (this.isHappy ? (this.mouthOffset * -1) : this.mouthOffset),
                FacePanel.MOUTH_WIDTH,
                this.mouthHeight,
                0,
                (this.isHappy ? -180 : 180)
        );
        // mouth (end)

        // text (start)
        if (isHappy) {
            g.setColor(Color.BLACK);
        } else { // end if
            g.setColor(Color.WHITE);
        } // end else
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        FontMetrics fontMetrics = g.getFontMetrics();
        g.drawString(displayText,
                (FacePanel.PANEL_WIDTH - fontMetrics.stringWidth(displayText)) / 2,
                FacePanel.PANEL_HEIGHT - fontMetrics.getAscent());
        // text (end)

        if (showDebugLines) {
            /* debug lines to show center and assist with symmetry */
            g.setColor(Color.GRAY);
            g.drawLine(0, FacePanel.PANEL_WIDTH / 2, FacePanel.PANEL_HEIGHT,
                    FacePanel.PANEL_WIDTH / 2);
            g.drawLine(FacePanel.PANEL_HEIGHT / 2, 0, FacePanel.PANEL_HEIGHT / 2,
                    FacePanel.PANEL_WIDTH);
        } // end if
    } // end paintComponent

} // end class
