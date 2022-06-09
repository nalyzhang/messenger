package com.nzhang.messenger.gui;

import com.nzhang.messenger.messages.dialog.Dialog;
import com.nzhang.messenger.messages.dialog.Message;
import com.nzhang.messenger.MessengerApplication;
import com.nzhang.messenger.messages.dialog.DialogService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
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

    @FXML
    TextArea enterMessage;

    @FXML
    Button btnSendMessage;

    @FXML
    private ListView Messages;

    //DialogService serviceMessenger = MessengerApplication.dialogService;

    public final ObservableList<Message> messages = FXCollections.observableArrayList();

    Dialog d;

    public ChatBox(Dialog d) {


        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("chatBox.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        MessengerApplication.dialogService.setChatBox(this);
        setDialog(d);

    }

    public void setDialog(Dialog d) {

        this.d = d;

        messages.addAll(d.getMessages());

        try {
            if (d.getName().equals("")) {
                this.chatName.setText("Без названия");
            } else {
                this.chatName.setText(d.getName());
            }

            this.dialogImage.setImage(d.getPhoto());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        try {


        this.Messages.setItems(messages);

        this.Messages.setCellFactory(lv -> {
            ListCell<Message> cell = new ListCell<Message>() {

                @Override
                public void updateItem(Message item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        return;
                    }
                    ChatBoxMessage chatBoxMessage = new ChatBoxMessage();
//                    String text = String.valueOf(enterMessage.getText());
//                    enterMessage.setText("");
//                    System.out.println(text);
                    chatBoxMessage.setTextFrom(item.isFromMe(), item.getText());
                    setGraphic(chatBoxMessage);
                }
            };
            return cell;
        });

        this.btnSendMessage.setOnAction(event -> {

//            String beginText = String.valueOf(MessengerApplication.personalityService.getMe().getName());
//            String mainText = String.valueOf(enterMessage.getText());
//            String text = beginText + ": " + mainText;
            String text = String.valueOf(enterMessage.getText());
            System.out.println(text);
            Message m = new Message(text, (int)(System.currentTimeMillis() / 1000L), true);
            MessengerApplication.dialogService.sendMessage(this.d, m);
            enterMessage.setText("");
            this.messages.add(m);

        });

//        } catch (Exception e) {
//            System.out.println("fucking chat");
//        }

    }

    public void acceptMessage(Message m) {

        Platform.runLater(() -> {
            messages.add(m);
            System.out.println(m.getId());
        });

    }

}