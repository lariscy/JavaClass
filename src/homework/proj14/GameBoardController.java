package homework.proj14;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Steven
 */
public class GameBoardController implements Initializable {

    @FXML
    private Button btnRoll;
    @FXML
    private DiePanelController diePanelController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnRoll.setOnAction((event) -> {
            diePanelController.roll();
        });
    }    
    
}
