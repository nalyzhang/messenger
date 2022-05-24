package com.nzhang.messenger;
// model view controller
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class MessengerController{

    public MenuBar btnHelp;
    public AnchorPane chatBox;
    public TextField findID;
    TextArea enterMessage;




    public void operationClicked(ActionEvent actionEvent) {
        Scanner in = new Scanner(System.in);
        System.out.println("operation clicked");
        Button b = (Button) actionEvent.getSource();
        String butt = b.idProperty().getValue();


        if (butt.equals("startDialog")){
                String text = String.valueOf(findID.getText());
                findID.setText("");
                System.out.println(text);
                ChatDialog n = new ChatDialog();
                n.setName(text);
                ChatBox chatBox = new ChatBox();
                chatBox.setChatName(text);
                this.chatBox.getChildren().clear();
                this.chatBox.getChildren().add(chatBox);
        }
        if (butt.equals("btnSendMessage")){

        }
    }

}