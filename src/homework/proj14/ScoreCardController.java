package homework.proj14;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 5.3.2017
 * @dueDate 5.4.2017
 * @description Kismet
 */
public class ScoreCardController implements Initializable {

    // javafx injected instance variables
    @FXML
    private TableView<ScoreOption> tblScoreCard;
    @FXML
    private TableColumn<ScoreOption, Integer> colIndex;
    @FXML
    private TableColumn<ScoreOption, String> colOption;
    @FXML
    private TableColumn<ScoreOption, String> colHowToScore;
    @FXML
    private TableColumn<ScoreOption, Integer> colScore;

    // instance variables
    private final ScoreCard scoreCard;
    
    // constructor
    public ScoreCardController() {
        this.scoreCard = new ScoreCard();
    } // end constructor
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.colIndex.setCellValueFactory((CellDataFeatures<ScoreOption, Integer> cdf) -> {
            ScoreOption so = cdf.getValue();
            if (so.getId() > 15){
                return new ReadOnlyObjectWrapper();
            }
            // so only 1 - 15 show on score card
            return new ReadOnlyObjectWrapper(so.getId());
        });
        this.colOption.setCellValueFactory(new PropertyValueFactory("name"));
        this.colHowToScore.setCellValueFactory(new PropertyValueFactory("howToScore"));
        this.colScore.setCellValueFactory(new PropertyValueFactory("score"));
        
