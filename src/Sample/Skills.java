/**
 * Sample Skeleton for 'skills.fxml' Controller Class
 */

package Sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Skills {



    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="levelText"
    private Text levelText; // Value injected by FXMLLoader

    @FXML
    private Button backButton;

    @FXML // fx:id="infoButton"
    private Button infoButton; // Value injected by FXMLLoader

    @FXML // fx:id="quston"
    private Text quston; // Value injected by FXMLLoader

    @FXML // fx:id="smileImg"
    private ImageView smileImg; // Value injected by FXMLLoader

    @FXML // fx:id="vocabularyButton"
    private Button vocabularyButton; // Value injected by FXMLLoader

    @FXML // fx:id="dialoguesButton"
    private Button dialoguesButton; // Value injected by FXMLLoader

    @FXML // fx:id="grammarButton"
    private Button grammarButton; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert levelText != null : "fx:id=\"levelText\" was not injected: check your FXML file 'skills.fxml'.";
        assert infoButton != null : "fx:id=\"infoButton\" was not injected: check your FXML file 'skills.fxml'.";
        assert quston != null : "fx:id=\"quston\" was not injected: check your FXML file 'skills.fxml'.";
        assert smileImg != null : "fx:id=\"smileImg\" was not injected: check your FXML file 'skills.fxml'.";
        assert vocabularyButton != null : "fx:id=\"vocabularyButton\" was not injected: check your FXML file 'skills.fxml'.";
        assert dialoguesButton != null : "fx:id=\"dialoguesButton\" was not injected: check your FXML file 'skills.fxml'.";
        assert grammarButton != null : "fx:id=\"grammarButton\" was not injected: check your FXML file 'skills.fxml'.";

        vocabularyButton.setOnAction(event -> {

            Stage stage = (Stage) infoButton.getScene().getWindow(); //close old window (starter window)
            // do what you have to do
            stage.close();

            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("../fxmlFiles/activity.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage = new Stage();
            stage.setTitle("Hello World");
            stage.setScene(new Scene(root, 960, 690));
            stage.setResizable(false);
            stage.show();


        });

        backButton.setOnAction(event -> {

            Stage stage = (Stage) infoButton.getScene().getWindow(); //close old window (starter window)
            // do what you have to do
            stage.close();

            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("../fxmlFiles/subject.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage = new Stage();
            stage.setTitle("Hello World");
            stage.setScene(new Scene(root, 960, 690));
            stage.setResizable(false);
            stage.show();
        });

        dialoguesButton.setOnAction(event -> {

            Stage stage = (Stage) infoButton.getScene().getWindow(); //close old window (starter window)
            // do what you have to do
            stage.close();

            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("../fxmlFiles/activityDialogues.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage = new Stage();
            stage.setTitle("Hello World");
            stage.setScene(new Scene(root, 960, 690));
            stage.setResizable(false);
            stage.show();
        });

    }


}

