package homework.proj14;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author Steven
 */
public class DieController {

    private static final int PIP_SIZE = 8;
    
    @FXML
    private Pane root;
    @FXML
    private Rectangle rectangle;

    private final Die die;
    
    public DieController() {
        this.die = new Die();
    }
    
    public void roll(){
        this.die.roll();
        this.addPips();
    }
    
    public int getCurrentValue(){
        return this.die.getCurrentValue();
    }

    private void addPips() {
        if (this.getCurrentValue() > 0){
//            double rectangleWidth = this.rectangle.getWidth();
//            double rectangleHeight = this.rectangle.getHeight();
            
            // remove existing pips
            this.root.getChildren().removeIf((node) -> {
                return node instanceof Circle;
            });
            
            // choose pip color
            Color pipColor = null;
            switch(this.die.getCurrentValue()){
                case 2:
                case 5:
                    pipColor = Color.RED;
                    break;
                case 3:
                case 4:
                    pipColor = Color.GREEN;
                    break;
                default:
                    pipColor = Color.BLACK;
            }
            
            // add new pips
            switch(this.die.getCurrentValue()){
                case 1:
                    root.getChildren().add(new Circle(rectangle.getWidth() / 2, rectangle.getHeight() / 2, PIP_SIZE, pipColor));
                    break;
                case 3:
                    root.getChildren().add(new Circle(rectangle.getWidth() / 2, rectangle.getHeight() / 2, PIP_SIZE, pipColor));
                case 2:
                    root.getChildren().add(new Circle(rectangle.getWidth() / 4, rectangle.getHeight() / 4, PIP_SIZE, pipColor));
                    root.getChildren().add(new Circle(3 * rectangle.getWidth() / 4, 3 * rectangle.getHeight() / 4, PIP_SIZE, pipColor));
                    break;
                case 5:
                    root.getChildren().add(new Circle(rectangle.getWidth() / 2, rectangle.getHeight() / 2, PIP_SIZE, pipColor));
                case 4:
                    root.getChildren().add(new Circle(rectangle.getWidth() / 4, rectangle.getHeight() / 4, PIP_SIZE, pipColor));
                    root.getChildren().add(new Circle(3 * rectangle.getWidth() / 4, 3 * rectangle.getHeight() / 4, PIP_SIZE, pipColor));
                    root.getChildren().add(new Circle(3 * rectangle.getWidth() / 4, rectangle.getHeight() / 4, PIP_SIZE, pipColor));
                    root.getChildren().add(new Circle(rectangle.getWidth() / 4, 3 * rectangle.getHeight() / 4, PIP_SIZE, pipColor));
                    break;
                case 6:
                    root.getChildren().add(new Circle(rectangle.getWidth() / 4, rectangle.getHeight() / 4, PIP_SIZE, pipColor));
                    root.getChildren().add(new Circle(3 * rectangle.getWidth() / 4, 3 * rectangle.getHeight() / 4, PIP_SIZE, pipColor));
                    root.getChildren().add(new Circle(3 * rectangle.getWidth() / 4, rectangle.getHeight() / 4, PIP_SIZE, pipColor));
                    root.getChildren().add(new Circle(rectangle.getWidth() / 4, 3 * rectangle.getHeight() / 4, PIP_SIZE, pipColor));
                    root.getChildren().add(new Circle(rectangle.getWidth() / 4, rectangle.getHeight() / 2, PIP_SIZE, pipColor));
                    root.getChildren().add(new Circle(3 * rectangle.getWidth() / 4, rectangle.getHeight() / 2, PIP_SIZE, pipColor));
                    break;
                default:
                    System.err.println("what what");
            }
        }
    }
    
}
