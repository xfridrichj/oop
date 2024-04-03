package oop.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javafx.stage.Stage;
import oop.model.program.Model;
import oop.view.VotePop;
import oop.view.VoteSurveyScene;

public class VotePopController {
    private Stage primaryStage;
    private VotePop votePop;
    private Model model;
    private String currentCode;
    private Map<String, List<String>> questionsWithOptions = new LinkedHashMap<>();
    private Map<String, String> optionsToQuestions = new LinkedHashMap<>();

    public VotePopController(VotePop votePop, Model model, Stage primaryStage) {
        this.votePop = votePop;
        this.model = model;
        this.primaryStage = primaryStage;

        votePop.getConfirmCodeButton().setOnAction(e -> {
            currentCode = votePop.getCodeField().getText();
            model.codeFinder(Integer.parseInt(currentCode),primaryStage, questionsWithOptions, optionsToQuestions, this);
            //checkCode(currentCode);//funkcia na najdenie a citanie fileu
        });
    }

    /*public void checkCode(String code) {
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
                    System.out.println(line);
                    if (line.equals(endSur)) {//ak sa nasiel koniec ankety "/"
                        primaryStage.close();
                        Stage voteStage = new Stage();
                        new VoteSurveyController(new VoteSurveyScene(voteStage,this), model);
                        break;
                    }
                    else if (line.equals(startQuestion)) {//zaciatok otazky
                        line = reader.readLine();//riadok s otazkou
                        System.out.println(line);
                        currentQuestion=line;
                        currentOptions = new ArrayList<>();//zresetuj otazky pred novym inputom
                        questionsWithOptions.put(currentQuestion, currentOptions);
                        line = reader.readLine();//precita dalsi riadok
                        if (line.equals(startOptions)) {//zacinaju options
                            while ((line = reader.readLine()) != null && !line.equals(startQuestion) && !line.equals(endSur) && !line.equals(startOptions)) {
                                currentOptions.add(line);
                                System.out.println(line);
                                optionsToQuestions.put(line, currentQuestion);
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
    }*/

    public Map<String, List<String>> getQuestionsWithOptions() {
        return questionsWithOptions;
    }

    public Map<String, String> getOptionsToQuestions() {
        return optionsToQuestions;
    }
}






/*package oop.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javafx.scene.Parent;
import javafx.stage.Stage;
import oop.model.program.Model;
import oop.view.VotePop;
import oop.view.VoteSurveyScene;

public class VotePopController {
    private Stage primaryStage;
    private VotePop votePop;
    private Model model;
    private String currentCode;
    private Map<String, Map<String, List<String>>> questionsWithOptions = new LinkedHashMap<>();

    public VotePopController(VotePop votePop, Model model, Stage primaryStage) {
        this.votePop = votePop;
        this.model = model;
        this.primaryStage = primaryStage;

        votePop.getConfirmCodeButton().setOnAction(e -> {
            currentCode = votePop.getCodeField().getText();
            // System.out.println("#"+currentCode);
            checkCode(currentCode);
        });
    }

    public void checkCode(String code) {
        String filePath = "data.txt";
        String formatCode = "#" + code;
        boolean foundCode = false;
        boolean startReading = false;
        // System.out.println("\n" + formatCode);

        String endSur = "/";
        String startQuestion = "$";
        String startOptions = "%";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            String currentQuestion;
            Map<String, List<String>> optionsMap = null;
            int questionCounter = 1;

            while ((line = reader.readLine()) != null) {
                if (line.equals(formatCode)) {
                    foundCode = true;
                    // System.out.println("Najdeny kod");
                    startReading = true;
                    continue;
                }
                if (startReading) {
                    if (line.equals(endSur)) {//ak je koniec survey
                        primaryStage.close();
                        Stage voteStage = new Stage();
                        new VoteSurveyController(new VoteSurveyScene(voteStage,this), model);
                        break;
                    }
                    else if (line.equals(startQuestion)) {// hlada otazky
                        line = reader.readLine();
                        currentQuestion = "Otazka "+questionCounter++;

                        optionsMap = new LinkedHashMap<>(); //Reset options for new question
                        questionsWithOptions.put(currentQuestion, optionsMap);
                        // System.out.println("toto je otazka: "+line);
                        line = reader.readLine();

                        if (line.equals(startOptions)) {//hlada options
                            while ((line = reader.readLine()) != null && !line.equals(startQuestion) && !line.equals(endSur) && !line.equals(startOptions)) {
                                // System.out.println("toto je jedna z moznosti: " + line);
                                optionsMap.computeIfAbsent(currentQuestion, k -> new ArrayList<>()).add(line);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*for (Map.Entry<String, Map<String, List<String>>> entry : questionsWithOptions.entrySet()) {
            System.out.println("Question: " + entry.getKey());
            Map<String, List<String>> optionsMap = entry.getValue();
            for (Map.Entry<String, List<String>> optionEntry : optionsMap.entrySet()) {
                System.out.println("Options: " + optionEntry.getValue());
            }
        }
        for (String question : questionsWithOptions.keySet()) {//printovanie klucov megamapy
            System.out.println("Question: " + question);
        }
        if (!foundCode) {
            System.out.println("Nenajdeny kod");
        }
    }

    public String getCurrentCode() {
        return currentCode;
    }

    public void setCurrentCode(String currentCode) {
        this.currentCode = currentCode;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public VotePop getVotePop() {
        return votePop;
    }

    public void setVotePop(VotePop votePop) {
        this.votePop = votePop;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Map<String, Map<String, List<String>>> getQuestionsWithOptions() {
        return questionsWithOptions;
    }

    public void setQuestionsWithOptions(Map<String, Map<String, List<String>>> questionsWithOptions) {
        this.questionsWithOptions = questionsWithOptions;
    }
}*/


