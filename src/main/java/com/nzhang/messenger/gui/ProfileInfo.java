package com.nzhang.messenger.gui;


import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class ProfileInfo extends TabPane {
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
}
