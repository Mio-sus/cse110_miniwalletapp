import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import  javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage)throws Exception{ //Exception = unreported exception java.io.IOException; must be caught or declared to be thrown

        FXMLLoader loader = new FXMLLoader(getClass().getResource("the.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 600, 400); // dashboard object was removed to use fxml
                                                        // root= the container that holds everything you see on the screen.

        stage.setScene(scene); //This line attaches your UI (Scene) to the window (Stage).

        stage.show();
    }



}


