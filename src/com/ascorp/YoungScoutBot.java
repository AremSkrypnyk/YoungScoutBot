package com.ascorp;

import com.ascorp.httpsrequests.georgia.GeorgiaPlayersGetRequest;
import com.ascorp.httpsrequests.georgia.GeorgiaTeamsGetRequest;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import static org.telegram.telegrambots.logging.BotLogger.log;


public class YoungScoutBot extends TelegramLongPollingBot {
    /**
     * Метод для приема сообщений.
     * @param update Содержит сообщение от пользователя.
     */
    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        try {
            sendMsg(update.getMessage().getChatId().toString(), message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод для настройки сообщения и его отправки.
     * @param chatId id чата
     * @param s Строка, которую необходимот отправить в качестве сообщения.
     */
    public synchronized void sendMsg(String chatId, String s) throws IOException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(getListOfPlayers());
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            log(Level.SEVERE, "Exception: ", e.toString());
        }
    }

    private String getListOfPlayers() throws IOException {
        Map<String, String> teams = new GeorgiaTeamsGetRequest()
                .executeRequest()
                .getListOfTeams("georgia");

        List<String> young = new ArrayList<>();

        for (Map.Entry team : teams.entrySet()) {
            young.addAll(new GeorgiaPlayersGetRequest(team.getKey().toString())
                    .executeRequest()
                    .getListOfPlayers(team.getValue().toString()));
        }

        String players = "";
        for (String player: young)
            players = players + player + "\n";

        return players;
    }

    /**
     * Метод возвращает имя бота, указанное при регистрации.
     * @return имя бота
     */
    @Override
    public String getBotUsername() {
        return "YoungScoutBot";
    }

    /**
     * Метод возвращает token бота для связи с сервером Telegram
     * @return token для бота
     */
    @Override
    public String getBotToken() {
        return "551197042:AAG3WW3an1hRl-QOhpu--9zNlopOR2g9Um0";
    }
}
