package com.nzhang.messenger.messages.dialog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public
class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String text;
    int unixTime;

    public Message() {

    }

    public String getText() {
        return text;
    }

    public int getUnixTime() {
        return unixTime;
    }

    public Message(String text, int unixTime) {
        this.text = text;
        this.unixTime = unixTime;
    }

}
