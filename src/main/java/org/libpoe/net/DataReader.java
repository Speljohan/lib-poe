package org.libpoe.net;

import com.google.gson.stream.JsonReader;
import org.libpoe.model.StashTab;
import org.libpoe.util.Constants;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Johan on 2014-02-11.
 * TODO: Add throttle to prevent lockout from GGG server
 */
public class DataReader {

    private static final String LOGIN_URL = "https://www.pathofexile.com/login";
    private static final String CHARACTER_URL = "http://www.pathofexile.com/character-window/get-characters";
    private static final String STASH_URL = "http://www.pathofexile.com/character-window/get-stash-items?league=%s&tabs=1&tabIndex=%s";

    private HttpURLConnection conn;

    private AuthInfo info;

    private HashMap<String, String> properties;

    public DataReader(AuthInfo info) {
        this.info = info;
        this.properties = new HashMap<String, String>();

    }

    private String sendPOST(String url, HashMap<String, String> params) throws Exception {

        StringBuilder sb = new StringBuilder();

        for(Map.Entry<String, String> entry : params.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }

        String p = sb.toString().subSequence(1, sb.toString().length() - 1).toString();

        conn = (HttpsURLConnection) new URL(url + p).openConnection();

        for(Map.Entry<String, String> entry : properties.entrySet()) {
            conn.setRequestProperty(entry.getKey(), entry.getValue());
        }

        conn.setUseCaches(false);

        return readContent(conn);
    }

    private String sendGET(String url) throws Exception {
        conn = (HttpURLConnection) new URL(url).openConnection();

        for(Map.Entry<String, String> entry : properties.entrySet()) {
            conn.setRequestProperty(entry.getKey(), entry.getValue());
        }

        conn.setUseCaches(false);

        return readContent(conn);
    }

    private String readContent(HttpURLConnection conn) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    /**
     * Authenticates with the server.
     * @return True if successful,
     */
    public boolean authenticate() {
        if (info.useSessionId()) {
            properties.put("Cookie", "PHPSESSID=" + info.getSessionId());

            try {
                return !sendGET(CHARACTER_URL).isEmpty();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            // TODO
            return false;
        }
    }

    public StashTab getStashTab(String league, int index) throws Exception {
        String data = sendGET(String.format(STASH_URL, league, index));
        return Constants.GSON_INSTANCE.fromJson(new JsonReader(new StringReader(data)), StashTab.class);
    }
}
