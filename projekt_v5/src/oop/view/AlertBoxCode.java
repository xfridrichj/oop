package oop.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Random;

public class AlertBoxCode {
    public static void display(int code) {
        Stage windowV = new Stage();
        windowV.initModality(Modality.APPLICATION_MODAL);
        windowV.setMinWidth(300);

        //int code = codeGenerator(); // Generate code
        String codeToString = String.valueOf(code);
        Label label = new Label("Kód na anketu: ");
        Hyperlink hyperlink = new Hyperlink(codeToString);

        hyperlink.setOnAction(e -> {
            ClipboardContent content = new ClipboardContent();
            content.putString(String.valueOf(code));
            Clipboard.getSystemClipboard().setContent(content);
            System.out.println("Clipped");
            windowV.close();//mozno zavriet aj scenu kde sa vytvaraju ankety?
        });

        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label,hyperlink);

        Scene scene = new Scene(layout, 300, 100);

        windowV.setScene(scene);
        windowV.showAndWait();
    }

    /*public static int codeGenerator() {
        Random rand = new Random();
        return rand.nextInt(90000) + 10000;
    }*/
}

/*
package oop.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Random;

public class AlertBoxCode {
    public static void display() {
        Stage windowV = new Stage();
        windowV.initModality(Modality.APPLICATION_MODAL);
        windowV.setMinWidth(300);

        int code = codeGenerator(); // Generate code
        String codeToString = String.valueOf(code);
        Label label = new Label("Kód na anketu: ");
        Hyperlink hyperlink = new Hyperlink(codeToString);

        hyperlink.setOnAction(e -> {
            ClipboardContent content = new ClipboardContent();
            content.putString(String.valueOf(code));
            Clipboard.getSystemClipboard().setContent(content);
            System.out.println("Clipped");
            windowV.close();//mozno zavriet aj scenu kde sa vytvaraju ankety?
        });

        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label,hyperlink);

        Scene scene = new Scene(layout, 300, 100);

        windowV.setScene(scene);
        windowV.showAndWait();
    }

    public static int codeGenerator() {
        Random rand = new Random();
        return rand.nextInt(90000) + 10000;
    }
}
*/