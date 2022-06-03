package com.nzhang.messenger.messages.dialog;

import com.nzhang.messenger.Util;
import javafx.scene.image.Image;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Dialog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    // Data of sobesednik

    Long UID;

    String currentAddress;

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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Dialog() {
        this.messages = new ArrayList<>();
    }

    public Long getUID() {
        return UID;
    }

    String name;
    String nickName;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    byte[] photo;

    String bio;

    @OneToMany(
            mappedBy = "dialog",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<Message> messages;

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public byte[] getPhotoByteArray() {
        return photo;
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

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Dialog(Long UID) {
        this.UID = UID;
        this.messages = new ArrayList<>();
    }

    public List<Message> getMessages() {
        return messages;
    }

    //private void addMessage(Message m) {
//        this.messages.add(m);
//    }


}

