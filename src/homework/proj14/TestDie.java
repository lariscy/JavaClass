package homework.proj14;

import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author Steven Lariscy
 */
public class TestDie extends Application {
    
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane();
        
        Rectangle rec = new Rectangle(100, 100, Color.BLACK);
        rec.setArcWidth(20);
        rec.setArcHeight(20);
        
        addRandomPips(root);
        
        root.getChildren().add(rec);
        
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void addRandomPips(StackPane root) {
        int num = new Random().nextInt() + 1;
        
        switch(num){
            
        }
    }
    
}
