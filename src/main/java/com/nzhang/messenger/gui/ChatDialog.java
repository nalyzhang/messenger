package com.nzhang.messenger.gui;

import javafx.scene.image.Image;

public class ChatDialog {

    String name;
    String message;
    Image image;

    //boolean fromMe = true;

    public void setName(String n) {
        this.name = n;
        this.message = "";
        this.image = null;

    }

    public void setImage(Image s) {
        this.image = s;

    }

}
