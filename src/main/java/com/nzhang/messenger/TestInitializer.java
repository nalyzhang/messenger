package com.nzhang.messenger;

import com.nzhang.messenger.messages.dialog.Message;
import com.nzhang.messenger.messages.dialog.Dialog;
import org.springframework.stereotype.Component;

@Component
public class TestInitializer {

    // TODO: написать заполнение тестовыми данными

    public void fillWithSampleData() {

        Dialog d = new Dialog(99L);
        d.setName("Кот-Бегемот");
        d.setNickName("Чёрт");
        d.setBio("Я - спутник Воланда и собрать Короьева... как же хочется его убить! :)");
        // TODO: заполняем всю информацию

        d = MessengerApplication.dialogService.dialogRepository.save(d);
        MessengerApplication.dialogService.sendMessage(d, new Message("Выпьем кофейку?", 11));
        MessengerApplication.dialogService.sendMessage(d, new Message("AAAAAAAAAAAA", 12));

        MessengerApplication.dialogService.startDialog("99L");

    }
}
