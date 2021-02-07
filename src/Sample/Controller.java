/**
 * Sample Skeleton for 'activity.fxml' Controller Class
 */

package Sample;

import java.io.*;
import java.net.URL;
import java.util.*;


import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller {


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

    @FXML // fx:id="answerRadio1"
    private RadioButton answerRadio1; // Value injected by FXMLLoader

    @FXML // fx:id="answers"
    private ToggleGroup answers; // Value injected by FXMLLoader

    @FXML // fx:id="quston"
    private Text questionText; // Value injected by FXMLLoader

    @FXML // fx:id="answerRadio2"
    private RadioButton answerRadio2; // Value injected by FXMLLoader

    @FXML // fx:id="answerRadio3"
    private RadioButton answerRadio3; // Value injected by FXMLLoader

    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    @FXML // fx:id="inputText"
    private TextArea inputText; // Value injected by FXMLLoader

    @FXML // fx:id="smileImg"
    private ImageView smileImg; // Value injected by FXMLLoader

    @FXML // fx:id="scoreLabel"
    private Text scoreLabel; // Value injected by FXMLLoader

    private int nowQuestion = 0; //we increment this after each question (after pushing OK)
    private  int correctAnswers=0;
    private int level=0; //1

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() throws IOException {


        level0.setOnAction(event -> {
            levelText.setText("Уровень 0");
            level=0; //0
           // nowLevelListDe=de0;
            reSet(level);
        });
        level1.setOnAction(event -> {
            levelText.setText("Уровень 1");
            level=1; //1
           // nowLevelListDe=de1;
            reSet(level);
        });
        level2.setOnAction(event -> {
            levelText.setText("Уровень 2");
            level=2; //2
            //nowLevelListDe=de2;
            reSet(level);
        });
        level3.setOnAction(event -> {
            levelText.setText("Уровень 3");
            level=3; //2
            //nowLevelListDe=de3;
            reSet(level);
        });
        level4.setOnAction(event -> {
            levelText.setText("Уровень 4");
            level=4; //4
           // nowLevelListDe=de4;
            reSet(level);
        })   ;
        level5.setOnAction(event -> {
            levelText.setText("Уровень 5");
            level=5; //5
           // nowLevelListDe=de5;
            reSet(level);
        });
        level6.setOnAction(event -> {
            levelText.setText("Уровень 6");
            level=6; //6
           // nowLevelListDe=de6;
            reSet(level);
        });
        level7.setOnAction(event -> {
            levelText.setText("Уровень 7");
            level=7; //7
           // nowLevelListDe=de7;
            reSet(level);
        });
        level8.setOnAction(event -> {
            levelText.setText("Уровень 8");
            level=8; //8
           // nowLevelListDe=de8;
            reSet(level);
        });


        okButton.setOnAction(event -> {
            //нажали на кнопку

            RadioButton selectedRadio = (RadioButton) answers.getSelectedToggle();
            if (selectedRadio != null) {
                String toggleGetValue = selectedRadio.getText();

              //  if (toggleGetValue.equals(de1.get(questions[level][nowQuestion].getKey()))) { //questions[level][nowQuestion].correctAnswer()
                if(toggleGetValue.equals(QuestMaker.questions.get(level).get(nowQuestion).getKey())){
                    System.out.println("! "+QuestMaker.questions.get(level).get(nowQuestion).getKey());
                    System.out.println("Good!");
                    correctAnswers++;
                    scoreLabel.setText(""+correctAnswers);
                } else {
                    System.out.println("Bad");
                }
            }
            //if now question is not the last
            if (nowQuestion + 1 != QuestMaker.questions.get(level).size()) {
                nowQuestion++;
                questionText.setText(QuestMaker.questions.get(level).get(nowQuestion).getQuestion());
                String[] answers =QuestMaker.questions.get(level).get(nowQuestion).getAnswers();

                List<String> stringList = Arrays.asList(answers);
                Collections.shuffle(stringList);

                answerRadio1.setText(stringList.get(0));
                answerRadio2.setText(stringList.get(1));
                answerRadio3.setText(stringList.get(2));

                selectedRadio.setSelected(false);

            } else {  //if now question is the last

                answerRadio1.setVisible(false);
                answerRadio2.setVisible(false);
                answerRadio3.setVisible(false);

                okButton.setVisible(false);


                questionText.setText("Правильных ответов: " + correctAnswers+" из "+QuestMaker.questions.get(level).size());

            }
        });

        infoButton.setOnAction(event -> {

            Stage stage = (Stage) infoButton.getScene().getWindow(); //close old window (starter window)
            // do what you have to do
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxmlFiles/info.fxml"));
            Parent root1 = null;
            try {
                root1 = (Parent) fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

             stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("ABC");
            stage.setScene(new Scene(root1, 960, 690));
            stage.show();
        });

        backButton.setOnAction(event -> {

            Stage stage = (Stage) infoButton.getScene().getWindow(); //close old window (starter window)
            // do what you have to do
            stage.close();

            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("../fxmlFiles/skills.fxml"));
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

    private void reSet(int level){
        nowQuestion=0;
        correctAnswers=0;
        scoreLabel.setText("0");

        answerRadio1.setVisible(true);
        answerRadio2.setVisible(true);
        answerRadio3.setVisible(true);
        okButton.setVisible(true);
        questionText.setText(QuestMaker.questions.get(level).get(nowQuestion).getQuestion());

        String[] answers =QuestMaker.questions.get(level).get(nowQuestion).getAnswers();
        List<String> stringList = Arrays.asList(answers);
        Collections.shuffle(stringList);

        answerRadio1.setText(stringList.get(0));
        answerRadio2.setText(stringList.get(1));
        answerRadio3.setText(stringList.get(2));
    }
}
