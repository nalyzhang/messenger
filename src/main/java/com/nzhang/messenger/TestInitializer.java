package com.nzhang.messenger;

import com.nzhang.messenger.messages.dialog.Message;
import com.nzhang.messenger.messages.dialog.Dialog;
import com.nzhang.messenger.messages.personality.Personality;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class TestInitializer {

    // TODO: написать заполнение тестовыми данными

    public void fillWithSampleData() {

        // Для демонстрационных целей очистим профиль текущего пользователя
        // и заполним с чистого листа

        MessengerApplication.personalityService.reset();
        Personality me = MessengerApplication.personalityService.createMe();
        me.setName("Маргарита");
        me.setBio("По жизни синдром спасателя...");
        me.setNickName("margarita");
        try {
            me.setPhoto(new File(MessengerApplication.class.getResource("pics/margarita.png").getFile()));
        } catch (Exception e) {

        }
        MessengerApplication.personalityService.saveMe(me);
        MessengerApplication.personalityService.showMe(me);


//        Dialog d = new Dialog(99L);
//        d.setName("Кот-Бегемот");
//        d.setNickName("Чёрт");
//        d.setBio("Я - спутник Воланда и собрат Короьева... как же хочется его убить! :) Мррр мяяяяу ^*^");
//         //TODO: заполняем всю информацию
//
//        d = MessengerApplication.dialogService.dialogRepository.save(d);
//        MessengerApplication.dialogService.sendMessage(d, new Message("Выпьем кофейку?", 11));
//        MessengerApplication.dialogService.sendMessage(d, new Message("AAAAAAAAAAAA", 12));
//
//        MessengerApplication.dialogService.openDialog("99L");
//

    }
}
