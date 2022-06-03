package com.nzhang.messenger.messages.dialog;

import com.nzhang.messenger.MessengerApplication;
import com.nzhang.messenger.gui.ChatBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DialogService {

    @Autowired
    public DialogRepository dialogRepository;

    @Autowired
    public MessageRepository messageRepository;

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

    public Dialog openDialog(String ip) {

        // 1. подключились по адресу
        Dialog predialog = new Dialog();
        predialog = MessengerApplication.clientService.getPersonality(ip, predialog);
        predialog = MessengerApplication.clientService.getPhoto(ip, predialog);
//
//
//        Long UID = 99L;
//        String name = "Nobody";
//        // ... и т.д.

        //
        List<Dialog> dialogs = dialogRepository.findByUID(predialog.getUID());
        Dialog d;
        if (dialogs.size() == 0) {
            // если мы общаемся в первый раз, то создаем новый диалог
            d = dialogRepository.save(predialog);
        } else {
            d = dialogs.get(0);
            d = MessengerApplication.clientService.getPersonality(ip, d);
            d = dialogRepository.save(d);
        }

        d.currentAddress = ip;
        return d;

    }

    public void sendMessage(Dialog d, Message m) {
        try {
            MessengerApplication.clientService.sendMessage(d.currentAddress, m.text);
            d.messages.add(m);
            this.messageRepository.save(m);
            this.dialogRepository.save(d);
        } catch (Exception e) {
            System.out.println("failed to send message to " + d.currentAddress);
        }
    }

    public List<Message> updateMessages(Dialog d) {
        return d.getMessages();
    }

    public void acceptMessage(Long uid, String text) {
        Dialog d = this.dialogRepository.findByUID(uid).get(0);
        Message m = new Message();
        //m.dialog = d;
        m.text = text;
        m.unixTime = (int) (System.currentTimeMillis() / 1000L);
        d.messages.add(m);
        this.messageRepository.save(m);
        this.dialogRepository.save(d);

        this.currentChatController.acceptMessage(m);

    }




    ChatBox currentChatController;

    public void setChatBox(ChatBox d) {
        this.currentChatController = d;
    }

}
