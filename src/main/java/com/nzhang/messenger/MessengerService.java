package com.nzhang.messenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessengerService {

    @Autowired
    private DialogRepository dialogRepository;

    public List<Dialog> setDialog() {
        return this.dialogRepository.findAll();
    }

    public Dialog getDialog(long id){
        return this.dialogRepository.getById(id);
    }


    public Long addDialog(Dialog dialog) {
        this.dialogRepository.save(dialog);
        System.out.println(dialog.id);
        return  dialog.id;
    }

    public void editDialog(Dialog dialog) {
        this.dialogRepository.save(dialog);
    }

    public void getDialogs() {
        this.dialogRepository.findAll();
    }
}
