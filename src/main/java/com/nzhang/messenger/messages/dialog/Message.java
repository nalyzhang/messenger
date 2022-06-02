package com.nzhang.messenger.messages.dialog;

import javax.persistence.*;
import java.util.List;

@Entity
public
class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String text;
    int unixTime;

    @ManyToOne(fetch = FetchType.EAGER)
    Dialog dialog;

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
