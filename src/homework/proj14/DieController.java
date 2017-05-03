package homework.proj14;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 5.3.2017
 * @dueDate 5.4.2017
 * @description Kismet
 */
public class DieController {

    // constants
    private static final int PIP_SIZE = 8;
    
    // javafx injected instance variables
    @FXML
    private Pane root;
    @FXML
    private Rectangle rectangle;

    // instance variables
    private Die die;
    private boolean dieHeld;
    private boolean dieLocked;
    
    // constructor
    public DieController() {
        this.die = new Die();
    } // end constructor
    
    public void roll(){
        if (!this.isDieHeld()){
            this.die.roll();
            this.addPips();
        } else { // end if
            this.setDieLocked(true);
            // set color to distinguish die being "locked"
            this.root.setStyle("-fx-background-color: #000000");
        } // end else
    } // end roll
    
    public int getCurrentValue(){
        return this.die.getCurrentValue();
    } // end 

    public boolean isDieHeld() {
        return this.dieHeld;
    } // end 

    public void setDieHeld(boolean dieHeld) {
        this.dieHeld = dieHeld;
    } // end 

    public boolean isDieLocked() {
        return this.dieLocked;
    } // end 

    public void setDieLocked(boolean dieLocked) {
        this.dieLocked = dieLocked;
    } // end 
    
    public void resetDie(){
        this.setDieHeld(false);
        this.setDieLocked(false);
        this.die = new Die();
        this.addPips();
        this.root.setStyle("-fx-background-color: -fx-background");
    } // end 
    
    private void invertHeld(){
        this.setDieHeld(!this.isDieHeld());
        if (this.isDieHeld()){
            // set color to distinguish die being "held"
            this.root.setStyle("-fx-background-color: #0000ff");
        } else { // end if
            // set color to back to default
            this.root.setStyle("-fx-background-color: -fx-background");
        } // end else
    } // end 
    
    @FXML
    private void holdDie(){
        if (this.getCurrentValue() > 0 && !this.isDieLocked()){
            this.invertHeld();
        } // end if
    } // end 

    private void addPips() {
        // remove existing pips
        this.root.getChildren().removeIf((node) -> {
            return node instanceof Circle;
        });
        
        if (this.getCurrentValue() > 0){
            double rectangleWidth = this.rectangle.getWidth();
            double rectangleHeight = this.rectangle.getHeight();
            
            // decide on pip color
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
                    root.getChildren().add(new Circle(rectangleWidth / 2, 
                            rectangleHeight / 2, DieController.PIP_SIZE, pipColor));
                    break;
                case 3:
                    root.getChildren().add(new Circle(rectangleWidth / 2, 
                            rectangleHeight / 2, DieController.PIP_SIZE, pipColor));
                case 2:
                    root.getChildren().add(new Circle(rectangleWidth / 4, 
                            rectangleHeight / 4, DieController.PIP_SIZE, pipColor));
                    root.getChildren().add(new Circle(3 * rectangleWidth / 4, 
                            3 * rectangleHeight / 4, DieController.PIP_SIZE, pipColor));
                    break;
                case 5:
                    root.getChildren().add(new Circle(rectangleWidth / 2, 
                            rectangleHeight / 2, DieController.PIP_SIZE, pipColor));
                case 4:
                    root.getChildren().add(new Circle(rectangleWidth / 4, 
                            rectangleHeight / 4, DieController.PIP_SIZE, pipColor));
                    root.getChildren().add(new Circle(3 * rectangleWidth / 4, 
                            3 * rectangleHeight / 4, DieController.PIP_SIZE, pipColor));
                    root.getChildren().add(new Circle(3 * rectangleWidth / 4, 
                            rectangleHeight / 4, DieController.PIP_SIZE, pipColor));
                    root.getChildren().add(new Circle(rectangleWidth / 4, 
                            3 * rectangleHeight / 4, DieController.PIP_SIZE, pipColor));
                    break;
                case 6:
                    root.getChildren().add(new Circle(rectangleWidth / 4, 
                            rectangleHeight / 4, DieController.PIP_SIZE, pipColor));
                    root.getChildren().add(new Circle(3 * rectangleWidth / 4, 
                            3 * rectangleHeight / 4, DieController.PIP_SIZE, pipColor));
                    root.getChildren().add(new Circle(3 * rectangleWidth / 4, 
                            rectangleHeight / 4, DieController.PIP_SIZE, pipColor));
                    root.getChildren().add(new Circle(rectangleWidth / 4, 
                            3 * rectangleHeight / 4, DieController.PIP_SIZE, pipColor));
                    root.getChildren().add(new Circle(rectangleWidth / 4, 
                            rectangleHeight / 2, DieController.PIP_SIZE, pipColor));
                    root.getChildren().add(new Circle(3 * rectangleWidth / 4, 
                            rectangleHeight / 2, DieController.PIP_SIZE, pipColor));
                    break;
                default:
                    System.err.println("check default switch case in DieController.addPips()");
                    break;
            } // end switch
        } // end if
    } // end addPips
    
} // end of class
