package com.nzhang.messenger;

import javafx.scene.image.Image;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Dialog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade =CascadeType.ALL)
    Personality me;

    @ManyToOne(fetch = FetchType.LAZY, cascade =CascadeType.ALL)
    Personality opponent;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Message> messages;

    public Personality getOpponent() {
        return opponent;
    }

    public Personality getMe() {
        return me;
    }

    Dialog(){
        this.messages = new ArrayList<>();
    }

    Dialog(Personality me, Personality opponent, ArrayList<Message> messages) {
        this.me = me;
        this.opponent = opponent;
        this.messages = messages;
    }

    public List<Message> getMessages() {
        return messages;
    }


}

@Entity
class Personality {
    boolean itsMe;
    String name;
    String nickName;
    //Image photo;
    String bio;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Personality() {

    }

    Personality(String name, String nickName, Image photo, String bio, boolean itsMe) {
        this.name = name;
        this.nickName = nickName;
        this.bio = bio;
        //this.photo = photo;
    }
}


@Entity
class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String text;
    int unixTime;

    Message() {

    }

    Message(String text, int unixTime) {
        this.text = text;
        this.unixTime = unixTime;
    }
}
