import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;

public class MyBot extends TelegramLongPollingBot {

    // Define the bot's username and token
    private static final String BOT_USERNAME = "@coder22bot";  // Replace with your bot username
    private static final String BOT_TOKEN = "6817651266:AAHDzZjfl3JyMhubKWcg-_hmTvqiCPw1JSY";        // Replace with your bot token

    @Override
    public void onUpdateReceived(Update update) {
        // Get the message from the update


        // Check if the message has text
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
        return BOT_USERNAME;  // Return the bot's username
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;  // Return the bot's token
    }

    public static void main(String[] args) {
        // Initialize the Telegram Bots API
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

            // Register the bot with the Telegram API
            botsApi.registerBot(new MyBot());
            System.out.println("Bot is running...");

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
