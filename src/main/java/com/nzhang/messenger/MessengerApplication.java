package com.nzhang.messenger;

import com.nzhang.messenger.messages.dialog.DialogService;
import com.nzhang.messenger.messages.personality.Personality;
import com.nzhang.messenger.messages.personality.PersonalityService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org..boot.aspringframeworkutoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class MessengerApplication extends Application {

    /*

    ааааааааа не слушаеца

    = = = = = =
    =  Vanya
    =
    =
    =  ip адрес
    = = = = = =

    | getPersonalInformation   |  sendMessage
    |     name                 |  text    |   "OK" (отчет об отправке)
    |     bio                  |
    \/    UID                  \/

    = = = = = =
    =  Petya
    =
    =
    =
    = = = = = =

    */

    public static DialogService dialogService = new DialogService();
    public static PersonalityService personalityService = new PersonalityService();

    private static ApplicationContext context;

//    public static Dialog example() {
//        Personality me = new Personality("Oleg", "oleg", null, "1", true);
//        Personality you = new Personality("Olga", "olga", null, "2", false);
//
//
//
//        long id = serviceMessenger.addDialog(new Dialog(me, you, new ArrayList<Message>()));
//        serviceMessenger.getDialog(id).messages.add(new Message("fucking message", 11));
//
//        return serviceMessenger.getDialog(id);
//    }

    @Override
    public void start(Stage stage) throws IOException {
        context = SpringApplication.run(MessengerApplication.class);

        dialogService = context.getBean(DialogService.class);
        personalityService = context.getBean(PersonalityService.class);

        new TestInitializer().fillWithSampleData();

        FXMLLoader fxmlLoader = new FXMLLoader(MessengerApplication.class.getResource("messengerMainScene.fxml"));
        System.out.println(fxmlLoader.getLocation());
        Scene scene = new Scene(fxmlLoader.load(), 760, 560);
        stage.setTitle("название не определено бип-боп");
        stage.setScene(scene);
        stage.show();



    }


    public static void main(String[] args) {
        launch();
    }
}