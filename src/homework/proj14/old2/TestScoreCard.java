package homework.proj14.old2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Steven
 */
public class TestScoreCard extends Application {
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane diePanel = FXMLLoader.load(this.getClass().getResource("ScoreCardPanel.fxml"));
        
        primaryStage.setScene(new Scene(diePanel));
        primaryStage.show();
    }

}
