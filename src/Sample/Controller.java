/**
 * Sample Skeleton for 'sample.fxml' Controller Class
 */

package Sample;

import java.io.*;
import java.net.URL;
import java.util.*;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLPortType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
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

    @FXML // fx:id="infoButton"
    private Button infoButton; // Value injected by FXMLLoader

    @FXML // fx:id="level1"
    private Button level1; // Value injected by FXMLLoader

    @FXML // fx:id="level2"
    private Button level2; // Value injected by FXMLLoader

    @FXML // fx:id="level0"
    private Button level0; // Value injected by FXMLLoader

    @FXML // fx:id="answerRadio1"
    private RadioButton answerRadio1; // Value injected by FXMLLoader

    @FXML // fx:id="answers"
    private ToggleGroup answers; // Value injected by FXMLLoader

    @FXML // fx:id="quston"
    private Text quston; // Value injected by FXMLLoader

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

    @FXML // fx:id="level3"
    private Button level3; // Value injected by FXMLLoader


    @FXML // fx:id="level4"
    private Button level4; // Value injected by FXMLLoader

    @FXML // fx:id="level5"
    private Button level5; // Value injected by FXMLLoader



    private ArrayList<String> ru0=new ArrayList<>();
    private ArrayList<String> de0=new ArrayList<>();
    private ArrayList<String> ru1=new ArrayList<>();
    private ArrayList<String> de1=new ArrayList<>();
    private ArrayList<String> ru2=new ArrayList<>();
    private ArrayList<String> de2=new ArrayList<>();
    private ArrayList<String> ru3=new ArrayList<>();
    private ArrayList<String> de3=new ArrayList<>();
    private ArrayList<String> ru4=new ArrayList<>();
    private ArrayList<String> de4=new ArrayList<>();
    private ArrayList<String> ru5=new ArrayList<>();
    private ArrayList<String> de5=new ArrayList<>();
    private ArrayList<String> nowLevelListDe=new ArrayList<>();


    private int nowQuestion = 0;
    private  int correctAnswers=0;
    private int level=0; //1

    private void fileWorker(ArrayList<String> listWordsRu,ArrayList<String> listWordsDe,int level) throws IOException {
        File file = new File("C:\\Users\\1\\IdeaProjects\\gameJavaFX1\\src\\txtFiles\\"+level+"ru.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String line=reader.readLine();
        while (line!= null) {
           listWordsRu.add(line); // ru0 ru1
            line=reader.readLine();
        }

        File file2 = new File("C:\\Users\\1\\IdeaProjects\\gameJavaFX1\\src\\txtFiles\\"+level+"de.txt");
        FileReader fr2 = new FileReader(file2);
        BufferedReader reader2 = new BufferedReader(fr2);
        String line2=reader2.readLine();
        while (line2!= null) {
            listWordsDe.add(line2); //de0 de1
            line2=reader2.readLine();
        }
    }


    private ArrayList<ArrayList<Questions>> questions=new ArrayList<ArrayList<Questions>>(){};
//Questions q=new Questions("Твое имя?", new String[]{"Аня", "Иван", "Ева"},0);

    private void questionsGenerator(ArrayList<String> arrayRu,ArrayList<String> arrayDe,int level){
        questions.add(level,new ArrayList<Questions>(){});
            for(int j=0;j<arrayRu.size();j++){
                int firstRandomIndex=getRandomFromList(arrayDe,j);
                int secondRandomIndex=getRandomFromList(arrayDe,j,firstRandomIndex);

                questions.get(level).add(j,new Questions(arrayRu.get(j),new String[]{arrayDe.get(j), arrayDe.get(firstRandomIndex),arrayDe.get(secondRandomIndex)},j));
                //questions[i][j]=new Questions(ru1.get(j),new String[]{de1.get(j), de1.get(firstRandomIndex),de1.get(secondRandomIndex)},j);
            }
    }


    private int getRandomFromList(ArrayList<String> arrayDe,int...v){
        Random rand = new Random();
        ArrayList<Integer> givenList = new ArrayList<>();
        for(int i=0; i<arrayDe.size();i++){
            givenList.add(i);
        }
        System.out.println("givenList "+givenList.size());


        if(v.length==1){
            givenList.remove(v[0]);
        }
        if(v.length==2){
            if(v[0]>v[1]) {givenList.remove(v[0]);
            givenList.remove(v[1]);}
            else {givenList.remove(v[1]);givenList.remove(v[0]);}
        }
        System.out.println("givenList2 "+givenList.size());

        int temp = rand.nextInt(givenList.size());
        int randomIndex = givenList.get(temp);


        System.out.println("randomIndex "+randomIndex);
        return randomIndex;
    }

   /* public static int rnd(int min, int max) //от мин до макс включая макс
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }*/



    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() throws IOException {

       fileWorker(ru0,de0,0);
       fileWorker(ru1,de1,1);
       fileWorker(ru2,de2,2);
        fileWorker(ru3,de3,3);
        fileWorker(ru4,de4,4);
        fileWorker(ru5,de5,5);

       questionsGenerator(ru0,de0,0);
       questionsGenerator(ru1,de1,1);
       questionsGenerator(ru2,de2,2);
        questionsGenerator(ru3,de3,3);
        questionsGenerator(ru4,de4,4);
        questionsGenerator(ru5,de5,5);

        level0.setOnAction(event -> {
            levelText.setText("Уровень 0");
            level=0; //0
            nowLevelListDe=de0;
            reSet(level);
        });
        level1.setOnAction(event -> {
            levelText.setText("Уровень 1");
            level=1; //1
            nowLevelListDe=de1;
            reSet(level);
        });
        level2.setOnAction(event -> {
            levelText.setText("Уровень 2");
            level=2; //2
            nowLevelListDe=de2;
            reSet(level);
        });
        level3.setOnAction(event -> {
            levelText.setText("Уровень 3");
            level=3; //2
            nowLevelListDe=de3;
            reSet(level);
        });
        level4.setOnAction(event -> {
            levelText.setText("Уровень 4");
            level=4; //4
            nowLevelListDe=de4;
            reSet(level);
        });
        level5.setOnAction(event -> {
            levelText.setText("Уровень 5");
            level=5; //5
            nowLevelListDe=de5;
            reSet(level);
        });


        okButton.setOnAction(event -> {
            //нажали на кнопку

            RadioButton selectedRadio = (RadioButton) answers.getSelectedToggle();
            if (selectedRadio != null) {
                String toggleGetValue = selectedRadio.getText();

              //  if (toggleGetValue.equals(de1.get(questions[level][nowQuestion].getKey()))) { //questions[level][nowQuestion].correctAnswer()
                if(toggleGetValue.equals(nowLevelListDe.get(questions.get(level).get(nowQuestion).getKey()))){
                    System.out.println("! "+nowLevelListDe.get(questions.get(level).get(nowQuestion).getKey()));
                    System.out.println("Good!");
                    correctAnswers++;
                    scoreLabel.setText(""+correctAnswers);
                } else {
                    System.out.println("Bad");
                }
            }
            if (nowQuestion + 1 != questions.get(level).size()) {
                nowQuestion++;
                quston.setText(questions.get(level).get(nowQuestion).getQuestion());
                String[] answers =questions.get(level).get(nowQuestion).getAnswers();

                List<String> stringList = Arrays.asList(answers);
                Collections.shuffle(stringList);

                answerRadio1.setText(stringList.get(0));
                answerRadio2.setText(stringList.get(1));
                answerRadio3.setText(stringList.get(2));

                selectedRadio.setSelected(false);

            } else {

                answerRadio1.setVisible(false);
                answerRadio2.setVisible(false);
                answerRadio3.setVisible(false);

                okButton.setVisible(false);


                quston.setText("Правильных ответов: " + correctAnswers+" из "+nowLevelListDe.size());

            }
        });

        infoButton.setOnAction(event -> {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("form2.fxml"));
            Parent root1 = null;
            try {
                root1 = (Parent) fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("ABC");
            stage.setScene(new Scene(root1));
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


       // RadioButton selectedRadio = (RadioButton) answers.getSelectedToggle();
       // selectedRadio.setSelected(false);

        quston.setText(questions.get(level).get(nowQuestion).getQuestion());

        String[] answers =questions.get(level).get(nowQuestion).getAnswers();

        List<String> stringList = Arrays.asList(answers);
        Collections.shuffle(stringList);

        answerRadio1.setText(stringList.get(0));
        answerRadio2.setText(stringList.get(1));
        answerRadio3.setText(stringList.get(2));
    }
}
