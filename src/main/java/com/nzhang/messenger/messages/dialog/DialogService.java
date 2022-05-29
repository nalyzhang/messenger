package com.nzhang.messenger.messages.dialog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DialogService {

    @Autowired
    public DialogRepository dialogRepository;

    @Autowired
    public DialogRepository messageRepository;

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
        // предположим, что мы получили необходимую информацию

        Long UID = 99L;
        String name = "Olga";
        // ... и т.д.

        List<Dialog> dialogs = dialogRepository.findByUID(UID);
        Dialog d;
        if (dialogs.size() == 0) {
            // если мы общаемся в первый раз, то создаем новый диалог
            d = new Dialog(UID);
            d.setName(name);
            // TODO: заполняем всю информацию

            d = dialogRepository.save(d);

        } else {
            d = dialogs.get(0);
        }

        return d;

    }

    public void sendMessage(Dialog d, Message m) {
        //this.messageRepository.ad
        d.messages.add(m);
        this.dialogRepository.save(d);

        // TODO: нам еще нужно отправить сообщение

    }
}
