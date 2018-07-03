package com.ascorp.httpsrequests.base.players;


import com.ascorp.httpsrequests.base.response.GetResponse;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

public class PlayersGetResponse extends GetResponse {

    public PlayersGetResponse(HttpURLConnection connection) {
        super(connection);
    }

    public List<String> getListOfPlayers(String teamName) throws IOException {
        Document doc = getDocumentFromResponse();

        Elements link = doc.getElementsByAttribute("data-people_id");

        List<String> youngPlayers = new ArrayList<>();

        for (Element element : link) {
            if (getPlayerAge(element) < 20 &&
                    getPlayedMinutes(element) > 0)
                youngPlayers.add(getPlayerName(element)
                        + ", age:" + getPlayerAge(element)
                        + ", club:" + teamName);
        }

        return youngPlayers;
    }

    private String getPlayerName(Element element) {
        return element.getElementsByClass("name large-link").get(0).getElementsByTag("a").get(0).ownText();
    }

    private int getPlayedMinutes(Element element) {
        return Integer.parseInt(element.getElementsByAttributeValueStarting("class", "number statistic game-minutes").get(0).ownText());
    }

    private int getPlayerAge(Element element) {
        if (element.getElementsByClass("number age").get(0).ownText().isEmpty())
            return 99;
        else
            return Integer.parseInt(element.getElementsByClass("number age").get(0).ownText());
    }
}
