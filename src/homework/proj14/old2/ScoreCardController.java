package homework.proj14.old2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Steven
 */
public class ScoreCardController implements Initializable {

    @FXML
    private TableView<ScoreOption> tblBasicSection;
    @FXML
    private TableColumn<ScoreOption, String> colName;
    @FXML
    private TableColumn<ScoreOption, String> colHowToScore;
    @FXML
    private TableColumn<ScoreOption, Node> colScore;
    
    private ObservableList<ScoreOption> tableData;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // @TODO remove - added for testing
        tableData = FXCollections.observableArrayList(
                new ScoreOption("ACES", "For each Ace"),
                new ScoreOption("DUECES", "For each Duece"),
                new ScoreOption("TREYS", "For each Trey"),
                new ScoreOption("FOURS", "For each Four"),
                new ScoreOption("FIVES", "For each Five"),
                new ScoreOption("SIXES", "For each Six")
        );
        
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colHowToScore.setCellValueFactory(new PropertyValueFactory<>("howToScore"));
        colScore.setCellValueFactory(new PropertyValueFactory<>("btnScore"));
        
        tblBasicSection.setItems(tableData);
    }    
    
}
