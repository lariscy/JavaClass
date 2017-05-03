package homework.proj14;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 5.3.2017
 * @dueDate 5.4.2017
 * @description Kismet
 */
public class GameDriver extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    } // end main
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(this.getClass().getResource("GameBoard.fxml"));
        primaryStage.setTitle("Kismet");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    } // end start
    
} // end class
