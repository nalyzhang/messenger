package com.nzhang.messenger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;

import java.io.IOException;


public class ChatBoxMessage {
    @FXML
    HBox messageBox;

    @FXML
    TextField messageText;

    @FXML
    Image avatar;

    void setTextFrom(boolean b, String text) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("chatTextFromMe.fxml"));
        fxmlLoader.getRoot();
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!b) {
            this.messageBox.getChildren().get(0).toFront();
        }
        messageText.setText(text);
    }


}
