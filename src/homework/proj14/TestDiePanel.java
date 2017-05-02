package homework.proj14;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author Steven
 */
public class TestDiePanel extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox diePanel = FXMLLoader.load(this.getClass().getResource("DiePanel.fxml"));
        
        primaryStage.setScene(new Scene(diePanel));
        primaryStage.show();
    }

}
