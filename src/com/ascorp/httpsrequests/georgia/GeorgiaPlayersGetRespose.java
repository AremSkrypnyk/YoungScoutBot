package com.ascorp.httpsrequests.georgia;

import com.ascorp.httpsrequests.base.players.PlayersGetResponse;

import java.net.HttpURLConnection;

public class GeorgiaPlayersGetRespose extends PlayersGetResponse {

    public GeorgiaPlayersGetRespose(HttpURLConnection connection) {
        super(connection);
    }
}
