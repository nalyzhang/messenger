package com.nzhang.messenger.messages;

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

    Message() {

    }

    public String getText() {
        return text;
    }

    public int getUnixTime() {
        return unixTime;
    }

    Message(String text, int unixTime) {
        this.text = text;
        this.unixTime = unixTime;
    }
}