        this.tblScoreCard.setItems(this.scoreCard.getScoreOptionsList());
    } // end initialize
    
    public void setupScoreColCellFactory(GameBoardController gameBoardController){
        this.colScore.setCellFactory((tableColumn) -> {
            
            TableCell<ScoreOption, Integer> cell = new TableCell<ScoreOption, Integer>(){
                @Override
                protected void updateItem(Integer score, boolean empty) {
                    super.updateItem(score, empty);
                    if (score != null || !empty){
                        ScoreOption so = (ScoreOption) this.getTableRow().getItem();
                        if (so.isPicked()){
                            this.setText(String.valueOf(score));
                        } // end if
                    } // end if
                } // end updateItem
            };
            
            cell.setOnMouseClicked((event) -> {
                ScoreOption so = (ScoreOption) cell.getTableRow().getItem();
                if (so != null && !so.isPicked() && !gameBoardController.isTurnScored()){
                    int[] dieValues = gameBoardController.getCurrentDieValues();
                    so.setPicked(true);
                    gameBoardController.setTurnScored(true);
                    switch(so.getId()){
                        case 1:
                            so.setScore(ScoringLogic.getScoreForAces(dieValues));
                            break;
                        case 2:
                            so.setScore(ScoringLogic.getScoreForDueces(dieValues));
                            break;
                        case 3:
                            so.setScore(ScoringLogic.getScoreForTreys(dieValues));
                            break;
                        case 4:
                            so.setScore(ScoringLogic.getScoreForFours(dieValues));
                            break;
                        case 5:
                            so.setScore(ScoringLogic.getScoreForFives(dieValues));
                            break;
                        case 6:
                            so.setScore(ScoringLogic.getScoreForSixes(dieValues));
                            break;
                        case 7:
                            so.setScore(ScoringLogic.getScoreTwoPairSameColor(dieValues));
                            break;
                        case 8:
                            so.setScore(ScoringLogic.getScoreThreeOfAKind(dieValues));
                            break;
                        case 9:
                            so.setScore(ScoringLogic.getScoreStraight(dieValues));
                            break;
                        case 10:
                            so.setScore(ScoringLogic.getScoreFlush(dieValues));
                            break;
                        case 11:
                            so.setScore(ScoringLogic.getScoreFullHouse(dieValues));
                            break;
                        case 12:
                            so.setScore(ScoringLogic.getScoreFullHouseSameColor(dieValues));
                            break;
                        case 13:
                            so.setScore(ScoringLogic.getScoreFourOfAKind(dieValues));
                            break;
                        case 14:
                            so.setScore(ScoringLogic.getScoreYarborough(dieValues));
                            break;
                        case 15:
                            so.setScore(ScoringLogic.getScoreKismet(dieValues));
                            break;
                    } // end switch
                    cell.setStyle("-fx-text-fill: -fx-text-background-color;");
                    this.updateTotals();
                } // end if
            });
            
            cell.hoverProperty().addListener((observable) -> {    
                ScoreOption so = (ScoreOption) cell.getTableRow().getItem();
                if(so != null && !gameBoardController.isTurnScored()){
                    int[] dieValues = gameBoardController.getCurrentDieValues();
                    if (cell.isHover() && !so.isPicked()){
                        switch(so.getId()){
                            case 1:
                                cell.setText(String.valueOf(ScoringLogic.getScoreForAces(dieValues)));
                                break;
                            case 2:
                                cell.setText(String.valueOf(ScoringLogic.getScoreForDueces(dieValues)));
                                break;
                            case 3:
                                cell.setText(String.valueOf(ScoringLogic.getScoreForTreys(dieValues)));
                                break;
                            case 4:
                                cell.setText(String.valueOf(ScoringLogic.getScoreForFours(dieValues)));
                                break;
                            case 5:
                                cell.setText(String.valueOf(ScoringLogic.getScoreForFives(dieValues)));
                                break;
                            case 6:
                                cell.setText(String.valueOf(ScoringLogic.getScoreForSixes(dieValues)));
                                break;
                            case 7:
                                cell.setText(String.valueOf(ScoringLogic.getScoreTwoPairSameColor(dieValues)));
                                break;
                            case 8:
                                cell.setText(String.valueOf(ScoringLogic.getScoreThreeOfAKind(dieValues)));
                                break;
                            case 9:
                                cell.setText(String.valueOf(ScoringLogic.getScoreStraight(dieValues)));
                                break;
                            case 10:
                                cell.setText(String.valueOf(ScoringLogic.getScoreFlush(dieValues)));
                                break;
                            case 11:
                                cell.setText(String.valueOf(ScoringLogic.getScoreFullHouse(dieValues)));
                                break;
                            case 12:
                                cell.setText(String.valueOf(ScoringLogic.getScoreFullHouseSameColor(dieValues)));
                                break;
                            case 13:
                                cell.setText(String.valueOf(ScoringLogic.getScoreFourOfAKind(dieValues)));
                                break;
                            case 14:
                                cell.setText(String.valueOf(ScoringLogic.getScoreYarborough(dieValues)));
                                break;
                            case 15:
                                cell.setText(String.valueOf(ScoringLogic.getScoreKismet(dieValues)));
                                break;
                        } // end switch
                        cell.setStyle("-fx-text-fill: #ff0000;");
                    } else { // end if
                        if (!so.isPicked()){
                            cell.setText("");
                        } // end fi
                        cell.setStyle("-fx-text-fill: -fx-text-background-color;");
                    } // end else
                } // end if
            });
            return cell;
        });
    } // end setupScoreColCellFactory

    private void updateTotals() {
        // basic section totals
        ScoreOption total = this.scoreCard.getScoreOptionById(16);
        int totalScore = this.scoreCard.getScoreOptionsList().stream().filter((so) -> {
            return so.getId() >= 1 && so.getId() <= 6;
        }).mapToInt((value) -> { return value.getScore(); }).sum();
        total.setScore(totalScore);
        
        ScoreOption basicSectionBonus = this.scoreCard.getScoreOptionById(17);
        int bonus = ScoringLogic.getBasicScoreBonus(totalScore);
        basicSectionBonus.setScore(bonus);
        
        ScoreOption basicSectionTotal1 = this.scoreCard.getScoreOptionById(18);
        basicSectionTotal1.setScore(totalScore + bonus);
        
        // kismet section totals
        ScoreOption kismetSectionTotal = this.scoreCard.getScoreOptionById(19);
        int kismetScore = this.scoreCard.getScoreOptionsList().stream().filter((so) -> {
            return so.getId() >= 7 && so.getId() <= 15;
        }).mapToInt((value) -> { return value.getScore(); }).sum();
        kismetSectionTotal.setScore(kismetScore);
        
        ScoreOption basicSectionTotal2 = this.scoreCard.getScoreOptionById(20);
        basicSectionTotal2.setScore(totalScore + bonus);
        
        ScoreOption finalTotal = this.scoreCard.getScoreOptionById(21);
        finalTotal.setScore(totalScore + bonus + kismetScore);
    } // end updateTotals
    
} // end class
