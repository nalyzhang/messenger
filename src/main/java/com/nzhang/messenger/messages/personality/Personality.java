package com.nzhang.messenger.messages.personality;

import com.nzhang.messenger.Util;
import javafx.scene.image.Image;

import javax.persistence.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
public
class Personality {

    // это только для хранения в нашей БД, нигде не используем
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    public Long getUID() {
        return UID;
    }

    // уникальный ID пользователя, который мы создаем, когда самый первый раз
    // входим в программу
    Long UID;
    String name;
    String nickName;
    byte[] photo;
    String bio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Image getPhoto() {
        try {
            Image im = Util.bytesToImage(this.photo);
            System.out.println(im.getHeight());
            return im;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setPhoto(File photo) throws IOException {
        this.photo = Util.imageToBytes(photo);
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }


    public Personality() {

    }

    public Personality(Long UID) {
        this.UID = UID;
    }


}
