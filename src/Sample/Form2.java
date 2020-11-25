/**
 * Sample Skeleton for 'form2.fxml' Controller Class
 */

package Sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Form2 {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="startButton"
    private Button startButton; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert startButton != null : "fx:id=\"startButton\" was not injected: check your FXML file 'form2.fxml'.";


        startButton.setOnAction(event -> {
            Stage stage = (Stage) startButton.getScene().getWindow();
            stage.close();
        });


    }
}
