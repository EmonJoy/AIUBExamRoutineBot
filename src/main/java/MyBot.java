import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;

public class MyBot extends TelegramLongPollingBot {

    private static final String BOT_USERNAME = "@coder22bot";  // ur bot username
    private static final String BOT_TOKEN = "6817651266:AAHDzZjfl3*********g-_XXXXXXX";       // Bot token,,I wwill hide it for my bot's security

    @Override
    public void onUpdateReceived(Update update) {



        if (update.hasMessage() && update.getMessage().hasText()) {
            String text = update.getMessage().getText().trim();
            long chatId = update.getMessage().getChatId();
            String Search;

            Search = Main.Search(text);

            SendMessage message = new SendMessage();
            message.setChatId(String.valueOf(chatId));



            message.setText(Search);


            // msg exicute korbo
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);


            botsApi.registerBot(new MyBot());
            System.out.println("Bot is running...🫡");

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
