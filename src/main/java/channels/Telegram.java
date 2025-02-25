package channels;


import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;
import utility.Logger;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Telegram implements Channel {
    static final String telegramBotToken = "1167083350:AAGK2IuNKNeFVCJAT-ZyCj_36s9l5e8QujY";

    TelegramBot telegramBot;
    long chatId;
    int lastMessageId = -1;

    @Override
    public String getName() {
        return "Telegram";
    }

    @Override
    public String input() {
        GetUpdates getUpdates = new GetUpdates().limit(100).offset(lastMessageId).timeout(0);

        GetUpdatesResponse updatesResponse = telegramBot.execute(getUpdates);
        List<Update> updates = updatesResponse.updates();

        Update update;
        if (updates.size() > 0)
            update = updates.get(updates.size() - 1);
        else update = updates.get(0);

        Message message = update.message();

        // Serve ad evitare il primo messagio non richiesto.
        if (lastMessageId == -1) lastMessageId = message.messageId();

        if (message.messageId() == lastMessageId) {
            try {
                TimeUnit.SECONDS.sleep(1);
                return input();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        lastMessageId = message.messageId();
        chatId = message.chat().id();

        // TODO: Gestire meglio la questione.
        if (message.text() == null) return input();

        return message.text();
    }

    @Override
    public void output(String output) {
        SendMessage request = new SendMessage(chatId, output);

        SendResponse sendResponse = telegramBot.execute(request);
    }

    @Override
    public void initialize() {
        telegramBot = new TelegramBot(telegramBotToken);
        Logger.logDebug("Inizializzato correttamente Telegram.");
    }
}
