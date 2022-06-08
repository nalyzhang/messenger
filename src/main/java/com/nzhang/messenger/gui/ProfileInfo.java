package com.nzhang.messenger.gui;


import com.nzhang.messenger.MessengerApplication;
import com.nzhang.messenger.messages.personality.Personality;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class ProfileInfo extends AnchorPane {
    TextField nickName;
    TextField name;
    TextArea bio;
    ImageView image;
    Label id;

    public ProfileInfo() {
    }

    public ProfileInfo (TextField nickName, TextField name, TextArea bio, ImageView image, Label id) {
        this.image = image;
        this.id = id;
        this.nickName = nickName;
        this.name = name;
        this.bio = bio;
    }
    
    public void setProfileInfo() {
        Personality me = MessengerApplication.personalityService.getMe();
        if (this.nickName != null) {
            this.id.setText(String.valueOf(me.getUID()));
            this.nickName.setText(me.getNickName());
            this.name.setText(me.getName());
            this.bio.setText(me.getBio());
            this.image.setImage(me.getPhoto());
        } else {
            System.out.println("HELP! I'm so sad and empty :'(");
        }
    }

    public void saveChanges(String nickName, String name, String bio) {
        MessengerApplication.personalityService.reset();
        MessengerApplication.personalityService.editMe(nickName,name,bio);
        setProfileInfo();
    }

    // добавить кнопку для сохранения
    // MessengerApplication.personalityService.saveMe()

    // TODO: (extra - после всех) - добавить (Google или зови меня) OpenFile
    // https://docs.oracle.com/javafx/2/ui_controls/file-chooser.htm

    // Me.setPhoto(new File()) <---- файл или ссылку на него вернет File Chooser

}
