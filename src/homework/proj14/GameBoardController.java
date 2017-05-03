package homework.proj14;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 5.3.2017
 * @dueDate 5.4.2017
 * @description Kismet
 */
public class GameBoardController implements Initializable {
    
    // constants
    private static final int MAX_ROLLS_PER_TURN = 3;
    private static final int MAX_TURNS_PER_GAME = 15;
    
    // javafx injected instance variables
    @FXML
    private DieController die1Controller;
    @FXML
    private DieController die2Controller;
    @FXML
    private DieController die3Controller;
    @FXML
    private DieController die4Controller;
    @FXML
    private DieController die5Controller;
    @FXML
    private Label lblTurnNumber;
    @FXML
    private ScoreCardController tblScoreCardController;
    
    // instance variables
    private int turnNumber = 1;
    private int rollNumber = 1;
    private boolean turnScored = true;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.tblScoreCardController.setupScoreColCellFactory(this);
    } // end initialize
    
    @FXML
    private void exitApp(){
        Platform.exit();
    } // end exitApp
    
    @FXML
    private void rollDice(){
        if (this.turnNumber <= GameBoardController.MAX_TURNS_PER_GAME){
            if (this.rollNumber <= GameBoardController.MAX_ROLLS_PER_TURN){
            
                if (this.areAllDiceHeld()){
                    this.lblTurnNumber.setText("Can't roll with all dice being held! "+
                            "Un-hold a die or score this turn below.");
                    return;
                } // end if

                this.lblTurnNumber.setText(
                        String.format("Turn: %s, Roll: %s", 
                                this.turnNumber, this.rollNumber));
                //this.lockHeldDice();

                this.die1Controller.roll();
                this.die2Controller.roll();
                this.die3Controller.roll();
                this.die4Controller.roll();
                this.die5Controller.roll();

                this.rollNumber++;
                this.setTurnScored(false);
            } else { // end if
                this.lblTurnNumber.setText("Max rolls ("+
                        GameBoardController.MAX_ROLLS_PER_TURN+
                        ") reached! Score this turn below.");
            } // end else
        } // end if
    } // end rollDice
    
    private boolean areAllDiceHeld(){
        return this.die1Controller.isDieHeld() && 
                this.die2Controller.isDieHeld() && 
                this.die3Controller.isDieHeld() &&
                this.die4Controller.isDieHeld() &&
                this.die5Controller.isDieHeld();
    } // end areAllDiceHeld
    
    public int[] getCurrentDieValues(){
        return new int[]{
            this.die1Controller.getCurrentValue(),
            this.die2Controller.getCurrentValue(),
            this.die3Controller.getCurrentValue(),
            this.die4Controller.getCurrentValue(),
            this.die5Controller.getCurrentValue()
        };
    } // end getCurrentDieValues
    
    public void resetDice(){
        this.die1Controller.resetDie();
        this.die2Controller.resetDie();
        this.die3Controller.resetDie();
        this.die4Controller.resetDie();
        this.die5Controller.resetDie();
    } // end resetDice

    public boolean isTurnScored() {
        return this.turnScored;
    } // end isTurnScored

    public void setTurnScored(boolean turnScored) {
        this.turnScored = turnScored;
        if (this.turnScored){
            this.lblTurnNumber.setText("Turn #"+this.turnNumber+
                    " scored! Roll again for next turn.");
            this.resetDice();
            this.turnNumber++;
            this.rollNumber = 1;
            if (this.turnNumber > GameBoardController.MAX_TURNS_PER_GAME){
                this.lblTurnNumber.setText("Game over! Thanks for playing!");
            } // end if
        } // end if
    } // end setTurnScored
    
} // end of class
