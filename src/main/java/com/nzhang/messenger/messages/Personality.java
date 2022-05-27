package com.nzhang.messenger.messages;

import javafx.scene.image.Image;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
class Personality {

    Long UID;

    String name;
    String nickName;
    //Image photo;
    String bio;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    public Personality() {

    }

    Personality(String name, String nickName, Image photo, String bio, boolean itsMe) {
        this.name = name;
        this.nickName = nickName;
        this.bio = bio;
        this.UID = (new Random()).nextLong();
        //this.photo = photo;
    }


}
