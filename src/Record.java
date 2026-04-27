import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;

public class Record {

    @FXML
    private TextField amountField;

    private Dashboard dashboardController;

    public void setDashboardController(Dashboard controller) {
        this.dashboardController = controller;
    }

    @FXML
    private ComboBox<String> categoryBox;

    @FXML
    public void initialize() {
        System.out.println(categoryBox); // DEBUG
    }

    @FXML
    private void handleAddRecord2() {
        String input = amountField.getText();

        if (input == null || input.trim().isEmpty()) {
            System.out.println("Please enter a number");
            return;
        }

        try {
            double amount = Double.parseDouble(input.trim());
            System.out.println("Entered Amount: " + amount);

            if (dashboardController != null) {
                dashboardController.deductBalance(amount);
            }

            Stage stage = (Stage) amountField.getScene().getWindow();
            stage.close();

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format!");
        }
    }
}

/*
 * Required flow
 * User enters amount in popup
 * Popup reads the value
 * Popup sends value → main controller
 * Main controller updates balance
 */