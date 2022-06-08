package com.nzhang.messenger.gui;
// model view controller
import com.nzhang.messenger.MessengerApplication;
import com.nzhang.messenger.messages.dialog.Dialog;
import com.nzhang.messenger.messages.dialog.Message;
import com.nzhang.messenger.messages.personality.Personality;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class MessengerController implements Initializable {


    public AnchorPane chatBox;
    public TextField findID;

    public ImageView scenePicture;

    public TabPane menuTabPane;
    public Button changePhoto;
    public Button saveChanges;
    public TextArea bio;
    public TextField name;
    public TextField nickName;

    Dialog d;

    public ProfileInfo profileInfo;


    public void operationClicked(ActionEvent actionEvent) {
        Scanner in = new Scanner(System.in);
        System.out.println("operation clicked");
        Button b = (Button) actionEvent.getSource();
        String butt = b.idProperty().getValue();

        switch (butt) {
            case "startDialog":
                String ip = String.valueOf(findID.getText());
                findID.setText("");
                System.out.println(ip);

                Dialog d = MessengerApplication.dialogService.openDialog(ip);
                this.d = d;

                ChatDialog n = new ChatDialog();
                n.setName(d.getName());

                ChatBox chatBox = new ChatBox(d);
                chatBox.setDialog(d);

                this.chatBox.getChildren().clear();
                this.chatBox.getChildren().add(chatBox);
                break;
        }
//        if (butt.equals("btnSendMessage")){
//            String text = String.valueOf(enterMessage.getText());
//            System.out.println(text);
//            MessengerApplication.dialogService.sendMessage(this.d, new Message(text, (int)(System.currentTimeMillis() / 1000L)));
//        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        this.scenePicture.setImage(new Image(String.valueOf(getClass().getResource("kjeg.png"))));

        this.menuTabPane.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                // если пользователь открыл вторую вкладку
               if (newValue.equals(1)) {
                   ((AnchorPane) menuTabPane.getTabs().get(1).getContent()).getChildren().clear();
                   // убить детей (убили выше) - создать нового - это сцена изменения пользователя
                   // загрузить туда пользователя из MessengerApplication.personalityService.getMe()
                   ProfileInfo c = new ProfileInfo();

                   ((AnchorPane) menuTabPane.getTabs().get(1).getContent()).getChildren().add(c);

               }
            }
        });
    }
}