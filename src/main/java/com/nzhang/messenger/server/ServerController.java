package com.nzhang.messenger.server;

import com.nzhang.messenger.MessengerApplication;
import com.nzhang.messenger.messages.personality.Personality;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

class PersonalInformation {
    public String name;
    public String bio;
    public Long UID;
    public String nickname;
    //public byte[] photo;
}

class Message {
    public long uid;
    public String text;
    public boolean fromMe;
}

@RestController
@RequestMapping(path = "/")
public class ServerController {

    @GetMapping("/getPersonalInformation")
    @ResponseStatus(HttpStatus.OK)
    public PersonalInformation getPersonalInformation() {
        PersonalInformation info = new PersonalInformation();
        Personality me = MessengerApplication.personalityService.getMe();
        info.name = me.getName();
        info.bio = me.getBio();
        info.UID = me.getUID();
        info.nickname = me.getNickName();
        return info;
    }

    @GetMapping(value = "/getPhoto", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public byte[] getPhoto() {
        return MessengerApplication.personalityService.getMe().getPhotoByteArray();
    }

    @PostMapping(value = "/sendMessage")
    @ResponseStatus(HttpStatus.CREATED)
    public void sendMessage(@RequestBody Message input) {
        MessengerApplication.dialogService.acceptMessage(input.uid, input.text);
        System.out.println(input.text + " | from " + String.valueOf(input.uid));
    }

}
