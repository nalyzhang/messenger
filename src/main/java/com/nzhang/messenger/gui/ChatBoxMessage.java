package com.nzhang.messenger.gui;

import com.nzhang.messenger.MessengerApplication;
import com.nzhang.messenger.messages.personality.Personality;
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


public class ChatBoxMessage extends HBox implements Initializable {
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

    void setTextFrom(boolean b, String text /* Dialog ... */) {
        messageText.setText(text);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