/*
 else if (line.equals(startQuestion)) {// hlada otazky
                        line = reader.readLine();
                        currentQuestion = line;
                        optionsMap = new LinkedHashMap<>(); // Reset options map for a new question
                        questionsWithOptions.put(currentQuestion, optionsMap);
                        // System.out.println("toto je otazka: "+line);
                        line = reader.readLine();
                        if (line.equals(startOptions)) {// hlada options
                            while ((line = reader.readLine()) != null && !line.equals(startQuestion) && !line.equals(endSur) && !line.equals(startOptions)) {
                                // System.out.println("toto je jedna z moznosti: " + line);
                                optionsMap.computeIfAbsent(currentQuestion, k -> new ArrayList<>()).add(line);
                            }
                        }
                    }
*/





/*
package oop.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javafx.scene.Parent;
import javafx.stage.Stage;
import oop.model.program.Model;
import oop.view.VotePop;
import oop.view.VoteSurveyScene;

public class VotePopController {
    private Stage primaryStage;
    private VotePop votePop;
    private Model model;
    private String currentCode;
    private Map<String, List<String>> questionsWithOptions = new LinkedHashMap<>();//nech su usporiadane, keby len hashmap - zle poradie
    public VotePopController(VotePop votePop, Model model, Stage primaryStage){
        this.votePop = votePop;
        this.model = model;
        this.primaryStage = primaryStage;

        votePop.getConfirmCodeButton().setOnAction(e->{
            currentCode = votePop.getCodeField().getText();
            //System.out.println("#"+currentCode);
            checkCode(currentCode);
        });
    }

    public void checkCode(String code){//najdi cislo a zapamataj si otazky a odpovede
        String filePath = "data.txt";
        String formatCode = "#" + code;
        boolean foundCode = false;
        boolean startReading = false;
        System.out.println("\n"+formatCode);

        //String startSur = "*";
        String endSur = "/";
        String startQuestion = "$";
        String startOptions = "%";

        //Map<String, List<String>> questionsWithOptions = new LinkedHashMap<>();//nech su usporiadane, keby len hashmap - zle poradie

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            String currentQuestion;
            List<String> currentOptions;

            while ((line = reader.readLine()) != null) {
                if (line.equals(formatCode)){
                    foundCode = true;
                    System.out.println("Najdeny kod");
                    startReading = true;
                    continue;
                }
                if (startReading){
                    if (line.equals(endSur)){//ak je koniec survey
                        primaryStage.close();
                        Stage voteStage = new Stage();
                        new VoteSurveyController(new VoteSurveyScene(voteStage),model);
                        break;
                    }
                    else if (line.equals(startQuestion)){//hlada otazky
                        line = reader.readLine();
                        currentQuestion = line;
                        currentOptions = new ArrayList<>(); //Reset options pre novu question
                        questionsWithOptions.put(currentQuestion, currentOptions);
                        //System.out.println("toto je otazka: "+line);
                        line = reader.readLine();
                        if (line.equals(startOptions)){//hlada options
                            while ((line = reader.readLine())!=null && !line.equals(startQuestion) && !line .equals(endSur) && !line.equals(startOptions)) {
                                //System.out.println("toto je jedna z moznosti: " + line);
                                currentOptions.add(line);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map.Entry<String, List<String>> entry : questionsWithOptions.entrySet()) {
            System.out.println("Question: " + entry.getKey());
            System.out.println("Options: " + entry.getValue());
        }
        if (!foundCode) {
            System.out.println("Nenajdeny kod");
        }
    }

    public String getCurrentCode() {
        return currentCode;
    }

    public void setCurrentCode(String currentCode) {
        this.currentCode = currentCode;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public VotePop getVotePop() {
        return votePop;
    }

    public void setVotePop(VotePop votePop) {
        this.votePop = votePop;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Map<String, List<String>> getQuestionsWithOptions() {
        return questionsWithOptions;
    }

    public void setQuestionsWithOptions(Map<String, List<String>> questionsWithOptions) {
        this.questionsWithOptions = questionsWithOptions;
    }
}
*/