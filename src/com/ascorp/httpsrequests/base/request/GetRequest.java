package com.ascorp.httpsrequests.base.request;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class GetRequest {

    protected HttpURLConnection connection;

    public GetRequest(String url) throws IOException {
        URL baseUrl = new URL(url);
        connection = getConnection(baseUrl);
    }

    private HttpURLConnection getConnection(URL baseUrl) throws IOException {
        return (HttpURLConnection) baseUrl.openConnection();
    }

    protected GetRequest setHeader(String header, String value) {
        connection.setRequestProperty(header, value);
        return this;
    }

    protected GetRequest setConnectTimeout(int value) {
        connection.setConnectTimeout(value);
        return this;
    }

    protected GetRequest setReadTimeout(int value) {
        connection.setReadTimeout(value);
        return this;
    }

    protected HttpURLConnection execute(){
        return connection;
    }

}
