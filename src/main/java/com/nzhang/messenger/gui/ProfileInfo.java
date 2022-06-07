package com.nzhang.messenger.gui;


import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class ProfileInfo extends AnchorPane {
    TextField nickName;
    TextField name;
    TextArea bio;
    
    public void setProfileInfo(String nickName, String name, String bio) {
        if (this.nickName != null) {
            this.nickName.setText(nickName);
            this.name.setText(name);
            this.bio.setText(bio);
        } else {
            System.out.println("HELP! I'm so sad and empty :'(");
        }
    }

    // TODO: добавить кнопку для сохранения
    // MessengerApplication.personalityService.saveMe()

    // TODO: (extra - после всех) - добавить (Google или зови меня) OpenFile
    // https://docs.oracle.com/javafx/2/ui_controls/file-chooser.htm

    // Me.setPhoto(new File()) <---- файл или ссылку на него вернет File Chooser

}
