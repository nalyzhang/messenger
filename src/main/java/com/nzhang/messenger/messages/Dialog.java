package com.nzhang.messenger.messages;

import com.nzhang.messenger.messages.Personality;

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

    }

    String name;
    String nickName;
    //Image photo;
    String bio;

    @OneToMany(cascade = CascadeType.ALL)
    List<Message> messages;

    Dialog(Long UID) {
        this.UID = UID;
        this.messages = new ArrayList<>();
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message m) {
        this.messages.add(m);
    }


}

