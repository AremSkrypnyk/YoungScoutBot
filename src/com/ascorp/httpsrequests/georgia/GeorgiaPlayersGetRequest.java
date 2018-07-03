package com.ascorp.httpsrequests.georgia;

import com.ascorp.httpsrequests.base.players.PlayersGetRequest;

import java.io.IOException;

public class GeorgiaPlayersGetRequest extends PlayersGetRequest {

    private static String playersSearchUrl = "https://us.soccerway.com/a/block_team_squad?block_id=page_team_1_block_team_squad_3&callback_params=%7B%22team_id%22%3A%22XXX%22%7D&action=changeView&params=%7B%22view%22%3A1%7D";

    public GeorgiaPlayersGetRequest(String teamID) throws IOException {
        super(playersSearchUrl.replace("XXX", teamID));
    }
}
