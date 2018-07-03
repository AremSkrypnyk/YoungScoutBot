package com.ascorp.httpsrequests.georgia;

import com.ascorp.httpsrequests.base.teams.TeamsGetRequest;

import java.io.IOException;

public class GeorgiaTeamsGetRequest extends TeamsGetRequest {

    private static final String TEAMS_SEARCH_URL = "https://us.soccerway.com/a/block_competition_tables?block_id=page_competition_1_block_competition_tables_7&callback_params=%7B%22season_id%22%3A%2215191%22%2C%22round_id%22%3A%2245330%22%2C%22outgroup%22%3A%22%22%2C%22competition_id%22%3A%22166%22%2C%22new_design_callback%22%3A%22%22%7D&action=changeTable&params=%7B%22type%22%3A%22competition_league_table%22%7D";

    public GeorgiaTeamsGetRequest() throws IOException {
        super(TEAMS_SEARCH_URL);
    }
}
