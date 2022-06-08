package com.nzhang.messenger.gui;


import com.nzhang.messenger.MessengerApplication;
import com.nzhang.messenger.messages.personality.Personality;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;


public class ProfileInfo extends AnchorPane implements Initializable {

    public TextField nickName;
    public TextField nameTextField;
    public TextArea bio;
    public ImageView image;
    public Label id;

    public ProfileInfo() {

        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("profileInfo.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void setProfileInfo() {
        Personality me = MessengerApplication.personalityService.getMe();
        if (this.nickName != null) {
            this.id.setText(String.valueOf(me.getUID()));
            this.nickName.setText(me.getNickName());
            this.nameTextField.setText(me.getName());
            this.bio.setText(me.getBio());
            this.image.setImage(me.getPhoto());
        } else {
            System.out.println("HELP! I'm so sad and empty :'(");
        }
    }

    public void onSaveButtonClicked() {
        String nameText = nameTextField.getText();
        String nickNameText = nickName.getText();
        String bioText = bio.getText();
        saveChanges(nickNameText,nameText,bioText);
    }

    public void onChangePhotoClicked() {
        System.out.println("change photo");
    }

    public void saveChanges(String nickName, String name, String bio) {
        MessengerApplication.personalityService.editMe(nickName,name,bio);
        setProfileInfo();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setProfileInfo();
    }

    // добавить кнопку для сохранения
    // MessengerApplication.personalityService.saveMe()

    // TODO: (extra - после всех) - добавить (Google или зови меня) OpenFile
    // https://docs.oracle.com/javafx/2/ui_controls/file-chooser.htm

    // Me.setPhoto(new File()) <---- файл или ссылку на него вернет File Chooser

}
