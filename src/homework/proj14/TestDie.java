package homework.proj14;

import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
        VBox root = new VBox();
        Pane stackPane = new Pane();
        
        Rectangle rec = new Rectangle(100, 100, Color.WHITE);
        rec.setStroke(Color.BLACK);
        rec.setArcWidth(20);
        rec.setArcHeight(20);
        
        stackPane.getChildren().add(rec);
        
        root.getChildren().add(stackPane);
        
        Button btnRoll = new Button("Roll");
        btnRoll.setOnAction((event) -> {
            addRandomPips(stackPane, rec);
        });
        root.getChildren().add(btnRoll);
        
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void addRandomPips(Pane pane, Rectangle rec) {
        pane.getChildren().removeIf((t) -> {
            return t instanceof Circle;
        });
        
        int num = new Random().nextInt(6) + 1;
        switch(num){
            case 1:
                pane.getChildren().add(new Circle(rec.getWidth() / 2, rec.getHeight() / 2, 10, Color.BLACK));
                break;
            case 3:
                pane.getChildren().add(new Circle(rec.getWidth() / 2, rec.getHeight() / 2, 10, Color.BLACK));
            case 2:
                pane.getChildren().add(new Circle(rec.getWidth() / 4, rec.getHeight() / 4, 10, Color.BLACK));
                pane.getChildren().add(new Circle(3 * rec.getWidth() / 4, 3 * rec.getHeight() / 4, 10, Color.BLACK));
                break;
            case 5:
                pane.getChildren().add(new Circle(rec.getWidth() / 2, rec.getHeight() / 2, 10, Color.BLACK));
            case 4:
                pane.getChildren().add(new Circle(rec.getWidth() / 4, rec.getHeight() / 4, 10, Color.BLACK));
                pane.getChildren().add(new Circle(3 * rec.getWidth() / 4, 3 * rec.getHeight() / 4, 10, Color.BLACK));
                pane.getChildren().add(new Circle(3 * rec.getWidth() / 4, rec.getHeight() / 4, 10, Color.BLACK));
                pane.getChildren().add(new Circle(rec.getWidth() / 4, 3 * rec.getHeight() / 4, 10, Color.BLACK));
                break;
            case 6:
                pane.getChildren().add(new Circle(rec.getWidth() / 4, rec.getHeight() / 4, 10, Color.BLACK));
                pane.getChildren().add(new Circle(3 * rec.getWidth() / 4, 3 * rec.getHeight() / 4, 10, Color.BLACK));
                pane.getChildren().add(new Circle(3 * rec.getWidth() / 4, rec.getHeight() / 4, 10, Color.BLACK));
                pane.getChildren().add(new Circle(rec.getWidth() / 4, 3 * rec.getHeight() / 4, 10, Color.BLACK));
                pane.getChildren().add(new Circle(rec.getWidth() / 4, rec.getHeight() / 2, 10, Color.BLACK));
                pane.getChildren().add(new Circle(3 * rec.getWidth() / 4, rec.getHeight() / 2, 10, Color.BLACK));
                break;
            default:
                System.err.println("what what");
        }
    }
    
}
