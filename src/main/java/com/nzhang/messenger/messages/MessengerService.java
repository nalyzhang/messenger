package com.nzhang.messenger.messages;

import com.nzhang.messenger.messages.Message;
import com.nzhang.messenger.messages.Personality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessengerService {

    @Autowired
    private DialogRepository dialogRepository;

    public Dialog getDialog(long id){
        return this.dialogRepository.getById(id);
    }


//    public Long addDialog(Dialog dialog) {
//        this.dialogRepository.save(dialog);
//        System.out.println(dialog.id);
//        return dialog.id;
//    }

    public void editDialog(Dialog dialog) {
        this.dialogRepository.save(dialog);
    }

    public List<Dialog> getDialogs() {
        return this.dialogRepository.findAll();
    }

    public Dialog startDialog(String ip) {

        // 1. подключились по адресу
        // got data from user

        // we got unique identifier
        // name, bop, photo
        Long UID = 99L;
        String name = "Olga";


        // 2. Searching for dialog between you and me
        Personality me = new Personality("Oleg", "oleg", null, "1", true);

        List<Dialog> dialogs = dialogRepository.findByUID(UID);
        Dialog d;
        if (dialogs.size() == 0) {
            d = new Dialog(UID);
            d.setName(name);
            // TODO:


            d = dialogRepository.save(d);
            d.addMessage(new Message("fucking message", 11));

        } else {
            d = dialogs.get(0);
        }

        return d;


    }
}
