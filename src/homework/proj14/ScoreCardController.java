package homework.proj14;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ScoreCardController implements Initializable {

    @FXML
    private TableView<ScoreOption> tblScoreCard;
    @FXML
    private TableColumn<ScoreOption, Integer> colIndex;
    @FXML
    private TableColumn<ScoreOption, String> colOption;
    @FXML
    private TableColumn<ScoreOption, String> colHowToScore;
    @FXML
    private TableColumn<ScoreOption, ScoreOption> colScore;

    private final ScoreCard scoreCard;
    private final ObservableList<ScoreOption> tableData;
    
    public ScoreCardController() {
        this.scoreCard = new ScoreCard();
        this.tableData = this.scoreCard.getScoreOptionsList();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.colIndex.setCellValueFactory(new PropertyValueFactory("id"));
        this.colOption.setCellValueFactory(new PropertyValueFactory("name"));
        this.colHowToScore.setCellValueFactory(new PropertyValueFactory("howToScore"));
        this.colScore.setCellValueFactory(new PropertyValueFactory("picked"));
        this.colScore.setCellValueFactory((param) -> {
            return new ReadOnlyObjectWrapper(param.getValue());
        });
//        this.tableData.get(0).setPicked(true);
//        this.tableData.get(0).setScore(40);
        
        this.tblScoreCard.setItems(this.tableData);
    }
    
    public void setupScoreColCellFactory(GameBoardController gameBoardController){
//        this.colScore.setCellValueFactory((param) -> {
//            ScoreOption scoreOption = param.getValue();
//            if (!scoreOption.isPicked()){
//                Button btnScore = new Button("Score");
//                btnScore.setOnAction((event) -> {
//                    System.out.println("clicked");
//                    scoreOption.setPicked(true);
//                    switch(scoreOption.getId()){
//                        case 1:
//                            System.out.println("made it");
//                            scoreOption.setScore(
//                                    ScoringLogic.getScoreForAces(gameBoardController.getCurrentDieValues()));
//                            System.out.println("picked: "+scoreOption.isPicked());
//                            System.out.println("score: "+scoreOption.getScore());
//                            break;
//                    }
//                });
//                return new ReadOnlyObjectWrapper(btnScore);
//            } else {
//                return new ReadOnlyObjectWrapper(scoreOption.getScore());
//            }
//        });
        
        this.colScore.setCellFactory((tableColumn) -> {
            return new TableCell<ScoreOption, ScoreOption>(){
                @Override
                protected void updateItem(ScoreOption scoreOption, boolean empty) {
                    super.updateItem(scoreOption, empty);
                    System.out.println("updateItem called");
                    
                    if (scoreOption == null || empty) {
                        this.setText(null);
                    } else {
                        
                        // @TODO - example of hover listener on cell
                        this.hoverProperty().addListener((observable) -> {
                            if (this.isHover()){
                                System.out.println("hovering cell: "+scoreOption.getName());
                            }
                        });
                        
                        
                        if (scoreOption.isPicked()){
                            this.setText(String.valueOf(scoreOption.getScore()));
                            this.setGraphic(null);
                        } else {
                            this.setText("");
                            Button btnScore = new Button("Score");
                            btnScore.setOnAction((event) -> {
                                System.out.println("clicked");
                                scoreOption.setPicked(true);
                            });
                            this.setGraphic(btnScore);
                        }
                    }
                }
                
            };
        });
    }
    
}
