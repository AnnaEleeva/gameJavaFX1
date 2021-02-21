/**
 * Sample Skeleton for 'activityDialogues.fxml' Controller Class
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
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ActivityDialogues {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="infoButton"
    private Button infoButton; // Value injected by FXMLLoader

    @FXML // fx:id="levelText"
    private Text levelText; // Value injected by FXMLLoader

    @FXML // fx:id="backButton"
    private Button backButton; // Value injected by FXMLLoader

    @FXML // fx:id="level1"
    private Button level1; // Value injected by FXMLLoader

    @FXML // fx:id="level2"
    private Button level2; // Value injected by FXMLLoader

    @FXML // fx:id="level0"
    private Button level0; // Value injected by FXMLLoader

    @FXML // fx:id="level3"
    private Button level3; // Value injected by FXMLLoader

    @FXML // fx:id="level4"
    private Button level4; // Value injected by FXMLLoader

    @FXML // fx:id="level5"
    private Button level5; // Value injected by FXMLLoader

    @FXML // fx:id="level6"
    private Button level6; // Value injected by FXMLLoader

    @FXML // fx:id="level7"
    private Button level7; // Value injected by FXMLLoader

    @FXML // fx:id="level8"
    private Button level8; // Value injected by FXMLLoader

    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    @FXML
    private Text speaker1Text;

    @FXML
    private Text questionText11; //(A)

    @FXML
    private RadioButton radioButton1;

    @FXML
    private RadioButton radioButton2;

    @FXML
    private Text titleText;

    private int nowQuestion = 0; //we increment this after each question (after pushing OK)
    private  int correctAnswers=0;
    private int level=0; //1

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {



        level0.setOnAction(event -> {
            levelText.setText("Уровень 0");
            level=0; //0
            // nowLevelListDe=de0;
        });
        level1.setOnAction(event -> {
            levelText.setText("Уровень 1");
            level=1; //1
            // nowLevelListDe=de1;
        });
        level2.setOnAction(event -> {
            levelText.setText("Уровень 2");
            level=2; //2
            //nowLevelListDe=de2;
        });
        level3.setOnAction(event -> {
            levelText.setText("Уровень 3");
            level=3; //2
            //nowLevelListDe=de3;
        });
        level4.setOnAction(event -> {
            levelText.setText("Уровень 4");
            level=4; //4
            // nowLevelListDe=de4;
        })   ;
        level5.setOnAction(event -> {
            levelText.setText("Уровень 5");
            level=5; //5
            // nowLevelListDe=de5;
        });
        level6.setOnAction(event -> {
            levelText.setText("Уровень 6");
            level=6; //6
            // nowLevelListDe=de6;
        });
        level7.setOnAction(event -> {
            levelText.setText("Уровень 7");
            level=7; //7
            // nowLevelListDe=de7;
        });
        level8.setOnAction(event -> {
            levelText.setText("Уровень 8");
            level=8; //8
            // nowLevelListDe=de8;
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

    }
}
