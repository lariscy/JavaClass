package homework.proj13;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 4.21.2017
 * @dueDate 4.27.2017
 * @description Bank Program
 */
public class BankDriver extends Application {
    
    private Stage primaryStage;
    
    public static void main(String[] args) {
        Application.launch(args);
    } // end main

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        
        BorderPane root = new BorderPane();
        
        Scene scene = new Scene(root, 300, 300);
        
        primaryStage.setTitle("Bank Program");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void showWelcomeScreen(){
        
    }
    
} // end class
