package com.nzhang.messenger.messages.personality;

import com.nzhang.messenger.messages.dialog.DialogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class PersonalityService {

    @Autowired
    private PersonalityRepository personalityRepository;

    public Personality getMe() {
        List<Personality> mes = this.personalityRepository.findAll();
        if (mes.size() == 0) {
            throw new RuntimeException("Меня еще не существет...");
        }
        return mes.get(0);
    }

    public Personality createMe() {
        List<Personality> mes = this.personalityRepository.findAll();
        if (mes.size() == 0) {
            return this.personalityRepository.save(new Personality((new Random()).nextLong()));
        } else {
            throw new RuntimeException("Я уже есть, чтобы меня вновь создавать..");
        }
    }

    public void saveMe(Personality me) {
        if (getMe().id == me.id) {
            this.personalityRepository.save(me);
        } else {
            throw new RuntimeException("You try to replace me with another me. ");
        }
    }

    public void reset() {
        this.personalityRepository.deleteAll();
    }



}
