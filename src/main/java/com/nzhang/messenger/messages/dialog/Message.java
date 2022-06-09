package com.nzhang.messenger.messages.dialog;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public
class Message {

    public Long getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    public Dialog getDialog() {
        return dialog;
    }

    String text;
    int unixTime;

    public boolean isFromMe() {
        return fromMe;
    }

    public void setFromMe(boolean fromMe) {
        this.fromMe = fromMe;
    }

    boolean fromMe = true;

    @ManyToOne(fetch = FetchType.LAZY)
    Dialog dialog;

    public Message() {

    }


    public String getText() {
        return text;
    }

    public int getUnixTime() {
        return unixTime;
    }

    public Message(String text, int unixTime, boolean fromMe) {
        this.text = text;
        this.unixTime = unixTime;
        this.fromMe = fromMe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id.equals(message.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
