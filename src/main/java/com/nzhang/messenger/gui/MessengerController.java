package com.nzhang.messenger.gui;
// model view controller
import com.nzhang.messenger.MessengerApplication;
import com.nzhang.messenger.messages.dialog.Dialog;
import com.nzhang.messenger.messages.dialog.Message;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.util.Scanner;

public class MessengerController{

    public MenuBar btnHelp;
    public AnchorPane chatBox;
    public TextField findID;
    TextArea enterMessage;


    Dialog d;


    public void operationClicked(ActionEvent actionEvent) {
        Scanner in = new Scanner(System.in);
        System.out.println("operation clicked");
        Button b = (Button) actionEvent.getSource();
        String butt = b.idProperty().getValue();


        if (butt.equals("startDialog")){
                String ip = String.valueOf(findID.getText());
                findID.setText("");
                System.out.println(ip);
                ChatDialog n = new ChatDialog();
                n.setName(MessengerApplication.dialogService.startDialog(ip).getName());
                ChatBox chatBox = new ChatBox(MessengerApplication.dialogService.startDialog(ip));
                //chatBox.setDialog(MessengerApplication.serviceMessenger.startDialog(text));
                chatBox.setChatName(MessengerApplication.dialogService.startDialog(ip).getName());
                this.chatBox.getChildren().clear();
                this.chatBox.getChildren().add(chatBox);
        }
        if (butt.equals("btnSendMessage")){
            String text = String.valueOf(enterMessage.getText());
            System.out.println(text);
            MessengerApplication.dialogService.sendMessage(this.d, new Message(text, 19));
        }
    }

}