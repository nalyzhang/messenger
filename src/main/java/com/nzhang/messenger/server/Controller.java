package com.nzhang.messenger.server;

import java.util.concurrent.atomic.AtomicLong;

import com.nzhang.messenger.MessengerApplication;
import com.nzhang.messenger.messages.personality.Personality;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

class PersonalInformation {
    public String name;
    public String bio;
    public Long UID;
    public String nickname;
    //public byte[] photo;
}

@RestController
public class Controller {

//    @RequestMapping("/greeting")
//    public Greeting greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
//        return new Greeting(counter.incrementAndGet(),
//                String.format(template, name));
//    }

    @RequestMapping("/getPersonalInformation")
    public PersonalInformation getPersonalInformation() {
        PersonalInformation info = new PersonalInformation();
        Personality me = MessengerApplication.personalityService.getMe();
        info.name = me.getName();
        info.bio = me.getBio();
        info.UID = me.getUID();
        info.nickname = me.getNickName();
        //info.photo = me.getPhoto();
        return info;
    }

}
