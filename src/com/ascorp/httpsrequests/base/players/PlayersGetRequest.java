package com.ascorp.httpsrequests.base.players;


import com.ascorp.httpsrequests.base.request.GetRequest;

import java.io.IOException;

public class PlayersGetRequest extends GetRequest {

    private static final String ACCEPT_LANG_HEADER_KEY = "Accept-Language";
    private static final String ACCEPT_LANG_HEADER_VALUE = "en-US,en";
    private static final int DEFAULT_TIMEOUT = 5000;

    public PlayersGetRequest(String url) throws IOException {
        super(url);

        setHeader(ACCEPT_LANG_HEADER_KEY, ACCEPT_LANG_HEADER_VALUE);
        setConnectTimeout(DEFAULT_TIMEOUT);
        setReadTimeout(DEFAULT_TIMEOUT);
    }

    public PlayersGetResponse executeRequest(){
        return new PlayersGetResponse(execute());
    }


}
