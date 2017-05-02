package homework.proj14.old2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Steven
 */
public class TestGameBoard extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox diePanel = FXMLLoader.load(this.getClass().getResource("GameBoard.fxml"));
        
        primaryStage.setTitle("Kismet");
        primaryStage.setScene(new Scene(diePanel));
        primaryStage.show();
    }

}
