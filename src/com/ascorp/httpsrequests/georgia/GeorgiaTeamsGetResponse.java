package com.ascorp.httpsrequests.georgia;

import com.ascorp.httpsrequests.base.teams.TeamsGetResponse;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;

public class GeorgiaTeamsGetResponse extends TeamsGetResponse {

    public GeorgiaTeamsGetResponse(HttpURLConnection connection) {
        super(connection);
    }

    public Map<String, String> getListOfTeams() throws IOException {
        return getListOfTeams("georgia");
    }
}
