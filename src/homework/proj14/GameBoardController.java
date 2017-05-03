package homework.proj14;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class GameBoardController implements Initializable {
    
    private static final int MAX_ROLLS_PER_TURN = 3;
    private static final int MAX_TURNS_PER_GAME = 15;
    
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
    
    private int turnNumber = 1;
    private int rollNumber = 1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.tblScoreCardController.setupScoreColCellFactory(this);
    }
    
    @FXML
    private void exitApp(){
        Platform.exit();
    }
    
    @FXML
    private void rollDice(){
        if (this.rollNumber <= GameBoardController.MAX_ROLLS_PER_TURN){
            
            if (this.areAllDiceHeld()){
                this.lblTurnNumber.setText("Can't roll with all dice being held! "+
                        "Un-hold a die or score this turn below.");
                return;
            }
            
            this.lblTurnNumber.setText(
                    String.format("Turn: %s, Roll: %s", turnNumber, rollNumber));
            //this.lockHeldDice();
        
            this.die1Controller.roll();
            this.die2Controller.roll();
            this.die3Controller.roll();
            this.die4Controller.roll();
            this.die5Controller.roll();
            
            this.rollNumber++;
        } else {
            this.lblTurnNumber.setText("Max rolls ("+
                    GameBoardController.MAX_ROLLS_PER_TURN+
                    ") reached! Score this turn below.");
        }
    }
    
    private boolean areAllDiceHeld(){
        return this.die1Controller.isDieHeld() && 
                this.die2Controller.isDieHeld() && 
                this.die3Controller.isDieHeld() &&
                this.die4Controller.isDieHeld() &&
                this.die5Controller.isDieHeld();
    }
    
    public int[] getCurrentDieValues(){
        return new int[]{
            this.die1Controller.getCurrentValue(),
            this.die2Controller.getCurrentValue(),
            this.die3Controller.getCurrentValue(),
            this.die4Controller.getCurrentValue(),
            this.die5Controller.getCurrentValue()
        };
    }
    
//    private void lockHeldDice(){
//        if (this.die1Controller.isDieHeld()){
//            this.die1Controller.setDieLocked(true);
//        }
//        if (this.die2Controller.isDieHeld()){
//            this.die2Controller.setDieLocked(true);
//        }
//        if (this.die3Controller.isDieHeld()){
//            this.die3Controller.setDieLocked(true);
//        }
//        if (this.die4Controller.isDieHeld()){
//            this.die4Controller.setDieLocked(true);
//        }
//        if (this.die5Controller.isDieHeld()){
//            this.die5Controller.setDieLocked(true);
//        }
//    }
    
} // end of class
