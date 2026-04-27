import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class Dashboard {  //extends VBox {

   /* public Dashboard(){   //constructor. when a Dashboard object is created run this code.
        Label label = new Label("Welcome to Dashboard");
        this.getChildren().add(label); //this=Vbox,getChildern()=list of items it contains,.add(label)=dds your Label into that list.>>“Add this label into the VBox so it becomes part of the UI”
    }*/ //out of use cause now im using fxml

    //public Button button; // without this button.setText() wont work.

    @FXML
    private Label balanceLabel; // to declare the balancelabel

    private double balance = 100000; // starting balance




    @FXML
    public void initialize() {
                                                                    // This runs automatically and sets the label's text to "1000.0"
        balanceLabel.setText(String.valueOf(balance));
    }

    @FXML
    private Button button; // used to link with fxml and the id in fxml
    @FXML
    private Button button2;

    @FXML
    private void handleClick(ActionEvent event) {
        System.out.println("Stay in  Dashboard"); //though it’s private, JavaFX can still call it because of @FXML.
        button.setText("anything");
    }

    @FXML
    private void handleClick2(ActionEvent event) {
        System.out.println("go to Record"); //though it’s private, JavaFX can still call it because of @FXML.
        button2.setText("anything2");
    }

    public void deductBalance(double amount) {
        balance -= amount;
        balanceLabel.setText(String.valueOf(balance)); //update the dashboard
        System.out.println("New Balance: " + balance);
    }



    @FXML
    private void handleAddRecord() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("add_record.fxml"));
            Parent root = loader.load();

            Record controller = loader.getController();
            controller.setDashboardController(this); // VERY IMPORTANT

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
