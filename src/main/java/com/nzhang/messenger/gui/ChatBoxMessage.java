package com.nzhang.messenger.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ChatBoxMessage extends Pane implements Initializable {
    @FXML
    HBox messageBox;

    @FXML
    TextArea messageText;

    @FXML
    Image avatar;

    ChatBoxMessage() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("chatTextFromMe.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void setTextFrom(boolean b, String text) {
        if (!b) {
            this.messageBox.getChildren().get(0).toBack();
        }
        messageText.setText(text);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
