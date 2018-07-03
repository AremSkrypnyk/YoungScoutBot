package com.ascorp.httpsrequests.base.response;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public abstract class GetResponse {

    private HttpURLConnection connection;

    public GetResponse(HttpURLConnection connection) {
        this.connection = connection;
    }

    public String getResponseBody() throws IOException {
        StringBuffer responseBody = new StringBuffer();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            responseBody.append(inputLine);
        }
        in.close();

        return responseBody.toString();
    }

    protected Document getDocumentFromResponse() throws IOException {
        return Jsoup.parse(new JSONObject(getResponseBody()).getJSONArray("commands").getJSONObject(0).getJSONObject("parameters").getString("content"));
    }
}
