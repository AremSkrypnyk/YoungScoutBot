package com.ascorp.httpsrequests.base.teams;


import com.ascorp.httpsrequests.base.response.GetResponse;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

public class TeamsGetResponse extends GetResponse {

    public TeamsGetResponse(HttpURLConnection connection) {
        super(connection);
    }

    public Map<String, String>  getListOfTeams(String country) throws IOException {
        Document doc = getDocumentFromResponse();
        Elements links = doc.getElementsByAttributeValueStarting("href", "/teams");

        Map<String, String> listOfTeams = new HashMap<>();

        for (Element element : links) {
            String cleanUpHref = element.attr("href").replace("/teams/" + country + "/", "");
            listOfTeams.put(cleanUpHref.substring(cleanUpHref.indexOf("/") + 1, cleanUpHref.lastIndexOf("/")), element.ownText());
        }

        return listOfTeams;
    }
}
