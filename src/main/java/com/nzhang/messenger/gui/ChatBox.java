package com.nzhang.messenger.gui;

import com.nzhang.messenger.messages.dialog.Dialog;
import com.nzhang.messenger.messages.dialog.Message;
import com.nzhang.messenger.MessengerApplication;
import com.nzhang.messenger.messages.dialog.DialogService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ChatBox extends Pane implements Initializable {

    @FXML
    Label chatName;

    @FXML
    ImageView dialogImage;

    public ChatBox(Dialog d) {

        this.d = d;

        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("chatBox.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setChatName(String s) {
        try {
            if (s.equals("")) {
                this.chatName.setText("Без названия");
            } else {
                this.chatName.setText(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setChatImage(Image s) {
        try {
            this.dialogImage.setImage(s);
        } catch (Exception e) {

        }
    }


    @FXML
    private ListView Messages;

    DialogService serviceMessenger = MessengerApplication.dialogService;



    public final ObservableList<Message> messages = FXCollections.observableArrayList();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        try {
            messages.addAll(serviceMessenger.updateMessages(d));

            this.Messages.setItems(messages);

            this.Messages.setCellFactory(lv -> {
                ListCell<Message> cell = new ListCell<Message>() {

                    @Override
                    public void updateItem(Message item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty){
                            return;
                        }
                        ChatBoxMessage chatBoxMessage = new ChatBoxMessage();
//                    String text = String.valueOf(enterMessage.getText());
//                    enterMessage.setText("");
//                    System.out.println(text);
                        chatBoxMessage.setTextFrom(true, item.getText());
                        setGraphic(chatBoxMessage);
                    }
                };
                return cell;
            });

//        } catch (Exception e) {
//            System.out.println("fucking chat");
//        }

    }

    Dialog d;

    public void setDialog(Dialog startDialog) {
        this.d = startDialog;
    }
}