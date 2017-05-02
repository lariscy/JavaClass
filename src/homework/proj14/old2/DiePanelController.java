package homework.proj14.old2;

import javafx.fxml.FXML;

/**
 * FXML Controller class
 *
 * @author Steven
 */
public class DiePanelController {
    
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

    public void roll(){
        die1Controller.roll();
        die2Controller.roll();
        die3Controller.roll();
        die4Controller.roll();
        die5Controller.roll();
    }
    
}
