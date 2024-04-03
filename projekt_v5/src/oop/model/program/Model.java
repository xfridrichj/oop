package oop.model.program;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import oop.controller.*;
import oop.view.*;
import oop.model.program.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Model implements ModelInterface{
    public User user;

    public Model() {
    }

    public void userAuth(String username, String password, BeforeLoginScene beforeLoginScene, BeforeLoginController beforeLoginController, AlertBoxUniv alertBoxUniv) {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))){
            String line;
            boolean loggedIn = false;
            while ((line = reader.readLine()) != null){
                if (line.equals(username) && (line = reader.readLine()).equals(password)){
                    System.out.println("Pouzivatel prijaty");
                    loggedIn = true;
                    beforeLoginScene.getUsernameField().clear();
                    beforeLoginScene.getPasswordField().clear();
                    Stage afterLoginStage = new Stage();
                    new AfterLoginController(new AfterLoginScene(afterLoginStage, username), Main.model,beforeLoginController);
                }
            }
            if (!loggedIn){
                AlertBoxUniv.display("Zadané zlé prihlasovacie údaje");;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void logOff(){
        System.out.println("Pouzivatel bol prihlaseny");
    }
    public String behaviorChoiceBox(CreateSurveyScene createSurveyScene, CreativeSurveyController creativeSurveyController, Map<String, String> questionTextMap){
        String selectedQuestion = createSurveyScene.getChoiceBox().getValue();//toto iba kontroluje ci bolo nieco vybrate, blockuje buttony
        if (selectedQuestion != null) {//ak bolo nieco vybrate
            createSurveyScene.getAddButton().setDisable(false);
            createSurveyScene.getConfirmButton().setDisable(false);

            createSurveyScene.getQuestionField().setText(questionTextMap.getOrDefault(selectedQuestion, ""));
        }
        else {
            createSurveyScene.getAddButton().setDisable(true);
            createSurveyScene.getConfirmButton().setDisable(true);
        }
        return selectedQuestion;
    }

    public void initQuestionContentMap(CreateSurveyScene createSurveyScene) {//spracovava otazky a otazkove polia
        createSurveyScene.setQuestionContentMap(new HashMap<>());
        for (String question : createSurveyScene.getChoiceBox().getItems()) {
            VBox questionContent = new VBox(10);
            createSurveyScene.getQuestionContentMap().put(question, questionContent);
        }
    }
    /*public void showOptions(CreateSurveyScene createSurveyScene,String question) {
        VBox root = createSurveyScene.getRoot();
        root.getChildren().removeIf(node -> node instanceof VBox);
        VBox selectedQuestionContent = createSurveyScene.getQuestionContentMap().get(question);
        root.getChildren().add(selectedQuestionContent);
    }*/
    public int codeGenerator() {
        Random rand = new Random();
        return rand.nextInt(90000)+10000;//aby boli 5ciferne vzdy
    }
    public void writingFile(int code, BeforeLoginController beforeLoginController,CreateSurveyScene createSurveyScene, Map<String, String> questionTextMap){
        FileWriter writer = null;
        try {
            //vlastne formatovania vpisania do fileu
            writer = new FileWriter("data.txt", true);
            writer.write("*\n");
            writer.write("@" + beforeLoginController.getCurrentUsername() + "@\n");
            writer.write("#" + code + "\n");

            //reverse order
            for (int i = createSurveyScene.getQuestionContentMap().size() - 1; i >= 0; i--) {
                String question = (String) createSurveyScene.getQuestionContentMap().keySet().toArray()[i];
                VBox contentVBox = createSurveyScene.getQuestionContentMap().get(question);

                StringBuilder data = new StringBuilder();
                for (int j = 0; j < contentVBox.getChildren().size(); j += 2) {
                    Label label = (Label) contentVBox.getChildren().get(j);
                    TextField textField = (TextField) contentVBox.getChildren().get(j + 1);
                    data.append(textField.getText());
                    if (j < contentVBox.getChildren().size() - 1) {
                        data.append("\n+\n");
                    }
                }

                String questionText = questionTextMap.getOrDefault(question, "");
                if (!questionText.isEmpty()) {
                    writer.write("$\n"+questionText+"\n");
                }
                if (!data.isEmpty()) {
                    writer.write("%\n" + data + "%\n");
                }
            }
            writer.write("/\n\n");
            System.out.println("anketa ulozena");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close(); //close
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void codeFinder(int code, Stage primaryStage, Map<String, List<String>> questionsWithOptions, Map<String,
            String> optionsToQuestions, VotePopController votePopController){

        String filePath = "data.txt";
        String formatCode = "#" + code;
        boolean foundCode = false;
        boolean readingFile = false;

        String endSur = "/";
        String startQuestion = "$";
        String startOptions = "%";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            String currentQuestion;
            List<String> currentOptions;

            while ((line = reader.readLine()) != null) {
                if (line.equals(formatCode)) {
                    foundCode = true;
                    readingFile = true;//nasiel sa zadany kod, citaj co je pod nim
                    System.out.println("Najdeny kod");
                    continue;
                }
                if (readingFile) {
                    //System.out.println(line);
                    if (line.equals(endSur)) {//ak sa nasiel koniec ankety "/"
                        primaryStage.close();
                        Stage voteStage = new Stage();
                        new VoteSurveyController(new VoteSurveyScene(voteStage,votePopController), this);
                        break;
                    }
                    else if (line.equals(startQuestion)) {//zaciatok otazky
                        line = reader.readLine();//riadok s otazkou
                        //System.out.println(line);
                        currentQuestion=line;
                        currentOptions = new ArrayList<>();//zresetuj otazky pred novym inputom
                        questionsWithOptions.put(currentQuestion, currentOptions);
                        line = reader.readLine();//precita dalsi riadok
                        if (line.equals(startOptions)) {//zacinaju options
                            while ((line = reader.readLine()) != null && !line.equals(startQuestion) && !line.equals(endSur) && !line.equals(startOptions)) {
                                currentOptions.add(line);
                                //System.out.println(line);
                                optionsToQuestions.put(line, currentQuestion);
                                line=reader.readLine();
                            }
                        }
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        if (!foundCode) {
            System.out.println("Nenajdeny kod");
        }
    }
    public void storingVotes(int code, VotePopController votePopController, VoteSurveyScene voteSurveyScene){
        String formatCode = "#" + code;
        boolean foundCode = false;
        boolean readingFile = false;
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))){
            String line;
            while ((line = reader.readLine()) != null){
                if (line.equals(formatCode)){
                    foundCode = true;
                    readingFile = true;
                    continue;
                }
                if (readingFile){
                    if (line.equals("/")){
                        break;
                    }
                    else if (line.equals("$")){
                        line = reader.readLine();
                        if (voteSurveyScene.getSelectedOptionMap().containsKey(line)){
                            line = reader.readLine();
                            line = reader.readLine();
                            if (line.equals(voteSurveyScene.getSelectedOptionMap().get(line))){

                            }
                        }
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void usernameFinder(String username){
        ArrayList<String> codesList = new ArrayList<>();
        String formatedUsername = "@" + username + "@";
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))){
            String line;
            while ((line = reader.readLine()) != null){
                if (line.equals(formatedUsername)){
                    line = reader.readLine();
                    codesList.add(line);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void ownSurveyFinder(ArrayList<String> codesList){
        for (String code : codesList){

        }
    }
    public void managing(){

    }
}
